package com.example.quanlynhansu.domain.dto.request.auth;

import com.example.quanlynhansu.constant.ErrorMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest {

    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    @Size(min = 10, max = 10, message = ErrorMessage.Validation.INVALID_EMPLOYEE_CODE)
    private String employeeCode;

    private String password;

}
