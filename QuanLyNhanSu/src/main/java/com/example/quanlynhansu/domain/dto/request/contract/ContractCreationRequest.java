package com.example.quanlynhansu.domain.dto.request.contract;

import com.example.quanlynhansu.constant.ContractType;
import com.example.quanlynhansu.constant.ErrorMessage;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractCreationRequest {

    @Size(min = 10, max = 10, message = ErrorMessage.Validation.INVALID_EMPLOYEE_CODE)
    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    private String contractCode;
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    private ContractType contractType;
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    private LocalDate startDate;
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    private LocalDate endDate;
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    private String jobTitle;
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    private Integer salaryLevel;
    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    private String employeeId;

}
