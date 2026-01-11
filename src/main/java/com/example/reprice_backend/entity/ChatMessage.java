package com.example.reprice_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
    private Integer chatMessageId;
    private Integer chatRoomId;
    private Integer senderId;
    private String messageType;
    private String content;
    private LocalDateTime sentDt;
}
