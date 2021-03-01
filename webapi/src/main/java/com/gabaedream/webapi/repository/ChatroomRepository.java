package com.gabaedream.webapi.repository;

import com.gabaedream.webapi.domain.aggregate.ChatroomAggregate;
import com.gabaedream.webapi.repository.dto.ChatroomDTO;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ChatroomRepository {

    private final ChatroomMapper chatroomMapper;

    public ChatroomRepository(ChatroomMapper chatroomMapper) {
        this.chatroomMapper = chatroomMapper;
    }

    public ChatroomAggregate findBySenderIdAndMessengerIdAndDeliveryCaseId(ChatroomAggregate chatroomAggregate) {
        Optional<ChatroomDTO> result = chatroomMapper.findBySenderIdAndMessengerIdAndDeliveryCaseId(chatroomAggregate.getSenderId(), chatroomAggregate.getMessengerId(), chatroomAggregate.getDeliveryCaseId());
        return result.map(ChatroomAggregate::new).orElse(null);
    }

    public ChatroomDTO save(ChatroomAggregate chatroomAggregate) {
        return chatroomMapper.save(chatroomAggregate.toDTO());
    }
}
