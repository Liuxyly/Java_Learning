package org.excem;

import java.util.*;

public class ScoreOperate {
	private Student[] student = new Student[5];
	private Scanner input;
	/**
	 * @param stu the stu to set
	 */
	public void setStu() {
		this.input = new Scanner(System.in);
		boolean flag = true;
		double tmp = 0.0;
		
		System.out.println("请输入五名参赛者的成绩：");
		
		for (int i = 0; i < student.length; i++) {
			try {
				if (flag) {
					this.student[i] = new Student();
				}
				tmp = input.nextDouble();
				this.student[i].setScore(tmp);
				
				flag = true;
			} catch (Exception e) {
				System.out.println("输入不正确！");
				input.nextLine();
				flag = false;
				i --;
			}
		}
		
	}
	
	public double avgScore() {
		double sum = 0;
		
		for (int i = 0; i < student.length; i++) {
			sum += student[i].getScore();
		}
		
		return sum / student.length;
	}
	
	public double maxScore() {
		double max = this.student[0].getScore();
		for (int i = 0; i < student.length; i++) {
			if (max < this.student[i].getScore()) {
				max = this.student[i].getScore();
			}
		}
		return max;
	}
	
}
