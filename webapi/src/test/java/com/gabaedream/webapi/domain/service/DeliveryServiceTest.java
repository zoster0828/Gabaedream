package com.gabaedream.webapi.domain.service;

import com.gabaedream.webapi.TestUtil;
import com.gabaedream.webapi.domain.constants.DeliveryStatus;
import com.gabaedream.webapi.domain.aggregate.DeliveryCaseAggregate;
import com.gabaedream.webapi.domain.exception.ServiceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("DeliveryCase service는")
@SpringBootTest
class DeliveryServiceTest {
    
    @Autowired
    DeliveryCaseService deliveryCaseService;

    @Test
    @DisplayName("CreateRequest를 던지면 신규 유저를 생성해주고, DeliveryCase Id로 꺼낼 수 있다.")
    void createNewDeliveryCase_And_GetTest() throws ServiceException {
        DeliveryCaseAggregate newDeliveryCase = deliveryCaseService.createCase(TestUtil.randomCreateDeliveryCaseRequest());

        DeliveryCaseAggregate foundDeliveryCase = deliveryCaseService.getCase(newDeliveryCase.getId());

        assertThat(newDeliveryCase, samePropertyValuesAs(foundDeliveryCase));
    }

    @Test
    @DisplayName("없는 id를 던지면 not found exception을 반환한다.")
    void not_found_DeliveryCase() throws ServiceException {

        assertThrows(ServiceException.class, () -> deliveryCaseService.getCase(9999999));
    }

    @Test
    @DisplayName("delivery status를 잘 업데이트 한다.")
    void update_status_success(){
        Map<String, Integer> statusMap = new HashMap<>();
        statusMap.put("start", DeliveryStatus.STARTED);
        statusMap.put("cancel", DeliveryStatus.CANCELD);
        statusMap.put("complete", DeliveryStatus.COMPLETED);
        statusMap.put("accept", DeliveryStatus.ACCEPTED);
        statusMap.put("fail", DeliveryStatus.FAILED);

        for(String status : statusMap.keySet()) {
            DeliveryCaseAggregate newDeliveryCase = deliveryCaseService.createCase(TestUtil.randomCreateDeliveryCaseRequest());
            deliveryCaseService.updateDeliveryCaseStatus(newDeliveryCase.getId(), status);
            DeliveryCaseAggregate startCase = deliveryCaseService.getCase(newDeliveryCase.getId());
            assertEquals(startCase.getStatus(), statusMap.get(status));
        }
    }

    @Test
    @DisplayName("없는 delivery status를 넣으면 error를 반환한다.")
    void update_status_fail(){

        DeliveryCaseAggregate newDeliveryCase = deliveryCaseService.createCase(TestUtil.randomCreateDeliveryCaseRequest());

        assertThrows(ServiceException.class, () -> deliveryCaseService.updateDeliveryCaseStatus(newDeliveryCase.getId(), "invalidCase"));
    }
}