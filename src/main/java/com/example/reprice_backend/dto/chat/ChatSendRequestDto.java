package com.example.reprice_backend.dto.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatSendRequestDto {
    private Integer chatRoomId;
    private Integer senderId;
    private String messageType;
    private String content;
}
