package com.gabaedream.webapi.messenger;

import com.gabaedream.webapi.domain.service.UserService;
import com.gabaedream.webapi.repository.MessengerRepository;
import com.gabaedream.webapi.repository.dto.MessengerDTO;
import com.gabaedream.webapi.messenger.view.request.MessengerListParameter;
import com.gabaedream.webapi.messenger.view.request.MessengerRegisterRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunkenrush
 */
@Service
public class MessengerService {
    private final MessengerRepository messengerRepository;
    private final UserService userService;

    public MessengerService(MessengerRepository repository, UserService userService) {
        this.messengerRepository = repository;
        this.userService = userService;
    }

    public List<MessengerDTO>  getMessengerInformationWithUserId(String userId) {
        userService.getUserWithId(userId);
        List<MessengerDTO> list = messengerRepository.findByUserId(userId);
        return list;
    }

    public MessengerDTO registerMessanger(MessengerRegisterRequest req) {
        userService.registerMessenger(req.getUserId());

        MessengerDTO dto = req.toMessengerDTO(req);
        return messengerRepository.save(dto);

    }

    public List<MessengerDTO> getMessengerInformation(MessengerListParameter param) {
        String filter = param.getFilter().getFilter();
        int limit = param.getLimit();
        int offset = param.getOffset();
        List<MessengerDTO> list = messengerRepository.findByFilter(filter, limit, offset);
        return list;
    }
}
