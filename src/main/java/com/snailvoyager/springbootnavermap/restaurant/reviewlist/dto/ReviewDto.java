package com.snailvoyager.springbootnavermap.restaurant.reviewlist.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ReviewDto {
    private Long id;
    private int wishListId;
    private String writer;
    private String comment;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
