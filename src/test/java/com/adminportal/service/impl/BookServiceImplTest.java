package com.adminportal.service.impl;

import com.adminportal.domain.Book;
import com.adminportal.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @InjectMocks
    BookServiceImpl bookService;
    @Mock
    BookRepository bookRepository;

    @Test
    void save() {
        //given
        Book book = new Book();
        //when
        bookService.save(book);
        //then
        verify(bookRepository).save(book);
    }

    @Test
    void findAll() {
        //given
        List<Book> bookList = new ArrayList<>();
        given(bookRepository.findAll()).willReturn(bookList);
        //when
        Collection<Book> expected = bookService.findAll();
        //then
        then(bookRepository).should().findAll();
        assertThat(expected).isNotNull();
    }

    @Test
    void findById() {
        //given
        Book book = new Book();
        given(bookRepository.findById(any())).willReturn(Optional.of(book));
        //when
        Optional<Book> expected = bookService.findById(any());
        //then
        then(bookRepository).should().findById(any());
        assertThat(expected).isNotNull();
    }

    @Test
    void removeOne() {
        bookService.removeOne(any());
        verify(bookRepository).deleteById(any());
    }
}