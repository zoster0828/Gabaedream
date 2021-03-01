package com.gabaedream.webapi.messenger;

import com.gabaedream.webapi.domain.exception.ServiceException;
import com.gabaedream.webapi.interfaces.controller.BaseController;
import com.gabaedream.webapi.interfaces.controller.view.DefaultView;
import com.gabaedream.webapi.messenger.repository.dto.MessengerDTO;
import com.gabaedream.webapi.messenger.view.request.MessengerListParameter;
import com.gabaedream.webapi.messenger.view.request.MessengerRegisterRequest;
import com.gabaedream.webapi.messenger.view.response.MessengerListView;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunkenrush
 * @apiNote 메신저 CRUD API
 */
@RestController
public class MessengerController extends BaseController {
    private final MessengerService messengerService;

    public MessengerController(MessengerService messengerService) {
        this.messengerService = messengerService;
    }

    @GetMapping("/messenger")
    public MessengerListView getMessengerList(
            MessengerListParameter param
            ) throws ServiceException {
        MessengerListView info = new MessengerListView(messengerService.getMessengerInformation(param));
        return info;
    }

    @GetMapping("/user/{userId}/messenger")
    public MessengerListView getMessengerRegisteredInformation(@PathVariable("userId") String userId) throws ServiceException {
        MessengerListView info = new MessengerListView(messengerService.getMessengerInformationWithUserId(userId));
        return info;
    }

    @PostMapping("/user/{userId}/messenger")
    public DefaultView registerMessanger(
            @PathVariable("userId") String userId,
            @RequestBody MessengerRegisterRequest req) throws ServiceException {
        MessengerDTO info = messengerService.registerMessanger(req);
        return new DefaultView(HttpStatus.CREATED);
    }

}
