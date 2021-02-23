package com.gabaedream.webapi.interfaces.controller.view;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class DefaultView {
    HttpStatus httpStatus;

}
