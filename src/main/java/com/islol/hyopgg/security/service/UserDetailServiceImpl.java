package com.islol.hyopgg.security.service;

import com.islol.hyopgg.member.entity.Member;
import com.islol.hyopgg.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String mbrId) throws UsernameNotFoundException {
        System.out.println("========================= 5 =========================");
        Member member = memberRepository.findByMbrId(mbrId)
                .orElseThrow(() -> new UsernameNotFoundException("회원 아이디를 확인해 주세요." + mbrId));
        return UserDetailsImpl.build(member);
    }
}
