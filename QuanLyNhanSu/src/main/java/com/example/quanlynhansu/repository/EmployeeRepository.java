package com.example.quanlynhansu.repository;

import com.example.quanlynhansu.domain.entity.Department;
import com.example.quanlynhansu.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    boolean existsByEmployeeCode(String departmentCode);

    boolean existsByEmployeeCodeAndIdNot(String employeeCode, String id);

    boolean existsByFullName(String fullName);

    List<Employee> findByFullNameContaining(String fullName);

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, String id);

    Optional<Employee> findByEmployeeCode(String employeeCode);
}
