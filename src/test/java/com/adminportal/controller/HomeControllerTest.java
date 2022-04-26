package com.adminportal.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {

    @Test
    void adminHome() {
        HomeController controller = new HomeController();
        assertEquals("home", controller.home());
    }

    @Test
    void adminIndex() {
        HomeController controller = new HomeController();
        assertEquals("redirect:/home", controller.index());
    }

    @Test
    void adminLogin() {
        HomeController controller = new HomeController();
        assertEquals("login", controller.login());
    }

}