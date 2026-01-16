package com.example.reprice_backend.dto.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatReadUpdateReqDto {
    private Integer chatRoomId;
    private Integer userId;
    private Integer lastReadMessageId;
}
