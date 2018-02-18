//题目描述
//要获得一个C语言程序的运行时间，常用的方法是调用头文件time.h，其中提供了clock()函数，可以捕捉从程序开始运行到clock()被调用时所
//
//耗费的时间。这个时间单位是clock tick，即“时钟打点”。同时还有一个常数CLK_TCK，给出了机器时钟每秒所走的时钟打点数。于是为了获
//
//得一个函数f的运行时间，我们只要在调用f之前先调用clock()，获得一个时钟打点数C1；在f执行完成后再调用clock()，获得另一个时钟打点
//
//数C2；两次获得的时钟打点数之差(C2-C1)就是f运行所消耗的时钟打点数，再除以常数CLK_TCK，就得到了以秒为单位的运行时间。
//
//
//
//这里不妨简单假设常数CLK_TCK为100。现给定被测函数前后两次获得的时钟打点数，请你给出被测函数运行的时间。
//
//输入描述:
//输入在一行中顺序给出2个整数C1和C1。注意两次获得的时钟打点数肯定不相同，即C1 < C2，并且取值在[0, 107]
//
//
//输出描述:
//在一行中输出被测函数运行的时间。运行时间必须按照“hh:mm:ss”（即2位的“时:分:秒”）格式输出；不足1秒的时间四舍五入到秒。
//
//输入例子:
//123 4577973
//
//输出例子:
//12:42:59


package basic.basic_1016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");
		float c1 = Integer.valueOf(str[0]), c2 = Integer.valueOf(str[1]);
		int seconds = Math.round((c2 - c1) / 100);
		
		String hh = seconds / 3600 + "";
		String mm = (seconds % 3600) / 60 + "";
		String ss = seconds % 60 + "";
		
		while (hh.length() < 2) {
			hh = "0" + hh;
		}
		while (mm.length() < 2) {
			mm = "0" + mm;
		}
		while (ss.length() < 2) {
			ss = "0" + ss;
		}
		
		System.out.println(hh + ":" + mm + ":" + ss);
		
	}

}
