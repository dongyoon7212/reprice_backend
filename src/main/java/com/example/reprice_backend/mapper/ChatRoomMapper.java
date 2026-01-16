package com.example.reprice_backend.mapper;

import com.example.reprice_backend.entity.ChatRoom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChatRoomMapper {
    int addChatRoom(ChatRoom chatRoom);
    ChatRoom getChatRoomById(Integer chatRoomId);
    ChatRoom getChatRoomByParticipants(Integer productId, Integer sellerId, Integer buyerId);
    List<ChatRoom> getChatRoomsByUserId(Integer userId);
    int updateLastMessageDt(Integer chatRoomId);
}
