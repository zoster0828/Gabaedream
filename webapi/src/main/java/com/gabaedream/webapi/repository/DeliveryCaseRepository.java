package com.gabaedream.webapi.repository;

import com.gabaedream.webapi.domain.aggregate.DeliveryCaseAggregate;
import com.gabaedream.webapi.repository.dto.DeliveryCaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeliveryCaseRepository {

    @Autowired
    DeliveryMapper deliveryMapper;

    public DeliveryCaseAggregate save(DeliveryCaseAggregate deliveryCaseAggregate) {
        DeliveryCaseDTO deliveryCaseDTO = deliveryCaseAggregate.toDTO();
        deliveryCaseDTO.setServerUpdatedTime(System.currentTimeMillis());
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

    public List<DeliveryCaseAggregate> findByMessengerId(String messengerId) {
        List<DeliveryCaseDTO> deliveryCaseDTOList = deliveryMapper.findByMessengerId(messengerId);
        List<DeliveryCaseAggregate> deliveryCaseAggregateList = new ArrayList<>();
        for(DeliveryCaseDTO deliveryCaseDTO : deliveryCaseDTOList){
            deliveryCaseAggregateList.add(new DeliveryCaseAggregate(deliveryCaseDTO));
        }
        return deliveryCaseAggregateList;
    }
}
