package com.example.quanlynhansu.repository;

import com.example.quanlynhansu.domain.entity.Department;
import com.example.quanlynhansu.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    boolean existsByEmployeeCode(String departmentCode);

    boolean existsByFullName(String fullName);

    Employee findEmployeeByFullName(String fullName);

    boolean existsByEmail(String email);
}
