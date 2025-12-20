package com.example.quanlynhansu.domain.dto.request.payroll;

import com.example.quanlynhansu.constant.ErrorMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayrollCreationRequest {
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    private BigDecimal baseSalary;
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    private BigDecimal bonus;
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    private BigDecimal deductionDecimal;
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    private Integer month;
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    private Integer year;
    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    private String employeeId;
}
