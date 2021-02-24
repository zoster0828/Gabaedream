package com.gabaedream.webapi;

import com.gabaedream.webapi.domain.aggregate.DeliveryCaseAggregate;
import com.gabaedream.webapi.domain.aggregate.UserAggregate;
import com.gabaedream.webapi.interfaces.controller.requests.CreateDeliveryCaseRequest;
import com.gabaedream.webapi.interfaces.controller.requests.CreateUserRequest;

import static org.apache.commons.lang3.RandomStringUtils.*;

public class TestUtil {
    public static UserAggregate createRandomUserAggregate() {
        CreateUserRequest createUserRequest = randomCreateUserRequest();
        return new UserAggregate(createUserRequest);
    }

    public static DeliveryCaseAggregate createRandomDeliveryCaseAggregate() {
        CreateDeliveryCaseRequest createDeliveryCaseRequest = randomCreateDeliveryCaseRequest();
        return new DeliveryCaseAggregate(createDeliveryCaseRequest);
    }

    public static CreateDeliveryCaseRequest randomCreateDeliveryCaseRequest() {
        CreateDeliveryCaseRequest createDeliveryCaseRequest = new CreateDeliveryCaseRequest();
        createDeliveryCaseRequest.setStart(String.format("경기도 화성시 %s아파트 %S동 %S호", randomAlphabetic(10), randomNumeric(2), randomNumeric(2)));
        createDeliveryCaseRequest.setDestination(String.format("서울시 강동구 %s아파트 %S동 %S호", randomAlphabetic(10), randomNumeric(2), randomNumeric(2)));
        createDeliveryCaseRequest.setPrice(Integer.parseInt(randomNumeric(4)));
        createDeliveryCaseRequest.setSenderId(randomAlphanumeric(20));
        createDeliveryCaseRequest.setMessengerId(randomAlphanumeric(20));
        return createDeliveryCaseRequest;
    }

    public static CreateUserRequest randomCreateUserRequest() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setAddress(String.format("경기도 화성시 %s아파트 %S동 %S호", randomAlphabetic(10), randomNumeric(2), randomNumeric(2)));
        createUserRequest.setEmail(String.format("%s@%s.com", randomAlphabetic(10), randomAlphabetic(5)));
        createUserRequest.setLegalName(randomAlphabetic(15));
        createUserRequest.setPassword(randomAlphanumeric(10));
        createUserRequest.setPhoneNumber(Long.parseLong(randomNumeric(10)));
        createUserRequest.setNickName(randomAlphanumeric(8));
        createUserRequest.setUserId(randomAlphanumeric(20));
        return createUserRequest;
    }
}
