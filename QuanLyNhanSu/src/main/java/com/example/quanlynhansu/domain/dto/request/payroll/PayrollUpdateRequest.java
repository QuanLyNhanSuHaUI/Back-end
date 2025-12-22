package com.example.quanlynhansu.domain.dto.request.payroll;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayrollUpdateRequest {

    private BigDecimal baseSalary;

    private BigDecimal bonus;

    private BigDecimal deductionDecimal;

    private Integer month;

    private Integer year;

}
