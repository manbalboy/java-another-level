package com.manbalboy.jpa.bookmanaber.service;

import com.manbalboy.jpa.bookmanaber.domain.Book;
import com.manbalboy.jpa.bookmanaber.repository.AuthorRepository;
import com.manbalboy.jpa.bookmanaber.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookServiceTest {

    @Autowired
    BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void isolationTest() {
        Book book = new Book();

        book.setName("JPA 강의");

        bookRepository.save(book);

        bookService.get(1L);

        System.out.println(">>>>" + bookRepository.findAll());
    }
}