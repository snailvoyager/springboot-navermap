package com.snailvoyager.springbootnavermap.restaurant.wishlist.service;

import com.snailvoyager.springbootnavermap.restaurant.wishlist.dto.WishListDto;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
public class WishListServiceTest {

    @Autowired
    private WishListService wishListService;

    private static final List<WishListDto> wishListDtoList = new ArrayList<>();

    @BeforeAll
    static void beforeAll() {
        System.out.println("############ Before All ###############");
        WishListDto wish1 = new WishListDto();
        wish1.setTitle("갈비집");
        wish1.setRoadAddress("서울시 갈비집");
        wishListDtoList.add(wish1);

        WishListDto wish2 = new WishListDto();
        wish2.setTitle("김밥집");
        wish2.setRoadAddress("전라도 김밥집");
        wishListDtoList.add(wish2);

    }

    @BeforeEach
    void beforeEach() {
        System.out.println("############ Before Each ###############");
        wishListDtoList.forEach(x -> wishListService.add(x));
    }

    @AfterEach
    void afterEach() {
        System.out.println("############ After Each ###############");
        wishListService.deleteAll();
    }

    @Test
    void test_search() {
        var result = wishListService.search("갈비집");

        assertThat(result).isNotNull();
    }

    @Test
    void test_add() {
        WishListDto wishListDto = new WishListDto();
        wishListDto.setTitle("TestTitle");
        wishListDto.setRoadAddress("TestRoadAddress");
        wishListDto.setLastVisitDate(LocalDateTime.now());
        var expected = wishListService.add(wishListDto);
        assertThat(expected).isNotNull();
        assertThat(expected.getTitle()).isEqualTo("TestTitle");
        assertThat(expected.getRoadAddress()).isEqualTo("TestRoadAddress");
        assertThat(expected.getLastVisitDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))).isEqualTo(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    @Test
    void test_findAll() {
        var wishList = wishListService.findAll();

        /*SoftAssertions.assertSoftly(softly ->{
            softly.assertThat(wishList)
                    .isNotNull()
                    .extracting("title").containsOnly("갈비집", "김밥집", "갈비집");
            softly.assertThat(wishList)
                    .extracting("roadAddress").contains("서울시 갈비집", "전라도 김밥집", "서울시 갈비집");   //중복 허용
        });*/

        assertAll("wishList",       //assertAll 과 혼합하여 사용
                () -> assertThat(wishList)
                        .extracting("roadAddress").contains("서울시 갈비집", "전라도 김밥집", "서울시 갈비집"), //중복, 순서 무시
                () -> assertThat(wishList)
                        .extracting("title").containsOnly("김밥집", "갈비집"),    //순서 무시
                () -> assertThat(wishList)
                        .extracting("title").containsExactly("갈비집", "김밥집"),     //순서 체크
                () -> assertThat(wishList)
                        .extracting("title").containsOnlyOnce("갈비집", "김밥집")    //오직 한개만 존재
        );
    }

    @Test
    void test_deleteAll() {
        wishListService.deleteAll();

        var wishList = wishListService.findAll();
        assertThat(wishList.size()).isEqualTo(0);
    }
}
