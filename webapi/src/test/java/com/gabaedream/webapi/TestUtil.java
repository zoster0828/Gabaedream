package com.gabaedream.webapi;

import com.gabaedream.webapi.domain.aggregate.UserAggregate;
import com.gabaedream.webapi.interfaces.controller.requests.CreateUserRequest;

import static org.apache.commons.lang3.RandomStringUtils.*;

public class TestUtil {
    public static UserAggregate createRandomAggregate() {
        CreateUserRequest createUserRequest = randomCreateUserRequest();
        return new UserAggregate(createUserRequest);
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
