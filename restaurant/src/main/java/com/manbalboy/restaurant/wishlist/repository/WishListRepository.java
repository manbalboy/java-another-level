package com.manbalboy.restaurant.wishlist.repository;

import com.manbalboy.restaurant.db.MemoryDbRepositoryAbstract;
import com.manbalboy.restaurant.wishlist.entity.WishListEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {
}
