package com.gabaedream.webapi.domain.aggregate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gabaedream.webapi.domain.DomainConstants;
import com.gabaedream.webapi.interfaces.controller.requests.CreateDeliveryCaseRequest;
import com.gabaedream.webapi.repository.dto.DeliveryCaseDTO;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryCaseAggregate {
    Integer id;
    String start;
    String destination;
    Long startTime;
    Long endTime;
    Integer price;
    Integer status;
    Float senderRating;
    Float messengerRating;
    String senderId;
    String messengerId;

    public DeliveryCaseAggregate(CreateDeliveryCaseRequest createDeliveryCaseRequest) {
        this.start = createDeliveryCaseRequest.getStart();
        this.destination = createDeliveryCaseRequest.getDestination();
        this.price = createDeliveryCaseRequest.getPrice();
        this.status = DomainConstants.DELIVERY_CREATED;
        this.senderId = createDeliveryCaseRequest.getSenderId();
        this.messengerId = createDeliveryCaseRequest.getMessengerId();
    }

    public DeliveryCaseAggregate(DeliveryCaseDTO savedDTO) {
        this.id = savedDTO.getId();
        this.start = savedDTO.getStart();
        this.destination = savedDTO.getDestination();
        this.startTime = savedDTO.getStartTime();
        this.endTime = savedDTO.getEndTime();
        this.price = savedDTO.getPrice();
        this.status = savedDTO.getStatus();
        this.senderRating = savedDTO.getSenderRating();
        this.messengerRating = savedDTO.getMessengerRating();
        this.senderId = savedDTO.getSenderId();
        this.messengerId = savedDTO.getMessengerId();
    }

    public DeliveryCaseDTO toDTO() {
        DeliveryCaseDTO deliveryCaseDTO = new DeliveryCaseDTO().builder()
                .id(id)
                .start(start)
                .destination(destination)
                .startTime(startTime)
                .endTime(endTime)
                .price(price)
                .status(status)
                .senderRating(senderRating)
                .messengerRating(messengerRating)
                .senderId(senderId)
                .messengerId(messengerId)
                .build();

        return deliveryCaseDTO;
    }

    public void start() {
        this.status = DomainConstants.DELIVERY_STARTED;
        this.startTime = System.currentTimeMillis();
    }

    public void complete() {
        this.status = DomainConstants.DELIVERY_COMPLETED;
        this.endTime = System.currentTimeMillis();
    }

    public void cancel() {
        this.status = DomainConstants.DELIVERY_CANCELD;
        this.endTime = System.currentTimeMillis();
    }

    public void accepted() {
        this.status = DomainConstants.DELIVERY_ACCEPTED;
    }

    public void fail() {
        this.status = DomainConstants.DELIVERY_FAILED;
        this.endTime = System.currentTimeMillis();
    }
}
