package com.openclassroom.yourcaryourway.chat.dto;

import lombok.Data;

@Data
public class MessageDto {
    private Long senderId;
    private Long receiverId;
    private String content;

}