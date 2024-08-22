package com.server.demo.growup.src.user.vo;



import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "user_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, unique = true)
    private String userUuid;
    private String userName;
    private String userNickname;

    @Column(nullable = false, unique = true)
    private String userEmail; // 로컬로그인 시 아이디로 대체
    private String userPassword; // 로컬 비밀번호
    private Timestamp createdAt;
    private String refreshToken;
    private Timestamp expiration;
    private Boolean isCouple;
    private String opponentUuid;


}
