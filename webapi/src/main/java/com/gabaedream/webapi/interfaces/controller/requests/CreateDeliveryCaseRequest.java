package com.gabaedream.webapi.interfaces.controller.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDeliveryCaseRequest {
    String start;
    String destination;
    Integer price;
    String senderId;
    String messengerId;
}
