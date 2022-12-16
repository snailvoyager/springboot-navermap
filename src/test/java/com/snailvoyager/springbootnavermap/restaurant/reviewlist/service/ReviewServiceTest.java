package com.snailvoyager.springbootnavermap.restaurant.reviewlist.service;

import com.snailvoyager.springbootnavermap.restaurant.reviewlist.dto.ReviewDto;
import com.snailvoyager.springbootnavermap.restaurant.reviewlist.entity.ReviewEntity;
import com.snailvoyager.springbootnavermap.restaurant.reviewlist.mapper.ReviewMapper;
import com.snailvoyager.springbootnavermap.restaurant.reviewlist.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ReviewServiceTest {
    @InjectMocks
    private ReviewService reviewService;

    @Mock
    private ReviewRepository reviewRepository;

    @Test
    void test_add() {
        //given
        var reviewDto = ReviewDto.builder()
                        .id(1L)
                        .writer("test")
                        .comment("comment...")
                        .build();
        var reviewEntity = ReviewMapper.INSTANCE.toEntity(reviewDto);

        when(reviewRepository.save(reviewEntity)).thenReturn(reviewEntity);
        //when
        var saveDto = reviewService.add(reviewDto);
        //then
        assertThat(saveDto.getId()).isEqualTo(reviewDto.getId());
        //verify
        verify(reviewRepository).save(any(ReviewEntity.class));
    }
}