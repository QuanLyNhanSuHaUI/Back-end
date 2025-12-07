package com.example.quanlynhansu.domain.dto.request;

import com.example.quanlynhansu.constant.ErrorMessage;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentUpdateRequest {

    private String departmentCode;

    private String name;

    private String description;

}
