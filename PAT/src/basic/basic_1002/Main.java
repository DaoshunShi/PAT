//时间限制 1000 ms 内存限制 32768 KB 代码长度限制 100 KB 判断程序 Standard (来自 小小)
//题目描述
//给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：
//
//
//
//A1 = 能被5整除的数字中所有偶数的和；
//
//A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
//
//A3 = 被5除后余2的数字的个数；
//
//A4 = 被5除后余3的数字的平均数，精确到小数点后1位；
//
//A5 = 被5除后余4的数字中最大数字。
//
//输入描述:
//每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N，随后给出N个不超过1000的待分类的正整数。数字间以空格分隔。
//
//
//输出描述:
//对给定的N个正整数，按题目要求计算A1~A5并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。
//
//若其中某一类数字不存在，则在相应位置输出“N”。
//
//输入例子:
//13 1 2 3 4 5 6 7 8 9 10 20 16 18
//
//输出例子:
//30 11 2 9.7 9


package basic.basic_1002;

import java.util.Scanner;

public class Main {
	
	private static int a1, a2, a3, a5;
	private static float a4;
	private static int flag_a2;
	private static int count_a4;

	public static void main(String[] args) {
		
		flag_a2 = 1;
		a1 = 0;
		a2 = 0;
		a3 = 0;
		a4 = 0;
		a5 = 0;
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			readNext(sc.nextInt());
		}
		
		read();
	}
	
	private static void read() {
		if (a1 == 0) {
			System.out.print("N ");
		}
		else {
			System.out.print(a1 + " ");
		}
		
		if (a2 == 0) {
			System.out.print("N ");
		}
		else {
			System.out.print(a2 + " ");
		}
		
		if (a3 == 0) {
			System.out.print("N ");
		}
		else {
			System.out.print(a3 + " ");
		}
		
		if (a4 == 0) {
			System.out.print("N ");
		}
		else {
			System.out.printf("%.1f ", (a4/(float)count_a4));
//			if(a4 % 1 == 0) {
//				System.out.printf("%.0f ", (a4/count_a4));
//			}
//			else 
//				System.out.printf("%.1f ", (a4/count_a4));
		}
		
		if (a5 == 0) {
			System.out.print("N");
		}
		else {
			System.out.print(a5);
		} 
	}

	private static void readNext(int num) {
		int t = num % 5;
		switch (t) {
		case 0:
			if (num % 2 == 0) {
				a1 += num;
			}
			break;
		case 1:
			a2 = a2 + flag_a2 * num;
			flag_a2 = -1 * flag_a2;
			break;
		case 2:
			a3++;
			break;
		case 3:
			a4 += num;
			count_a4++;
			break;
		case 4:
			a5 = Math.max(num, a5);
			break;
		}
	}
}
