package com.gabaedream.webapi.repository;

import com.gabaedream.webapi.repository.dto.ChatroomDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatroomMapper extends JpaRepository<ChatroomDTO, Long> {

    Optional<ChatroomDTO> findBySenderIdAndMessengerIdAndDeliveryCaseId(String senderId, String messengerId, Integer delieveryCaseId);

    //ChatroomDTO save(ChatroomDTO chatroomDTO);
}
