package com.tosan.mock.training;

import org.junit.Before;

public class ApplicationRunner {

	private MathApplication mathApplication;
	
	@Before
	public void before(){
		mathApplication = new MathApplication();
	}
	
	public double myCalculation(double input1,double input2){
		return mathApplication.add(input1+1, input2+1);
	}
	
	
	
}
