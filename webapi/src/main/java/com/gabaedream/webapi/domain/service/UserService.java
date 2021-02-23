package com.gabaedream.webapi.domain.service;

import com.gabaedream.webapi.domain.aggregate.UserAggregate;
import com.gabaedream.webapi.domain.exception.ServiceException;
import com.gabaedream.webapi.interfaces.controller.requests.UserRequest;
import com.gabaedream.webapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserAggregate getUserWithId(String userId) throws ServiceException {
        return userRepository.findByUserId(userId);
    }

    public void createNewUser(UserRequest userRequest) {
        userRepository.save(new UserAggregate(userRequest));
    }
}
