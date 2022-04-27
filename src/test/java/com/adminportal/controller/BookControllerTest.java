package com.adminportal.controller;

import com.adminportal.domain.Book;
import com.adminportal.service.BookService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ContextConfiguration(classes = BookController.class)
@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    @InjectMocks
    BookController bookController;

    @Mock
    BookService bookService;
    @Mock
    Model model;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @AfterEach
    void tearDown() {
        reset(bookService);
    }

    @Test
    void addBook() throws Exception {
        Book book = mock(Book.class);
        model.addAttribute("book", book);
        mockMvc.perform(get("/api/v1/book/add"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("book"))
                .andExpect(view().name("addBook"));
    }

    @Test
    void bookInfo() throws Exception {
        Book book = mock(Book.class);
        given(bookService.findById(any())).willReturn(book);
        model.addAttribute("book", book);
        mockMvc.perform(get("/api/v1/book/bookInfo?id=" + book.getId()))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("book"))
                .andExpect(view().name("bookDetails"));
    }

    @Test
    void updateBook() throws Exception {
        Book book = mock(Book.class);
        model.addAttribute("book", book);
        given(bookService.findById(any())).willReturn(book);

        mockMvc.perform(get("/api/v1/book/updateBook?id=" + book.getId()))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("book"))
                .andExpect(view().name("updateBook"));
    }

    @Test
    void bookList() throws Exception {
        given(bookService.findAll()).willReturn(Lists.newArrayList(new Book(), new Book()));

        mockMvc.perform(get("/api/v1/book/books"))
                .andExpect(status().isOk())
                .andExpect(view().name("bookList"));
    }

}