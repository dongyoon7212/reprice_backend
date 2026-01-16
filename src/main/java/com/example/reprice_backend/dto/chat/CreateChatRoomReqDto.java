package com.example.reprice_backend.dto.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateChatRoomReqDto {
    private Integer productId;
    private Integer sellerId;
    private Integer buyerId;
}
