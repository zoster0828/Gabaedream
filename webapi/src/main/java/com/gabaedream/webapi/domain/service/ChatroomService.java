package com.gabaedream.webapi.domain.service;

import com.gabaedream.webapi.domain.aggregate.ChatroomAggregate;
import com.gabaedream.webapi.interfaces.controller.requests.CreateChatroomRequest;
import com.gabaedream.webapi.repository.ChatroomRepository;
import com.gabaedream.webapi.repository.dto.ChatroomDTO;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ChatroomService {

    private final ChatroomRepository chatroomRepository;

    public ChatroomService(ChatroomRepository chatroomRepository) {
        this.chatroomRepository = chatroomRepository;
    }

    public ChatroomAggregate createChatroom(CreateChatroomRequest chatroomRequest) {
        ChatroomAggregate chatroomAggregate = chatroomRepository.findBySenderIdAndMessengerIdAndDeliveryCaseId(new ChatroomAggregate(chatroomRequest));

        if (Objects.isNull(chatroomAggregate)) {
            ChatroomDTO chatroomDTO = chatroomRepository.save(new ChatroomAggregate(chatroomRequest));
            chatroomAggregate = new ChatroomAggregate(chatroomDTO);
        }

        return chatroomAggregate;
    }
}
