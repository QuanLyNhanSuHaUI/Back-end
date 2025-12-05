package com.example.quanlynhansu.controller;

import com.example.quanlynhansu.base.RestApiV1;
import com.example.quanlynhansu.base.VsResponseUtil;
import com.example.quanlynhansu.constant.UrlConstant;
import com.example.quanlynhansu.domain.dto.request.DepartmentCreationRequest;
import com.example.quanlynhansu.domain.entity.Department;
import com.example.quanlynhansu.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;

@RestApiV1
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DepartmentController {

    DepartmentService departmentService;

    @PostMapping(UrlConstant.Department.DEPARTMENT_COMMON)
    public ResponseEntity<?> createDepartment(@Valid @RequestBody DepartmentCreationRequest request){
        return VsResponseUtil.success(HttpStatus.CREATED, departmentService.createDepartment(request));
    }

}
