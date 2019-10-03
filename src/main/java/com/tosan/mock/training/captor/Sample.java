package com.tosan.mock.training.captor;

public class Sample {
	public void foo(OtherClass other) {
        SomeData data = new SomeData("Some inner data");
        other.doSomething(data);
    }
	
}
