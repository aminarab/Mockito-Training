package com.tosan.junit.training.suite.classes;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.tosan.junit.training.suite.categories.PerformanceTests;
import com.tosan.junit.training.suite.categories.RegressionTests;

public class ClassC {

    @Category({PerformanceTests.class, RegressionTests.class})
    @Test
    public void test_c_1() {
        assertThat(1 == 1, equalTo(true));
    }

    @Category(RegressionTests.class)
    @Test
    public void test_c_2() {
        assertThat(1 == 1, equalTo(true));
    }
}
