package com.example.quanlynhansu.service;

import com.example.quanlynhansu.domain.dto.request.DepartmentCreationRequest;
import com.example.quanlynhansu.domain.dto.request.DepartmentUpdateRequest;
import com.example.quanlynhansu.domain.dto.response.DepartmentResponse;
import com.example.quanlynhansu.domain.entity.Department;

import java.util.List;

public interface DepartmentService {

    DepartmentResponse createDepartment(DepartmentCreationRequest request);

    List<DepartmentResponse> getAllDepartments();

    DepartmentResponse getDepartmentById(String id);

    DepartmentResponse getDepartmentByName(String name);

    DepartmentResponse updateDepartment(DepartmentUpdateRequest request, String id);

}
