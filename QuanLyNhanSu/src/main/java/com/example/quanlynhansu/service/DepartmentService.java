package com.example.quanlynhansu.service;

import com.example.quanlynhansu.domain.dto.request.department.DepartmentCreationRequest;
import com.example.quanlynhansu.domain.dto.request.department.DepartmentUpdateRequest;
import com.example.quanlynhansu.domain.dto.response.DepartmentResponse;

import java.util.List;

public interface DepartmentService {

    DepartmentResponse createDepartment(DepartmentCreationRequest request);

    List<DepartmentResponse> getAllDepartments();

    DepartmentResponse getDepartmentById(String id);

    DepartmentResponse getDepartmentByName(String name);

    DepartmentResponse updateDepartment(DepartmentUpdateRequest request, String id);

    DepartmentResponse deleteDepartment(String id);

}
