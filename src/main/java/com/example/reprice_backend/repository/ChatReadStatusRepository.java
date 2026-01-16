package com.example.reprice_backend.repository;

import com.example.reprice_backend.entity.ChatReadStatus;
import com.example.reprice_backend.mapper.ChatReadStatusMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChatReadStatusRepository {
    private final ChatReadStatusMapper chatReadStatusMapper;

    public boolean upsertChatReadStatus(ChatReadStatus chatReadStatus) {
        return chatReadStatusMapper.upsertChatReadStatus(chatReadStatus) > 0;
    }
}
