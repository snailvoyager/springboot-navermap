package com.snailvoyager.springbootnavermap.restaurant.reviewlist.repository;

import com.snailvoyager.springbootnavermap.restaurant.reviewlist.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long>, ReviewRepositoryCustom {
}
