package com.example.reprice_backend.mapper;

import com.example.reprice_backend.entity.ChatMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChatMessageMapper {
    int addChatMessage(ChatMessage chatMessage);
    List<ChatMessage> getChatMessages(Integer chatRoomId, Integer limit, Integer cursorMessageId);
}
