package com.islol.hyopgg.naejeon.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class NaejeonReqDTO {
    private List<Long> members = new ArrayList<>();
}
