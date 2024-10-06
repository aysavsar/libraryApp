package com.aysavs.libraryApp.infrastructure.repository;

import com.aysavs.libraryApp.domain.aggragate.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
