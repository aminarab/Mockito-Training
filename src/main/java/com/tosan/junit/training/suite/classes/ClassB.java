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
import com.tosan.junit.training.suite.categories.RegressionTests;
import com.tosan.mock.training.CalculatorService;
import com.tosan.mock.training.MathApplication;

@RunWith(MockitoJUnitRunner.class)
@Category({PerformanceTests.class, RegressionTests.class})
public class ClassB {

    @Test
    public void test_b_1() {
        assertThat(1 == 1, equalTo(true));
    }

	@InjectMocks
	MathApplication mathApplication = new MathApplication();

	@Mock
	CalculatorService calcService;

	
	@Test
	public void testSubtract() throws NoSuchFieldException, SecurityException {
		
		// add the behavior of calc service to add two numbers
		when(calcService.subtract(20.0 , 10.0)).thenReturn(15.00);
		
		
		// test the add functionality
		Assert.assertEquals(mathApplication.subtract(20.0 , 10.0), 25.0, 0);
		
		//limit the method call to 1, no less and no more calls are allowed
		verify(calcService, times(1)).subtract(20.0 , 10.0);
	}
}
