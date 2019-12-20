package com.tosan.mock.training;

import java.util.Date;

public class MathApplication {

	private static double extra = 10.0;

	private CalculatorService calcService;

	public void setCalculatorService(CalculatorService calcService) {
		this.calcService = calcService;
	}

//	public static void setExtra(double extra) {
//		MathApplication.extra = extra;
//	}

	public double add(double input1, double input2) {
		Integer i = new Integer(5);
		return calcService.add(input1, input2) + extra + i;
		
	}

	public double subtract(double input1, double input2) {
		return calcService.subtract(input1, input2) + extra;
	}

	public double multiply(double input1, double input2) {
		return calcService.multiply(input1, input2) + extra;
	}

	public double divide(double input1, double input2) {
		return calcService.divide(input1, input2) + extra;
	}

	public double simpleCalculation(double input1, double input2) {
		double total = 0;
		for (int i = 0; i < 5; i++) {
			total = add(input1, input2);
			System.out.println(i + " : add(input1, input2) : " + input1 + "+" + input2);
			if (i % 2 == 0) {
				total = subtract(total, input2);
				System.out.println(i + " : subtract(total, input2) : " + input1 + "-" + input2);
			}
		}
		System.out.println(total);
		return total;
	}

	public double throwRuntimeException(double input1, double input2) {
		return add(input1, input2);
	}

	public double timeoutSample(double input1, double input2) throws InterruptedException {
		System.out.println(new Date());
		Thread.sleep(2000);
		System.out.println(new Date());
		double add = calcService.add(input1, input2) ;
		System.out.println(new Date() + " add");
		Thread.sleep(2000);
		System.out.println(new Date() + " sub");
		double sub = calcService.subtract(input1, input2) ;
		return add + sub;
	} 
	
}