package com.islol.hyopgg.league.service;

import com.islol.hyopgg.league.dto.LeagueReqDTO;
import com.islol.hyopgg.league.entity.League;
import com.islol.hyopgg.league.repository.LeagueRepository;
import com.islol.hyopgg.member.entity.Member;
import com.islol.hyopgg.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LeagueService {

    private final MemberRepository memberRepository;
    private final LeagueRepository leagueRepository;

    @Transactional
    public void save(LeagueReqDTO reqDTO) {
        List<Member> members = memberRepository.findByMbrSeqIn(reqDTO.getMembers());
        League league = new League();
        for (Member member : members) {
            member.addLeague(league);
        }
        leagueRepository.save(league);
    }


}
