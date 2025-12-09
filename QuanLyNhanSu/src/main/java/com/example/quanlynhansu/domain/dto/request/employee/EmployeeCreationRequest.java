package com.example.quanlynhansu.domain.dto.request.employee;

import com.example.quanlynhansu.constant.ErrorMessage;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeCreationRequest {

    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    @Size(min = 10, max = 10, message = ErrorMessage.Validation.INVALID_EMPLOYEE_CODE)
    String employeeCode;

    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    String fullName;

    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    @Email(message = ErrorMessage.Validation.INVALID_FORMAT_FIELD)
    String email;

    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    private String departmentId;
}
