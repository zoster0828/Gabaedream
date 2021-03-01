package com.gabaedream.webapi.messenger.view.response;

import com.gabaedream.webapi.repository.dto.MessengerDTO;
import lombok.Data;

import java.util.List;

/**
 * 출발지, 도착지, 시간(요일(월화수목금)/시간), 이동 수단, 최소금액
 */
@Data
public class MessengerListView {
    private List<MessengerDTO> list;

    public MessengerListView(List<MessengerDTO> list) {
        this.list = list;
    }
}
