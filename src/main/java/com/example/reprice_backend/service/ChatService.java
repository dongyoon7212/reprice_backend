package com.example.reprice_backend.service;

import com.example.reprice_backend.dto.*;
import com.example.reprice_backend.entity.ChatMessage;
import com.example.reprice_backend.entity.ChatReadStatus;
import com.example.reprice_backend.entity.ChatRoom;
import com.example.reprice_backend.repository.ChatMessageRepository;
import com.example.reprice_backend.repository.ChatReadStatusRepository;
import com.example.reprice_backend.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;
    private final ChatReadStatusRepository chatReadStatusRepository;

    @Transactional(rollbackFor = Exception.class)
    public ApiRespDto<ChatRoom> createOrGetRoom(CreateChatRoomReqDto reqDto) {
        ChatRoom existing = chatRoomRepository.getChatRoomByParticipants(
                reqDto.getProductId(),
                reqDto.getSellerId(),
                reqDto.getBuyerId()
        );
        if (existing != null) {
            return new ApiRespDto<>("success", "기존 채팅방을 반환합니다.", existing);
        }

        LocalDateTime now = LocalDateTime.now();
        ChatRoom chatRoom = ChatRoom.builder()
                .productId(reqDto.getProductId())
                .sellerId(reqDto.getSellerId())
                .buyerId(reqDto.getBuyerId())
                .status("ACTIVE")
                .lastMessageDt(now)
                .createDt(now)
                .build();

        Optional<ChatRoom> saved = chatRoomRepository.addChatRoom(chatRoom);
        if (saved.isEmpty()) {
            return new ApiRespDto<>("failed", "채팅방 생성에 실패했습니다.", null);
        }
        return new ApiRespDto<>("success", "채팅방이 생성되었습니다.", saved.get());
    }

    public ApiRespDto<List<ChatMessage>> getMessages(Integer chatRoomId, Integer limit, Integer cursorMessageId) {
        List<ChatMessage> messages = chatMessageRepository.getChatMessages(chatRoomId, limit, cursorMessageId);
        return new ApiRespDto<>("success", "조회완료", messages);
    }

    public ApiRespDto<List<ChatRoom>> getRoomsByUser(Integer userId) {
        List<ChatRoom> rooms = chatRoomRepository.getChatRoomsByUserId(userId);
        return new ApiRespDto<>("success", "조회완료", rooms);
    }

    @Transactional(rollbackFor = Exception.class)
    public Optional<ChatMessageRespDto> saveMessage(ChatSendRequestDto reqDto) {
        LocalDateTime now = LocalDateTime.now();
        ChatMessage chatMessage = ChatMessage.builder()
                .chatRoomId(reqDto.getChatRoomId())
                .senderId(reqDto.getSenderId())
                .messageType(reqDto.getMessageType())
                .content(reqDto.getContent())
                .sentDt(now)
                .build();

        Optional<ChatMessage> saved = chatMessageRepository.addChatMessage(chatMessage);
        if (saved.isEmpty()) {
            return Optional.empty();
        }

        chatRoomRepository.updateLastMessageDt(reqDto.getChatRoomId());
        upsertReadStatus(reqDto.getChatRoomId(), reqDto.getSenderId(), saved.get().getChatMessageId());

        ChatMessageRespDto response = ChatMessageRespDto.builder()
                .chatMessageId(saved.get().getChatMessageId())
                .chatRoomId(saved.get().getChatRoomId())
                .senderId(saved.get().getSenderId())
                .messageType(saved.get().getMessageType())
                .content(saved.get().getContent())
                .sentDt(saved.get().getSentDt())
                .build();
        return Optional.of(response);
    }

    public boolean updateReadStatus(ChatReadUpdateReqDto reqDto) {
        return upsertReadStatus(reqDto.getChatRoomId(), reqDto.getUserId(), reqDto.getLastReadMessageId());
    }

    private boolean upsertReadStatus(Integer chatRoomId, Integer userId, Integer lastReadMessageId) {
        ChatReadStatus status = ChatReadStatus.builder()
                .chatRoomId(chatRoomId)
                .userId(userId)
                .lastReadMessageId(lastReadMessageId)
                .updateDt(LocalDateTime.now())
                .build();
        return chatReadStatusRepository.upsertChatReadStatus(status);
    }
}
