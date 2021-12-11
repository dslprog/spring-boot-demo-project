package com.dslprog.cursospringboot.service;

import com.dslprog.cursospringboot.dto.RoleDto;
import com.dslprog.cursospringboot.model.Role;
import com.dslprog.cursospringboot.repository.IRoleJpaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RoleServiceImpl implements IRoleService{

    @Autowired
    private IRoleJpaRepository roleJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RoleDto create(RoleDto roleDto) {
        Role role = modelMapper.map(roleDto, Role.class);
        role = roleJpaRepository.save(role);
        return modelMapper.map(role,RoleDto.class);
    }
}
