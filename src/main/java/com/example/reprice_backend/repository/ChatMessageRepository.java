package com.example.reprice_backend.repository;

import com.example.reprice_backend.entity.ChatMessage;
import com.example.reprice_backend.mapper.ChatMessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ChatMessageRepository {
    private final ChatMessageMapper chatMessageMapper;

    public Optional<ChatMessage> addChatMessage(ChatMessage chatMessage) {
        try {
            int result = chatMessageMapper.addChatMessage(chatMessage);
            if (result != 1) {
                throw new RuntimeException("채팅 메시지 저장에 실패했습니다.");
            }
        } catch (RuntimeException e) {
            return Optional.empty();
        }
        return Optional.of(chatMessage);
    }

    public List<ChatMessage> getChatMessages(Integer chatRoomId, Integer limit, Integer cursorMessageId) {
        return chatMessageMapper.getChatMessages(chatRoomId, limit, cursorMessageId);
    }
}
