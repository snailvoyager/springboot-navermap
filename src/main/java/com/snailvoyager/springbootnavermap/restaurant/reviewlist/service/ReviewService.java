package com.snailvoyager.springbootnavermap.restaurant.reviewlist.service;

import com.snailvoyager.springbootnavermap.restaurant.reviewlist.dto.ReviewDto;
import com.snailvoyager.springbootnavermap.restaurant.reviewlist.mapper.ReviewMapper;
import com.snailvoyager.springbootnavermap.restaurant.reviewlist.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewDto add(ReviewDto reviewDto) {
        var entity = ReviewMapper.INSTANCE.toEntity(reviewDto);
        var saveEntity = reviewRepository.save(entity);
        return ReviewMapper.INSTANCE.toDto(saveEntity);
    }

    public List<ReviewDto> findByWriter(ReviewDto reviewDto) {
        var result =  reviewRepository.findByWriter(reviewDto);
        return result.stream()
                .map(ReviewMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
}
