package com.tosan.junit.training.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.mockito.junit.MockitoJUnitRunner;

import com.tosan.junit.training.suite.classes.ClassA;
import com.tosan.junit.training.suite.classes.ClassB;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ClassA.class, //test case 1
        ClassB.class     //test case 2
})
public class SuiteAbcTest {
	//normally, this is an empty class
}