package com.dslprog.cursospringboot.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RoleDto {
    private Long id;

    @NotBlank
    @Size(max=15)
    private String name;
}
