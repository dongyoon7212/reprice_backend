package com.example.reprice_backend.dto.chat;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ChatRoomListRespDto {
    private Integer chatRoomId;
    private Integer productId;
    private String title;
    private String imageUrl;
    private Integer sellerId;
    private String sellerDisplayName;
    private Integer buyerId;
    private String buyerDisplayName;
    private String status;
    private String lastMessageContent;
    private LocalDateTime lastMessageDt;
    private LocalDateTime createDt;
}
