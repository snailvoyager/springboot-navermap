package com.snailvoyager.springbootnavermap.restaurant.controller;

import com.snailvoyager.springbootnavermap.restaurant.wishlist.service.WishListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private WishListService wishListService;

    @Test
    public void add() throws Exception {
        mvc.perform(post("/api/restaurant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"TestTitle\", \"roadAddress\":\"Busan\"}"))
                //.andExpect(status().isCreated())
                //.andExpect(header().string("location", "/restaurants/1234"))
                .andExpect(content().string(""));

        verify(wishListService).add(any());    //Mock객체에 아무 데이터 넣기
    }
}
