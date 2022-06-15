package com.gram.copyinsta.repository;

import com.gram.copyinsta.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {
}
