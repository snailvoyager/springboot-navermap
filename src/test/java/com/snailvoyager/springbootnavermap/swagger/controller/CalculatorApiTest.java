package com.snailvoyager.springbootnavermap.swagger.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.snailvoyager.springbootnavermap.swagger.component.Calculator;
import com.snailvoyager.springbootnavermap.swagger.component.DollarCalculator;
import com.snailvoyager.springbootnavermap.swagger.component.MarketApi;
import com.snailvoyager.springbootnavermap.swagger.controller.CalculatorApi;
import com.snailvoyager.springbootnavermap.swagger.dto.Req;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(CalculatorApi.class)
@AutoConfigureWebMvc
@Import({Calculator.class, DollarCalculator.class})     //단위 테스트로 필요한 class import
public class CalculatorApiTest {

    @MockBean
    private MarketApi marketApi;

    @Autowired
    private MockMvc mockmvc;

    @BeforeEach         //Test 전에 수행
    public void init() {
        Mockito.when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void sumTest() throws Exception {
        // /calc/sum
        mockmvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8080/calc/sum")
                        .queryParam("x", "10")
                        .queryParam("y", "10")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.content().string("60000")
        ).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void minusTest() throws Exception {
        Req req = new Req();
        req.setX(10);
        req.setY(10);

        String json = new ObjectMapper().writeValueAsString(req);     //JSON 변환

        mockmvc.perform(
                MockMvcRequestBuilders.post("http://localhost:8080/calc/minus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.result").value("0")   //json 값 체크
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.response.resultCode").value("OK")
        ).andDo(MockMvcResultHandlers.print());
    }

}
