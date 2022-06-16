package com.gram.copyinsta.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "userId")
@ToString
public class Member {
    @Id //PK 옵션
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userId;

    @Column
    private String pw;

    @Column
    private String nickname;

    @Column
    private LocalDateTime joinDate;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="userId")
    private List<MemberRole> memberRoles;



}
