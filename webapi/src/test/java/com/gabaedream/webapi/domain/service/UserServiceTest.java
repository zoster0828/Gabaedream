package com.gabaedream.webapi.domain.service;

import com.gabaedream.webapi.TestUtil;
import com.gabaedream.webapi.domain.aggregate.UserAggregate;
import com.gabaedream.webapi.domain.exception.ServiceException;
import com.gabaedream.webapi.interfaces.controller.requests.CreateUserRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Nested
@DisplayName("User service는")
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    @DisplayName("CreateRequest를 던지면 신규 유저를 생성해주고, user Id로 꺼낼 수 있다.")
    void createNewUser_And_GetTest() throws ServiceException {
        UserAggregate newUser = userService.createNewUser(TestUtil.randomCreateUserRequest());

        UserAggregate foundUser = userService.getUserWithId(newUser.getUserId());

        assertThat(newUser, samePropertyValuesAs(foundUser));
    }

    @Test
    @DisplayName("이미 있는 userId로 request를 던지면 에러를 반환한다.")
    void alreadyExists() throws ServiceException {
        CreateUserRequest createUserRequest = TestUtil.randomCreateUserRequest();
        userService.createNewUser(createUserRequest);

        assertThrows(ServiceException.class, () -> userService.createNewUser(createUserRequest));
    }

    @Test
    @DisplayName("없는 id를 던지면 not found exception을 반환한다.")
    void not_found_user() throws ServiceException {

        assertThrows(ServiceException.class, () -> userService.getUserWithId("invalidId"));
    }

}