package com.snailvoyager.springbootnavermap.restaurant.wishlist.service;

import com.snailvoyager.springbootnavermap.restaurant.wishlist.dto.WishListDto;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WishListServiceTest {

    @Autowired
    private WishListService wishListService;

    @Test
    public void searchTest() {
        var result = wishListService.search("갈비집");

        System.out.println(result);
        assertThat(result).isNotNull();
    }

    @Test
    public void add() {
        WishListDto wishListDto = new WishListDto();
        wishListDto.setTitle("TestTitle");
        wishListDto.setRoadAddress("TestRoadAddress");
        var expected = wishListService.add(wishListDto);
        assertThat(expected).isNotNull();
        assertThat(expected.getTitle()).isEqualTo("TestTitle");
        assertThat(expected.getRoadAddress()).isEqualTo("TestRoadAddress");
    }
}
