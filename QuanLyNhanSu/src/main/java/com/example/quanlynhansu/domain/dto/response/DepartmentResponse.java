package com.example.quanlynhansu.domain.dto.response;

import com.example.quanlynhansu.constant.ErrorMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResponse {

    private String departmentCode;

    private String name;

    private String description;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

}
