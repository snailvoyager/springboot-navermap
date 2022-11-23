package com.snailvoyager.springbootnavermap.restaurant.wishlist.repository;

import com.snailvoyager.springbootnavermap.restaurant.wishlist.entity.WishListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository extends JpaRepository<WishListEntity, Integer> {

}
