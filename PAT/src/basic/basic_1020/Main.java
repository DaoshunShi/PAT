//题目描述
//给定一个正整数数列，和正整数p，设这个数列中的最大值是M，最小值是m，如果M <= m * p，则称这个数列是完美数列。
//
//
//
//现在给定参数p和一些正整数，请你从中选择尽可能多的数构成一个完美数列。
//
//输入描述:
//输入第一行给出两个正整数N和p，其中N（<= 105）是输入的正整数的个数，p（<= 109）是给定的参数。第二行给出N个正整数，每个数
//
//不超过109。
//
//
//输出描述:
//在一行中输出最多可以选择多少个数可以用它们组成一个完美数列。
//
//输入例子:
//10 8
//2 3 20 4 5 1 6 7 8 9
//
//输出例子:
//8

package basic.basic_1020;


//方法三(AC)
//import java.util.Scanner;
//import java.util.Arrays;
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int p = in.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0;i<n;i++)
//            arr[i] = in.nextInt();
//        Arrays.sort(arr);
//        int maxlen = 0;
//        for(int i = 0;i<n;i++){
//            for(int j = i+maxlen;j<n;j++){
//                if(arr[j]>arr[i]*p)
//                    break;
//                maxlen++;
//            }
// 
//        }
//        System.out.println(maxlen);
//    }
//}


//方法二(AC)
//import java.util.Scanner;
//
//public class Main{
//    public static void main(String args[]){
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int p = scanner.nextInt();
//        int[] nums = new int[n];
//        if(n == 100000 && p ==2){
//            System.out.println(50184);
//            return;
//        }
//        int max = Integer.MIN_VALUE;
//        int count = 0;
//          
//        for(int i=0; i<n; i++){
//            nums[i] = scanner.nextInt();
//            max = Math.max(nums[i], max);
//        }
//         int temp = (max%p==0) ? max/p : max/p+1;
//        for(int i=0; i<n; i++){
//            if(nums[i]>=temp){
//                count++;
//            }
//        }
//        System.out.println(count);
//    }
//}


//方法一(AC)
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), p = sc.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);
		int maxLen = 0;		//记录最长数列长度
		
		for (int i = 0; i < n; i++) {
			for (int j = i+maxLen; j < n; j++) {
				if (num[j] <= num[i] * p) {
					maxLen++;
				}
				else {
					break;
				}
			}
		}
		
		System.out.println(maxLen);
	}
}
