package com.gabaedream.webapi.repository;

import com.gabaedream.webapi.domain.aggregate.UserAggregate;
import com.gabaedream.webapi.repository.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    UserMapper userMapper;

    public UserAggregate findByUserId(String userId) {
        Optional<UserDTO> result = userMapper.findByUserId(userId);
        if(result.isPresent()){
            return new UserAggregate(result.get());
        } else{
            return null;
        }
    }

    public UserDTO save(UserAggregate userAggregate) {
        UserDTO userDTO = userMapper.save(userAggregate.toDTO());
        return userDTO;
    }
}
