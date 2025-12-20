package com.example.quanlynhansu.repository;

import com.example.quanlynhansu.domain.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
@Repository
public interface PayrollRepository extends JpaRepository<Payroll, String>, JpaSpecificationExecutor<Payroll> {
}
