package org.collention;

public class FunctionTestClass {

	public static void main(String[] args) {
		int q = FunctionTest2.something(12, 23, (int a, int b) -> {
			return a * b;
		});
		
		System.out.println(q);
	}
}

class FunctionTest2 {
	public static int something(int a, int b, FunctionTest oper){
		return oper.operation(a, b);
	}
}

@FunctionalInterface
interface FunctionTest {
	int operation(int a, int b);
}