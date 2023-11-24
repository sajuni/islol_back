package com.islol.hyopgg.member.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDTO {
    private String mbrId;
    private String mbrPwd;
}
