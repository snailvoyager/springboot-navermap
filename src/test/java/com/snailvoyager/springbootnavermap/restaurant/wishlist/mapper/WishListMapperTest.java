package com.snailvoyager.springbootnavermap.restaurant.wishlist.mapper;

import com.snailvoyager.springbootnavermap.restaurant.wishlist.dto.WishListDto;
import com.snailvoyager.springbootnavermap.restaurant.wishlist.entity.WishListEntity;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class WishListMapperTest {

    @Test
    public void wishListToDto() {
        WishListDto wishListDto = new WishListDto();
        wishListDto.setTitle("TestTitle");
        wishListDto.setRoadAddress("TestRoadAddress");

        WishListEntity wishListEntity = WishListMapper.INSTANCE.toEntity(wishListDto);
        assertThat(wishListEntity.getTitle()).isEqualTo("TestTitle");
        assertThat(wishListEntity.getRoadAddress()).isEqualTo("TestRoadAddress");

        var expectedDto = WishListMapper.INSTANCE.toDto(wishListEntity);
        assertThat(expectedDto.getTitle()).isEqualTo(wishListDto.getTitle());
        assertThat(expectedDto.getRoadAddress()).isEqualTo(wishListDto.getRoadAddress());
    }
}