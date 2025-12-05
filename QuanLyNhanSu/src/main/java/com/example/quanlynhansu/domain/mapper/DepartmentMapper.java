package com.example.quanlynhansu.domain.mapper;


import com.example.quanlynhansu.domain.dto.request.DepartmentCreationRequest;
import com.example.quanlynhansu.domain.dto.response.DepartmentResponse;
import com.example.quanlynhansu.domain.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentResponse toDepartmentResponse(Department department);
    Department toDepartment(DepartmentCreationRequest request);

    List<DepartmentResponse> toListDepartment(List<DepartmentResponse> departmentResponses);

}
