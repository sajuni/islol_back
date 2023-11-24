package com.islol.hyopgg.league.entity;

import com.islol.hyopgg.common.entity.BaseEntity;
import com.islol.hyopgg.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tb_league")
public class League extends BaseEntity {
    @Id
    @Column(name = "lg_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lgSeq;

    @ManyToMany(mappedBy = "leagues")
    private List<Member> members = new ArrayList<>();
}
