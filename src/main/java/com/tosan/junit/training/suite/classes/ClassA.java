package com.tosan.junit.training.suite.classes;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tosan.junit.training.suite.categories.PerformanceTests;
import com.tosan.mock.training.CalculatorService;
import com.tosan.mock.training.MathApplication;


@RunWith(MockitoJUnitRunner.class)
public class ClassA {

	@InjectMocks
	MathApplication mathApplication = new MathApplication();

	@Mock
	CalculatorService calcService;

	
	@Test
	public void testAdd() throws NoSuchFieldException, SecurityException {
		
		// add the behavior of calc service to add two numbers
		when(calcService.add(10.0, 20.0)).thenReturn(35.00);
		
		
		// test the add functionality
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 45.0, 0);
		
		//limit the method call to 1, no less and no more calls are allowed
		verify(calcService, times(1)).add(10.0, 20.0);
	}
	
    @Category(PerformanceTests.class)
    @Test
    public void test_a_1() {
        assertThat(1 == 1, equalTo(true));
    }

    @Test
    public void test_a_2() {
        assertThat(1 == 1, equalTo(true));
    }
}
