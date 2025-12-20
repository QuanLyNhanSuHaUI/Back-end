package com.example.quanlynhansu.domain.mapper;

import com.example.quanlynhansu.domain.dto.request.payroll.PayrollCreationRequest;
import com.example.quanlynhansu.domain.dto.response.PayrollResponse;
import com.example.quanlynhansu.domain.entity.Payroll;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PayrollMapper {

    Payroll toPayroll(PayrollCreationRequest request);

    PayrollResponse toPayrollResponse(Payroll payroll);

    List<PayrollResponse> toPayrollResponsePage(List<Payroll> payrolls);

}
