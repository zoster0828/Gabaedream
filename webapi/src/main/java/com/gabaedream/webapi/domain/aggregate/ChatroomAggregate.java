package com.gabaedream.webapi.domain.aggregate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gabaedream.webapi.interfaces.controller.requests.CreateChatroomRequest;
import com.gabaedream.webapi.repository.dto.ChatroomDTO;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatroomAggregate {

    private Long chatroomId;
    private final String senderId;
    private final String messengerId;
    private final Integer deliveryCaseId;

    public ChatroomAggregate(CreateChatroomRequest createChatroomRequest) {
        this.senderId = createChatroomRequest.getSenderId();
        this.messengerId = createChatroomRequest.getMessengerId();
        this.deliveryCaseId = createChatroomRequest.getDeliveryCaseId();
    }

    public ChatroomAggregate(ChatroomDTO chatroomDTO) {
        this.chatroomId = chatroomDTO.getChatroomId();
        this.senderId = chatroomDTO.getSenderId();
        this.messengerId = chatroomDTO.getMessengerId();
        this.deliveryCaseId = chatroomDTO.getDeliveryCaseId();
    }

    public ChatroomDTO toDTO() {
        return ChatroomDTO.builder()
                .chatroomId(chatroomId)
                .senderId(senderId)
                .messengerId(messengerId)
                .deliveryCaseId(deliveryCaseId)
                .build();
    }
}
