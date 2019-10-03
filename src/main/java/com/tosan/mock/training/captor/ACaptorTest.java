package com.tosan.mock.training.captor;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ACaptorTest {

	@InjectMocks
	Sample sample = new Sample();

	@Mock
	OtherClass otherClass;


	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testCaptor(){
		// Run the foo method with the mock
		new Sample().foo(otherClass);

		// Capture the argument of the doSomething function
		ArgumentCaptor<SomeData> captor = ArgumentCaptor.forClass(SomeData.class);
		verify(otherClass, times(1)).doSomething(captor.capture());

		// Assert the argument
		SomeData actual = captor.getValue();
		Assert.assertEquals("Some inner data", actual.getValue());
		
		
		
	}
	
}
