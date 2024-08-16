package com.snailvoyager.springbootnavermap.restaurant.wishlist.service

import com.snailvoyager.springbootnavermap.naver.NaverFeignClient
import com.snailvoyager.springbootnavermap.restaurant.wishlist.dto.WishListDto
import com.snailvoyager.springbootnavermap.restaurant.wishlist.entity.WishListEntity
import com.snailvoyager.springbootnavermap.restaurant.wishlist.repository.WishListRepository
import spock.lang.Specification

import java.time.LocalDateTime

class WishListServiceSpec extends Specification {
    def naverFeignClient
    def wishListRepository
    def wishListService

    def setup() {
        naverFeignClient = Mock(NaverFeignClient)
        wishListRepository = Stub(WishListRepository)
        wishListService = new WishListService(naverFeignClient, wishListRepository)
    }

    def "add test" () {
        given: "stubbing"
        def dto = new WishListDto()
        dto.setTitle("testTitle")
        dto.setRoadAddress("seoul")
        dto.setLastVisitDate(LocalDateTime.now())

        def entity = new WishListEntity()
        entity.setTitle("testTitle")
        entity.setRoadAddress("seoul")
        entity.setLastVisitDate(LocalDateTime.now())

        wishListRepository.save(_) >> entity

        when: "stimulus"
        def result = wishListService.add(dto)

        then: "response"
        result.getTitle() == dto.getTitle()
    }

}
