package com.gabaedream.webapi.interfaces.controller.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    String userId;
    String password;
    String nickName;
    String legalName;
    Long phoneNumber;
    String email;
    String address;
}
