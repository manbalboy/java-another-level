package com.manbalboy.jpa.bookmanaber.repository;

import com.manbalboy.jpa.bookmanaber.domain.User;
import com.manbalboy.jpa.bookmanaber.domain.UserHistory;
import com.manbalboy.jpa.bookmanaber.domain.code.Gender;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;
import static org.springframework.data.domain.Sort.Order.desc;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

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


    @Test
    void flush() {
        userRepository.save(
                new User("훈", "manbalboy@hanmail.net")
        );

        userRepository.flush();

        userRepository.findAll().forEach(System.out::println);
    }


    @Test
    void count() {
        System.out.println("before : >>> " + userRepository.count());

        userRepository.save(
                new User("훈", "manbalboy@hanmail.net")
        );
        System.out.println("after : >>> " + userRepository.count());

    }


    @Test
    void existsById() {
        System.out.println("existsById : >>> " + userRepository.existsById(5L));
    }


    @Test
    void delete() {
        userRepository.delete(
                userRepository.getById(3L)
        );

        userRepository.findAll().forEach(System.out::println);
    }


    @Test
    void deleteById() {
        userRepository.deleteById(3L);

        userRepository.findAll().forEach(System.out::println);
    }


    @Test
    void deleteAll() {
        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L, 2L)));
        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    void deleteAllInBatch() {
        userRepository.deleteAllInBatch(userRepository.findAllById(Lists.newArrayList(1L, 2L)));
        userRepository.findAll().forEach(System.out::println);
    }


    @Test
    void page() {
        Page<User> users = userRepository.findAll(PageRequest.of(1, 3));

        System.out.println("page : " + users);
        System.out.println("totalElement : " + users.getTotalElements());
        System.out.println("totalPages : " + users.getTotalPages());
        System.out.println("numberOfElement : " + users.getNumberOfElements());
        System.out.println("sort : " + users.getSort());
        System.out.println("size : " + users.getSize());
        users.getContent().forEach(System.out::println);
    }


    @Test
    void queryByExample() {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("email", endsWith());

        Example<User> example = Example.of(new User("na", "fastcampus.com"), matcher);
        userRepository.findAll(example).forEach(System.out::println);
    }


    @Test
    void queryByMethodFindBy() {
        userRepository.save(new User("훈", "manbalboy@hanmail.net"));
        System.out.println(userRepository.findByName("훈"));
    }


    @Test
    void queryByMethodFindBys() {
        userRepository.save(new User("훈", "manbalboy@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy1@hanmail.net"));
        System.out.println(userRepository.findUsersByName("훈"));
    }

    @Test
    void queryByMethodFindByName() {
        userRepository.save(new User("훈", "manbalboy@hanmail.net"));
        System.out.println("find : " + userRepository.findByName("훈"));
        System.out.println("query : " + userRepository.queryByName("훈"));
        System.out.println("search : " + userRepository.searchByName("훈"));
        System.out.println("stream : " + userRepository.streamByName("훈"));
        System.out.println("get : " + userRepository.getByName("훈"));
    }

    @Test
    void queryByMethodFindFirstByName() {
        userRepository.save(new User("훈", "manbalboy@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy1@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy2@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy3@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy4@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy5@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy5@hanmail.net"));
        System.out.println("findFirst4ByName : " + userRepository.findFirst4ByName("훈"));
        System.out.println("findTop3ByName : " + userRepository.findTop3ByName("훈"));
    }

    @Test
    void queryByMethodFindFirstByNameAndEmail() {
        userRepository.save(new User("훈", "manbalboy@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy1@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy2@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy3@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy4@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy5@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy5@hanmail.net"));
        System.out.println("findByNameAndEmail : " + userRepository.findByNameAndEmail("훈", "manbalboy3@hanmail.net"));
    }

    @Test
    void queryByMethodFindFirstByNameOrEmail() {
        userRepository.save(new User("훈", "manbalboy@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy1@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy2@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy3@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy4@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy5@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy5@hanmail.net"));
        System.out.println("findByNameAndEmail : " + userRepository.findByNameOrEmail("훈", "manbalboy3@hanmail.net"));
    }

    @Test
    void findByIdIsNotNull() {

        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
    }

    @Test
    void findByAddressesIsNotEmpty() {
//        System.out.println("findByAddressesIsNotEmpty : " + userRepository.findByAddressesIsNotEmpty());
    }

    @Test
    void findByNameIn() {
        userRepository.save(new User("훈1", "manbalboy@hanmail.net"));
        userRepository.save(new User("훈2", "manbalboy1@hanmail.net"));
        userRepository.save(new User("훈3", "manbalboy2@hanmail.net"));
        userRepository.save(new User("훈4", "manbalboy3@hanmail.net"));
        userRepository.save(new User("훈5", "manbalboy4@hanmail.net"));
        userRepository.save(new User("훈6", "manbalboy5@hanmail.net"));
        userRepository.save(new User("훈7", "manbalboy5@hanmail.net"));
        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("훈3", "훈2")));
    }

    @Test
    void findByNameStartingWithfindByNameEndingWith() {
        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("mar"));
        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("tin"));
        System.out.println("findByNameContains : " + userRepository.findByNameContains("art"));
        System.out.println("findByNameContains : " + userRepository.findByNameLike("%art%"));
    }

    @Test
    void findTop1ByName() {
        userRepository.save(new User("훈", "manbalboy@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy1@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy2@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy3@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy4@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy5@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy6@hanmail.net"));
        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("훈"));
        System.out.println("findTop5ByNameOrderByEmailDesc : " + userRepository.findTop5ByNameOrderByEmailDesc("훈"));
        System.out.println("findFirst5ByNameOrderByIdDescEmailAsc : " + userRepository.findFirst5ByNameOrderByIdDescEmailAsc("훈"));
    }

    @Test
    void findFirstByName() {
        userRepository.save(new User("훈", "manbalboy@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy1@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy2@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy3@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy4@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy5@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy6@hanmail.net"));
        System.out.println("findTop1ByName : " + userRepository.findFirst5ByName("훈", Sort.by(desc("name"), desc("id"))));
    }


    @Test
    void findByName() {
        userRepository.save(new User("훈", "manbalboy@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy1@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy2@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy3@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy4@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy5@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy6@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy4@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy5@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy6@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy4@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy5@hanmail.net"));
        userRepository.save(new User("훈", "manbalboy6@hanmail.net"));
        System.out.println("findByName : " + userRepository.findByName("훈", PageRequest.of(0, 3, Sort.by(desc("email"), desc("id")))).getContent());
    }


    @Test
    void Listener() {
        User user = new User();
        user.setEmail("manbalboy@hanmail.net");
        user.setName("훈");
        user.setGender(Gender.MALE);

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("훈 2");
        userRepository.save(user2);

        userRepository.deleteById(1L);
    }

    @Test
    void userRelationTest() {
        User user = User.builder()
                .name("훈")
                .email("manbalboy@hanmail.net")
                .gender(Gender.MALE)
                .build();

        userRepository.save(user);

        System.out.println(">>>>" + userRepository.findAll());

        user.setName("훈2");

        userRepository.save(user);
        user.setEmail("jh2001c@gmail.com");

        userRepository.save(user);
        System.out.println("==============================");
        userHistoryRepository.findAll().forEach(System.out::println);
        System.out.println("==============================");
//        List<UserHistory> result = userHistoryRepository.findByUserId(
//                userRepository.findByEmail("jh2001c@gmail.com").getId()
//        );
        List<UserHistory> result = userRepository.findByEmail("jh2001c@gmail.com").getUserHistories();
        System.out.println(">>>>==============================");
        result.forEach(System.out::println);
        System.out.println(">>>>==============================");

        result.forEach(userHistoryItem -> {
            System.out.println(userHistoryItem.getUser());
        });
    }


}