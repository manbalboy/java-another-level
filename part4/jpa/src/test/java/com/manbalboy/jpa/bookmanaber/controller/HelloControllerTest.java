package com.manbalboy.jpa.bookmanaber.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest
@MockBean(JpaMetamodelMappingContext.class)
class HelloControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloWorld() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/hello-world"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string("hello world"));
    }
}