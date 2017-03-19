package org.Liuxy;

import java.util.*;
import java.text.*;

public class DVDManager {

	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		int _caseNumber = 0;
		String[] DVDName = { "变形金刚", "黑客帝国", "电锯惊魂" };
		boolean[] states = { false, true, false };
		String[] date = { null, "2017-01-01", null };
		int[] times = {0, 1, 0};
		boolean[] delOrNot = {false, false, false};
		
		String state = null;
		String nameTemp = null;
		boolean exit = false;
		int delNumber = 0;
		int bNumber = 0;
		int rNumber = 0;
		int index = 0;
		boolean allDel;
		boolean addflag = true;

		while (!exit) {
			System.out.println("----------------------");
			System.out.println("1.查 询DVD");
			System.out.println("2.增 加DVD");
			System.out.println("3.删 除DVD");
			System.out.println("4.借 出DVD");
			System.out.println("5.归 还DVD");
			System.out.println("6.退 出");
			System.out.println("----------------------");
			System.out.print("请输入数字：");
			try {
				_caseNumber = input.nextInt();
			} catch (Exception e) {
				_caseNumber = 7;
				input.nextLine();
			}
			
			switch (_caseNumber) {
				case 1:
					// 查询
					// 序号 名称 是否被借出 借出时间 借出次数
					index = 0;
					System.out.println("序号\t\t名称\t\t是否被借出\t\t借出时间\t\t借出次数");
					for (int i = 0; i < DVDName.length; i++) {
						if (!states[i]) {
							state = "可借出";
						}else{
							state = "已借出";
						}
						if ( //DVDName[i] != null && 
							date[i] != null && !delOrNot[i]) {
							
							System.out.println(++index + "\t\t" + DVDName[i] + "\t\t" + state + "\t\t" 
									+ date[i] + "\t" + times[i]);
						}
						if ( //DVDName[i] != null && 
							date[i] == null && !delOrNot[i]){
							System.out.println(++index + "\t\t" + DVDName[i] + "\t\t" + state + "\t\t" 
									+ "\t\t" + times[i]);
						}
					}
					
					if(index == 0){
						System.out.println("没有DVD信息");
					}
					
					System.out.println("*******************");
					System.out.println("输入0返回");
					try {
						input.next();
					} catch (Exception e) {
						break;
					}
					
					break;
				case 2:
					// 增加
					System.out.print("请输入要添加的DVD名：");
					nameTemp = input.next();
					for (String DVDN : DVDName) {
						if (nameTemp.equals(DVDN)) {
							addflag = false;
							break;
						}
					}
					
					if (!addflag) {
						System.out.println("DVD已经添加！");
						break;
					}
					
					DVDName 	= Arrays.copyOf(DVDName		, DVDName.length + 1);
					states 		= Arrays.copyOf(states		, states.length + 1);
					times 		= Arrays.copyOf(times		, times.length + 1);
					date 		= Arrays.copyOf(date		, date.length + 1);
					delOrNot 	= Arrays.copyOf(delOrNot	, delOrNot.length + 1);
					
					DVDName[DVDName.length - 1] 	= nameTemp;
					states[DVDName.length - 1] 		= false;
					times[DVDName.length - 1] 		= 0;
					date[DVDName.length - 1]		= null;
					delOrNot[DVDName.length - 1] 	= false;
					System.out.println("\t添加成功");
//					}
					
					System.out.println("*******************");
					System.out.println("输入0返回");
					try {
						input.next();
					} catch (Exception e) {
						break;
					}
					
					break;
				case 3:
					// 删除
					allDel = true;
					for (boolean del : delOrNot) {
						allDel &= del;
					}
					
					if (allDel) {
						System.out.println("没有DVD数据，返回主菜单！");
						break;
					}
					
					System.out.println("序号\t\t名称\t\t是否被借出\t\t借出时间\t\t借出次数");
					index = 0;
					for (int i = 0; i < DVDName.length; i++) {
						if (!states[i]) {
							state = "可借出";
						}else{
							state = "已借出";
						}
						if ( //DVDName[i] != null && 
							date[i] != null && !delOrNot[i]) {
							
							System.out.println(++index + "\t\t" + DVDName[i] + "\t\t" + state + "\t\t" 
									+ date[i] + "\t" + times[i]);
						}
						if ( //DVDName[i] != null && 
							date[i] == null && !delOrNot[i]){
							System.out.println(++index + "\t\t" + DVDName[i] + "\t\t" + state + "\t\t" 
									+ "\t\t" + times[i]);
						}
					}
					
					System.out.print("请输入要删除的DVD的序号：");
					try {
						delNumber = input.nextInt();
					} catch (Exception e) {
						System.out.println("您输入的序号不对,回到主菜单");
						input.nextLine();
						break;
					}
					
					if (delNumber >= 1 && delNumber <= delOrNot.length) {
//						delOrNot[delNumber - 1] = true;
						for (int i = 0, delindex = 0; i < delOrNot.length; i++) {
							if (!delOrNot[i]) {
								delindex++;
							}
							if (delindex == delNumber) {
								delOrNot[i] = true;
								delNumber = i;
								break;
							}
						}
						
						if (states[delNumber]) {
							delOrNot[delNumber] = false;
							System.out.println("已借出，不可删除！");
							break;
						}
					}else{
						System.out.println("您输入的序号不在列表中,回到主菜单");
						break;
					}
					
					System.out.println("*******************");
					System.out.println("输入0返回");
					try {
						input.next();
					} catch (Exception e) {
						break;
					}
					
					break;
				case 4:
					// 借出
					System.out.println("序号\t\t名称\t\t是否被借出\t\t借出时间\t\t借出次数");
					index = 0;
					for (int i = 0; i < DVDName.length; i++) {
						if (!states[i]) {
							state = "可借出";
						}else{
							state = "已借出";
						}
						if ( //DVDName[i] != null && 
							date[i] != null && !delOrNot[i]) {
							
							System.out.println(++index + "\t\t" + DVDName[i] + "\t\t" + state + "\t\t" 
									+ date[i] + "\t" + times[i]);
						}
						if ( //DVDName[i] != null && 
							date[i] == null && !delOrNot[i]){
							System.out.println(++index + "\t\t" + DVDName[i] + "\t\t" + state + "\t\t" 
									+ "\t\t" + times[i]);
						}
					}
					
					System.out.print("请输入要借出的DVD的序号：");
					try {
						bNumber = input.nextInt();
					} catch (Exception e) {
						System.out.println("您输入的序号不对,回到主菜单");
						input.nextLine();
						break;
					}
					
					if (bNumber >= 1 && bNumber <= states.length) {
						
						for (int i = 0, delindex = 0; i < delOrNot.length; i++) {
							if (!delOrNot[i]) {
								delindex++;
							}
							if (delindex == bNumber) {
								bNumber = i;
								break;
							}
						}
						
						if (!states[bNumber]) {
							states[bNumber] = true;
							date[bNumber] = format.format(today);
							times[bNumber] ++;
						}else{
							System.out.println("已借出，不可重复借出！");
							break;
						}
						
					}else{
						System.out.println("您输入的序号不在列表中,回到主菜单");
						break;
					}
					
					System.out.println("*******************");
					System.out.println("输入0返回");
					try {
						input.next();
					} catch (Exception e) {
						break;
					}
					
					break;
				case 5:
					// 归还
					
					System.out.println("序号\t\t名称\t\t是否被借出\t\t借出时间\t\t借出次数");
					index = 0;
					for (int i = 0; i < DVDName.length; i++) {
						if (!states[i]) {
							state = "可借出";
						}else{
							state = "已借出";
						}
						if ( //DVDName[i] != null && 
							date[i] != null && !delOrNot[i]) {
							
							System.out.println(++index + "\t\t" + DVDName[i] + "\t\t" + state + "\t\t" 
									+ date[i] + "\t" + times[i]);
						}
						if ( //DVDName[i] != null && 
							date[i] == null && !delOrNot[i]){
							System.out.println(++index + "\t\t" + DVDName[i] + "\t\t" + state + "\t\t" 
									+ "\t\t" + times[i]);
						}
					}
					
					System.out.print("请输入要归还的DVD的序号：");
					try {
						rNumber = input.nextInt();
					} catch (Exception e) {
						System.out.println("您输入的序号不对,回到主菜单");
						input.nextLine();
						break;
					}
					
					if (rNumber >= 1 && rNumber <= states.length) {
						
						for (int i = 0, delindex = 0; i < delOrNot.length; i++) {
							if (!delOrNot[i]) {
								delindex++;
							}
							if (delindex == rNumber) {
								rNumber = i;
								break;
							}
						}
						
						if (states[rNumber]) {
							
					        Calendar cal = Calendar.getInstance();
					        
					        try {
								cal.setTime(format.parse(format.format(today)));
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					        long time1 = cal.getTimeInMillis();
					        
					        try {
								cal.setTime(format.parse(date[rNumber]));
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					        long time2 = cal.getTimeInMillis();
					        
					        long between_days=(time1 - time2)/(1000*3600*24);
					            
					        System.out.println("DVD已归还");
					        System.out.println("一共" + Integer.parseInt(String.valueOf(between_days)) + "元");
					        
					        date[rNumber] = null;
					        states[rNumber] = false;
						}else{
							System.out.println("已借归还，不可重复归还！");
							break;
						}
						
					}else{
						System.out.println("您输入的序号不在列表中,回到主菜单");
						break;
					}
					
					System.out.println("*******************");
					System.out.println("输入0返回");
					try {
						input.next();
					} catch (Exception e) {
						break;
					}
					
					break;
				case 6:
					// 退出
					exit = true;
					System.out.println("欢迎下次使用");
					break;
				default:
					System.out.println("请输入正确的操作码");
					break;
			}
		}

	}

}
