package com.gabaedream.webapi.domain.service;

import com.gabaedream.webapi.domain.aggregate.DeliveryCaseAggregate;
import com.gabaedream.webapi.domain.exception.ResultCode;
import com.gabaedream.webapi.domain.exception.ServiceException;
import com.gabaedream.webapi.interfaces.controller.requests.CreateDeliveryCaseRequest;
import com.gabaedream.webapi.repository.DeliveryCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryCaseService {

    @Autowired
    DeliveryCaseRepository deliveryCaseRepository;

    public DeliveryCaseAggregate createCase(CreateDeliveryCaseRequest createDeliveryCaseRequest) {
        DeliveryCaseAggregate deliveryCaseAggregate = new DeliveryCaseAggregate(createDeliveryCaseRequest);

        DeliveryCaseAggregate result = deliveryCaseRepository.save(deliveryCaseAggregate);

        return result;
    }

    public DeliveryCaseAggregate updateDeliveryCaseStatus(int deliveryCaseId, String status) {
        DeliveryCaseAggregate deliveryCase = deliveryCaseRepository.findById(deliveryCaseId);
        if(deliveryCase == null){
            throw new ServiceException(ResultCode.DELIVERY_ID_NOT_FOUND, deliveryCaseId);
        }
        switch(status){
            case "accept":
                deliveryCase.accepted();
                break;
            case "fail":
                deliveryCase.fail();
                break;
            case "start":
                deliveryCase.start();
                break;
            case "complete":
                deliveryCase.complete();
                break;
            case "cancel":
                deliveryCase.cancel();
                break;
            default:
                throw new ServiceException(ResultCode.INVALID_STATUS, status);
        }

        DeliveryCaseAggregate result = deliveryCaseRepository.save(deliveryCase);

        return result;
    }

    public DeliveryCaseAggregate getCase(int deliveryId) {
        DeliveryCaseAggregate foundAggregate = deliveryCaseRepository.findById(deliveryId);
        if(foundAggregate == null){
            throw new ServiceException(ResultCode.DELIVERY_ID_NOT_FOUND, deliveryId);
        } else {
            return foundAggregate;
        }
    }
}
