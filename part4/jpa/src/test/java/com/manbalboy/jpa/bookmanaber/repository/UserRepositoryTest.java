package com.manbalboy.jpa.bookmanaber.repository;

import com.manbalboy.jpa.bookmanaber.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {
        User user = new User();
        user.setEmail("slow");

        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", contains());
        Example<User> example = Example.of(user, matcher);

        userRepository.findAll(example).forEach(System.out::println);
    }

    @Test
    void sort() {
        userRepository.findAll(
                Sort.by(Sort.Direction.DESC, "name")
        ).forEach(System.out::println);
    }


    @Test
    void findByAllId() {
        userRepository.findAllById(
                Lists.newArrayList(1L, 5L, 3L)
        ).forEach(System.out::println);
    }


    @Test
    void saveAll() {
        User user = new User("훈", "manbalboy@hanmail.net");
        User userA = new User("윤혜", "0221jyh@hanmail.net");
        userRepository.saveAll(
                Lists.newArrayList(user, userA)
        );

        userRepository.findAll().forEach(System.out::println);
    }


    @Test
    void findById() {
        User user = new User("훈", "manbalboy@hanmail.net");
        User userA = new User("윤혜", "0221jyh@hanmail.net");
        userRepository.saveAll(
                Lists.newArrayList(user, userA)
        );

        User userB = userRepository.findById(6L).orElse(null);
        System.out.println("userB >> : " + userB);

        if (userRepository.findById(6L).isPresent()) {
            System.out.println(userRepository.findById(6L).get());
        }
    }
}