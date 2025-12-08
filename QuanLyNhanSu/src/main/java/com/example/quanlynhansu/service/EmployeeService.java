package com.example.quanlynhansu.service;

import com.example.quanlynhansu.domain.dto.request.employee.EmployeeCreationRequest;
import com.example.quanlynhansu.domain.dto.response.EmployeeResponse;
import org.springframework.stereotype.Repository;


public interface EmployeeService {

    EmployeeResponse createEmployee(EmployeeCreationRequest request);

}
