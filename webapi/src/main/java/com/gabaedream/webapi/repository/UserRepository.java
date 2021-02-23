package com.gabaedream.webapi.repository;

import com.gabaedream.webapi.domain.aggregate.UserAggregate;
import com.gabaedream.webapi.domain.exception.ResultCode;
import com.gabaedream.webapi.domain.exception.ServiceException;
import com.gabaedream.webapi.repository.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    UserCRUDRepository userCRUDRepository;

    public UserAggregate findByUserId(String userId) throws ServiceException {
        Optional<UserDTO> result = userCRUDRepository.findById(userId);
        if(result.isPresent()){
            return new UserAggregate(result.get());
        } else{
            throw new ServiceException(ResultCode.USER_ID_NOT_FOUND, userId);
        }
    }

    public void save(UserAggregate userAggregate) {
        UserDTO userDTO = userCRUDRepository.save(userAggregate.toDTO());;
    }
}
