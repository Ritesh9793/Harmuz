package com.blw_project.harmuz.service;

import com.blw_project.harmuz.dto.AuthResponse;
import com.blw_project.harmuz.dto.LoginRequest;

public interface LoginService {
    AuthResponse authenticate(LoginRequest request);
}