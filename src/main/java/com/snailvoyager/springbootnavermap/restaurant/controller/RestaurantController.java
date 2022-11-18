package com.snailvoyager.springbootnavermap.restaurant.controller;

import com.snailvoyager.springbootnavermap.restaurant.wishlist.dto.WishListDto;
import com.snailvoyager.springbootnavermap.restaurant.wishlist.service.WishListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final WishListService wishListService;

    @GetMapping("/mapping")
    public WishListDto search(@RequestParam String query) {
        return wishListService.search(query);
    }

    @PostMapping("")
    public WishListDto add(@RequestBody WishListDto wishListDto) {
        log.info("{}", wishListDto);
        return wishListService.add(wishListDto);
    }

    @GetMapping("/all")
    public List<WishListDto> findAll() {
        return wishListService.findAll();
    }

    @DeleteMapping("/{index}")
    public void delete(@PathVariable int index) {
        wishListService.delete(index);
    }
    @PostMapping("/{index}")
    public void addVisit(@PathVariable int index){
        wishListService.addVisit(index);
    }
}
