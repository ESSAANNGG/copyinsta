package com.gram.copyinsta;

import com.gram.copyinsta.entity.Member;
import com.gram.copyinsta.entity.MemberRole;
import com.gram.copyinsta.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.config.web.servlet.oauth2.login.OAuth2LoginSecurityMarker;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

@SpringBootTest
class CopyinstaApplicationTests {
    @Autowired
    MemberRepository memberRepository;


    @Test
    void contextLoads() {
    }

    @Test
    public void insertMember(){
        for(int i=0; i<10; i++){
            Member member = new Member();
            member.setUserId("member" +i);
            member.setPw("memberPw"+i);
            member.setNickname("nick"+i);
            MemberRole role = new MemberRole();
            if(i <= 8) {
                role.setRoleName("BASIC");
            }else if(i <= 9) {
                role.setRoleName("MANAGER");
            }else {
                role.setRoleName("ADMIN");
            }
            member.setMemberRoles(Arrays.asList(role));
            memberRepository.save(member);
        }
    }

//    @Test
//    public void testMember() {
//        Optional<Member> result = Optional.ofNullable(memberRepository.findOne(8));
//        result.ifPresent(member -> log.info("member " + member));
//    }

}
