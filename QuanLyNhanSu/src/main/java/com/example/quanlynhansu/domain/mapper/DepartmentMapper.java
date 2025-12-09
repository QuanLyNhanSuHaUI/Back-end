package com.example.quanlynhansu.domain.mapper;


import com.example.quanlynhansu.domain.dto.request.department.DepartmentCreationRequest;
import com.example.quanlynhansu.domain.dto.request.department.DepartmentUpdateRequest;
import com.example.quanlynhansu.domain.dto.response.DepartmentResponse;
import com.example.quanlynhansu.domain.entity.Department;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentResponse toDepartmentResponse(Department department);
    Department toDepartment(DepartmentCreationRequest request);

    List<DepartmentResponse> toListDepartmentResponse(List<Department> departments);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDepartment(DepartmentUpdateRequest request, @MappingTarget Department department);

}
