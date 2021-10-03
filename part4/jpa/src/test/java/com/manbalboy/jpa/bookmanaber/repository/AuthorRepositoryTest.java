package com.manbalboy.jpa.bookmanaber.repository;

import com.manbalboy.jpa.bookmanaber.domain.Author;
import com.manbalboy.jpa.bookmanaber.domain.Book;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;


    @Test
    @Transactional
    void manyToMany() {
        Book book1 = givenBook("백두대간1");
        Book book2 = givenBook("백두대간2");
        Book book3 = givenBook("용의자x헌신");
        Book book4 = givenBook("개발책3");

        Author author1 = givenAuthor("훈");
        Author author2 = givenAuthor("윤헤");

        book1.addAuthor(author1, author2);
        book2.addAuthor(author2);
        book3.addAuthor(author2);
        book4.addAuthor(author1, author2);

        author1.addBooks(book1, book2, book4);
        author2.addBooks(book2, book1, book3);

        bookRepository.saveAll(Lists.newArrayList(book1, book2, book3, book4));
        authorRepository.saveAll(Lists.newArrayList(author1, author2));


        System.out.println("authors through book : " + bookRepository.findAll().get(2).getAuthors());
        System.out.println("=================================================================");
        System.out.println("books through author : " + authorRepository.findAll().get(0).getBooks());

    }

    Book givenBook(String name) {
        return bookRepository.save(Book.builder().name(name).build());
    }

    Author givenAuthor(String name) {
        return authorRepository.save(Author.builder().name(name).build());
    }
}