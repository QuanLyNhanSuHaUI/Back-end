package com.example.quanlynhansu.domain.dto.request.department;

import com.example.quanlynhansu.constant.ErrorMessage;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentUpdateRequest {

    private String departmentCode;

    private String name;

    private String description;

}
