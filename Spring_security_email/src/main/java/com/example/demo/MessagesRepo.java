package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesRepo extends JpaRepository<Messages, Integer>{
	Messages findAllBySenderId(String senderId);
}
