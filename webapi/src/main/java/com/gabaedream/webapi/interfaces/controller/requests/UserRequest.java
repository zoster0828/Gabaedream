package com.gabaedream.webapi.interfaces.controller.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
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
}
