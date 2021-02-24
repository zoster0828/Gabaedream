package com.gabaedream.webapi.messenger.view.model;

import com.gabaedream.webapi.messenger.repository.dto.MessengerDTO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
