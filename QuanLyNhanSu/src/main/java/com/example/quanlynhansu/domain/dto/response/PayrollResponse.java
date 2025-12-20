package com.example.quanlynhansu.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayrollResponse {

    private BigDecimal baseSalary;
    private BigDecimal bonus;
    private BigDecimal deductionDecimal;
    private Integer month;
    private Integer year;

}
