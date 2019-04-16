package com.xxkj.passport.Service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserDetailsServiceImpTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void loadUserByUsername() {
        //Assert.assertEquals("aaa", "aab");// 检查值
        assertThat("aaa",is("*a*"));
    }
}