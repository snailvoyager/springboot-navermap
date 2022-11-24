package com.snailvoyager.springbootnavermap.restaurant.wishlist.mapper;

import com.snailvoyager.springbootnavermap.restaurant.wishlist.dto.WishListDto;
import com.snailvoyager.springbootnavermap.restaurant.wishlist.entity.WishListEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WishListMapper extends EntityMapper<WishListDto, WishListEntity> {
    WishListMapper INSTANCE = Mappers.getMapper(WishListMapper.class);

    WishListDto toDto(WishListEntity wishListEntity);

    WishListEntity toEntity(WishListDto wishListDto);
}
