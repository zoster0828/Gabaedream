package com.gabaedream.webapi.interfaces.controller.requests;

import com.gabaedream.webapi.repository.dto.MessengerDTO;
import lombok.Data;

@Data
public class MessengerRegisterRequest {
    String userId;
    String start;
    String destination;
    String day;
    String transportation;
    Integer minimumPrice;

    public MessengerDTO toMessengerDTO(MessengerRegisterRequest request) {
        MessengerDTO dto = new MessengerDTO();
        dto.setUserId(request.getUserId());
        dto.setStart(request.getStart());
        dto.setDestination(request.getDestination());
        dto.setDay(request.getDay());
        dto.setMinimumPrice(request.getMinimumPrice());
        dto.setTransportation(request.getTransportation());
        return dto;
    }
}
