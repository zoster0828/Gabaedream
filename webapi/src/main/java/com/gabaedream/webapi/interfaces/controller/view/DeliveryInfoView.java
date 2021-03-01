package com.gabaedream.webapi.interfaces.controller.view;

import com.gabaedream.webapi.domain.aggregate.DeliveryCaseAggregate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryInfoView {
    DeliveryCaseAggregate deliveryCaseAggregate;

    public DeliveryInfoView(DeliveryCaseAggregate deliveryCaseAggregate) {
        this.deliveryCaseAggregate = deliveryCaseAggregate;
    }
}
