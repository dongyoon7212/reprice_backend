package com.example.reprice_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessageRespDto {
    private Integer chatMessageId;
    private Integer chatRoomId;
    private Integer senderId;
    private String messageType;
    private String content;
    private LocalDateTime sentDt;
}
