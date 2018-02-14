//题目描述
//给定数字0-9各若干个。你可以以任意顺序排列这些数字，但必须全部使用。目标是使得最后得到的数尽可能小（注意0不能做首位）。例如：
//
//给定两个0，两个1，三个5，一个8，我们得到的最小的数就是10015558。
//
//
//
//现给定数字，请编写程序输出能够组成的最小的数。
//
//输入描述:
//每个输入包含1个测试用例。每个测试用例在一行中给出10个非负整数，顺序表示我们拥有数字0、数字1、……数字9的个数。整数间用一个空
//
//格分隔。10个数字的总个数不超过50，且至少拥有1个非0的数字。
//
//
//输出描述:
//在一行中输出能够组成的最小的数。
//
//输入例子:
//2 2 0 0 0 3 0 0 1 0
//
//输出例子:
//10015558


package basic.basic_1013;

//方法一
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		String[] str = bf.readLine().split(" ");
//		int[] num = new int[str.length];
//		String result = "";
//		
//		for (int i = 0; i < str.length; i++) {
//			num[i] = Integer.valueOf(str[i]);
//		}
//		//输出第一位
//		if (num[0] != 0) {
//			int i = 1;
//			while (num[i] == 0) {
//				i++;
//			}
//			num[i]--;
//			System.out.print(i);
//		}
//		//输出数字
//		for (int i = 0; i < str.length; i++) {
//			while (num[i] > 0) {
//				System.out.print(i);
//				num[i]--;
//			}
//		}
//	}
//
//}

//方法二
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String[] b=bf.readLine().trim().split(" ");
        int []a=new int [b.length];
        int count=0;
        int zero=Integer.parseInt(b[0]);
        for(int i=1,j=a.length;i<j;i++) {
            a[i]=Integer.parseInt(b[i]);
            if(a[i]!=0) {
                  
                for(int c=0;c<a[i];c++) {
                    System.out.print(i);
                    count++;
                    if(zero!=0&&count==1) {
                        for(int d=0;d<zero;d++) {
                            System.out.print("0");
                        }
                    }
                }
            }
        }
    }
}
