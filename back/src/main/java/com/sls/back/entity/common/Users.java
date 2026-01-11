package com.sls.back.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "USERS")
public class Users {
    //사용자

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    //기본키,사용자 고유번호 (PK)

    @Column(name = "EMAIL", nullable = false)
    private String email;
    //이메일

    @Column(name = "PASSWORD", nullable = false)
    private String password;
    //비밀번호

    @Column(name = "NICKNAME")
    private String nickname;
    //닉네임(닉네임 설정하지 않았을 시엔 이메일이 출력)

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;
    //사용자 생성일

    // ================= 강제 생성자 =================
    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }
    // 생성자

    // ================= 연관관계 =================
    @PrePersist
    private void onCreate() {
        this.createDate = LocalDateTime.now();
    }
    // 생성일 자동 생성


}
