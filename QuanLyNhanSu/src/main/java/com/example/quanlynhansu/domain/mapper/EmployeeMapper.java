package com.example.quanlynhansu.domain.mapper;

import com.example.quanlynhansu.domain.dto.request.employee.EmployeeCreationRequest;
import com.example.quanlynhansu.domain.dto.request.employee.EmployeeUpdateRequest;
import com.example.quanlynhansu.domain.dto.response.EmployeeResponse;
import com.example.quanlynhansu.domain.entity.Employee;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEmployee(EmployeeCreationRequest request);

    @Mapping(source = "department.name", target = "departmentName")
    EmployeeResponse toEmployeeResponse(Employee employee);

    List<EmployeeResponse> toListEmployeeResponses(List<Employee> list);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEmployee(EmployeeUpdateRequest request, @MappingTarget Employee employee);

}
