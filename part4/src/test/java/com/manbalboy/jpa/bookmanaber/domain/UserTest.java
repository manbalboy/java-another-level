package com.manbalboy.jpa.bookmanaber.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void test() {
        User user = new User();
        user.setEmail("manbalboy@hanmail.net");
        user.setName("훈");

        System.out.println(">>>>> : " + user);


        Assertions.assertEquals("훈", user.getName());
        Assertions.assertEquals("manbalboy@hanmail.net", user.getEmail());
    }
}