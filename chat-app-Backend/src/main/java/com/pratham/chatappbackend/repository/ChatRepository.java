package com.pratham.chatappbackend.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.pratham.chatappbackend.model.Chat;
import com.pratham.chatappbackend.model.User;

public interface ChatRepository extends JpaRepository<Chat, Integer> {

  @Query("select c from Chat c join c.users u where u.id=:userId")
  public List<Chat> findChatByUserid(@Param("userId") Integer userId);

  @Query("select c form chat c where c.isGroup=false And :user Member of c.users And :reqUser Member of c,users")
  public Chat findSingleChatByUserIds(@Param("user") User user, @Param("reqUser") User reqUser);

}