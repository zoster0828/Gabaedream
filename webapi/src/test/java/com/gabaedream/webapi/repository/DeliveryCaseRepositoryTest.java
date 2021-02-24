package com.gabaedream.webapi.repository;

import com.gabaedream.webapi.TestUtil;
import com.gabaedream.webapi.domain.aggregate.DeliveryCaseAggregate;
import com.gabaedream.webapi.domain.exception.ServiceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Nested
@DisplayName("DeliveryCase repository는")
@SpringBootTest
class DeliveryCaseRepositoryTest {

    @Autowired
    DeliveryCaseRepository deliveryCaseRepository;

    @Test
    @DisplayName("DeliveryCaseAggr을 던지면 저장하고, id로 꺼내올 수 있다.")
    void setGetTest() throws ServiceException {
        DeliveryCaseAggregate randomAggregate = TestUtil.createRandomDeliveryCaseAggregate();

        DeliveryCaseAggregate savedAggregate = deliveryCaseRepository.save(randomAggregate);

        int createdId = savedAggregate.getId();

        DeliveryCaseAggregate foundDeliveryCaseAggregate = deliveryCaseRepository.findById(createdId);

        assertThat(savedAggregate, samePropertyValuesAs(foundDeliveryCaseAggregate));
    }

    @Test
    @DisplayName("틀린 ID를 넣으면 NULL을 리턴 한다.")
    void notFoundTest(){
        DeliveryCaseAggregate invalidId = deliveryCaseRepository.findById(999999);
        assertEquals(invalidId, null);
    }

}