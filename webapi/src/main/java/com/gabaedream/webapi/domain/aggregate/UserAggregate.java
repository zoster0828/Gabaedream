package com.gabaedream.webapi.domain.aggregate;

import com.gabaedream.webapi.interfaces.controller.requests.CreateUserRequest;
import com.gabaedream.webapi.repository.dto.UserDTO;
import lombok.Getter;

import javax.persistence.Entity;

@Getter
public class UserAggregate {
    String userId;
    String password;
    String nickName;
    String legalName;
    Long phoneNumber;
    String email;
    String address;
    Integer serviceCount;
    Integer userStatus;
    Float rating;
    Boolean messenger;

    public UserAggregate(UserDTO userDTO) {
        this.userId = userDTO.getUserId();
        this.password = userDTO.getPassword();
        this.nickName = userDTO.getNickName();
        this.legalName = userDTO.getLegalName();
        this.phoneNumber = userDTO.getPhoneNumber();
        this.email = userDTO.getEmail();
        this.address = userDTO.getAddress();
        this.serviceCount = userDTO.getServiceCount();
        this.rating = userDTO.getRating();
        this.messenger = userDTO.getMessenger();
        this.userStatus = userDTO.getUserStatus();
    }

    public UserAggregate(CreateUserRequest createUserRequest) {
        this.userId = createUserRequest.getUserId();
        this.password = createUserRequest.getPassword();
        this.nickName = createUserRequest.getNickName();
        this.legalName = createUserRequest.getLegalName();
        this.phoneNumber = createUserRequest.getPhoneNumber();
        this.email = createUserRequest.getEmail();
        this.address = createUserRequest.getAddress();
        this.serviceCount = 0;
        this.userStatus = 1;
        this.rating = 0f;
        this.messenger = false;
    }

    public UserDTO toDTO() {
        UserDTO userDTO = UserDTO.builder()
                .userId(userId)
                .password(password)
                .nickName(nickName)
                .legalName(legalName)
                .phoneNumber(phoneNumber)
                .email(email)
                .address(address)
                .serviceCount(serviceCount)
                .userStatus(userStatus)
                .rating(rating)
                .messenger(messenger)
                .build();

        return userDTO;
    }
}
