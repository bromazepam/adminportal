package com.adminportal.config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

@WebMvcTest(SecurityConfig.class)
class SecurityConfigTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPublicMatchers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/some-public-url"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithMockUser
    public void testAuthenticatedAccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/some-private-url"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testLoginPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testLogin() throws Exception {
        mockMvc.perform(formLogin("/login").user("user").password("password"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/"))
                .andExpect(MockMvcResultMatchers.status().isFound());
    }

    @Test
    public void testLogout() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/logout")
                        .with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/?logout"))
                .andExpect(MockMvcResultMatchers.status().isFound());
    }
}

