package com.example.quanlynhansu.service.impl;

import com.example.quanlynhansu.constant.ErrorMessage;
import com.example.quanlynhansu.domain.dto.request.auth.LoginRequest;
import com.example.quanlynhansu.domain.dto.response.auth.LoginResponse;
import com.example.quanlynhansu.domain.entity.Employee;
import com.example.quanlynhansu.exception.NotFoundException;
import com.example.quanlynhansu.repository.EmployeeRepository;
import com.example.quanlynhansu.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthServiceImpl implements AuthService {

    EmployeeRepository employeeRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public LoginResponse login(LoginRequest request) {
        try{
            Employee employee = employeeRepository.findByEmployeeCode(request.getEmployeeCode())
                    .orElseThrow(()-> new NotFoundException(ErrorMessage.Auth.ERR_INCORRECT_CREDENTIALS));
            log.info(passwordEncoder.encode(request.getPassword()));
            log.info(employee.getPassword());
            if (passwordEncoder.matches(request.getPassword(),employee.getPassword())){
                return new LoginResponse(employee.getId(), employee.getEmployeeCode(), employee.getFullName());
            }
            else {
                throw new NotFoundException(ErrorMessage.Auth.ERR_INCORRECT_CREDENTIALS);
            }
        }catch (Exception e) {
        throw new RuntimeException("Lỗi hệ thống khi đăng nhập.");
        }
    }
}
