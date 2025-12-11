package com.example.quanlynhansu.controller;

import com.example.quanlynhansu.base.RestApiV1;
import com.example.quanlynhansu.base.VsResponseUtil;
import com.example.quanlynhansu.constant.UrlConstant;
import com.example.quanlynhansu.domain.dto.request.auth.LoginRequest;
import com.example.quanlynhansu.repository.EmployeeRepository;
import com.example.quanlynhansu.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestApiV1
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {

    AuthService authService;

    @PostMapping(UrlConstant.Auth.LOGIN)
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        return VsResponseUtil.success(HttpStatus.OK, authService.login(request));
    }

}
