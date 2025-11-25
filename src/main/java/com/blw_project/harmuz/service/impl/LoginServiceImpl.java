package com.blw_project.harmuz.service.impl;

import com.blw_project.harmuz.dto.AuthResponse;
import com.blw_project.harmuz.dto.LoginRequest;
import com.blw_project.harmuz.service.LoginService;
import com.blw_project.harmuz.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Override
    public AuthResponse authenticate(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        String token = jwtUtil.generateToken(authentication.getName(),
                authentication.getAuthorities());

        return new AuthResponse(token);
    }
}