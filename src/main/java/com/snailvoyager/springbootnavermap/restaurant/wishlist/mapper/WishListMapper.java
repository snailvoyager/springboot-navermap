package com.snailvoyager.springbootnavermap.restaurant.wishlist.mapper;

import com.snailvoyager.springbootnavermap.restaurant.wishlist.dto.WishListDto;
import com.snailvoyager.springbootnavermap.restaurant.wishlist.entity.WishListEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WishListMapper extends EntityMapper<WishListDto, WishListEntity> {
    WishListMapper INSTANCE = Mappers.getMapper(WishListMapper.class);

    WishListDto toDto(WishListEntity wishListEntity);

    @Mapping(target = "sameFieldName", source = "sameFieldName", qualifiedByName = "mapToInteger")
    WishListEntity toEntity(WishListDto wishListDto);

    @Named("mapToInteger")
    default int mapToInteger(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(str);
    }
}
