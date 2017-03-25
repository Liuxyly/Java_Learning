package org.excem;

public class TestClass {

	public static void main(String[] args) {
		ScoreOperate oper = new ScoreOperate();
		
		oper.setStu();
		System.out.println("平均值：" + oper.avgScore());
		System.out.println("最大值：" + oper.maxScore());
	}

}
