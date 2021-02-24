package com.gabaedream.webapi.repository;

import com.gabaedream.webapi.TestUtil;
import com.gabaedream.webapi.domain.aggregate.UserAggregate;
import com.gabaedream.webapi.domain.exception.ServiceException;
import com.gabaedream.webapi.repository.dto.UserDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("User repository는")
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("UserAggregate를 던지면 저장하고, id로 꺼내올 수 있다.")
    void setGetTest() throws ServiceException {
        UserAggregate randomAggregate = TestUtil.createRandomUserAggregate();
        UserDTO savedDTO = userRepository.save(randomAggregate);

        String createdId = savedDTO.getUserId();

        UserAggregate foundUserAggregate = userRepository.findByUserId(createdId);

        UserDTO foundUserDTO = foundUserAggregate.toDTO();

        assertThat(savedDTO, samePropertyValuesAs(foundUserDTO));
    }

    @Test
    @DisplayName("틀린 ID를 넣으면 NULL을 리턴 한다.")
    void notFoundTest(){
        UserAggregate invalidId = userRepository.findByUserId("InvalidId");
        assertEquals(invalidId, null);
    }
}