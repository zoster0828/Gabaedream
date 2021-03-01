package com.gabaedream.webapi.domain.aggregate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gabaedream.webapi.domain.constants.DeliveryStatus;
import com.gabaedream.webapi.interfaces.controller.requests.CreateDeliveryCaseRequest;
import com.gabaedream.webapi.repository.dto.DeliveryCaseDTO;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
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
    Long serverCreatedTime;
    Long serverUpdatedTime;

    public DeliveryCaseAggregate(CreateDeliveryCaseRequest createDeliveryCaseRequest) {
        this.start = createDeliveryCaseRequest.getStart();
        this.destination = createDeliveryCaseRequest.getDestination();
        this.price = createDeliveryCaseRequest.getPrice();
        this.status = DeliveryStatus.CREATED;
        this.senderId = createDeliveryCaseRequest.getSenderId();
        this.messengerId = createDeliveryCaseRequest.getMessengerId();
        this.serverCreatedTime = System.currentTimeMillis();
        this.serverUpdatedTime = System.currentTimeMillis();
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
        this.serverCreatedTime = savedDTO.getServerCreatedTime();
        this.serverUpdatedTime = savedDTO.getServerUpdatedTime();
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
                .serverCreatedTime(serverCreatedTime)
                .serverUpdatedTime(serverUpdatedTime)
                .build();

        return deliveryCaseDTO;
    }

    public void start() {
        this.status = DeliveryStatus.STARTED;
        this.startTime = System.currentTimeMillis();
    }

    public void complete() {
        this.status = DeliveryStatus.COMPLETED;
        this.endTime = System.currentTimeMillis();
    }

    public void cancel() {
        this.status = DeliveryStatus.CANCELD;
        this.endTime = System.currentTimeMillis();
    }

    public void accepted() {
        this.status = DeliveryStatus.ACCEPTED;
    }

    public void fail() {
        this.status = DeliveryStatus.FAILED;
        this.endTime = System.currentTimeMillis();
    }
}
