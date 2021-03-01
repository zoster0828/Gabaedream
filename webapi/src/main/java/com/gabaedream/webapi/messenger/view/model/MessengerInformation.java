package com.gabaedream.webapi.messenger.view.model;

import com.gabaedream.webapi.messenger.repository.dto.MessengerDTO;
import lombok.Data;

@Data
public class MessengerInformation {

    private Long id;
    private String userId;
    private String start;
    private String destination;
    private String day;
    private String transportation;
    private Integer minimumPrice;

    public MessengerInformation(MessengerDTO dto){

    }
}
