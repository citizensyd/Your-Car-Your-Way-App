package com.openclassroom.yourcaryourway.chat.repository;

import com.openclassroom.yourcaryourway.chat.dto.RequestDto;
import com.openclassroom.yourcaryourway.chat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySenderIdOrReceiverId(Long senderId, Long receiverId);
}
