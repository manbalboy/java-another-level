package com.manbalboy.jpa.bookmanaber.repository;

import com.manbalboy.jpa.bookmanaber.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
//    User findByName(String name);

    List<User> findUsersByName(String name);

    User findByName(String name);

    User getByName(String name);

    User readByName(String name);

    User queryByName(String name);

    User searchByName(String name);

    User streamByName(String name);

    List<User> findFirst4ByName(String name);

    List<User> findTop3ByName(String name);


}
