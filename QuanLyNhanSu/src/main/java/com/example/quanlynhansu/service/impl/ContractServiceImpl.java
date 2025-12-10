package com.example.quanlynhansu.service.impl;

import com.example.quanlynhansu.constant.ErrorMessage;
import com.example.quanlynhansu.domain.dto.request.contract.ContractCreationRequest;
import com.example.quanlynhansu.domain.dto.response.ContractResponse;
import com.example.quanlynhansu.domain.entity.Contract;
import com.example.quanlynhansu.domain.entity.Employee;
import com.example.quanlynhansu.domain.mapper.ContractMapper;
import com.example.quanlynhansu.exception.DuplicateResourceException;
import com.example.quanlynhansu.exception.NotFoundException;
import com.example.quanlynhansu.repository.ContractRepository;
import com.example.quanlynhansu.repository.EmployeeRepository;
import com.example.quanlynhansu.service.ContractService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ContractServiceImpl implements ContractService {

    ContractMapper contractMapper;
    ContractRepository contractRepository;
    EmployeeRepository employeeRepository;

    @Override
    public ContractResponse createContract(ContractCreationRequest request) {

        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(()-> new NotFoundException(ErrorMessage.Employee.ERR_NOT_FOUND_ID));

        if (contractRepository.existsByContractCode(request.getContractCode())){
            throw new DuplicateResourceException(ErrorMessage.ERR_DUPLICATE,
                    new String[]{"Mã hợp đồng", request.getContractCode()});
        }

        Contract contract = contractMapper.toContract(request);

        contract.setEmployee(employee);

        Contract savedContract = contractRepository.save(contract);
        return contractMapper.toContractResponse(savedContract);
    }

    @Override
    public List<ContractResponse> getAllContract() {

        List<Contract> list = contractRepository.findAll();

        return contractMapper.toListContractResponses(list);
    }

    @Override
    public ContractResponse getContractById(String id) {

        Contract contract = contractRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(ErrorMessage.Contract.ERR_NOT_FOUND_ID
                        , new String[]{id}));

        return contractMapper.toContractResponse(contract);
    }

    @Override
    public List<ContractResponse> getContractByEmployeeName(String name) {

        List<Employee> employees = employeeRepository.findByFullNameContaining(name);

        if (employees.isEmpty()){
            return Collections.emptyList();
        }

        List<String> employeeIds = employees.stream()
                .map(Employee::getId)
                .collect(Collectors.toList());

        List<Contract> contracts = contractRepository.findByEmployeeIdIn(employeeIds);

        return contractMapper.toListContractResponses(contracts);
    }
}
