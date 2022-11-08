package com.snailvoyager.springbootnavermap.restaurant.wishlist.repository;

import com.snailvoyager.springbootnavermap.restaurant.db.MemoryDbRepositoryAbstract;
import com.snailvoyager.springbootnavermap.restaurant.wishlist.entity.WishListEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {

}
