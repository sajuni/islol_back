package com.islol.hyopgg.naejeon.service;

import com.islol.hyopgg.member.entity.Member;
import com.islol.hyopgg.member.repository.MemberRepository;
import com.islol.hyopgg.naejeon.dto.NaejeonReqDTO;
import com.islol.hyopgg.naejeon.entity.Naejeon;
import com.islol.hyopgg.naejeon.repository.NaejeonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class NaejeonService {

    private final NaejeonRepository naejeonRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void save(NaejeonReqDTO reqDTO) {
        List<Member> members = memberRepository.findByMbrSeqIn(reqDTO.getMembers());
        Naejeon naejeon = new Naejeon();
        for (Member member : members) {
            member.addNaejeon(naejeon);
        }
        naejeonRepository.save(naejeon);
    }

}
