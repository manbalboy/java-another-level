package com.manbalboy.jpa.bookmanaber.service;


import com.manbalboy.jpa.bookmanaber.domain.User;
import com.manbalboy.jpa.bookmanaber.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class EntityManagerTest {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    void entityManagerTest() {
        entityManager.createQuery("select u from User u").getResultList().forEach(System.out::println);
    }

    @Test
    void cacheFindTest() {
        System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
        System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
        System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
        System.out.println(userRepository.findByEmail("martin@fastcampus.com"));

        System.out.println("==============================================================================");
        System.out.println("==============================================================================");
        System.out.println("==============================================================================");

        //key 로 조회하는경우 영속성 컨텍스트 cache 에 저당되어있는지 확인하고 캐쉬값을 가져다 사용한다.

        System.out.println(userRepository.findById(2L).get());
        System.out.println(userRepository.findById(2L).get());
        System.out.println(userRepository.findById(2L).get());
        System.out.println(userRepository.findById(2L).get().getUserHistories());
        System.out.println("==============================================================================");
        System.out.println("==============================================================================");
        System.out.println("==============================================================================");

        userRepository.deleteById(1L);


    }

    @Test
    void cacheFindTest2() {
        User user = userRepository.findById(1L).get();
        user.setName("훈");

        userRepository.save(user);

        System.out.println("===============");
        System.out.println("===============");
        System.out.println("===============");

        user.setEmail("manbalboy@hnamil.net");

        userRepository.save(user);
        userRepository.flush();
    }


    @Test
    void cacheFindTest3() {
        User user = userRepository.findById(1L).get();
        user.setName("훈");

        userRepository.save(user);

        System.out.println("===============");
        System.out.println("===============");
        System.out.println("===============");

        user.setEmail("manbalboy@hnamil.net");

        userRepository.save(user);


        System.out.println(userRepository.findAll());
    }

}
