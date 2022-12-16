package com.snailvoyager.springbootnavermap.restaurant.reviewlist.service;

import com.snailvoyager.springbootnavermap.restaurant.reviewlist.dto.ReviewDto;
import com.snailvoyager.springbootnavermap.restaurant.reviewlist.mapper.ReviewMapper;
import com.snailvoyager.springbootnavermap.restaurant.reviewlist.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewDto add(ReviewDto reviewDto) {
        var entity = ReviewMapper.INSTANCE.toEntity(reviewDto);
        var saveEntity = reviewRepository.save(entity);
        return ReviewMapper.INSTANCE.toDto(saveEntity);
    }
}
