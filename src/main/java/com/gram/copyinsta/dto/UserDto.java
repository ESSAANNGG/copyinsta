package com.gram.copyinsta.dto;

import com.gram.copyinsta.entity.Role;
import com.gram.copyinsta.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String userId;

    private String nickname;

    private String pw;

    private String email;

    private LocalDateTime localDateTime;

    private Role role;

    //DTO -> Entity
        public User toEntity(){
            User user = User.builder()
                    .userId(userId)
                    .nickname(nickname)
                    .pw(pw)
                    .email(email)
                    .joinDate(localDateTime)
                    .role(role)
                    .build();

            return user;
        }
}
