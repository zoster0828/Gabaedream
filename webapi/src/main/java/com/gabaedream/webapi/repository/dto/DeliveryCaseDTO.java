package com.gabaedream.webapi.repository.dto;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Builder
@EqualsAndHashCode
@Table(name = "delivery_case")
public class DeliveryCaseDTO {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "start", nullable = false)
    String start;

    @Column(name = "destination", nullable = false)
    String destination;

    @Column(name = "start_time")
    Long startTime;

    @Column(name = "end_time")
    Long endTime;

    @Column(name = "price", nullable = false)
    Integer price;

    @Column(name = "status", nullable = false)
    Integer status;

    @Column(name = "sender_rating")
    Float senderRating;

    @Column(name = "messenger_rating")
    Float messengerRating;

    @Column(name = "sender_id", nullable = false)
    String senderId;

    @Column(name = "messenger_id", nullable = false)
    String messengerId;

    @Column(name = "server_created_time")
    Long serverCreatedTime;

    @Column(name = "server_updated_time")
    Long serverUpdatedTime;
}
