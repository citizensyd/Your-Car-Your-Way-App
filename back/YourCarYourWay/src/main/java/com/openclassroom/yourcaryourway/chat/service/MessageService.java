package com.openclassroom.yourcaryourway.chat.service;
import com.openclassroom.yourcaryourway.chat.dto.MessageDto;
import com.openclassroom.yourcaryourway.chat.dto.RequestDto;
import com.openclassroom.yourcaryourway.chat.model.Message;
import com.openclassroom.yourcaryourway.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public void sendMessage(MessageDto messageDto) {
        Message message = new Message();
        message.setSenderId(messageDto.getSenderId());
        message.setReceiverId(messageDto.getReceiverId());
        message.setContent(messageDto.getContent());
        message.setTimestamp(LocalDateTime.now());
        messageRepository.save(message);
    }

    public List<Message> getMessages(RequestDto requestDto) {
        return messageRepository.findBySenderIdOrReceiverId(requestDto.getSenderId(), requestDto.getReceiverId());
    }
}

