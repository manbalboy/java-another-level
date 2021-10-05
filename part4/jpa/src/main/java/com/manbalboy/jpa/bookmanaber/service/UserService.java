package com.manbalboy.jpa.bookmanaber.service;

import com.manbalboy.jpa.bookmanaber.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class UserService {
    @Autowired
    private EntityManager entityManager;

//    @Autowired
//    private UserRepository userRepository;

    @Transactional
    public void put() {
        User user = new User();
        user.setName("new User");
        user.setEmail("newUser@fastcampus.com");
//        userRepository.save(user);

        entityManager.persist(user);

        entityManager.detach(user); //영속성으로 관리하지않게 함

        user.setName("훈");

        entityManager.merge(user);
        entityManager.clear();
    }
}
