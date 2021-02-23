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
@Table(name = "user_info")
public class UserDTO {
    @Id
    @Column(name = "user_id", nullable = false)
    String userId;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "nick_name", nullable = false)
    String nickName;

    @Column(name = "legal_name", nullable = false)
    String legalName;

    @Column(name = "phone_number", nullable = false)
    Long phoneNumber;

    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "address", nullable = false)
    String address;

    @Column(name = "service_count", nullable = false)
    Integer serviceCount;

    @Column(name = "rating", nullable = false)
    Float rating;

    @Column(name = "messenger", nullable = false)
    Boolean messenger;

    @Column(name = "user_status", nullable = false)
    Integer userStatus;
}
