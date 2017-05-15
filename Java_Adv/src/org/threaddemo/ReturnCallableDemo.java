package org.threaddemo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReturnCallableDemo {

	public static void main(String[] args) {
		System.out.println("程序开始");
		Date date1 = new Date();
		
		int taskSize = 5;
		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		// 创建多个又返回值的 任务
		List<Future<?>> futures = new ArrayList<>();
		Callable<?> call = null;
		for (int i = 0; i < taskSize; i++) {
			call = new CallableDemo(i + " ");
			// 执行任务并获取Future对象
			Future<?> future = pool.submit(call);
			futures.add(future);
		}
		//关闭线程池
		pool.shutdown();
		
		for (Future<?> future : futures) {
			try {
				System.out.println(">>>" + future.get().toString());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Date date2 = new Date();
		System.out.println("程序结束， 运行时间" + (date2.getTime() - date1.getTime()) + "毫秒");
	}

}

class CallableDemo implements Callable<Object> {
	private String taskNum;
	
	public CallableDemo(String taskNum) {
		this.taskNum = taskNum;
	}

	@Override
	public Object call() throws Exception {
		System.out.println(">>>" + taskNum + "任务启动");
		Date date1 = new Date();
		Thread.sleep(1000);
		Date date2 = new Date();
		long time = date2.getTime() - date1.getTime();
		System.out.println(">>>" + taskNum + "任务结束");
		
		return taskNum + "任务返回运行结果，当前任务时间：" + time + "毫秒"; 
	}
	
	
}