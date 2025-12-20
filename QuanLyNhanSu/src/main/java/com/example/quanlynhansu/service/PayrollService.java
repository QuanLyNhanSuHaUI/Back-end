package com.example.quanlynhansu.service;

import com.example.quanlynhansu.domain.dto.request.payroll.PayrollCreationRequest;
import com.example.quanlynhansu.domain.dto.response.PayrollResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PayrollService {

    PayrollResponse createPayroll(PayrollCreationRequest request);

    PayrollResponse getPayrollById(String id);

}
