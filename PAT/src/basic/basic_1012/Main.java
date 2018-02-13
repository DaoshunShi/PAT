//题目描述
//输入两个非负10进制整数A和B(<=2^30-1)，输出A+B的D (1 < D <= 10)进制数。
//
//输入描述:
//输入在一行中依次给出3个整数A、B和D。
//
//
//输出描述:
//输出A+B的D进制数。
//
//输入例子:
//123 456 8
//
//输出例子:
//1103


package basic.basic_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");
		
		int ab = Integer.valueOf(str[0]) + Integer.valueOf(str[1]);
		int d = Integer.valueOf(str[2]);
		StringBuilder result = new StringBuilder();
		
		//进行进制转换
		while(ab != 0) {
			result.append(ab % d);
			ab = ab / d;
		}
		
		System.out.println(result.reverse());
	}

}
