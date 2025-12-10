package com.example.quanlynhansu.repository;

import com.example.quanlynhansu.domain.entity.Contract;
import com.example.quanlynhansu.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, String> {

    boolean existsByContractCode(String contractCode);

    List<Contract> findByEmployeeIdIn(List<String> employeeIds);
}
