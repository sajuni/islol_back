package com.islol.hyopgg.member.entity;

import com.islol.hyopgg.common.entity.BaseEntity;
import com.islol.hyopgg.league.entity.League;
import com.islol.hyopgg.member.dto.MemberSaveReqDTO;
import com.islol.hyopgg.naejeon.entity.Naejeon;
import com.islol.hyopgg.role.entity.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_member")
public class Member extends BaseEntity {
    @Id
    @Column(name = "mbr_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mbrSeq;
    @Column(name = "mbr_id", length = 100, nullable = false)
    private String mbrId;
    @Column(name = "mbr_gm_id", length = 100, nullable = false)
    private String mbrGmId;
    @Column(name = "mbr_pwd", length = 100, nullable = false)
    private String mbrPwd;
    @Column(name = "mbr_nm", length = 50, nullable = false)
    private String mbrNm;
    @Column(name = "mbr_phone", length = 20, nullable = false)
    private String mbrPhone;
    @Column(name = "mbr_sole", length = 20)
    private String mbrSole;
    @Column(name = "mbr_free", length = 20)
    private String mbrFree;
    @Column(name = "warning_count", length = 1)
    private Integer warningCount;
    @Column(name = "mbr_birth_day", length = 8)
    private String mbrBirthDay;
    @Column(name = "del_yn", length = 1)
    private String delYn;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "tb_member_role",
            joinColumns = @JoinColumn(name = "mbr_seq"),
            inverseJoinColumns = @JoinColumn(name = "role_seq"))
    private List<Role> roles = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "tb_naejeon_member",
            joinColumns = @JoinColumn(name = "mbr_seq"),
            inverseJoinColumns = @JoinColumn(name = "nj_seq"))
    private List<Naejeon> naejeons = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "tb_league_member",
            joinColumns = @JoinColumn(name = "mbr_seq"),
            inverseJoinColumns = @JoinColumn(name = "lg_seq"))
    private List<League> leagues = new ArrayList<>();

    public Member(MemberSaveReqDTO req) {
        this.mbrId = req.getMbrId();
        this.mbrGmId = req.getMbrGmId();
        this.mbrPwd = req.getMbrPwd();
        this.mbrNm = req.getMbrNm();
        this.mbrPhone = req.getMbrPhone();
        this.mbrSole = req.getMbrSole();
        this.mbrFree = req.getMbrFree();
        this.mbrBirthDay = req.getMbrBirthDay();
        this.roles = req.getRoles();
        this.delYn = "N";
    }

    public void addNaejeon(Naejeon naejeon) {
        naejeons.add(naejeon);
        naejeon.getMembers().add(this);
    }
    public void addLeague(League league) {
        leagues.add(league);
        league.getMembers().add(this);
    }
}
