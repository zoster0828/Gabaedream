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
@Table(name = "chatroom", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "sender_user_id", "messenger_user_id", "delivery_case_id"})})
public class ChatroomDTO {

    @Id
    @Column(name = "chatroom_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatroomId;

    @Column(name = "sender_user_id", nullable = false)
    private String senderId;

    @Column(name = "messenger_user_id", nullable = false)
    private String messengerId;

    @Column(name = "delivery_case_id")
    private Integer deliveryCaseId;
}
