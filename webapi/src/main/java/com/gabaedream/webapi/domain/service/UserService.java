package com.gabaedream.webapi.domain.service;

import com.gabaedream.webapi.domain.aggregate.UserAggregate;
import com.gabaedream.webapi.domain.exception.ResultCode;
import com.gabaedream.webapi.domain.exception.ServiceException;
import com.gabaedream.webapi.interfaces.controller.requests.CreateUserRequest;
import com.gabaedream.webapi.repository.UserRepository;
import com.gabaedream.webapi.repository.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserAggregate getUserWithId(String userId) throws ServiceException {
        UserAggregate foundAggregate = userRepository.findByUserId(userId);
        if(foundAggregate == null){
            throw new ServiceException(ResultCode.USER_ID_NOT_FOUND, userId);
        } else {
            return foundAggregate;
        }
    }


    public UserAggregate createNewUser(CreateUserRequest createUserRequest) {
        UserAggregate findFirst = userRepository.findByUserId(createUserRequest.getUserId());

        if(findFirst == null) {
            UserAggregate userAggregate = new UserAggregate(createUserRequest);
            UserDTO createdDTO = userRepository.save(userAggregate);
            return new UserAggregate(createdDTO);
        } else {
            throw new ServiceException(ResultCode.ALREADY_EXISTS_USER, createUserRequest.getUserId());
        }
    }

    public void registerMessenger(String userId) {
        UserAggregate foundUser = getUserWithId(userId);
        foundUser.registerMessenger();
        userRepository.save(foundUser);
    }
}
