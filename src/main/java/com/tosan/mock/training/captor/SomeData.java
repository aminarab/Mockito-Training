package com.tosan.mock.training.captor;

public class SomeData {

	public SomeData(String value){
		this.value = value;
	}
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}