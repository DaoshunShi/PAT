//题目描述
//本题要求计算A/B，其中A是不超过1000位的正整数，B是1位正整数。你需要输出商数Q和余数R，使得A = B * Q + R成立。
//
//输入描述:
//输入在1行中依次给出A和B，中间以1空格分隔。
//
//
//输出描述:
//在1行中依次输出Q和R，中间以1空格分隔。
//
//输入例子:
//123456789050987654321 7
//
//输出例子:
//17636684150141093474 3


package basic.basic_1007;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigDecimal a = new BigDecimal(1);
		BigDecimal b = new BigDecimal(1);
		a = sc.nextBigDecimal();
		b = sc.nextBigDecimal();
		
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		BigDecimal q, r = new BigDecimal(1);
//		r = a % b;
//	    q = (a - r) / b;
		r = a.divideAndRemainder(b)[1];
		q = (a.subtract(r)).divide(b);
		
		System.out.println(q.toString() + " " + r.toString());
	}

}
