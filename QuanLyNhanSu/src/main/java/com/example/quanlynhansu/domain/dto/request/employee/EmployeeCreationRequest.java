package com.example.quanlynhansu.domain.dto.request.employee;

import com.example.quanlynhansu.constant.ErrorMessage;
import com.example.quanlynhansu.constant.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCreationRequest {

    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    private String employeeCode;

    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    private String fullName;

    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    private String email;

    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    private Gender gender;

    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    private LocalDate dateOfBirth;

    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    private String phoneNumber;

    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    private String position;

    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    private String qualification;

}
