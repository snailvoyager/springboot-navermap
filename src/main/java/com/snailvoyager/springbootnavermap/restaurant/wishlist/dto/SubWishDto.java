package com.snailvoyager.springbootnavermap.restaurant.wishlist.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SubWishDto extends WishListDto {
    private String subTitle;
}
