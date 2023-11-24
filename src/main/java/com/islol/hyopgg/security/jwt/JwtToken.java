package com.islol.hyopgg.security.jwt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtToken {
    private String token;
    private String type = "Bearer";
}
