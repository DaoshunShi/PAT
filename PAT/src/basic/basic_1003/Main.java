//题目描述
//令Pi表示第i个素数。现任给两个正整数M <= N <= 10000，请输出PM到PN的所有素数。
//
//输入描述:
//输入在一行中给出M和N，其间以空格分隔。
//
//
//输出描述:
//输出从PM到PN的所有素数，每10个数字占1行，其间以空格分隔，但行末不得有多余空格。
//
//输入例子:
//5 27
//
//输出例子:
//11 13 17 19 23 29 31 37 41 43
//
//47 53 59 61 67 71 73 79 83 89
//
//97 101 103


package basic.basic_1003;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[] prime = new int[n-m+1];
		int i = 2;	//记录当前数字
		int cnt1 = 0;	//记录当前素数个数
		int cnt2 = 1;	//记录当前行第i个
		
		while (cnt1 < m-1) {	//去第0个到第m-1个素数
			if (isPrime(i)) {
				cnt1++;
			}
			i++;
		}
		
		while (cnt1 < n) {	//取第m个到第n个素数
			if (isPrime(i)) {
				cnt1++;
				prime[cnt1-m] = i;
			}
			i++;
		}

		for (int j = 0; j < n-m+1; j++) {
			if (j == n-m) {
				System.out.print(prime[j]);
			}
			else {
				if (cnt2 < 10) {
					System.out.print(prime[j] + " ");
				}
				else {
					System.out.println(prime[j]);
					cnt2 = 0;
				}
			}
			cnt2++;
		}
	}
	
	private static boolean isPrime(int n){
		int temp = (int) Math.sqrt(n);
		if (n==2 || n==3) {
			return true;
		}
		else if (n%6 != 1 && n%6 != 5) {
			return false;
		}
		else {
			for (int i = 5; i <= temp; i+=6) {
				if (n%i == 0 || n%(i+2) == 0) {
					return false;
				}
			}
			return true;
		}
    }
}
