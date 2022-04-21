package com.adminportal.repository;

import com.adminportal.domain.security.Role;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Disabled
    @Test
    void findByName() {
        //given
        Role role = new Role();
        role.setRoleId(1);
        role.setName("admin");
        roleRepository.save(role);
        //when
        Role expected = roleRepository.findByName("admin");

        //then
        assertThat(expected.getName()).isEqualTo(role.getName());
    }
}