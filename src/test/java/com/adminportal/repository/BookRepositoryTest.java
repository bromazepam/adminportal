package com.adminportal.repository;

import com.adminportal.domain.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void whenFindByTitle_thenReturnBook() {
        // given
        Book book = new Book();
        book.setId(1L);
        entityManager.persist(book);
        entityManager.flush();

        // when
        Optional<Book> found = bookRepository.findById(book.getId());

        // then
        assert (found.isPresent());
        assert (found.get().getId().equals(book.getId()));
    }
}