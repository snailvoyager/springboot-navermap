package com.snailvoyager.springbootnavermap.restaurant.wishlist.dto;

import com.snailvoyager.springbootnavermap.restaurant.wishlist.entity.WishListEntity;
import com.snailvoyager.springbootnavermap.restaurant.wishlist.mapper.SubWishMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubWishDtoTest {

    @Test
    void testMapToDto() {
        WishListEntity entity = new WishListEntity();
        entity.setIndex(1);
        entity.setAddress("address");
        entity.setCategory("category");
        entity.setVisit(true);

        SubWishDto dto = SubWishMapper.INSTANCE.toDto(entity);

        assertThat(dto.getIndex()).isEqualTo(1);
        assertThat(dto.getSubTitle()).isNull();
    }

}