package com.example.reprice_backend.mapper;

import com.example.reprice_backend.entity.ChatReadStatus;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatReadStatusMapper {
    int upsertChatReadStatus(ChatReadStatus chatReadStatus);

}
