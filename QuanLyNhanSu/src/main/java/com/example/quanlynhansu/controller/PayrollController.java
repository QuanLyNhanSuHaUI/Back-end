package com.example.quanlynhansu.controller;

import com.example.quanlynhansu.base.RestApiV1;
import com.example.quanlynhansu.base.VsResponseUtil;
import com.example.quanlynhansu.constant.UrlConstant;
import com.example.quanlynhansu.domain.dto.request.payroll.PayrollCreationRequest;
import com.example.quanlynhansu.service.PayrollService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestApiV1
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PayrollController {

    PayrollService payrollService;

    @PostMapping(UrlConstant.Payroll.PAYROLL_COMMON)
    public ResponseEntity<?> createPayroll(@Valid @RequestBody PayrollCreationRequest request){
        return VsResponseUtil.success(HttpStatus.CREATED, payrollService.createPayroll(request));
    }

    @GetMapping(UrlConstant.Payroll.PAYROLL_ID)
    public ResponseEntity<?> getPayrollById(@PathVariable(required = false) String id){
        return VsResponseUtil.success(HttpStatus.OK, payrollService.getPayrollById(id));
    }

    @GetMapping(UrlConstant.Payroll.PAYROLL_CONDITIONS)
    public ResponseEntity<?> getPayrollByConditions(
            @RequestParam(required = false) BigDecimal baseSalary,
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer year, Pageable pageable){
        return VsResponseUtil.success(HttpStatus.OK,payrollService.getPayrollByConditions(baseSalary,month,year,pageable));
    }

}
