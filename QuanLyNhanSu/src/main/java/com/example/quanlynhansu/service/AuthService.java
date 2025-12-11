package com.example.quanlynhansu.service;

import com.example.quanlynhansu.domain.dto.request.auth.LoginRequest;
import com.example.quanlynhansu.domain.dto.response.auth.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);

}
