package com.gabaedream.webapi.interfaces.controller;

import com.gabaedream.webapi.domain.aggregate.UserAggregate;
import com.gabaedream.webapi.domain.exception.ServiceException;
import com.gabaedream.webapi.domain.service.UserService;
import com.gabaedream.webapi.interfaces.controller.requests.CreateUserRequest;
import com.gabaedream.webapi.interfaces.view.UserInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UserInfoController extends BaseController{

    @Autowired
    UserService userService;

    @GetMapping("/user/{userId}")
    public UserInfoView getUserInformation(@PathVariable("userId") String userId) throws ServiceException {
        UserAggregate userAggregate = userService.getUserWithId(userId);
        return new UserInfoView(userAggregate);
    }

    @PostMapping("/user")
    public UserInfoView createNewUser(@RequestBody CreateUserRequest createUserRequest) throws ServiceException {
        UserAggregate newUser = userService.createNewUser(createUserRequest);
        return new UserInfoView(newUser);
    }
}
