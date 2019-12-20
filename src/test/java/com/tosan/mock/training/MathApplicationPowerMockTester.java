package com.tosan.mock.training;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MathApplication.class)
public class MathApplicationPowerMockTester {

	@InjectMocks
	MathApplication mathApplication = new MathApplication();

	@Mock
	CalculatorService calcService;

	
	@Test
	public void testAdd() throws NoSuchFieldException, SecurityException {
		double extra = 20.0;
		Whitebox.setInternalState(MathApplication.class, "extra", extra);

		when(calcService.add(10.0, 20.0)).thenReturn(35.00);
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 55.0, 0);
		verify(calcService, times(1)).add(10.0, 20.0);
	}
	

	@Test
	public void testAdd2() throws NoSuchFieldException, SecurityException {
		double extra = 20.0;
		Whitebox.setInternalState(MathApplication.class, "extra", extra);
		try {
			PowerMockito.whenNew(Integer.class).withArguments(5).thenReturn(7);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		when(calcService.add(10.0, 20.0)).thenReturn(35.00);
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 62.0, 0);
		verify(calcService, times(1)).add(10.0, 20.0);
	}
	
}
















