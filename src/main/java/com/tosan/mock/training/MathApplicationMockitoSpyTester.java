package com.tosan.mock.training;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MathApplicationMockitoSpyTester {

	MathApplication mathApplication;

	CalculatorService calcService;

	CalculatorService spyCalcService;

	@Before
	public void setUp() {
		mathApplication = new MathApplication();
		
		calcService = mock(CalculatorService.class);

		CalculatorService calculator = new CalculatorServiceImpl();
		spyCalcService = spy(calculator);
	}

	

	@Test
	public void testSpyDoNotNeedExpections() throws NoSuchFieldException, SecurityException {

		mathApplication.setCalculatorService(spyCalcService);

		// perform operation on real object
		// test the add functionality
		Assert.assertEquals(mathApplication.add(20.0, 10.0), 40.0, 0);

		mathApplication.setCalculatorService(calcService);
		// add the behavior of calc service to add two numbers
		 when(calcService.add(10.0, 20.0)).thenReturn(30.00);

		/*
		 * Without expectations methods of Mocked Object will not work
		 */

		// test the add functionality
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 40.0, 0);

		// limit the method call to 1, no less and no more calls are allowed
		verify(calcService, times(1)).add(10.0, 20.0);

	}
}
