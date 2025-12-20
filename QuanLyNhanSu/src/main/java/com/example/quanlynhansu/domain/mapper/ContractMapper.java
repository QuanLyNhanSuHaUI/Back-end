package com.example.quanlynhansu.domain.mapper;

import com.example.quanlynhansu.domain.dto.request.contract.ContractCreationRequest;
import com.example.quanlynhansu.domain.dto.request.contract.ContractUpdateRequest;
import com.example.quanlynhansu.domain.dto.response.ContractResponse;
import com.example.quanlynhansu.domain.dto.response.EmployeeResponse;
import com.example.quanlynhansu.domain.entity.Contract;
import com.example.quanlynhansu.domain.entity.Employee;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContractMapper {

    Contract toContract(ContractCreationRequest request);

    @Mapping(source = "employee.fullName", target = "employeeName")
    ContractResponse toContractResponse(Contract contract);

    List<ContractResponse> toListContractResponses(List<Contract> list);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateContractResponse (ContractUpdateRequest request, @MappingTarget Contract contract);

}
