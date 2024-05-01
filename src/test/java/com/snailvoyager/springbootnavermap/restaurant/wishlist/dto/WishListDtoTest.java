package com.snailvoyager.springbootnavermap.restaurant.wishlist.dto;

import com.snailvoyager.springbootnavermap.restaurant.wishlist.entity.WishListEntity;
import com.snailvoyager.springbootnavermap.restaurant.wishlist.mapper.WishListMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WishListDtoTest {

    @Test
    void testMapToDto_whenStringFieldIsNotEmpty() {
        WishListDto dto = WishListDto.builder()
                .index(1)
                .title("title")
                .address("address")
                .sameFieldName("0") // String 필드에 "0"
                .build();
        WishListEntity entity = WishListMapper.INSTANCE.toEntity(dto);

        assertThat(entity.getSameFieldName()).isEqualTo(0);
    }

    @Test
    void testMapToDto_whenStringFieldIsNull() {
        WishListDto dto = WishListDto.builder()
                .index(1)
                .title("title")
                .address("address")
                .sameFieldName(null) // String 필드에 null
                .build();

        WishListEntity entity = WishListMapper.INSTANCE.toEntity(dto);

        assertThat(entity.getSameFieldName()).isEqualTo(0);
    }

    @Test
    void testMapToDto_whenStringFieldIsEmpty() {
        WishListDto dto = WishListDto.builder()
                .index(1)
                .title("title")
                .address("address")
                .sameFieldName("") // String 필드에 공란
                .build();

        /*assertThatThrownBy(() -> {
            WishListEntity entity = WishListMapper.INSTANCE.toEntity(dto);      //Mapstruct 객체 매핑 시 NumberFormatException
        }).isInstanceOf(NumberFormatException.class);*/

        WishListEntity entity = WishListMapper.INSTANCE.toEntity(dto);
        assertThat(entity.getSameFieldName()).isEqualTo(0);
    }

}