package com.example.quanlynhansu.service;

import com.example.quanlynhansu.domain.dto.request.payroll.PayrollCreationRequest;
import com.example.quanlynhansu.domain.dto.response.PayrollResponse;

public interface PayrollService {

    PayrollResponse createPayroll(PayrollCreationRequest request);

}
