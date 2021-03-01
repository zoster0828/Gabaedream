package com.gabaedream.webapi.interfaces.controller;

import com.gabaedream.webapi.domain.aggregate.ChatroomAggregate;
import com.gabaedream.webapi.domain.exception.ServiceException;
import com.gabaedream.webapi.domain.service.ChatroomService;
import com.gabaedream.webapi.interfaces.controller.requests.CreateChatroomRequest;
import com.gabaedream.webapi.interfaces.controller.view.ChatroomInfoView;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ChatroomController extends BaseController {

    private final ChatroomService chatroomService;

    public ChatroomController(ChatroomService chatroomService) {
        this.chatroomService = chatroomService;
    }

    @PostMapping("/chatroom")
    public ChatroomInfoView createChatroom(@RequestBody CreateChatroomRequest chatroomRequest) throws ServiceException {
        ChatroomAggregate chatroomAggregate = chatroomService.createChatroom(chatroomRequest);
        return new ChatroomInfoView(chatroomAggregate);
    }
}
