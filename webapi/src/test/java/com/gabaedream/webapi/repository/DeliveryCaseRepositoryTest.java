package com.gabaedream.webapi.repository;

import com.gabaedream.webapi.TestUtil;
import com.gabaedream.webapi.domain.aggregate.DeliveryCaseAggregate;
import com.gabaedream.webapi.domain.exception.ServiceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    @DisplayName("findByMessengerId는 userId가 messenger로 등록된 모든 list를 반환한다.")
    void findByMessengerIdest(){
        DeliveryCaseAggregate randomAggregate = TestUtil.createRandomDeliveryCaseAggregate();

        for(int i = 0 ; i < 10 ; i ++) {
            deliveryCaseRepository.save(randomAggregate);
        }

        List<DeliveryCaseAggregate> byMessengerId = deliveryCaseRepository.findByMessengerId(randomAggregate.getMessengerId());

        assertTrue(byMessengerId.size() == 10);
        for(DeliveryCaseAggregate dca : byMessengerId){
            System.out.println(dca);
        }
    }

}