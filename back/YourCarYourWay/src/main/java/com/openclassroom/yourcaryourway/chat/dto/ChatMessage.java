package com.openclassroom.yourcaryourway.chat.dto;

import lombok.Data;

@Data
public class ChatMessage {
    private String content;
    private String sender;
}

