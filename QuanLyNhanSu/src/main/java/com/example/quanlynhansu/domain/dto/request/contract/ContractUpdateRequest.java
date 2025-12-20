package com.example.quanlynhansu.domain.dto.request.contract;

import com.example.quanlynhansu.constant.ContractType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractUpdateRequest {

    private String contractCode;
    private ContractType contractType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String jobTitle;
    private Integer salaryLevel;

}
