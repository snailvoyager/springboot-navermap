package com.snailvoyager.springbootnavermap.restaurant.controller;

import com.snailvoyager.springbootnavermap.restaurant.reviewlist.dto.ReviewDto;
import com.snailvoyager.springbootnavermap.restaurant.reviewlist.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/{id}")
    public List<ReviewDto> getReview(@PathVariable long id) {
        return null;
    }

    @PostMapping("")
    public ReviewDto add(@RequestBody ReviewDto reviewDto) {
        return reviewService.add(reviewDto);
    }
}
