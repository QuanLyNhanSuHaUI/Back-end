package com.example.quanlynhansu.service;

import com.example.quanlynhansu.domain.dto.request.employee.EmployeeCreationRequest;
import com.example.quanlynhansu.domain.dto.request.employee.EmployeeUpdateRequest;
import com.example.quanlynhansu.domain.dto.response.EmployeeResponse;
import com.example.quanlynhansu.domain.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeService {

    EmployeeResponse createEmployee(EmployeeCreationRequest request);

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse getEmployeeById(String id);

    List<EmployeeResponse> getEmployeeByFullName(String name);

    EmployeeResponse updateEmployee(EmployeeUpdateRequest request, String id);

    EmployeeResponse deleteEmployee(String id);

}
