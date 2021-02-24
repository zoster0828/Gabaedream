package com.gabaedream.webapi.messenger.repository;

import com.gabaedream.webapi.common.Day;
import com.gabaedream.webapi.domain.aggregate.UserAggregate;
import com.gabaedream.webapi.messenger.repository.dto.MessengerDTO;
import com.gabaedream.webapi.repository.dto.UserDTO;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Data
@Repository
public class MessengerRepository  {

    private final MessengerMapper mapper;

    public MessengerRepository(MessengerMapper mapper) {
        this.mapper = mapper;
    }

    public List<MessengerDTO> findByUserId(String userId) {
        Optional<List<MessengerDTO>> result = mapper.findByUserId(userId);
        if(result.isPresent()){
            return result.get();
        } else{
            return null;
        }
    }

    public MessengerDTO save(MessengerDTO messengerDTO) {
        MessengerDTO result = mapper.save(messengerDTO);
        return result;
    }


}
