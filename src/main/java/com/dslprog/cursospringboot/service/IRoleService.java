package com.dslprog.cursospringboot.service;

import com.dslprog.cursospringboot.dto.RoleDto;

import javax.validation.Valid;

public interface IRoleService {
    public RoleDto create(@Valid RoleDto roleDto);
}
