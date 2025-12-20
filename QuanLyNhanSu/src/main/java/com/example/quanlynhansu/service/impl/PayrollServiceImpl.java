package com.example.quanlynhansu.service.impl;

import com.example.quanlynhansu.constant.ErrorMessage;
import com.example.quanlynhansu.domain.dto.request.payroll.PayrollCreationRequest;
import com.example.quanlynhansu.domain.dto.response.PayrollResponse;
import com.example.quanlynhansu.domain.entity.Employee;
import com.example.quanlynhansu.domain.entity.Payroll;
import com.example.quanlynhansu.domain.mapper.PayrollMapper;
import com.example.quanlynhansu.exception.NotFoundException;
import com.example.quanlynhansu.repository.EmployeeRepository;
import com.example.quanlynhansu.repository.PayrollRepository;
import com.example.quanlynhansu.service.PayrollService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PayrollServiceImpl implements PayrollService {

    PayrollMapper payrollMapper;
    PayrollRepository payrollRepository;
    EmployeeRepository employeeRepository;

    @Override
    public PayrollResponse createPayroll(PayrollCreationRequest request) {

        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(()-> new NotFoundException(ErrorMessage.Employee.ERR_NOT_FOUND_ID));
        Payroll payroll = payrollMapper.toPayroll(request);

        payroll.setEmployee(employee);

        Payroll savedPayroll = payrollRepository.save(payroll);

        return payrollMapper.toPayrollResponse(savedPayroll);
    }
}
