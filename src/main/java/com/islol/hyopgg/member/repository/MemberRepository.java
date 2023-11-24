package com.islol.hyopgg.member.repository;

import com.islol.hyopgg.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMbrId(String mbrId);
    Optional<Member> findByMbrSeq(Long seq);
    boolean existsByMbrId(String mbrId);

    List<Member> findByMbrSeqIn(List<Long> memberSeq);
}
