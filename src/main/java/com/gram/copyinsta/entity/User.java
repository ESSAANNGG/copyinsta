package com.gram.copyinsta.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class User {
    @Id //PK 옵션
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userId;

    @Column
    private String nickname;

    @Column
    private String pw;

    @Column
    private String email;

    @Column
    private LocalDateTime joinDate;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;


    public User(Long id, String pw, List<GrantedAuthority> authorities) {
    }
}
