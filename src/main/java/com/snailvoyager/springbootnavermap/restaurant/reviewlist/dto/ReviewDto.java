package com.snailvoyager.springbootnavermap.restaurant.reviewlist.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private Long id;
    private int wishListId;
    private String writer;
    private String comment;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
