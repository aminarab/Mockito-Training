package com.tosan.mock.training;

public class CalculatorServiceImpl implements CalculatorService {

	
	
	public double add(double input1, double input2) {
		double add = input1 + input2;
		System.out.println("Cal : " + input1 + "+" +  input2 + "=" + add);
		return add;
	}

	public double subtract(double input1, double input2) {
		return input1 - input2;
	}

	public double multiply(double input1, double input2) {
		return input1 * input2;
	}

	public double divide(double input1, double input2) {
		return input1 / input2;
	}
	
}
