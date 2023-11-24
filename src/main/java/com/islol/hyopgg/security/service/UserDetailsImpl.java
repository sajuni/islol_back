package com.islol.hyopgg.security.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.islol.hyopgg.member.entity.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserDetailsImpl implements UserDetails {
    private Long mbrSeq;
    private String mbrId;
    private String mbrGmId;
    private String mbrNm;
    @JsonIgnore
    private String mbrPwd;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long mbrSeq, String mbrId, String mbrGmId, String mbrNm, String mbrPwd,
                           Collection<? extends GrantedAuthority> authorities) {
        this.mbrSeq = mbrSeq;
        this.mbrId = mbrId;
        this.mbrGmId = mbrGmId;
        this.mbrNm = mbrNm;
        this.mbrPwd = mbrPwd;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(Member member) {
        List<GrantedAuthority> authorities = member.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleNm().name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                member.getMbrSeq(),
                member.getMbrId(),
                member.getMbrGmId(),
                member.getMbrNm(),
                member.getMbrPwd(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return mbrPwd;
    }

    @Override
    public String getUsername() {
        return mbrNm;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(mbrSeq, user.mbrSeq);
    }
}