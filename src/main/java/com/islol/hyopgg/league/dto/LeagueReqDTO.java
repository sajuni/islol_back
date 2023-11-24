package com.islol.hyopgg.league.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
public class LeagueReqDTO {
    private List<Long> members = new ArrayList<>();
}
