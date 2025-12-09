package com.example.quanlynhansu.domain.dto.request.employee;

import com.example.quanlynhansu.constant.ErrorMessage;
import com.example.quanlynhansu.constant.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateRequest {

    @Size(min = 10, max = 10, message = ErrorMessage.Validation.INVALID_EMPLOYEE_CODE)
    private String employeeCode;

    private String fullName;

    @Email(message = ErrorMessage.Validation.INVALID_FORMAT_FIELD)
    private String email;

    private Gender gender;

    private LocalDate dateOfBirth;

    private String phoneNumber;

    private String position;

    private String qualification;

    private String username;
}
