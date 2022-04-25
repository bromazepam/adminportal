package com.adminportal.controller;

import com.adminportal.repository.BookRepository;
import com.adminportal.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class ResourceControllerTest {

    @Test
    void testRemoveList() {
        ResourceController resourceController = new ResourceController(new BookServiceImpl(mock(BookRepository.class)));
        ArrayList<String> bookIdList = new ArrayList<>();
        assertEquals("delete success", resourceController.removeList(bookIdList, new ConcurrentModel()));
    }
}

