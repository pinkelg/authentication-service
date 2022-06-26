package com.gurung.authentication.controllers.auth;

import com.gurung.authentication.controllers.payload.request.UserNameAndPasswordLoginRequest;
import com.gurung.authentication.controllers.payload.response.UserNameAndPasswordLoginResponse;
import com.gurung.authentication.security.jwt.JwtUtils;
import com.gurung.authentication.user.services.UserDetailsImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Author: Pinkel Gurung
 * Date: 6/25/22
 * Time: 10:50 PM
 */

@RestController
@Slf4j
@RequestMapping("/api/auth")
public class login {

    private AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;



    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setJwtUtils(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@Valid @RequestBody UserNameAndPasswordLoginRequest userNameAndPasswordLoginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userNameAndPasswordLoginRequest.getUsername(), userNameAndPasswordLoginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new UserNameAndPasswordLoginResponse(
                        userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getFirstName(),
                        userDetails.getMiddleName(),
                        userDetails.getLastName(),
                        roles));
    }
}
