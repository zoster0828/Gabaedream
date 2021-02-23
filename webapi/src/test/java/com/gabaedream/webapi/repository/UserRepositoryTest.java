package com.gabaedream.webapi.repository;

import com.gabaedream.webapi.TestUtil;
import com.gabaedream.webapi.domain.aggregate.UserAggregate;
import com.gabaedream.webapi.domain.exception.ResultCode;
import com.gabaedream.webapi.domain.exception.ServiceException;
import com.gabaedream.webapi.repository.dto.UserDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.sameInstance;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Nested
    @DisplayName("User repository는")
    public class userRepositoryTest{

        @Test
        @DisplayName("UserAggregate를 던지면 저장하고, id로 꺼내올 수 있다.")
        void setGetTest() throws ServiceException {
            UserAggregate randomAggregate = TestUtil.createRandomAggregate();
            UserDTO savedDTO = userRepository.save(randomAggregate);

            String createdId = savedDTO.getUserId();

            UserAggregate findedUserAggregate = userRepository.findByUserId(createdId);

            UserDTO findedUserDTO = findedUserAggregate.toDTO();

            assertThat(savedDTO, samePropertyValuesAs(findedUserDTO));
        }

        @Test
        @DisplayName("틀린 ID를 넣으면 ID NOT FOUND를 THROW 한다.")
        void notFoundTest(){
            assertThrows(ServiceException.class, () -> userRepository.findByUserId("InvalidId"));
        }
    }
}