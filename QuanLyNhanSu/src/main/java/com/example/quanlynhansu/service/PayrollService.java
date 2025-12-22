package com.example.quanlynhansu.service;

import com.example.quanlynhansu.domain.dto.request.payroll.PayrollCreationRequest;
import com.example.quanlynhansu.domain.dto.request.payroll.PayrollUpdateRequest;
import com.example.quanlynhansu.domain.dto.response.PayrollResponse;
import com.example.quanlynhansu.domain.entity.Payroll;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface PayrollService {

    PayrollResponse createPayroll(PayrollCreationRequest request);

    PayrollResponse getPayrollById(String id);

    Page<PayrollResponse> getPayrollByConditions(BigDecimal baseSalary, Integer month, Integer year, Pageable pageable);

    PayrollResponse updatePayroll(PayrollUpdateRequest request, String id);

}
