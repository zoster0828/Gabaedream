package com.gabaedream.webapi.messenger.repository;

import com.gabaedream.webapi.messenger.repository.dto.MessengerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessengerMapper extends JpaRepository<MessengerDTO, String> {
    Optional<List<MessengerDTO>> findByUserId(String userId);
    MessengerDTO save(MessengerDTO dto);
}
