package org.collention;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListDemo4 {

	public static void main(String[] args) {
		
		Map<A, B> maps = new HashMap<>();
		
		
		maps.put(new A(), new B());
		maps.put(new A(), new B());
		maps.put(new A(), new B());
		maps.put(new A(), new B());
		
		Stream
			//数组的值
			.of("a", "b", "c", "d")
			//转换为List
			.collect(Collectors.toList())
			//把List转换为Stream
			.stream()
			//对Steam中每个元素进行处理
			.map(string -> string.toUpperCase())
			//输出每个元素的值
			.forEach(string -> System.out.println(string));
		
		System.out.println("--------------------------");
		
		
//		B b = new B();
//		System.out.println("-----");
//		A a = new B();
//		System.out.println("-----");
//		A a2 = new B();
//		System.out.println("-----");
//		A a1 = new A();
		
		
	}

}

class A {
	static{System.out.println("1");}
	
	public A(){System.out.println("2");}
}

class B extends A {
	static{System.out.println("a");}
	public B(){System.out.println("b");}
}