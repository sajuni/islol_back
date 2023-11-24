package com.islol.hyopgg.naejeon.entity;

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
@Table(name = "tb_naejeon")
public class Naejeon extends BaseEntity {
    @Id
    @Column(name = "nj_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long njSeq;

    @ManyToMany(mappedBy = "naejeons")
    private List<Member> members = new ArrayList<>();

}
