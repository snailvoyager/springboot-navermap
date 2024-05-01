package com.snailvoyager.springbootnavermap.restaurant.wishlist.mapper;

import com.snailvoyager.springbootnavermap.restaurant.wishlist.dto.SubWishDto;
import com.snailvoyager.springbootnavermap.restaurant.wishlist.entity.WishListEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubWishMapper extends EntityMapper<SubWishDto, WishListEntity> {
    SubWishMapper INSTANCE = Mappers.getMapper(SubWishMapper.class);
}
