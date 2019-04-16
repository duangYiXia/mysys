package com.xxkj.passport.controller;

import com.xxkj.passport.BaseTest;
import com.xxkj.passport.dto.UserDetails;
import com.xxkj.passport.entity.User;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AuthControllerTest extends BaseTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();// 使用WebApplicationContext初始化mockMVC
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void register() throws Exception {
        String json = "{'admin'：'admin'}";
        Assert.assertThat(json, is("{'admin'：'admin'}"));// 可作为数据检查
        //发送post请求
        mvc.perform(MockMvcRequestBuilders.post("register")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(json.getBytes())
                /*.session(new MockHttpSession())*/
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

        //Spring Boot Web 测试 带返回结果
        ParameterizedTypeReference<List<UserDetails>> type = new ParameterizedTypeReference<List<UserDetails>>() {};
        ResponseEntity<List<UserDetails>> result = restTemplate.exchange("/get", HttpMethod.GET, null, type);
        Assert.assertThat(result.getBody().get(0).getUsername(), Matchers.notNullValue());
    }
}