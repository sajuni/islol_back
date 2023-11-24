package com.islol.hyopgg.member.controller;

import com.islol.hyopgg.member.dto.LoginDTO;
import com.islol.hyopgg.member.dto.MemberInfoResDTO;
import com.islol.hyopgg.member.dto.MemberSaveReqDTO;
import com.islol.hyopgg.member.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RequestMapping("/api/member")
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody MemberSaveReqDTO reqDTO) throws Exception {
        memberService.registerMember(reqDTO);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/modify/{seq}")
    public ResponseEntity<?> modify(@RequestBody MemberSaveReqDTO reqDTO, @PathVariable("seq") Long seq) {
        MemberInfoResDTO memberInfoResDTO = memberService.modifyMember(reqDTO, seq);
        return ResponseEntity.ok(memberInfoResDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        System.out.println("loginDTO = " + loginDTO);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getMbrId(), loginDTO.getMbrPwd());
        return ResponseEntity.ok("dd");
    }
}
