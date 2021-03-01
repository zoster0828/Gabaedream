package com.gabaedream.webapi.repository;

import com.gabaedream.webapi.repository.dto.MessengerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessengerMapper extends JpaRepository<MessengerDTO, String> {
    Optional<List<MessengerDTO>> findByUserId(String userId);
    MessengerDTO save(MessengerDTO dto);

    @Query(value = "SELECT * FROM messenger_info " +
            "ORDER BY :filter " +
            "LIMIT :limit " +
            "OFFSET :offset ", nativeQuery = true)
    Optional<List<MessengerDTO>> findByFilter(@Param("filter") String filter,
                                              @Param("limit") int limit,
                                              @Param("offset") int offset);
}
