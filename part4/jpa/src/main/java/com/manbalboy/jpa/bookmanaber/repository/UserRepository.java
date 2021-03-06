package com.manbalboy.jpa.bookmanaber.repository;

import com.manbalboy.jpa.bookmanaber.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface UserRepository extends JpaRepository<User, Long> {
//    User findByName(String name);

    List<User> findUsersByName(String name);

    User findByName(String name);

    User findByEmail(String email);

    User getByName(String name);

    User readByName(String name);

    User queryByName(String name);

    User searchByName(String name);

    User streamByName(String name);

    List<User> findFirst4ByName(String name);

    List<User> findTop3ByName(String name);


    List<User> findByNameAndEmail(String name, String email);

    List<User> findByNameOrEmail(String name, String email);

    List<User> findByCreatedAtAfter(LocalDateTime yesterday);

    List<User> findByIdAfter(Long id);

    List<User> findByCreatedAtGreaterThan(LocalDateTime yesterday);

    List<User> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);

    List<User> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);

    List<User> findByIdBetween(Long id1, Long id2);

    List<User> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2);

    List<User> findByIdIsNotNull();

//    List<User> findByAddressesIsNotEmpty();

    List<User> findByNameIn(List<String> names);

    List<User> findByNameStartingWith(String name);

    List<User> findByNameEndingWith(String name);

    List<User> findByNameContains(String name);

    List<User> findByNameLike(String name);

    List<User> findTop1ByName(String name);

    List<User> findTop5ByNameOrderByEmailDesc(String name);

    List<User> findFirst5ByNameOrderByIdDescEmailAsc(String name);

    List<User> findFirst5ByName(String name, Sort sort);

    Page<User> findByName(String name, Pageable pageable);

    @Query(value = "select * from user limit 1;", nativeQuery = true)
    Map<String, Object> findRowRecord();


}
