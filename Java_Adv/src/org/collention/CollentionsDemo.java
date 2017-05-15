package org.collention;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

enum Week {
	
}

public class CollentionsDemo {

	public static void main(String[] args) {
		
		List<Dog> dogs = new ArrayList<>();
		
		dogs.add(new Dog("亚亚", "拉布拉多"));
		dogs.add(new Dog("偶偶", "雪纳瑞"));
		dogs.add(new Dog("飞飞", "拉布拉多"));
		dogs.add(new Dog("美美", "雪纳瑞"));
		
		
//		List<String> names = Arrays.asList("Tan", "Zhen", "Yu");
//      Collections.sort(names, (String a, String b) -> a.compareTo(b));
		
		Collections.sort(dogs, (Dog o1, Dog o2) ->{
			return Collator.getInstance(Locale.CHINA).compare(o1.getName(), o2.getName());
		});
		
		dogs.forEach((Dog dog) -> {System.out.println(dog.getName() + "--->" + dog.getSt());});
	}

}
