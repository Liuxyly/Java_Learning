package org.collention;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ArrayListTest {

	public static void main(String[] args) {
		
		
		
		try {
			SecureRandom sr = SecureRandom.getInstanceStrong();
			
			System.out.println(sr.getAlgorithm());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		(new Thread(() -> {
			System.out.println("Java 8 Test");
		})).start();

		List<String> list = new ArrayList<String>();

		for (int i = 0; i < 1000000; i++) {
			double d = Math.random() * 1000;
			list.add(d + "");
		}

		long start = System.nanoTime();// 获取系统开始排序的时间点
		/**
		 * 串行排序
		 */
		// int count = (int) list.stream().sequential().sorted().count();
		/**
		 * 并行排序
		 */
		@SuppressWarnings("unused")
		int count = (int) list.stream().parallel().sorted().count();
		long end = System.nanoTime();// 获取系统结束排序的时间点
		long ms = TimeUnit.NANOSECONDS.toMillis(end - start);// 得到串行排序所用的时间
		System.out.println(ms + "ms");

//		list.stream() // 获取列表的 stream 操作对象
//				.filter((s) -> s.startsWith("222"))// 对这个流做过滤操作
//				.forEach(System.out::println);
	}

}
