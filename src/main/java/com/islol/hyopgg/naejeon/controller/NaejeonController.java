package com.islol.hyopgg.naejeon.controller;

import com.islol.hyopgg.naejeon.dto.NaejeonReqDTO;
import com.islol.hyopgg.naejeon.service.NaejeonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RequestMapping("/api/naejeon")
@RestController
public class NaejeonController {

    private final NaejeonService naejeonService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody NaejeonReqDTO reqDTO) {
        naejeonService.save(reqDTO);
        return ResponseEntity.ok("ok");
    }


}
