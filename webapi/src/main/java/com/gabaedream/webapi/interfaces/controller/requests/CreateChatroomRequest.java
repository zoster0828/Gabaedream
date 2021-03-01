package com.gabaedream.webapi.interfaces.controller.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateChatroomRequest {

    String senderId;
    String messengerId;
    Integer deliveryCaseId;
}
