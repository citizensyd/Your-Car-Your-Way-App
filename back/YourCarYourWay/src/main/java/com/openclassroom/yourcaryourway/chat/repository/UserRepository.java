package com.openclassroom.yourcaryourway.chat.repository;

import com.openclassroom.yourcaryourway.chat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
