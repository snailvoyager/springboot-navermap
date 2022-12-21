package com.snailvoyager.springbootnavermap.restaurant.reviewlist.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.snailvoyager.springbootnavermap.restaurant.reviewlist.entity.QReviewEntity;
import com.snailvoyager.springbootnavermap.restaurant.reviewlist.entity.ReviewEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.time.LocalDate;
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

        var saveEntity = reviewRepository.save(entity);
        ReviewEntity reviewEntity = jpaQueryFactory
                .select(e)
                .from(e)
                .where(Expressions.currentDate().between(e.beginDate, e.endDate))
                .fetchOne();

        assertThat(saveEntity.getId()).isEqualTo(1L);
    }

}