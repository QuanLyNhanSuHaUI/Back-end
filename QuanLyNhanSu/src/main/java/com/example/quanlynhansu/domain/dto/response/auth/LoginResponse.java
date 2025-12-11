package com.example.quanlynhansu.domain.dto.response.auth;

import com.example.quanlynhansu.constant.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    private String token; // Token JWT/Bearer

    private String id;
    private String employeeCode;
    private String fullName;

    private Role role;

    public LoginResponse(String id, String employeeCode, String fullName) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.fullName = fullName;
        this.token = null;
        this.role = null;
    }
}
