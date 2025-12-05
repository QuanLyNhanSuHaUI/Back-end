package com.example.quanlynhansu.service;

import com.example.quanlynhansu.domain.dto.request.DepartmentCreationRequest;
import com.example.quanlynhansu.domain.dto.response.DepartmentResponse;

public interface DepartmentService {

    DepartmentResponse createDepartment(DepartmentCreationRequest request);

}
