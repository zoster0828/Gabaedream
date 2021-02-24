package com.gabaedream.webapi.repository;

import com.gabaedream.webapi.repository.dto.DeliveryCaseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryCRUDRepository extends JpaRepository<DeliveryCaseDTO, String> {
    DeliveryCaseDTO save(DeliveryCaseDTO deliveryCaseDTO);

    DeliveryCaseDTO findById(int deliveryCaseId);
}
