ExceptionMatcher extends TypeSafeMatcher<AuthenticationException>

https://stackoverflow.com/questions/36253040/example-on-mockitos-argumentcaptor

class A {
    public void foo(OtherClass other) {
        SomeData data = new SomeData("Some inner data");
        other.doSomething(data);
    }
}
Now if you want to check the inner data you can use the captor:

// Create a mock of the OtherClass
OtherClass other = mock(OtherClass.class);

// Run the foo method with the mock
new A().foo(other);

// Capture the argument of the doSomething function
ArgumentCaptor<SomeData> captor = ArgumentCaptor.forClass(SomeData.class);
verify(other, times(1)).doSomething(captor.capture());

// Assert the argument
SomeData actual = captor.getValue();
assertEquals("Some inner data", actual.innerData); 