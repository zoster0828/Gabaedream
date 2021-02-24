package com.gabaedream.webapi.messenger;

import com.gabaedream.webapi.domain.exception.ServiceException;
import com.gabaedream.webapi.interfaces.controller.view.DefaultView;
import com.gabaedream.webapi.messenger.repository.dto.MessengerDTO;
import com.gabaedream.webapi.messenger.view.request.MessengerRegisterRequest;
import com.gabaedream.webapi.messenger.view.response.MessengerListView;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunkenrush
 * @apiNote 메신저 CRUD API
 */
@RestController
@RequestMapping("/messenger")
public class MessengerController {
    private final MessengerService messengerService;

    public MessengerController(MessengerService messengerService) {
        this.messengerService = messengerService;
    }

    @GetMapping("/user/{userId}")
    public MessengerListView getMessengerRegisteredInformation(@PathVariable("userId") String userId) throws ServiceException {
        MessengerListView info = new MessengerListView(messengerService.getMessengerInformationWithUserId(userId));
        return info;
    }

    @PostMapping("/user")
    public DefaultView registerMessanger(
            @RequestBody MessengerRegisterRequest req) throws ServiceException {
        MessengerDTO info = messengerService.registerMessanger(req);
        return new DefaultView(HttpStatus.CREATED);
    }

}
