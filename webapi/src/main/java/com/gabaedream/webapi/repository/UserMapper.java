package com.gabaedream.webapi.repository;

import com.gabaedream.webapi.repository.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMapper extends JpaRepository<UserDTO, String> {
    Optional<UserDTO> findByUserId(String userId);
    UserDTO save(UserDTO userDTO);
}
