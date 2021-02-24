package com.gabaedream.webapi.repository;

import com.gabaedream.webapi.domain.aggregate.DeliveryCaseAggregate;
import com.gabaedream.webapi.repository.dto.DeliveryCaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeliveryCaseRepository {

    @Autowired
    DeliveryMapper deliveryMapper;

    public DeliveryCaseAggregate save(DeliveryCaseAggregate deliveryCaseAggregate) {
        DeliveryCaseDTO deliveryCaseDTO = deliveryCaseAggregate.toDTO();
        DeliveryCaseDTO savedDTO = deliveryMapper.save(deliveryCaseDTO);

        return new DeliveryCaseAggregate(savedDTO);
    }

    public DeliveryCaseAggregate findById(int deliveryCaseId) {
        DeliveryCaseDTO foundCaseDTO = deliveryMapper.findById(deliveryCaseId);
        if(foundCaseDTO == null){
            return null;
        }
        return new DeliveryCaseAggregate(foundCaseDTO);
    }
}
