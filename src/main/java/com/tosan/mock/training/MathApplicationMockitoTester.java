package com.tosan.mock.training;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.timeout;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

//@RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationMockitoTester {

	// @InjectMocks annotation is used to create and inject the mock object
	@InjectMocks
	MathApplication mathApplication = new MathApplication();

	// @Mock annotation is used to create the mock object to be injected
	@Mock
	CalculatorService calcService;


	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testAdd() throws NoSuchFieldException, SecurityException {
		// add the behavior of calc service to add two numbers
		when(calcService.add(10.0, 20.0)).thenReturn(35.00);

		// test the add functionality
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 45.0, 0);

		// limit the method call to 1, no less and no more calls are allowed
		verify(calcService, times(1)).add(10.0, 20.0);

	}


	@Test
	public void testVerifySimpleCalculation() {
		// test the add functionality
		Assert.assertEquals(mathApplication.simpleCalculation(10.0, 20.0), 10.0, 0);

		// check a minimum 1 call count
		verify(calcService, atLeastOnce()).subtract(10.0, 20.0);

		// check if add function is called minimum 2 times
		verify(calcService, atLeast(2)).add(10.0, 20.0);

		// check if add function is called maximum 3 times
		verify(calcService, atMost(5)).add(10.0, 20.0);

	}

	@Test
	public void testThrowRuntimeException() {

		thrown.expect(RuntimeException.class);
		thrown.expectMessage(containsString("divide operation not implemented"));

		doThrow(new RuntimeException("divide operation not implemented")).when(calcService).add(10.0, 20.0);

		mathApplication.throwRuntimeException(10.0, 20.0);
	}

	@Test
	public void testOrderSimpleCalculation() {
		// test the add functionality
		Assert.assertEquals(mathApplication.simpleCalculation(10.0, 20.0), 10.0, 0);

		InOrder inOrder = inOrder(calcService);

		// following will make sure that add is first called then subtract is
		// called.
		inOrder.verify(calcService).add(10.0, 20.0);
		inOrder.verify(calcService).subtract(10.0, 20.0);
	}

	@Test
	public void testCallbackAdd() throws NoSuchFieldException, SecurityException {
		when(calcService.add(10.0, 20.0)).thenAnswer(new Answer<Double>() {

			public Double answer(InvocationOnMock invocation) throws Throwable {
				// get the arguments passed to mock
				Object[] args = invocation.getArguments();
				System.out.println(args);
				// get the mock
				Object mock = invocation.getMock();
				// return the result
				return 46.0;
			}

		});

		// test the add functionality
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 56.0, 0);

	}

	@Test
	public void testTimeout() throws NoSuchFieldException, SecurityException, InterruptedException {

		when(calcService.add(20.0, 10.0)).thenReturn(30.0);

		Assert.assertEquals(mathApplication.timeoutSample(20.0, 10.0), 30.0, 0);

		// verify call to add method to be completed within 100 ms
		verify(calcService, timeout(3000)).add(20.0, 10.0);

		// invocation count can be added to ensure multiplication invocations
		// can be checked within given timeframe
		verify(calcService, timeout(5000).times(1)).subtract(20.0, 10.0);
	}

	@Test
	public void testResetAdd() throws NoSuchFieldException, SecurityException {

		when(calcService.add(20.0, 10.0)).thenReturn(35.0);
		// test the add functionality
		Assert.assertEquals(mathApplication.add(20.0, 10.0), 45.0, 0);
		// reset the mock
		reset(calcService);
		when(calcService.add(20.0, 10.0)).thenReturn(21.0);
		// // test the add functionality after resetting the mock
		Assert.assertEquals(mathApplication.add(20.0, 10.0), 31.0, 0);

	}


}