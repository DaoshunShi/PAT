//题目描述
//给定任一个各位数字不完全相同的4位正整数，如果我们先把4个数字按非递增排序，再按非递减排序，然后用第1个数字减第2个数字，将得到
// 一个新的数字。一直重复这样做，我们很快会停在有“数字黑洞”之称的6174，这个神奇的数字也叫Kaprekar常数。
// 
// 例如，我们从6767开始，将得到
// 
// 7766 - 6677 = 1089
// 9810 - 0189 = 9621
// 9621 - 1269 = 8352
// 8532 - 2358 = 6174
// 7641 - 1467 = 6174
// ... ...
// 
// 现给定任意4位正整数，请编写程序演示到达黑洞的过程。
//
//输入描述:
//输入给出一个(0, 10000)区间内的正整数N。
//
//
//输出描述:
//如果N的4位数字全相等，则在一行内输出“N - N = 0000”；否则将计算的每一步在一行内输出，直到6174作为差出现，输出格式见样例,每行中间没有空行。注意每个数字按4位数格
// 式输出。
//
//输入例子:
//6767
//
//输出例子:
//7766 - 6677 = 1089
// 9810 - 0189 = 9621
// 9621 - 1269 = 8352
// 8532 - 2358 = 6174
 

package basic.basic_1009;


//方法一(AC)
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[4];
		do {
			for(int i=0;i<4;i++){
				a[i]=n%10;
				n/=10;
			}
			Arrays.sort(a);
			int high=0,low=0;
			for(int i=0;i<4;i++){//取最大值
				high+=a[3-i]*Math.pow(10, 3-i);
			}
			for(int i=0;i<4;i++){//取最小值
				low+=a[i]*Math.pow(10, 3-i);
			}
			n=high-low;
			System.out.printf("%04d - %04d = %04d\n",high,low,n);
			if(n==0){
				return ;
			}
		} while(n!=6174);
	}
}


//方法二(AC)
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		String n = bf.readLine();
//		
//		if (n.equals("0000")) {
//			System.out.println("N - N = 0000");
//		}
//		if (n.equals("6174")) {
//			n = getNext(n);
//		}
//		while (!n.equals("6174") && !n.equals("0000")) {
//			n = getNext(n);
//		}
//		
//	}
//	
//	public static String getNext(String value) {
//		//保证获取的vale长度为4
//		while (value.length() < 4) {
//			value = "0" + value;
//		}
//		
//		//获取sor和rev
//		int[] sor = new int[value.length()];
//		int[] rev = new int[value.length()];
//		for (int i = 0; i < value.length(); i++) {
//			sor[i] = value.charAt(i) - '0';
//			rev[i] = value.charAt(i) - '0';
//		}
//
//		//冒泡排序
//		for (int i = 0; i < value.length(); i++) {
//			for (int j = i; j < value.length(); j++) {
//				if (sor[i] < sor[j]) {
//					int temp = sor[j];
//					sor[j] = sor[i];
//					sor[i] = temp;
//				}
//				if (rev[i] > rev[j]) {
//					int temp = rev[j];
//					rev[j] = rev[i];
//					rev[i] = temp;
//				}
//			}
//		}
//		
//		//计算a，b
//		int a = 0, b = 0;
//		String strA = "", strB = "", result;
//		for (int i = 0; i < 4; i++) {
//			a = a * 10 + sor[i];
//			b = b * 10 + rev[i];
//			strA = strA + sor[i];
//			strB = strB + rev[i];
//		}
//		result = (a - b) + "";
//		while (result.length() < 4) {
//			result = "0" + result;
//		}
//		System.out.println(strA + " - " + strB + " = " + result);
//		
//		return result;
//	}
//
//}
