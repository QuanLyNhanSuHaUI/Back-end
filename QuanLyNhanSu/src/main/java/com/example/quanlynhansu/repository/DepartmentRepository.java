package com.example.quanlynhansu.repository;

import com.example.quanlynhansu.domain.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
    boolean existsByDepartmentCode(String departmentCode);

    boolean existsByName(String name);
}
