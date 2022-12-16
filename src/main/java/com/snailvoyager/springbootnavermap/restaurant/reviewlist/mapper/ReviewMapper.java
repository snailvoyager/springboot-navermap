package com.snailvoyager.springbootnavermap.restaurant.reviewlist.mapper;

import com.snailvoyager.springbootnavermap.restaurant.reviewlist.dto.ReviewDto;
import com.snailvoyager.springbootnavermap.restaurant.reviewlist.entity.ReviewEntity;
import com.snailvoyager.springbootnavermap.restaurant.wishlist.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewMapper extends EntityMapper<ReviewDto, ReviewEntity> {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    @Override
    ReviewEntity toEntity(final ReviewDto dto);

    @Override
    ReviewDto toDto(final ReviewEntity entity);
}
