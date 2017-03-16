package first;

import java.util.*;

public class FirstProgramm {

	public static void main(String[] args) {

		// 输出本人信息
		// String name = "小明";
		// int age = 25;
		// int work = 3;
		// int worked = 5;
		// String Tec = "Java";
		// String Hobit = "篮球";
		//
		// System.out.println("这个同学的姓名是：" + name);
		// System.out.println("年龄是：" + age);
		// System.out.println("工作了" + work + "年了");
		// System.out.println("做过" + worked + "个项目");
		// System.out.println("技术方向是" + Tec);
		// System.out.println("兴趣爱好是：" + Hobit);

		// 从键盘上输入4位会员卡号并将数据存储于变量中，最后打印变量值
		// System.out.println("请输入4位会员卡号：");
		// Scanner inNum = new Scanner(System.in);
		// int CardID = inNum.nextInt();
		// System.out.println("会员卡号是：" + CardID);

		// 两个变量的交换
		// int num1 = 8;
		// int num2 = 9;
		// int tmp = num1;
		// num1 = num2;
		// num1 = tmp;
		// 仅限于数字
		// num1 = num1 + num2;
		// num2 = num1 - num2;
		// num1 = num1 - num2;

		// System.out.println("switch num1 is " + num1 + "\nnum2 is " + num2);

		// 输入4位数并打印各个位上的数字，最后把这些数求和
		// Scanner inNum = new Scanner(System.in);
		// System.out.println("请输入4位会员卡号：");
		// int CardID = inNum.nextInt();
		// System.out.println("会员卡号是：" + CardID);
		// System.out.println("千位数：" + CardID/1000 + "百位数：" + (CardID/100)%10 +
		// "十位数：" + (CardID/10)%10 + "个位数：" + CardID%10);
		// System.out.println("会员卡号" + CardID + "各位数之和：" + (CardID/1000 +
		// (CardID/100)%10 + (CardID/10)%10 + CardID%10));

		// 如果各个位数之和大于20
		// int sum = CardID/1000 + (CardID/100)%10 + (CardID/10)%10 + CardID%10;
		// if (sum > 20){
		// System.out.println("会员卡号" + CardID + "的会员，您中奖了！奖品是MP3");
		//
		// }else{
		// System.out.println("谢谢惠顾");
		//
		// }

		/*
		 * (java > 90 && music > 80) || (java = 100 && music > 70)
		 * 
		 */

		// 抽奖规则：会员号的百位数字等于产生的随机数字即为心愿会员
		// Scanner inNum = new Scanner(System.in);
		// System.out.println("我行我素购物管理系统 >幸运抽奖");
		// System.out.println("\n请输入4位会员号：");
		//
		// int CardID = inNum.nextInt();
		// int bai = (CardID/100)%10;
		// int ran = (int) (Math.random() * 10);
		// if ( bai == ran ){
		// System.out.println(CardID + "号客户是幸运客户，获精美的MP3一个。");
		// }else{
		// System.out.println(CardID + "号客户,谢谢您的支持！");
		// }
		// 优先级 非 > 算数 > 关系 > 逻辑 >（&& > ||）
		// System.out.println("请输入名次");
		// int order = new Scanner(System.in).nextInt();
		// //switch(表达式) 可以使用的数据类型 ：int short byte char String 枚举
		// switch (order) {
		// //case 常量
		// case 1:
		// //语句
		// System.out.println("参加麻省理工大学组织的1个月夏令营");
		// break; //结束整个选择结构
		// case 2:
		// System.out.println("奖励惠普笔记本电脑一部");
		// break;
		// case 3:
		// System.out.println("奖励移动硬盘一个");
		// break;
		// default:
		// System.out.println("谢谢惠顾");
		// break;
		// }

		// while应用的场合是循环次数不固定的情况
		// 循环结构：循环条件与循环操作
		// while (condition) {
		//
		// }
		// 先循环再判断，别忘了分号
		// do {
		//
		// } while (condition);

		// for循环的执行步骤 表达式1 表达式2 true 操作 表达式3 表达式2 false 跳出

		// for ( 表达式1; 表达式2; 表达式3) {
		// 操作
		// }
		// 输出其中的最大值和最小值，输入0则结束循环
		// Scanner input = new Scanner(System.in);
		// int tmp = 0, max = 0, min = 0;
		// System.out.print("请输入一个整数（输入0结束）：");
		// max = min = tmp = input.nextInt();
		//
		// while ( tmp != 0){
		// if (tmp > max)
		// {
		// max = tmp;
		// }
		// if (tmp < min)
		// {
		// min = tmp;
		// }
		//
		// System.out.print("请输入一个整数（输入0结束）：");
		// tmp = input.nextInt();
		//
		// }
		//
		// System.out.println("最大值是：" + max + "\n最小值是：" + min);

		// 输入数字返回星期
		// int week = 0;
		//
		// do{
		// System.out.print("请输入数字1-7（输入0结束）：");
		// week = input.nextInt();
		// switch(week){
		// case 1:
		// System.out.println("今天是 MON");
		// break;
		// case 2:
		// System.out.println("今天是 TUE");
		// break;
		// case 3:
		// System.out.println("今天是 WED");
		// break;
		// case 4:
		// System.out.println("今天是 THU");
		// break;
		// case 5:
		// System.out.println("今天是 FRI");
		// break;
		// case 6:
		// System.out.println("今天是 SAT");
		// break;
		// case 7:
		// System.out.println("今天是 SUN");
		// break;
		// default:
		// break;
		// }
		//
		// }while(week != 0);
		// System.out.println("程序结束");

		// 机票查询
		// System.out.println("请输入您出行的月份：1～12：");
		// int mon = input.nextInt();
		// System.out.println("请问您选择头等舱还是经济舱？头等舱输入1，经济舱输入2");
		// int _case = input.nextInt();
		//
		// if(mon >= 1 && mon <= 12){
		// if(mon >= 4 && mon <= 10){
		//
		// if(_case == 1){
		// System.out.println("您的机票价格为：" + 5000 * 0.9);
		// }else if(_case == 2){
		// System.out.println("您的机票价格为：" + 5000 * 0.6);
		// }
		// }else{
		// if(_case == 1){
		// System.out.println("您的机票价格为：" + 5000 * 0.5);
		// }else if(_case == 2){
		// System.out.println("您的机票价格为：" + 5000 * 0.4);
		// }
		// }
		//
		// }else{
		// System.out.println("请输入正确的月份");
		// }

		// for (int i = 0; i < 5; i++) {
		// for (int j = 0; j < 5; j++) {
		// System.out.print("*");
		// }
		// System.out.println();
		// }

		// for (int i = 0; i < 5; i++) {
		//
		// for (int k = 0; k < (5 - i) ; k++) {
		// System.out.print(" ");
		// }
		//
		// for (int j = 0; j < 5; j++) {
		// System.out.print("*");
		// }
		// System.out.println();
		// }

		// for (int i = 0; i < 5 ; i++) {
		// for (int j = 0; j <= (4 - i) ; j++) {
		// System.out.print(" ");
		// }
		//
		// for (int k = 1; k <= (2 * i + 1); k++) {
		// System.out.print("*");
		// }
		// System.out.println();
		// }

		// int sum = 0, tmp = 0;
		// for (int i = 1; i <= 10; i++) {
		// sum+=i;
		// if(sum > 20){
		// tmp = i;
		// break;
		// }
		// }
		// System.out.println("Number is " + tmp);

		// Scanner input = new Scanner(System.in);
		// System.out.print("输入班级总人数：");
		// int member = input.nextInt();
		// int tmp = member;
		// int i = 0, j = 0;
		//
		// while(member != 0){
		//
		// System.out.print("请输入第" + ++i + "位学生成绩是：");
		// if (input.nextInt() >= 80) {
		// j++;
		// }
		// member--;
		// }
		//
		// System.out.println("80分以上的学生人数是：" + j);
		// double bili = ((double)j/tmp)*100;
		// System.out.println("80分以上的学生所占的比例为：" + bili + "%" );

		// for (int i = 1, j = 1; j <= 9 ; i++) {
		// System.out.print(i + " * " + j + " = " + i * j + "\t");
		// if (i == j) {
		// i = 0;
		// j++;
		// System.out.println();
		// }
		// }

		// System.out.print("请输入要打印的行数：");
		// int rows = input.nextInt();
		// for (int i = 1; i <= rows; i++) {
		// for (int j = 1; j <= (2 * i - 1); j++) {
		// System.out.print("*");
		// }
		// System.out.println();
		// }

		Scanner input = new Scanner(System.in);
		// int i = 1;
		// double score = 0.0, sum = 0.0;
		// String name = null;
		// boolean flag = true;
		//
		// while(true){
		//
		// //一个人的五门成绩的平均值
		// flag = true;
		// i = 1;
		// sum = 0.0;
		//
		// System.out.print("请输入您的名字：");
		//
		// if (input.hasNext()) {
		// name = input.next();
		// while(i <= 5){
		// System.out.print("请输入第" + i + "门科目的成绩:");
		// try{
		// score = input.nextInt();
		//
		// if ( score < 0 ) {
		// System.out.println("输入的成绩有误，请重新输入");
		// }else{
		// sum += score;
		// i++;
		// }
		// }catch(Exception e){
		// System.out.println("输入的成绩有误，请重新输入");
		// }
		//
		// }
		// }else{
		// System.out.println("请输入正确的名字，然后继续。");
		// flag = false;
		// }
		//
		// if (flag) {
		// System.out.println(name+ "， 您的五门成绩的平均值是：" + sum/5);
		// System.out.println("请问是否继续(y/n)?");
		// if (!input.next().equals("y")) {
		// break;
		// }
		// }
		// }
		//
		// System.out.println("程序结束");

		// int i = 1, j = 1, tmp = 0, times = 0;
		//
		// while(true){
		// if ((10 - i - 3 * j) > 0) {
		// while (true) {
		// if (10 - i - 3 * j > 0) {
		// times++;
		// System.out.println("x is " + (10 - i - 3 * j) * 2 + "\t-- y is " + j
		// * 10 + "\t-- z is " + i * 5);
		// }else{
		// break;
		// }
		// j++;
		// }
		// }else{
		// break;
		// }
		// i++;
		// j = 1;
		//
		// }
		//
		// System.out.println(times);

		// int[] sort = {99, 85, 82, 63, 60, 0};
		// int tmp1 = 0, index = 0;
		//
		// System.out.print("Input a number to insert: ");
		// int insertNumber = input.nextInt();
		//
		// for (int i = 0; i < sort.length; i++) {
		// if (insertNumber >= sort[i]) {
		// index = i;
		// break;
		// }
		// }
		//
		// for (int i = index; i < sort.length - 1; i++) {
		// sort[i + 1] = sort[i];
		// }
		// sort[index] = insertNumber;
		//
		// for (int tmp:sort) {
		// System.out.print(tmp + " ");
		// }

		// int scores[]={2,6,5,4,9};
		// bubbleSort(scores);

		// int[][] scores1 = {{12, 23, 34, 45}, {12, 23, 34, 67}, {12, 23, 34,
		// 56}};
		// System.out.println(scores1.length);
		// System.out.println(scores1[0].length);
		//
		// for (int i = 0, j = 0;; j++) {
		//
		// if (j == scores1[i].length) {
		// j = 0;
		// i++;
		// }
		// if (i < scores1.length) {
		// System.out.print(scores1[i][j]);
		// }else{
		// break;
		// }
		//
		// }

		// int[] scores1 = {12, 23, 34};
		// int [] scores2 = null;

		// printscoresay(scores);

		// scoresays.sort(scores);

		// double [] moneys = new double[5];
		// double money = 0.0;
		// double sum = 0.0;
		// boolean flag = true;
		//
		// System.out.println("请输入会员本月的消费记录");
		// for (int i = 0; i < moneys.length; i++) {
		// System.out.print("请输入第" + (i + 1) + "笔购物金额:");
		// try {
		// moneys[i] = input.nextInt();
		// flag = true;
		// } catch (Exception e) {
		// System.out.println("数据有误");
		// input.nextLine();
		// i--;
		// flag = false;
		// }
		// if (flag) {
		// sum += moneys[i];
		// }
		//
		//
		// }
		//
		// System.out.println();
		// System.out.println();
		// System.out.println("序号\t\t金额（元）");
		//
		// for (int i = 0; i < moneys.length; i++) {
		// System.out.println(i + 1 + "\t\t" + moneys[i]);
		// }
		//
		// System.out.println("总金额\t\t" + sum);

		// double[] scores = new double[5];
		//
		// for (int i = 0; i < scores.length; i++) {
		// System.out.print("请输入第" + (i + 1) + "名学生的成绩:");
		// try {
		// scores[i] = input.nextInt();
		// } catch (Exception e) {
		// System.out.println("数据有误");
		// input.nextLine();
		// i--;
		// }
		// }
		//
		// double max = 0.0, min = 0.0, sum = 0.0;
		// max = min = scores[0];
		// for (int i = 0; i < scores.length; i++) {
		// sum += scores[i];
		//
		// if (scores[i] > max) {
		// max = scores[i];
		// }
		// if (scores[i] < min) {
		// min = scores[i];
		// }
		// }
		//
		// System.out.println("平均值：" + sum / scores.length + "\t最大值" + max +
		// "\t最小值" + min);

//		int[] a = new int[1];
//
//		int i = 0;
//		// 把数据赋值到数组
//		do {
//
//			// 输入一个数据
//			System.out.print("请输入数字：");
//			a[i] = input.nextInt();
//			a = scoresays.copyOf(a, a.length + 1);
//			i++;
//
//			System.out.print("是否继续（y/n） ");
//			// 询问是否继续输入
//		} while (input.next().equals("y"));
//
//		printscoresay(a, 0, a.length - 1);
		
		//作业1
//		double [] monays = new double[4];
//		System.out.println("请输入4家店的价格");
//		
//		for (int i = 0; i < monays.length; i++) {
//			System.out.print("第" + (i + 1) + "店的价格：");
//			monays[i] = input.nextInt();
//		}
//		
//		double min = monays[0];
//		
//		for (int i = 0; i < monays.length; i++) {
//			if (monays[i] < min){
//				min = monays[i];
//			}
//		}
//		
//		System.out.println("最低价格是：" + min);
		
		
		//作业2
//		int [] scores = new int[5];
//		System.out.println("请输入5名学员的成绩：");
//		for (int i = 0; i < scores.length; i++) {
//			scores[i] = input.nextInt();
//		}
//		
//		// 定义比较的次数,次数为数组长度-1
//		int temp = 0;
//		int times = scores.length - 1;
//		for (int i = 0; i < times; i++) {
//			if (scores[i] < scores[i + 1]) {
//				temp = scores[i];
//				scores[i] = scores[i + 1];
//				scores[i + 1] = temp;
//			}
//			// 关键点:判断是否是最后一次比较，若是，那么重制变量i
//			if (i == times - 1) {
//				i = -1;		// i重置为-1，随后for循环会自动++,因此下次比较时i值为0
//				times--;	// 比较次数递减1
//			}
//		}
//		
//		System.out.print("学员的成绩按降序排列：");
//		for (int score:scores) {
//			System.out.print(score + "\t");
//		}
		
		//作业3
		char [] chars = new char[5];
		String tmp = null;
		System.out.println("请输入5个字符：");
		for (int i = 0; i < chars.length; i++) {
			tmp = input.next();
			if (tmp.length() > 1) {
				System.out.println("请重新输入");
				i--;
			}else{
				chars[i] = tmp.charAt(0);
			}	
		}
		
		Arrays.sort(chars);
		
		tmp = null;
		char searchKey;
		int index = 0;
		
		while (true) {
			System.out.print("请输入需要查找的字符：");
			tmp = input.next();
			
			if (tmp.length() > 1) {
				System.out.println("请重新输入");
			}else{
				searchKey = tmp.charAt(0);
				index = Arrays.binarySearch(chars, searchKey);
				
				if (index < 0 || index > chars.length - 1 ) {
					System.out.println("没有找到");
				}else{
					System.out.println("您所查找的字符在" + (index + 1));
				}
			}
			System.out.print("是否继续(y/n):");
			if (!input.next().equals("y")) {
				break;
			}
		}
		
		
		
		

		// ------------------ ----------------------

//		int _caseNumber = 0;
//		int[] NumberID = { 1, 2, 3 };
//		String[] DVDName = { "变形金刚", "黑客帝国", "电锯惊魂" };
//		boolean[] state = { false, true, false };
//		String[] date = { "2017/03/23", "2017/04/23", "2017/05/03" };
//
//		while (true) {
//
//			System.out.print("请输入数字：");
//			_caseNumber = input.nextInt();
//
//			switch (_caseNumber) {
//			case 1:
//				// 查询
//				// 序号 名称 是否被借出 借出时间
//				System.out.println("序号\t\t名称\t\t是否被借出\t\t借出时间");
//				for (int i = 0; i < NumberID.length; i++) {
//					System.out.println(NumberID[i] + "\t\t" + DVDName[i] + "\t\t" + state[i] + "\t\t" + date[i]);
//				}
//
//				break;
//			case 2:
//				// 增加
//
//				break;
//			case 3:
//				// 删除
//
//				break;
//			case 4:
//				// 更改
//
//				break;
//			case 5:
//				// 续借
//
//				break;
//			case 6:
//				// 归还
//
//				break;
//			default:
//				break;
//			}
//		}

		// ----------------------------- end of program --------------------------------
	}

	private static void printscoresay(int[] scores, int from, int to) {
		for (int i = from; i < to; i++) {
			System.out.print(scores[i] + " ");
		}
	}

	private static void bubbleSort(int[] scores) {
		// 定义比较的次数,次数为数组长度-1
		int times = scores.length - 1;
		for (int i = 0; i < times; i++) {
			if (scores[i] > scores[i + 1]) {
				int temp = scores[i];
				scores[i] = scores[i + 1];
				scores[i + 1] = temp;
			}
			// 关键点:判断是否是最后一次比较，若是，那么充值变量
			if (i == times - 1) {
				i = -1;// i重置为-1，随后for循环会自动++,因此下次比较时i值为0
				times--;// 比较次数递减1
			}
		}

	}
}
