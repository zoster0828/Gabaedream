package com.gabaedream.webapi.interfaces.controller.view;

import com.gabaedream.webapi.domain.aggregate.ChatroomAggregate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ChatroomInfoView {

    private ChatroomAggregate chatroomAggregate;
}
