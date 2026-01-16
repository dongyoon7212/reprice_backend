package com.example.reprice_backend.repository;

import com.example.reprice_backend.entity.ChatRoom;
import com.example.reprice_backend.mapper.ChatRoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ChatRoomRepository {
    private final ChatRoomMapper chatRoomMapper;

    public Optional<ChatRoom> addChatRoom(ChatRoom chatRoom) {
        try {
            int result = chatRoomMapper.addChatRoom(chatRoom);
            if (result != 1) {
                throw new RuntimeException("채팅방 생성에 실패했습니다.");
            }
        } catch (RuntimeException e) {
            return Optional.empty();
        }
        return Optional.of(chatRoom);
    }

    public ChatRoom getChatRoomById(Integer chatRoomId) {
        return chatRoomMapper.getChatRoomById(chatRoomId);
    }

    public ChatRoom getChatRoomByParticipants(Integer productId, Integer sellerId, Integer buyerId) {
        return chatRoomMapper.getChatRoomByParticipants(productId, sellerId, buyerId);
    }

    public java.util.List<ChatRoom> getChatRoomsByUserId(Integer userId) {
        return chatRoomMapper.getChatRoomsByUserId(userId);
    }

    public boolean updateLastMessageDt(Integer chatRoomId) {
        return chatRoomMapper.updateLastMessageDt(chatRoomId) == 1;
    }
}
