package com.manbalboy.restaurant.wishlist.repository;

import com.manbalboy.restaurant.wishlist.entity.WishListEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WishListRepositoryTest {
    @Autowired
    private WishListRepository wishListRepository;

    private WishListEntity create() {
        var wishList = new WishListEntity();
        wishList.setTitle("title");
        wishList.setCategory("category");
        wishList.setAddress("address");
        wishList.setRoadAddress("roadAddress");
        wishList.setHomePageLink("homepage");
        wishList.setImageLink("homepage");
        wishList.setVisit(true);
        wishList.setVisitCount(1);
        wishList.setLastVisitDate(null);

        return wishList;
    }

    @Test
    void saveTest() {
        var wishList = create();

        var expected = wishListRepository.save(wishList);

        Assertions.assertNotNull(expected);
        Assertions.assertEquals(1, expected.getIndex());
    }

    @Test
    void updateTest() {
        var wishList = create();

        var expected = wishListRepository.save(wishList);
        expected.setTitle("update title");


        var saveExpected = wishListRepository.save(expected);

        Assertions.assertNotNull(saveExpected);
        Assertions.assertEquals("update title", expected.getTitle());
        Assertions.assertEquals(1, wishListRepository.findAll().size());
    }

    @Test
    void findByIdTest() {
        var wishList = create();
        wishListRepository.save(wishList);

        var expected = wishListRepository.findById(1);
        Assertions.assertEquals(true, expected.isPresent());
        Assertions.assertEquals(1, expected.get().getIndex());
    }

    @Test
    void deleteTest() {
        var wishList = create();
        wishListRepository.save(wishList);
        wishListRepository.deleteById(1);
        int count = wishListRepository.findAll().size();
        Assertions.assertEquals(0, count);

    }

    @Test
    void listAllTest() {
        var wishList = create();
        wishListRepository.save(wishList);
        var wishList2 = create();
        wishListRepository.save(wishList2);
        var wishList3 = create();
        wishListRepository.save(wishList3);

        int count = wishListRepository.findAll().size();
        Assertions.assertEquals(3, count);
    }
}