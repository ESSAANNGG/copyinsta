package com.gram.copyinsta.dto;

import com.gram.copyinsta.entity.MemberRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {

    private String userId;

    private String nickname;

    private String pw;

    private LocalDateTime localDateTime;

    private MemberRole role;

    //DTO -> Entity작업
//        public Member toEntity(){
//            Member user = Member.builder()
//                    .userId(userId)
//                    .nickname(nickname)
//                    .pw(pw)
//                    .joinDate(localDateTime)
//                    .role(role)
//                    .build();
//            return user;
//        }
}
