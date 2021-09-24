package com.manbalboy.springjunittest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manbalboy.springjunittest.component.Calculator;
import com.manbalboy.springjunittest.component.DollarCalculator;
import com.manbalboy.springjunittest.component.MarketApi;
import com.manbalboy.springjunittest.dto.Req;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(CalculatorApiController.class)
@AutoConfigureMockMvc
@Import({Calculator.class, DollarCalculator.class})
class CalculatorApiControllerTest {
    @MockBean
    MarketApi marketApi;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void init() {
        Mockito.when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    void sumTest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("http://localhost:8080/api/sum")
                        .queryParam("x", "10")
                        .queryParam("y", "10")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.content().string("60000")
        ).andDo(
                MockMvcResultHandlers.print()
        );
    }


    @Test
    void postMinusTest() throws Exception {

        Req req = new Req();
        req.setX(10);
        req.setY(10);

        String json = new ObjectMapper().writeValueAsString(req);

        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("http://localhost:8080/api/minus/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.result").value("0")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.response.resultCode").value("Ok")
        ).andDo(
                MockMvcResultHandlers.print()
        );
    }
}