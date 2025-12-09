package com.example.quanlynhansu.domain.dto.request.department;

import com.example.quanlynhansu.constant.ErrorMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentCreationRequest {

    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    private String departmentCode;

    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    private String name;

    @NotNull(message = ErrorMessage.Validation.NOT_EMPTY)
    private String description;

}
