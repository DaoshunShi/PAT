//题目描述
//本题要求你写个程序把给定的符号打印成沙漏的形状。例如给定17个“*”，要求按下列格式打印
// 
// *****
//  ***
//   *
//  ***
// *****
// 所谓“沙漏形状”，是指每行输出奇数个符号；各行符号中心对齐；相邻两行符号数差2；符号数先从大到小顺序递减到1，再从小到大顺序递
// 增；首尾符号数相等。
// 
// 给定任意N个符号，不一定能正好组成一个沙漏。要求打印出的沙漏能用掉尽可能多的符号。
//
//输入描述:
//输入在一行给出1个正整数N（<=1000）和一个符号，中间以空格分隔。
//
//
//输出描述:
//首先打印出由给定符号组成的最大的沙漏形状，最后在一行中输出剩下没用掉的符号数。
//
//输入例子:
//19 *
//
//输出例子:
//*****
//
// ***
//
// *
//
// ***
//
//*****
//
//2


package basic.basic_1017;



//方法一(AC)
//*****
//***
//*
//***
//*****
//
//* : abs((l-1) - 2*i) + 1
//_ : l - ((l-1) - 2*i + 1)
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		String[] str = bf.readLine().split(" ");
//		int n = Integer.valueOf(str[0]);
//		int l = 1, count = 1;	//l记录行数，count记录*数
//		
//		
//		
//		
//		if (n == 1) {
//			System.out.println(str[1]);
//			System.out.println("0");
//		}
//		else {
//			l = l + 2;
//			while (count + 2 * l <= n) {
//				count = count + 2 * l;
//				l = l + 2;
//			}
//			l = l - 2;
//			
//			for (int i = 0; i < l; i++ ) {
//				String tempStr = "";
//				for (int j = (l - (Math.abs((l-1) - 2*i) + 1)) / 2; j > 0; j--) {
//					tempStr = " " + tempStr;
//				}
//				for (int j = Math.abs((l-1) - 2*i) + 1; j > 0; j--) {
//					tempStr = tempStr + str[1];
//				}
////				for (int j = (l - (Math.abs((l-1) - 2*i) + 1)) / 2; j > 0; j--) {
////					System.out.print(" ");
////					tempStr = tempStr + " ";
////				}
//				System.out.println(tempStr);
//			}
//			
//			System.out.print(n - count);
//		}		
//	}
//}


//方法二(AC)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
 
public class Main{
    @SuppressWarnings("unchecked")
    public static void main(String args[]) throws IOException{
        //input
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        bf.close();
        int n = Integer.parseInt(input[0]);    
        String c = input[1];
         
        int ln = (int) Math.sqrt((float)(n+1)/2);
        int line = 2 * ln - 1;
        int pnum = (ln - 1) * 2 + 1;
         
        for(int i = 1; i <= ln; i++){
            System.out.println(Printstr(line, pnum, c));
            pnum -= 2;         
        }
        pnum = 1;
        for(int i = ln+1; i <= line; i++){
            pnum += 2;
            System.out.println(Printstr(line, pnum, c));
        }
        System.out.println(n - (ln*ln*2-1));
    }
    public static String Printstr(int total, int pn, String c){
        int blank = (total-pn)/2;
        StringBuilder res = new StringBuilder();
        for(int i = 1; i <= blank; i++){
            res.append(" ");
        }
        for(int i = 1; i <= pn; i++){
            res.append(c);
        }
        return res.toString();
    }
}