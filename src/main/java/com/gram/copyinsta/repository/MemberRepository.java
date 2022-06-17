package com.gram.copyinsta.repository;

import com.gram.copyinsta.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Long> {
        List<Member> findByUserId(String userId);
}
