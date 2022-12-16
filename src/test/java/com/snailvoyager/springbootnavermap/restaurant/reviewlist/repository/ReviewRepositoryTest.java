package com.snailvoyager.springbootnavermap.restaurant.reviewlist.repository;

import com.snailvoyager.springbootnavermap.restaurant.reviewlist.entity.ReviewEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ReviewRepositoryTest {
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    void test_add(){
        //given
        ReviewEntity entity = ReviewEntity.builder()
                .id(1L)
                .writer("test")
                .comment("test...")
                .build();
        //when
        var saveEntity = reviewRepository.save(entity);
        //then
        assertThat(saveEntity.getId()).isEqualTo(entity.getId());
        assertThat(saveEntity.getWriter()).isEqualTo(entity.getWriter());
    }
}