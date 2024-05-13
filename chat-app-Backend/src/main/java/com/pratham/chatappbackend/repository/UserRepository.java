package com.pratham.chatappbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratham.chatappbackend.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
