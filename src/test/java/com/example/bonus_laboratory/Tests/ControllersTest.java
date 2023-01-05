package com.example.bonus_laboratory.Tests;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllersTest {
    @Autowired
    private MockMvc mvc;
    @Test
    public void mainControllerTest1() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void mainControllerTest2() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/freedb"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void mainControllerTest3() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/surface_error"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
}
