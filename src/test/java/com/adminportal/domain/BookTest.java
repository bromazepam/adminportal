package com.adminportal.domain;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BookTest {
    @Test
    void testConstructor() throws UnsupportedEncodingException {
        Book actualBook = mock(Book.class);
        actualBook.setActive(true);
        actualBook.setAuthor("JaneDoe");
        MockMultipartFile mockMultipartFile = new MockMultipartFile("Name", "AAAAAAAA".getBytes("UTF-8"));

        actualBook.setBookImage(mockMultipartFile);
        ArrayList<BookToCartItem> bookToCartItemList = new ArrayList<>();
        actualBook.setBookToCartItemList(bookToCartItemList);
        actualBook.setCategory("Category");
        actualBook.setDescription("The characteristics of someone or something");
        actualBook.setFormat("Format");
        actualBook.setId(123L);
        actualBook.setInStockNumber(10);
        actualBook.setIsbn(1);
        actualBook.setLanguage("en");
        actualBook.setListPrice(10.0);
        actualBook.setNumberOfPages(10);
        actualBook.setOurPrice(10.0);
        actualBook.setPublicationDate("2020-03-01");
        actualBook.setPublisher("Publisher");
        actualBook.setShippingWeight(10.0);
        actualBook.setTitle("Dr");
        assertEquals("JaneDoe", actualBook.getAuthor());
        assertSame(mockMultipartFile, actualBook.getBookImage());
        assertSame(bookToCartItemList, actualBook.getBookToCartItemList());
        assertEquals("Category", actualBook.getCategory());
        assertEquals("The characteristics of someone or something", actualBook.getDescription());
        assertEquals("Format", actualBook.getFormat());
        assertEquals(123L, actualBook.getId().longValue());
        assertEquals(10, actualBook.getInStockNumber());
        assertEquals(1, actualBook.getIsbn());
        assertEquals("en", actualBook.getLanguage());
        assertEquals(10.0, actualBook.getListPrice());
        assertEquals(10, actualBook.getNumberOfPages());
        assertEquals(10.0, actualBook.getOurPrice());
        assertEquals("2020-03-01", actualBook.getPublicationDate());
        assertEquals("Publisher", actualBook.getPublisher());
        assertEquals(10.0, actualBook.getShippingWeight());
        assertEquals("Dr", actualBook.getTitle());
        assertTrue(actualBook.isActive());
    }
}

