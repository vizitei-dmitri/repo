package com.devolution.demo.controller;

import com.devolution.demo.DemoApplication;
import com.devolution.demo.request.UserRequest;
import com.devolution.demo.response.TestResponse;
import com.devolution.demo.response.UserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = DemoApplication.class)
@TestPropertySource("classpath:test.properties")
@Sql(scripts = "classpath:sql/test-init.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@AutoConfigureMockMvc
@WebAppConfiguration
@RequiredArgsConstructor
class TestControllerTest {

    private final ObjectMapper mapper = new ObjectMapper();

    private final WebApplicationContext webApplicationContext;

    private MockMvc mvc;

    @SneakyThrows
    @BeforeEach
    void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @SneakyThrows
    @Test
    void helloTest() {
        MvcResult listResults = mvc.perform(get("/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String result = listResults.getResponse().getContentAsString();

        TestResponse testResponse = mapper.readValue(result, TestResponse.class);
        assertThat(testResponse.getMessage()).isEqualTo("Hello world!");
    }

    @SneakyThrows
    @Test
    void findUsersTest() {
        MvcResult listResults = mvc.perform(get("/user")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String result = listResults.getResponse().getContentAsString();

        List<UserResponse> testResponse = Arrays.asList(mapper.readValue(result, UserResponse[].class));
        assertThat(testResponse).hasSize(3);
    }

    @SneakyThrows
    @Test
    void deleteTest() {
        MvcResult listResults = mvc.perform(delete("/user/4")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String result = listResults.getResponse().getContentAsString();

        assertThat(result).isEqualTo("User was deleted successfully");
    }

    @SneakyThrows
    @Test
    void addUserTest() {
        UserRequest userRequest = new UserRequest();
        userRequest.setAge(23);
        userRequest.setName("name");
        String json = mapper.writeValueAsString(userRequest);
        MvcResult listResults = mvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();


        String result = listResults.getResponse().getContentAsString();
        UserResponse listRes = mapper.readValue(result, UserResponse.class);
        assertThat(listRes.getAge()).isEqualTo(23);
    }
}