package com.example.quanlynhansu.domain.dto.response;

import com.example.quanlynhansu.constant.ContractType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractResponse {

    private String contractCode;

    private ContractType contractType;

    private LocalDate startDate;

    private LocalDate endDate;

    private String jobTitle;

    private Integer salaryLevel;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private String employeeName;

}
