package com.adminportal.service.impl;

import com.adminportal.domain.User;
import com.adminportal.repository.UserRepository;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class UserSecurityServiceTest {

    @Mock
    UserRepository userRepository;

    @Test
    void loadUserByUsername() {
        given(userRepository.findByUsername(anyString())).willReturn(new User());

        User user = userRepository.findByUsername(anyString());

        then(userRepository).should().findByUsername(anyString());
        assertThat(user).isNotNull();
    }

    @Test
    void loadUserByUsernameNotFound() {
        User user = userRepository.findByUsername("2");

        AssertionsForClassTypes.assertThat(user).isNull();

    }
}