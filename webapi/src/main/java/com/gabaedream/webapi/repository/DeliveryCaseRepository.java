package com.gabaedream.webapi.repository;

import com.gabaedream.webapi.domain.aggregate.DeliveryCaseAggregate;
import com.gabaedream.webapi.repository.dto.DeliveryCaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeliveryCaseRepository {

    @Autowired
    DeliveryCRUDRepository deliveryCRUDRepository;

    public DeliveryCaseAggregate save(DeliveryCaseAggregate deliveryCaseAggregate) {
        DeliveryCaseDTO deliveryCaseDTO = deliveryCaseAggregate.toDTO();
        DeliveryCaseDTO savedDTO = deliveryCRUDRepository.save(deliveryCaseDTO);

        return new DeliveryCaseAggregate(savedDTO);
    }

    public DeliveryCaseAggregate findById(int deliveryCaseId) {
        DeliveryCaseDTO foundCaseDTO = deliveryCRUDRepository.findById(deliveryCaseId);
        if(foundCaseDTO == null){
            return null;
        }
        return new DeliveryCaseAggregate(foundCaseDTO);
    }
}
