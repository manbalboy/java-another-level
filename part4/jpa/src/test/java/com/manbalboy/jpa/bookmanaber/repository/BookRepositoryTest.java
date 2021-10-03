package com.manbalboy.jpa.bookmanaber.repository;

import com.manbalboy.jpa.bookmanaber.domain.Book;
import com.manbalboy.jpa.bookmanaber.domain.Publisher;
import com.manbalboy.jpa.bookmanaber.domain.Review;
import com.manbalboy.jpa.bookmanaber.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void crudTest() {
        Book book = new Book();

        book.setCategory(">>");
        book.setAuthorId(1L);
        book.setName("백두대간");
//        book.setPublisherId(1L);

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }


    @Test
    @Transactional
    void bookRelationTest() {
        givenBookAndReview();
        User user = userRepository.findByEmail("martin@fastcampus.com");

        System.out.println("Review : " + user.getReviews());
        System.out.println("Book : " + user.getReviews().get(0).getBook());
        System.out.println("Publisher : " + user.getReviews().get(0).getBook().getPublisher());
    }


    void givenBookAndReview() {
        givenReview(givenUser(), givenBook(givenPublisher()));
    }

    Publisher givenPublisher() {
        return publisherRepository.save(Publisher.builder().name("교보").build());
    }

    Book givenBook(Publisher publisher) {
        Book book = Book.builder()
                .name("JAP")
                .publisher(publisher)
                .build();

        return bookRepository.save(book);
    }

    User givenUser() {
        return userRepository.findByEmail("martin@fastcampus.com");
    }

    void givenReview(User user, Book book) {
        Review review = Review.builder()
                .title("내인생을 바꾼책 ")
                .content("너무너무 재미있었음")
                .score(5.0f)
                .user(user)
                .book(book)
                .build();

        reviewRepository.save(review);

        System.out.println("======================");
        System.out.println(reviewRepository.findAll());
        System.out.println("======================");
    }

}