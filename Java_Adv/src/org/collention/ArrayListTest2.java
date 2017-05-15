package org.collention;

import java.util.*;
import java.util.function.Consumer;

public class ArrayListTest2 {

	public static void main(String[] args) {
		Set<Dog> set = new HashSet<Dog>();
		List<Dog> list = new ArrayList<Dog>();
		StringBuffer buf = new StringBuffer();
		StringBuilder bub = new StringBuilder();
		
		Dog[] dogs = new Dog[2];
		dogs[0] = new Dog("Test5", "Test6");
		dogs[1] = new Dog("Test7", "Test8");
		
		set.add(new Dog("Test1", "Test2"));
		set.add(new Dog("Test3", "Test4"));
		
		list.add(new Dog("亚亚", "拉布拉多"));
		list.add(new Dog("偶偶", "雪纳瑞"));
		list.add(new Dog("飞飞", "拉布拉多"));
		list.add(new Dog("美美", "雪纳瑞"));
		
		list.forEach(
//			new Consumer<Dog>() { 
//
//				@Override
//				public void accept(Dog dog) {
//					System.out.println(dog.getName() + "---" + dog.getSt());
//				}
//			
//			}
			(Dog dog) -> {
				System.out.println(dog.getName() + "---" + dog.getSt());
			}
				);
		
		System.out.println("----------------------------------");
		
		set.addAll(list);
		
		Iterator<Dog> iter = set.iterator();
		Dog dog = null;
		//hasNext()判断是否有下一个元素
		while (iter.hasNext()) {
			//next()获取下一个元素
			dog = iter.next();
			 
			 System.out.println(dog.getName() + "---" + dog.getSt());
			
		}
		
		/*
		list.addAll(set);
		
		System.out.println("删除前共计" + list.size() + "条");
		
		for (Dog dog : list) {
			System.out.println(dog.getName() + "\t" + dog.getSt());
		}
		
		System.out.println("第一条" + list.remove(0).getName() + "被删除");
		
		System.out.println("删除后共计" + list.size() + "条");
		
		list.remove(0);
		*/
		
	}

}
