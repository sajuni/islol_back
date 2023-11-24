package com.islol.hyopgg.league.controller;


import com.islol.hyopgg.league.dto.LeagueReqDTO;
import com.islol.hyopgg.league.service.LeagueService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/api/league")
@RestController
public class LeagueController {

    private final LeagueService leagueService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody LeagueReqDTO reqDTO) {
        leagueService.save(reqDTO);
        return ResponseEntity.ok("ok");
    }
}
