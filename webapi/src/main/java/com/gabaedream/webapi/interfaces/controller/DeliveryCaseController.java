package com.gabaedream.webapi.interfaces.controller;

import com.gabaedream.webapi.domain.aggregate.DeliveryCaseAggregate;
import com.gabaedream.webapi.domain.exception.ServiceException;
import com.gabaedream.webapi.domain.service.DeliveryCaseService;
import com.gabaedream.webapi.interfaces.controller.requests.CreateDeliveryCaseRequest;
import com.gabaedream.webapi.interfaces.controller.view.DeliveryInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@CrossOrigin(origins = "*")
public class DeliveryCaseController extends BaseController{

    @Autowired
    DeliveryCaseService deliveryCaseService;

    @PostMapping("/delivery")
    public DeliveryInfoView createDeliveryCase(@RequestBody CreateDeliveryCaseRequest createDeliveryCaseRequest) throws ServiceException {
        DeliveryCaseAggregate deliveryCaseAggregate = deliveryCaseService.createCase(createDeliveryCaseRequest);
        return new DeliveryInfoView(deliveryCaseAggregate);
    }

    @GetMapping("/delivery/{deliveryId}")
    public DeliveryInfoView getDeliveryCase(@PathVariable int deliveryId) throws ServiceException {
        DeliveryCaseAggregate deliveryCaseAggregate = deliveryCaseService.getCase(deliveryId);
        return new DeliveryInfoView(deliveryCaseAggregate);
    }

    @PutMapping("/delivery/{deliveryId}/status/{status}")
    public DeliveryInfoView startDelivery(@PathVariable int deliveryId,
                                          @PathVariable String status) throws ServiceException {
        DeliveryCaseAggregate deliveryCaseAggregate = deliveryCaseService.updateDeliveryCaseStatus(deliveryId, status);
        return new DeliveryInfoView(deliveryCaseAggregate);
    }
}
