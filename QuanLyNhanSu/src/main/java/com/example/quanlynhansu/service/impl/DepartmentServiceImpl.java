package com.example.quanlynhansu.service.impl;

import com.example.quanlynhansu.constant.ErrorMessage;
import com.example.quanlynhansu.domain.dto.request.DepartmentCreationRequest;
import com.example.quanlynhansu.domain.dto.request.DepartmentUpdateRequest;
import com.example.quanlynhansu.domain.dto.response.DepartmentResponse;
import com.example.quanlynhansu.domain.entity.Department;
import com.example.quanlynhansu.domain.mapper.DepartmentMapper;
import com.example.quanlynhansu.exception.DuplicateResourceException;
import com.example.quanlynhansu.exception.NotFoundException;
import com.example.quanlynhansu.repository.DepartmentRepository;
import com.example.quanlynhansu.service.DepartmentService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<DepartmentResponse> getAllDepartments() {

        List<Department> departments = departmentRepository.findAll();

        return departmentMapper.toListDepartmentResponse(departments);
    }

    @Override
    public DepartmentResponse getDepartmentById(String id) {

        Department department = departmentRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(ErrorMessage.Department.ERR_NOT_FOUND_ID, new String[]{id}));
        return departmentMapper.toDepartmentResponse(department);
    }

    @Override
    public DepartmentResponse getDepartmentByName(String name) {

        Department department = departmentRepository.findDepartmentByName(name);

        if(department == null){
            throw new NotFoundException(ErrorMessage.Department.USERNAME_NOT_FOUND);
        }
        return departmentMapper.toDepartmentResponse(department);
    }

    @Override
    @Transactional
    public DepartmentResponse updateDepartment(DepartmentUpdateRequest request, String id) {

        Department department = departmentRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(ErrorMessage.Department.ERR_NOT_FOUND_ID,
                        new String[]{id}));

        departmentMapper.updateDepartment(request, department);

        departmentRepository.save(department);

        return departmentMapper.toDepartmentResponse(department);
    }

    @Override
    public DepartmentResponse deleteDepartment(String id) {
        Department department = departmentRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(ErrorMessage.Department.ERR_NOT_FOUND_ID,
                        new String[]{id}));
        departmentRepository.delete(department);
        return departmentMapper.toDepartmentResponse(department);
    }


}
