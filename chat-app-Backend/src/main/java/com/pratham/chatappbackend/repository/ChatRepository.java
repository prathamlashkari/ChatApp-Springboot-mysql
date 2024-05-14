package com.pratham.chatappbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pratham.chatappbackend.model.Chat;
import com.pratham.chatappbackend.model.User;

public interface ChatRepository extends JpaRepository<Chat, Integer> {

  @Query("select c from Chat c join c.users u where u.id = :userId")
  List<Chat> findChatByUserid(@Param("userId") Integer userId);

  @Query("select c from Chat c where c.isGroup = false and :user member of c.users and :reqUser member of c.users")
  Chat findSingleChatByUserIds(@Param("user") User user, @Param("reqUser") User reqUser);
}
