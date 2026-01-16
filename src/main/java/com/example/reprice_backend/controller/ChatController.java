package com.example.reprice_backend.controller;

import com.example.reprice_backend.dto.ApiRespDto;
import com.example.reprice_backend.dto.CreateChatRoomReqDto;
import com.example.reprice_backend.entity.ChatMessage;
import com.example.reprice_backend.entity.ChatRoom;
import com.example.reprice_backend.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @PostMapping("/rooms")
    public ApiRespDto<ChatRoom> createChatRoom(@RequestBody CreateChatRoomReqDto reqDto) {
        return chatService.createOrGetRoom(reqDto);
    }

    @GetMapping("/rooms/{chatRoomId}/messages")
    public ApiRespDto<List<ChatMessage>> getMessages(
            @PathVariable Integer chatRoomId,
            @RequestParam(defaultValue = "30") Integer limit,
            @RequestParam(required = false) Integer cursorMessageId
    ) {
        return chatService.getMessages(chatRoomId, limit, cursorMessageId);
    }

    @GetMapping("/rooms")
    public ApiRespDto<List<ChatRoom>> getRoomsByUser(@RequestParam Integer userId) {
        return chatService.getRoomsByUser(userId);
    }
}
