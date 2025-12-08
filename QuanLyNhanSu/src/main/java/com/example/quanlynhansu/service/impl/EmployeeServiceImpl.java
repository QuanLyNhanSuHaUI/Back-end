package com.example.quanlynhansu.service.impl;

import com.example.quanlynhansu.constant.ErrorMessage;
import com.example.quanlynhansu.domain.dto.request.employee.EmployeeCreationRequest;
import com.example.quanlynhansu.domain.dto.response.EmployeeResponse;
import com.example.quanlynhansu.domain.entity.Employee;
import com.example.quanlynhansu.domain.mapper.EmployeeMapper;
import com.example.quanlynhansu.exception.DuplicateResourceException;
import com.example.quanlynhansu.repository.EmployeeRepository;
import com.example.quanlynhansu.service.EmployeeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeMapper employeeMapper;
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponse createEmployee(EmployeeCreationRequest request) {

        if(employeeRepository.existsByEmployeeCode(request.getEmployeeCode())){
            throw new DuplicateResourceException(ErrorMessage.ERR_DUPLICATE,
                    new String[]{"Mã nhân viên",request.getEmployeeCode()});
        }

        if (employeeRepository.existsByEmail(request.getEmail())){
            throw new DuplicateResourceException(ErrorMessage.ERR_DUPLICATE,
                    new String[]{"Email",request.getEmail()});
        }

        Employee employee = employeeMapper.toEmployee(request);

        Employee savedEmployee = employeeRepository.save(employee);

        return employeeMapper.toEmployeeResponse(savedEmployee);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {

        List<Employee> list = employeeRepository.findAll();

        return employeeMapper.toListEmployeeResponses(list);
    }
}
