package com.openclassroom.yourcaryourway.chat.controller;

import com.openclassroom.yourcaryourway.chat.dto.MessageDto;
import com.openclassroom.yourcaryourway.chat.dto.RequestDto;
import com.openclassroom.yourcaryourway.chat.model.Message;
import com.openclassroom.yourcaryourway.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody MessageDto messageDto) {
        messageService.sendMessage(messageDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getMessages(@RequestBody RequestDto requestDto) {
        return ResponseEntity.ok(messageService.getMessages(requestDto));
    }
}

