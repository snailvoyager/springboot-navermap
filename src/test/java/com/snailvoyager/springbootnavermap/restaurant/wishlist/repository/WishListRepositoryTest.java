package com.snailvoyager.springbootnavermap.restaurant.wishlist.repository;

import com.snailvoyager.springbootnavermap.restaurant.wishlist.entity.WishListEntity;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WishListRepositoryTest {
    @Autowired
    private WishListRepository wishListRepository;

    private WishListEntity create() {
        var wishList = new WishListEntity();
        wishList.setTitle("title");
        wishList.setCategory("category");
        wishList.setAddress("address");
        wishList.setRoadAddress("readAddress");
        wishList.setHomePageLink("");
        wishList.setImageLink("");
        wishList.setVisit(false);
        wishList.setVisitCount(0);
        wishList.setLastVisitDate(null);
        return wishList;
    }

    @Test
    public void saveTest() {
        var wishListEntity = create();
        var expected = wishListRepository.save(wishListEntity);

//        Assertions.assertNotNull(expected);
//        Assertions.assertEquals(1, expected.getIndex());
        assertThat(expected).isNotNull();
        assertThat(expected.getIndex()).isEqualTo(1);
    }

    @Test
    public void updateTest() {
        var wishListEntity = create();
        var expected = wishListRepository.save(wishListEntity);

        expected.setTitle("update test");
        var savedEntity = wishListRepository.save(expected);

//        Assertions.assertEquals("update test", savedEntity.getTitle());
//        Assertions.assertEquals(1, wishListRepository.listAll().size());
        assertThat(savedEntity.getTitle()).isEqualTo("update test");
        assertThat(wishListRepository.listAll().size()).isEqualTo(1);
    }

    @Test
    public void findByIdTest() {
        var wishListEntity = create();
        wishListRepository.save(wishListEntity);

        var expected = wishListRepository.findById(1);

//        Assertions.assertTrue(expected.isPresent());
//        Assertions.assertEquals(1, expected.get().getIndex());
        assertThat(expected).isNotEmpty();
        assertThat(expected.get().getIndex()).isEqualTo(1);
    }

    @Test
    public void deleteTest() {
        var wishListEntity = create();
        wishListRepository.save(wishListEntity);

        wishListRepository.deleteById(1);

        int count = wishListRepository.listAll().size();

//        Assertions.assertEquals(0, count);
        assertThat(count).isEqualTo(0);
    }

    @Test
    public void listAllTest() {
        var wishListEntity1 = create();
        wishListRepository.save(wishListEntity1);

        var wishListEntity2 = create();
        wishListRepository.save(wishListEntity2);

        int count = wishListRepository.listAll().size();
//        Assertions.assertEquals(2, count);
        assertThat(count).isEqualTo(2);
    }
}
