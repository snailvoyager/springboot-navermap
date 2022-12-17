package com.snailvoyager.springbootnavermap.restaurant.reviewlist.repository;

import com.snailvoyager.springbootnavermap.restaurant.reviewlist.dto.ReviewDto;
import com.snailvoyager.springbootnavermap.restaurant.reviewlist.entity.ReviewEntity;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<ReviewEntity> findByWishListId(ReviewDto reviewDto);
}
