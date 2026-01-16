package com.example.reprice_backend.controller;

import com.example.reprice_backend.dto.chat.ChatMessageRespDto;
import com.example.reprice_backend.dto.chat.ChatReadUpdateReqDto;
import com.example.reprice_backend.dto.chat.ChatSendRequestDto;
import com.example.reprice_backend.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ChatWebSocketController {
    private final ChatService chatService;
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat.send")
    public void sendMessage(@Payload ChatSendRequestDto reqDto) {
        Optional<ChatMessageRespDto> saved = chatService.saveMessage(reqDto);
        saved.ifPresent(message -> messagingTemplate.convertAndSend(
                "/topic/chat/rooms/" + message.getChatRoomId(),
                message
        ));
    }

    @MessageMapping("/chat.read")
    public void updateReadStatus(@Payload ChatReadUpdateReqDto reqDto) {
        chatService.updateReadStatus(reqDto);
    }
}
