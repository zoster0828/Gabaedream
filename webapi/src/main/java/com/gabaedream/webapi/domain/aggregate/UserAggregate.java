package com.gabaedream.webapi.domain.aggregate;

import com.gabaedream.webapi.interfaces.controller.requests.UserRequest;
import com.gabaedream.webapi.repository.dto.UserDTO;

public class UserAggregate {
    String userId;
    String password;
    String nickName;
    String legalName;
    Integer phoneNumber;
    String email;
    String address;
    String serviceCount;
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
    }

    public UserAggregate(UserRequest userRequest) {
        this.userId = null;
        this.password = userRequest.getPassword();
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
