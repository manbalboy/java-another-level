package com.manbalboy.jpa.bookmanaber.repository;

import com.manbalboy.jpa.bookmanaber.domain.Book;
import com.manbalboy.jpa.bookmanaber.domain.BookReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookReviewInfoRepositoryTest {
    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void crudTest() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
//        bookReviewInfo.setBookId(1L);
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);

        System.out.println(bookReviewInfoRepository.findAll());
    }

    @Test
    void crudTest2() {
        Book book = givenBook();
        givenBookReviewInfo(book);

        System.out.println(">>>>>>" + bookReviewInfoRepository.findAll());

        Book result = bookReviewInfoRepository.findById(1L)
                .orElseThrow(RuntimeException::new)
                .getBook();


        System.out.println(">>>>>" + result);

    }


    Book givenBook() {
        Book book = new Book();
        book.setName("백두대간");
        book.setAuthorId(1L);
        book.setPublisherId(1L);

        return bookRepository.save(book);
    }

    void givenBookReviewInfo(Book book) {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();

//        bookReviewInfo.setBookId(1L);
        bookReviewInfo.setBook(book);
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);


        bookReviewInfoRepository.save(bookReviewInfo);
    }


}