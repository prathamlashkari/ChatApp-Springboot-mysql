package com.pratham.chatappbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratham.chatappbackend.model.Chat;

public interface ChatRepository extends JpaRepository<Chat, Integer> {

}