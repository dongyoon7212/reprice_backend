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
public class ChatReadStatus {
    private Integer chatReadStatusId;
    private Integer chatRoomId;
    private Integer userId;
    private Integer lastReadMessageId;
    private LocalDateTime updateDt;
}
