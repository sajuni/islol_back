package com.islol.hyopgg.member.dto;

import com.islol.hyopgg.member.entity.Member;
import com.islol.hyopgg.security.jwt.JwtToken;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberInfoResDTO {
    private Long mbrSeq;
    private String mbrId;
    private String mbrGmId;
    private String mbrNm;
    private String mbrPhone;
    private String mbrSole;
    private String mbrFree;
    private String mbrBirthDay;
//    private List<Role> roles;
    private Map<String, Object> roles = new HashMap<>();
    private JwtToken jwtToken;

    public static MemberInfoResDTO toDto(Member member) {
        MemberInfoResDTO memberInfoResDTO = new MemberInfoResDTO();
        memberInfoResDTO.setMbrSeq(member.getMbrSeq());
        memberInfoResDTO.setMbrId(member.getMbrId());
        memberInfoResDTO.setMbrGmId(member.getMbrGmId());
        memberInfoResDTO.setMbrNm(member.getMbrNm());
        memberInfoResDTO.setMbrPhone(member.getMbrPhone());
        memberInfoResDTO.setMbrSole(member.getMbrSole());
        memberInfoResDTO.setMbrFree(member.getMbrFree());
        memberInfoResDTO.setMbrBirthDay(member.getMbrBirthDay());
        Map<String, Object> role = new HashMap<>();
        role.put("roleNm", member.getRoles().get(0).getRoleNm().name());
        role.put("roleSeq", member.getRoles().get(0).getRoleSeq());
        memberInfoResDTO.setRoles(role);
        return memberInfoResDTO;
    }
}
