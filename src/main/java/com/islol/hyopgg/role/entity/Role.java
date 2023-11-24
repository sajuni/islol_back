package com.islol.hyopgg.role.entity;

import com.islol.hyopgg.common.entity.BaseEntity;
import com.islol.hyopgg.member.entity.Member;
import com.islol.hyopgg.role.enums.RoleNm;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tb_role")
public class Role extends BaseEntity {
    @Id
    @Column(name = "role_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleSeq;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role_nm", nullable = false)
    private RoleNm roleNm;

    @ManyToMany(mappedBy = "roles")
    private List<Member> members = new ArrayList<>();

}
