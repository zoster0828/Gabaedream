package com.gabaedream.webapi.messenger;

import com.gabaedream.webapi.messenger.repository.MessengerRepository;
import com.gabaedream.webapi.messenger.repository.dto.MessengerDTO;
import com.gabaedream.webapi.messenger.view.request.MessengerRegisterRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunkenrush
 */
@Service
public class MessengerService {
    private final MessengerRepository repository;

    public MessengerService(MessengerRepository repository) {
        this.repository = repository;
    }

    public List<MessengerDTO>  getMessengerInformationWithUserId(String userId) {
        List<MessengerDTO> list = repository.findByUserId(userId);
        return list;
    }

    public MessengerDTO registerMessanger(MessengerRegisterRequest req) {
        MessengerDTO dto = req.toMessengerDTO(req);
        return repository.save(dto);
    }
}
