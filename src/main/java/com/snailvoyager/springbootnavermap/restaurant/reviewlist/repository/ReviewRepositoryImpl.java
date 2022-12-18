package com.snailvoyager.springbootnavermap.restaurant.reviewlist.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.snailvoyager.springbootnavermap.restaurant.reviewlist.dto.ReviewDto;
import com.snailvoyager.springbootnavermap.restaurant.reviewlist.entity.QReviewEntity;
import com.snailvoyager.springbootnavermap.restaurant.reviewlist.entity.ReviewEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ReviewEntity> findByWriter(ReviewDto reviewDto) {
        QReviewEntity review = QReviewEntity.reviewEntity;

        return jpaQueryFactory
                .select(review)
                .from(review)
                .where(review.writer.eq(reviewDto.getWriter()))
                .fetch();
    }
}
