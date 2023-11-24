package com.islol.hyopgg.member.service;

import com.islol.hyopgg.member.dto.MemberInfoResDTO;
import com.islol.hyopgg.member.dto.MemberSaveReqDTO;
import com.islol.hyopgg.member.entity.Member;
import com.islol.hyopgg.member.repository.MemberRepository;
import com.islol.hyopgg.role.entity.Role;
import com.islol.hyopgg.role.enums.RoleNm;
import com.islol.hyopgg.role.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void registerMember(MemberSaveReqDTO reqDTO) throws Exception {
        if (memberRepository.existsByMbrId(reqDTO.getMbrId())) {
            throw new Exception("이미 존재하는 아이디 입니다.");
        }
        reqDTO.setMbrPwd(passwordEncoder.encode(reqDTO.getMbrPwd()));
        Optional<Role> byRole = roleRepository.findByRoleNm(RoleNm.ROLE_USER);
        if (byRole.isPresent()) {
            Role role = byRole.get();
            reqDTO.setRoles(List.of(role));
        } else {
            Role userRole = new Role();
            userRole.setRoleNm(RoleNm.ROLE_USER);
            reqDTO.setRoles(List.of(userRole));
        }

        Member member = new Member(reqDTO);
        memberRepository.save(member);
    }

    @Transactional
    public MemberInfoResDTO modifyMember(MemberSaveReqDTO reqDTO, Long seq) {
        Member member = memberRepository.findByMbrSeq(seq).get();

        member.setMbrGmId(reqDTO.getMbrGmId());
        member.setMbrPwd(passwordEncoder.encode(reqDTO.getMbrPwd()));
        member.setMbrNm(reqDTO.getMbrNm());
        member.setMbrPhone(reqDTO.getMbrPhone());
        member.setMbrSole(reqDTO.getMbrSole());
        member.setMbrFree(reqDTO.getMbrFree());

        return MemberInfoResDTO.toDto(memberRepository.save(member));
    }

}
