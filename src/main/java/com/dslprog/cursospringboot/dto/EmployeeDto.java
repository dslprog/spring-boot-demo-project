package com.dslprog.cursospringboot.dto;

import com.dslprog.cursospringboot.model.Project;
import com.dslprog.cursospringboot.model.Role;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String badgeNumber;
    private String email;
    private Role role;
    private List<Project> projects;
}
