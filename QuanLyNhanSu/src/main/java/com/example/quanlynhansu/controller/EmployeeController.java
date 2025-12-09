package com.example.quanlynhansu.controller;

import com.example.quanlynhansu.base.RestApiV1;
import com.example.quanlynhansu.base.VsResponseUtil;
import com.example.quanlynhansu.constant.UrlConstant;
import com.example.quanlynhansu.domain.dto.request.employee.EmployeeCreationRequest;
import com.example.quanlynhansu.domain.dto.request.employee.EmployeeUpdateRequest;
import com.example.quanlynhansu.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestApiV1
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class EmployeeController {

    EmployeeService employeeService;

    @PostMapping(UrlConstant.Employee.EMPLOYEE_COMMON)
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeCreationRequest request){
        return VsResponseUtil.success(HttpStatus.CREATED, employeeService.createEmployee(request));
    }

    @GetMapping(UrlConstant.Employee.EMPLOYEE_COMMON)
    public ResponseEntity<?> getAllEmployees(){
        return VsResponseUtil.success(HttpStatus.OK, employeeService.getAllEmployees());
    }

    @GetMapping(UrlConstant.Employee.EMPLOYEE_ID)
    public ResponseEntity<?> getEmployeeById(@PathVariable String id){
        return VsResponseUtil.success(HttpStatus.OK, employeeService.getEmployeeById(id));
    }

    @GetMapping(UrlConstant.Employee.EMPLOYEE_NAME)
    public ResponseEntity<?> getEmployeeByFullName(@RequestParam String name){
        return VsResponseUtil.success(HttpStatus.OK, employeeService.getEmployeeByFullName(name));
    }

    @PatchMapping(UrlConstant.Employee.EMPLOYEE_ID)
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeUpdateRequest request, @PathVariable String id){
        return VsResponseUtil.success(HttpStatus.OK, employeeService.updateEmployee(request, id));
    }

}
