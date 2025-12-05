package com.example.quanlynhansu.service.impl;

import com.example.quanlynhansu.constant.ErrorMessage;
import com.example.quanlynhansu.domain.dto.request.DepartmentCreationRequest;
import com.example.quanlynhansu.domain.dto.response.DepartmentResponse;
import com.example.quanlynhansu.domain.entity.Department;
import com.example.quanlynhansu.domain.mapper.DepartmentMapper;
import com.example.quanlynhansu.exception.DuplicateResourceException;
import com.example.quanlynhansu.repository.DepartmentRepository;
import com.example.quanlynhansu.service.DepartmentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentServiceImpl implements DepartmentService {

    DepartmentMapper departmentMapper;

    DepartmentRepository departmentRepository;


    @Override
    public DepartmentResponse createDepartment(DepartmentCreationRequest request) {

        if(departmentRepository.existsByDepartmentCode(request.getDepartmentCode())){
            throw new DuplicateResourceException(ErrorMessage.ERR_DUPLICATE,
                    new String[]{"Mã phòng",request.getDepartmentCode()});
        }

        if(departmentRepository.existsByName(request.getName())){
            throw new DuplicateResourceException(ErrorMessage.ERR_DUPLICATE,
                    new String[]{"Tên phòng",request.getName()});
        }

        Department department = departmentMapper.toDepartment(request);

        Department savedDepartment = departmentRepository.save(department);

        return departmentMapper.toDepartmentResponse(savedDepartment);
    }
}
