package com.gabaedream.webapi.interfaces.view;

import com.gabaedream.webapi.domain.aggregate.DeliveryCaseAggregate;

import java.util.List;

public class DeliveryListInfoView {
    List<DeliveryCaseAggregate> deliveryCaseAggregateList;
    public DeliveryListInfoView(List<DeliveryCaseAggregate> deliveryCaseAggregateList) {
        this.deliveryCaseAggregateList = deliveryCaseAggregateList;
    }
}
