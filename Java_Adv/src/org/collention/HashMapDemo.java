package org.collention;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		Map<String, Dog> dogMap = new HashMap<String, Dog>();
		
		dogMap.put("a", new Dog("亚亚", "拉布拉多"));
		dogMap.put("b", new Dog("偶偶", "雪纳瑞"));
		dogMap.put("c", new Dog("飞飞", "拉布拉多"));
		dogMap.put("d", new Dog("美美", "雪纳瑞"));
		
		dogMap.forEach((String key, Dog dogu) -> {
			System.out.println(dogu.getName() + "----" + dogu.getSt() + "'s key is " + key);
		});
		
		Set<Map.Entry<String, Dog>> entry = dogMap.entrySet();
		
		for (Map.Entry<String, Dog> entry2 : entry) {
			System.out.println(entry2.getKey() + "-->" + entry2.getValue().getName() + "&" + entry2.getValue().getSt());
		}
		
		Collection<Dog> collDogs = dogMap.values();
		//---------------------------------------
		Iterator<Dog> it = collDogs.iterator();
		Dog dog = null;
		
		while (it.hasNext()) {
			dog = it.next();
			System.out.println(dog.getName() + "----" + dog.getSt());
		}
		//---------------------------------------
		System.out.println("-----------------------");
		//---------------------------------------
		collDogs.forEach(
			(Dog dogi) ->{
				System.out.println(dogi.getName() + "----" + dogi.getSt());
			}
		);
		//---------------------------------------
		
	}

}
