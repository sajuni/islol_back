package com.islol.hyopgg.member.dto;

import com.islol.hyopgg.role.entity.Role;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class MemberSaveReqDTO {
    @NotNull
    private String mbrId;
    @NotNull
    private String mbrGmId;
    @NotNull
    private String mbrPwd;
    @NotNull
    private String mbrNm;
    @NotNull
    private String mbrPhone;
    private String mbrSole;
    private String mbrFree;
    private String mbrBirthDay;
    private List<Role> roles;

}
