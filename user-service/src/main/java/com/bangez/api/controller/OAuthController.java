package com.bangez.api.controller;

import com.bangez.api.domain.dto.OAuth2UserDTO;
import com.bangez.api.service.OAuthService;
import com.bangez.api.domain.dto.LoginDTO;
import com.bangez.api.domain.dto.PrincipalUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class OAuthController {

    private final OAuthService service;

//    @PostMapping("/login/local")
//    public Mono<PrincipalUserDetails> login(@RequestBody LoginDTO dto) {
//        log.info("login: {}", dto);
//        return Mono.just(new PrincipalUserDetails
//                (UserModel.builder()
//                        .id("aaa1234")
//                        .name("test")
//                        .email(dto.getEmail())
//                        .profile("testProfile.jpg")
//                        .roles(List.of(Role.ROLE_USER))
//                        .registration(Registration.LOCAL)
//                        .build(), null));
//    }

    @PostMapping("/login/local")
    public PrincipalUserDetails localLogin(@RequestBody LoginDTO dto){
        log.info("로컬 로그인 메소드");
        return service.login(dto);
    }

    @PostMapping("/oauth2/{registration}")
    public ResponseEntity<LoginDTO> oauthJoin(@RequestBody OAuth2UserDTO dto) {
        log.info("user oauth2 파라미터: {} ", dto);
        return ResponseEntity.ok(service.oauthJoin(dto));
    }

}