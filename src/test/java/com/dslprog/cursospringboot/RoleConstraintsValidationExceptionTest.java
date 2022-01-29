package com.dslprog.cursospringboot;

import com.dslprog.cursospringboot.dto.RoleDto;
import com.dslprog.cursospringboot.model.Role;
import com.dslprog.cursospringboot.service.RoleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RoleConstraintsValidationExceptionTest {

    @Autowired
    private RoleServiceImpl roleService;

    @Test
    public void constraintsValidationExceptionTest(){
        RoleDto invalidRole = new RoleDto();
        assertThrows(ConstraintViolationException.class, () -> roleService.create(invalidRole) );
        invalidRole.setName("");
        assertThrows(ConstraintViolationException.class, () -> roleService.create(invalidRole) );
        invalidRole.setName("1234567890123456");
        assertThrows(ConstraintViolationException.class, () -> roleService.create(invalidRole) );
    }

    @Test
    public void shouldCreateRole(){
        String roleName = "ROLE_ADMIN";
        RoleDto roleDto = new RoleDto();
        roleDto.setName(roleName);
        roleDto = roleService.create(roleDto);
        assertEquals(roleDto.getName(), roleName);
        assertNotNull(roleDto.getId());
    }
}
