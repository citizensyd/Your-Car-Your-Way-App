package com.openclassroom.yourcaryourway.chat.dto;

import lombok.Data;

@Data
public class RequestDto {
    private Long senderId;
    private Long receiverId;
}

