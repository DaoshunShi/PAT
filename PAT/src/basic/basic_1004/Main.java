//题目描述
//大侦探福尔摩斯接到一张奇怪的字条：“我们约会吧！ 3485djDkxh4hhGE 2984akDfkkkkggEdsb s&hgsfdk d&Hyscvnm”。大侦探很
//
// 快就明白了，字条上奇怪的乱码实际上就是约会的时间“星期四 14:04”，因为前面两字符串中第1对相同的大写英文字母（大小写有区分）是
//
// 第4个字母'D'，代表星期四；第2对相同的字符是'E'，那是第5个英文字母，代表一天里的第14个钟头（于是一天的0点到23点由数字0到9、
//
// 以及大写字母A到N表示）；后面两字符串第1对相同的英文字母's'出现在第4个位置（从0开始计数）上，代表第4分钟。现给定两对字符串，
//
// 请帮助福尔摩斯解码得到约会的时间。
//
//输入描述:
//输入在4行中分别给出4个非空、不包含空格、且长度不超过60的字符串。
//
//
//输出描述:
//在一行中输出约会的时间，格式为“DAY HH:MM”，其中“DAY”是某星期的3字符缩写，即MON表示星期一，TUE表示星期二，WED表示星期三，THU表示星期
//
//四，FRI表示星期五，SAT表示星期六，SUN表示星期日。题目输入保证每个测试存在唯一解。
//
//输入例子:
//3485djDkxh4hhGE
//
//2984akDfkkkkggEdsb
//
//s&hgsfdk
//
//d&Hyscvnm
//
//输出例子:
//THU 14:04


package basic.basic_1004;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] strs = new String[4];
		for (int i = 0; i < 4; i++) {
			strs[i] = sc.next();
		}
		
		for (int i = 0; i < 4; i++) {
			System.out.println(strs[i]);
		}
//		int cnt1 = (int) (Math.pow(2, 31) - 1 );
//		System.out.println(cnt1);
		
		System.out.println(strs[0].substring(4));
		
		int wd = getWeekday(strs[0], strs[1]);
		System.out.println(wd);
	}
	
	private static int getWeekday(String str1, String str2) {
		int cnt1 = (int) (Math.pow(2, 31) - 1);
		int wd = 0;
		
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) - 'A' >= 0 && str1.charAt(i) - 'A'<= 25) {
				for (int j = 0; j < str2.length(); j++) {
					if (str1.charAt(i) == str2.charAt(j)) {
						if (cnt1 > i+j) {
							cnt1 = i + j;
//							System.out.println(cnt1);
							wd = str1.charAt(i) - 'A' + 1;
						}
					}
					
				}
			}
		}
		return wd;
	}

//	private static int getHour(String str1, String str2) {
//		int cnt1 = (int) (Math.pow(2, 31) - 1);
//		int cnt2 = (int) (Math.pow(2, 31) - 1);
////		int wd = 0;
//		int hour = 0;
//		
//		for (int i = 0; i < str1.length(); i++) {
//			if (str1.charAt(i) - 'A' >= 0 && str1.charAt(i) - 'A'<= 25) {
//				for (int j = 0; j < str2.length(); j++) {
//					if (str1.charAt(i) == str2.charAt(j)) {
//						if (cnt1 > i+j) {
//							cnt1 = i + j;
//							wd = str1.charAt(i) - 'A' + 1;
//						}
//						else if (cnt2 > i+j) {
//							cnt2 = i + j;
//							wd = str1.charAt(i) - 
//						}
//					}
//					
//				}
//			}
//		}
//		return wd;
//	}
	
}
