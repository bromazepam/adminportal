package com.adminportal.repository;

import com.adminportal.domain.User;
import com.adminportal.utility.SecurityUtility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    @BeforeEach
    void setUp() {
        User user = new User();
        user.setId(1L);
        user.setUsername("testName");
        user.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
        user.setEmail("test@mail.com");
        underTest.save(user);
    }

    @AfterEach
    void tearDown() {
        underTest.deleteById(1L);
    }

    @Disabled
    @Test
    void itShouldFindUserByUsername() {
        //when
        User expected = underTest.findByUsername("testName");

        //then
        assertThat(expected.getUsername()).isEqualTo("testName");
    }

    @Disabled
    @Test
    void findByEmail() {
        //when
        User expected = underTest.findByEmail("test@mail.com");

        //then
        assertThat(expected.getEmail()).isEqualTo("test@mail.com");
    }
}