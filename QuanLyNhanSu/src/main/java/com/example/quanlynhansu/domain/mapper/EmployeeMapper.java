package com.example.quanlynhansu.domain.mapper;

import com.example.quanlynhansu.domain.dto.request.employee.EmployeeCreationRequest;
import com.example.quanlynhansu.domain.dto.response.EmployeeResponse;
import com.example.quanlynhansu.domain.entity.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEmployee(EmployeeCreationRequest request);

    EmployeeResponse toEmployeeResponse(Employee employee);

    List<EmployeeResponse> toListEmployeeResponses(List<Employee> list);

}
