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
@Table(name = "messenger_info")
public class MessengerDTO {
        @Id
        @Column(name = "id", nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "user_id", nullable = false)
        String userId;

        @Column(name = "start", nullable = false)
        String start;

        @Column(name = "destination", nullable = false)
        String destination;

        @Column(name = "day", nullable = false)
        String day;

        @Column(name = "transportation", nullable = false)
        String transportation;

        @Column(name = "min_price", nullable = false)
        Integer minimumPrice;
}
