package com.example.quanlynhansu.service.impl;

import com.example.quanlynhansu.constant.ErrorMessage;
import com.example.quanlynhansu.domain.dto.request.payroll.PayrollCreationRequest;
import com.example.quanlynhansu.domain.dto.request.payroll.PayrollUpdateRequest;
import com.example.quanlynhansu.domain.dto.response.PayrollResponse;
import com.example.quanlynhansu.domain.entity.Employee;
import com.example.quanlynhansu.domain.entity.Payroll;
import com.example.quanlynhansu.domain.mapper.PayrollMapper;
import com.example.quanlynhansu.exception.NotFoundException;
import com.example.quanlynhansu.repository.EmployeeRepository;
import com.example.quanlynhansu.repository.PayrollRepository;
import com.example.quanlynhansu.service.PayrollService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public PayrollResponse getPayrollById(String id) {

       Payroll payroll = payrollRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorMessage.Payroll.ERR_NOT_FOUND_ID));

        return payrollMapper.toPayrollResponse(payroll);
    }

    @Override
    public Page<PayrollResponse> getPayrollByConditions(BigDecimal baseSalary, Integer month, Integer year, Pageable pageable) {

        Page<Payroll> payrolls = payrollRepository.findAll(new Specification<>() {
            @Override
            public @Nullable Predicate toPredicate(Root<Payroll> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();

                if (baseSalary!=null){
                    predicates.add(criteriaBuilder.equal(root.get("baseSalary"), baseSalary));
                }

                if (month!=null){
                    predicates.add(criteriaBuilder.equal(root.get("month"),month));
                }
                if (year!=null){
                    predicates.add(criteriaBuilder.equal(root.get("year"),year));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        },pageable);

        return payrolls.map(payrollMapper::toPayrollResponse);
    }

    @Override
    public PayrollResponse updatePayroll(PayrollUpdateRequest request, String id) {

        Payroll payroll = payrollRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(ErrorMessage.Payroll.ERR_NOT_FOUND_ID));

        payrollMapper.updatePayrollResponse(request,payroll);

        payrollRepository.save(payroll);

        return payrollMapper.toPayrollResponse(payroll);
    }
}
