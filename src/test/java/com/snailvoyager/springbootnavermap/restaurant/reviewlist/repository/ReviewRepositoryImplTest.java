package com.snailvoyager.springbootnavermap.restaurant.reviewlist.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.snailvoyager.springbootnavermap.restaurant.reviewlist.dto.ReviewDto;
import com.snailvoyager.springbootnavermap.restaurant.reviewlist.entity.QReviewEntity;
import com.snailvoyager.springbootnavermap.restaurant.reviewlist.entity.ReviewEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ReviewRepositoryImplTest {
    @PersistenceContext
    EntityManager em;

    JPAQueryFactory jpaQueryFactory;

    @Autowired
    private ReviewRepository reviewRepository;

    @BeforeEach
    void beforeEach() {
        jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Test
    void test_findByWriterId() {
        QReviewEntity e = QReviewEntity.reviewEntity;

        ReviewEntity entity = ReviewEntity.builder()
                .id(1L)
                .writer("test")
                .comment("test...")
                .build();
        //when
        var saveEntity = reviewRepository.save(entity);

        ReviewEntity reviewEntity = jpaQueryFactory
                .select(e)
                .from(e)
                .where(e.writer.eq("test"))
                .fetchOne();

        assertThat(reviewEntity.getWriter()).isEqualTo("test");
    }

    @Test
    void test_betweenDate() {
        QReviewEntity e = QReviewEntity.reviewEntity;
        ReviewEntity entity = ReviewEntity.builder()
                .id(1L)
                .writer("test")
                .comment("asldkjfsdjf")
                .beginDate(Date.from(LocalDate.of(2022,12,1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .endDate(Date.from(LocalDate.of(2022,12,30).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        ReviewEntity entity2 = ReviewEntity.builder()
                .id(2L)
                .beginDate(Date.from(LocalDate.now().minusDays(10).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .endDate(Date.from(LocalDate.now().plusDays(10).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        reviewRepository.save(entity);
        reviewRepository.save(entity2);

        ReviewEntity reviewEntity = jpaQueryFactory
                .select(e)
                .from(e)
                .where(Expressions.currentDate().between(e.beginDate, e.endDate))
                .fetchOne();

        assert reviewEntity != null;
        assertThat(reviewEntity.getId()).isEqualTo(2L);
    }

    @Test
    void test_findReviewByWriterReturnDto() {
        QReviewEntity review = QReviewEntity.reviewEntity;

        ReviewEntity entity = ReviewEntity.builder()
                .id(1L)
                .writer("test")
                .comment("asldkjfsdjf")
                .createDate(LocalDateTime.of(2023, 1, 17, 21, 30))
                .build();

        reviewRepository.save(entity);

        ReviewDto reviewDto = jpaQueryFactory
                .select(Projections.fields(ReviewDto.class,
                        review.id,
                        review.wishListId,
                        review.createDate,
                        review.updateDate))
                .from(review)
                .where(review.writer.eq("test"))
                .fetchOne();

        assertThat(reviewDto.getId()).isEqualTo(1L);
        assertThat(reviewDto.getCreateDate().getMonth()).isEqualTo(Month.JANUARY);
        assertThat(reviewDto.getCreateDate().getDayOfMonth()).isEqualTo(17);
    }

}