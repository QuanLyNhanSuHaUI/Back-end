package com.example.quanlynhansu.service.impl;

import com.example.quanlynhansu.constant.ErrorMessage;
import com.example.quanlynhansu.domain.dto.request.employee.EmployeeCreationRequest;
import com.example.quanlynhansu.domain.dto.request.employee.EmployeeUpdateRequest;
import com.example.quanlynhansu.domain.dto.response.EmployeeResponse;
import com.example.quanlynhansu.domain.entity.Employee;
import com.example.quanlynhansu.domain.mapper.EmployeeMapper;
import com.example.quanlynhansu.exception.DuplicateResourceException;
import com.example.quanlynhansu.exception.NotFoundException;
import com.example.quanlynhansu.repository.EmployeeRepository;
import com.example.quanlynhansu.service.EmployeeService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
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

    @Override
    public EmployeeResponse getEmployeeById(String id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(ErrorMessage.Employee.ERR_NOT_FOUND_ID, new String[]{id}));

        return employeeMapper.toEmployeeResponse(employee);
    }

    @Override
    public List<EmployeeResponse> getEmployeeByFullName(String name) {

        List<Employee> employee = employeeRepository.findByFullNameContaining(name);

        if (employee == null){
            throw new NotFoundException(ErrorMessage.Employee.USERNAME_NOT_FOUND);
        }

        return employeeMapper.toListEmployeeResponses(employee);
    }

    @Override
    @Transactional
    public EmployeeResponse updateEmployee(EmployeeUpdateRequest request, String id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(ErrorMessage.Employee.ERR_NOT_FOUND_ID,
                        new String[]{id}));


        employeeMapper.updateEmployee(request,employee);


        employeeRepository.save(employee);

        return employeeMapper.toEmployeeResponse(employee);
    }

    @Override
    public EmployeeResponse deleteEmployee(String id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(ErrorMessage.Employee.ERR_NOT_FOUND_ID,
                        new String[]{id}));

        employeeRepository.delete(employee);
        return employeeMapper.toEmployeeResponse(employee);
    }
}
