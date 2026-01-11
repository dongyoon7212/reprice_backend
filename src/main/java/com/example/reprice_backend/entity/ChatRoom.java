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
public class ChatRoom {
    private Integer chatRoomId;
    private Integer productId;
    private Integer sellerId;
    private Integer buyerId;
    private String status;
    private String lastMessageAt;
    private LocalDateTime createDt;
}
