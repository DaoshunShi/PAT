//题目描述
//根据维基百科的定义：
//
//
//
//插入排序是迭代算法，逐一获得输入数据，逐步产生有序的输出序列。每步迭代中，算法从输入序列中取出一元素，将之插入有序序列中正确
//
//的位置。如此迭代直到全部元素有序。
//
//
//
//归并排序进行如下迭代操作：首先将原始序列看成N个只包含1个元素的有序子序列，然后每次迭代归并两个相邻的有序子序列，直到最后只剩
//
//下1个有序的序列。
//
//
//
//现给定原始序列和由某排序算法产生的中间序列，请你判断该算法究竟是哪种排序算法？
//
//输入描述:
//输入在第一行给出正整数N (<=100)；随后一行给出原始序列的N个整数；最后一行给出由某排序算法产生的中间序列。这里假设排序的目标序列是升序。数字间以
//
//空格分隔。
//
//
//输出描述:
//首先在第1行中输出“Insertion Sort”表示插入排序、或“Merge Sort”表示归并排序；然后在第2行中输出用该排序算法再迭代一轮的结果序列。题目保证每组测试
//
//的结果是唯一的。数字间以空格分隔，且行末不得有多余空格。
//
//输入例子:
//10
//
//3 1 2 8 7 5 9 4 6 0
//
//1 2 3 7 8 5 9 4 6 0
//
//输出例子:
//Insertion Sort
//
//1 2 3 5 7 8 9 4 6 0


package basic.basic_1025;


//方法一(未完成)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static int[] search;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(bf.readLine());
		String[] strs1 = bf.readLine().split(" ");
		String[] strs2 = bf.readLine().split(" ");
		int[] before = new int[n];
		int[] after = new int[n];
		for (int i = 0; i < n; i++) {
			before[i] = Integer.valueOf(strs1[i]);
			after[i] = Integer.valueOf(strs2[i]);
		}
		String type = "Insertion Sort";
		int index = 0;
		for (int i = 0; i < n ; i++) {
			if (after[i] > after[i+1]) {
				index = i + 1;	//从 i+1 位置开始无序
				break;
			}
		}
		for (int i = index; i < n; i++) {
			if (before[i] != after[i]) {
				type = "Merge Sort";	//如果是插入排序，从index开始 两个数组的顺序是一样的
				break;
			}
		}
		
		if (type.equals("Insertion Sort")) {
			int num = after[index];
			for (int j  =index; j > 0; j--) {
				if (after[j] < after[j-1]) {
					after[j] = after[j - 1];
					after[j-1] = num;
				}
			}
		} 
		else {
			//如果是归并排序  index 的值表示这么多规模已经排序完，
			//比如 index == 2, 说明规模为2的已经排序完， 下一次排序规模为4
			index = 2 * index;
			for (int i = 0; i < n; i += index) {
				int next = i+index>n ? n : i+index;
				Arrays.sort(after, i, next);
			}
		}
		
		System.out.println(type);
		for (int i = 0; i < n-1; i++) {
			System.out.print(after[i] + " ");
		}
		System.out.print(after[n-1]);
		
	}
	


}


//方法二(AC)
//import java.util.Scanner;
//import java.util.Arrays;
//public class No1025 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] a = new int[n];//原始的
//        int[] b = new int[n];//部分排序过的
//        for(int i = 0;i<n;i++)
//            a[i] = in.nextInt();
//        for(int i = 0;i<n;i++)
//            b[i] = in.nextInt();
//        String type = "Insertion Sort";
//        int index = 0;
//        for(int i = 0;i<n-1;i++){
//            if(b[i]>b[i+1]){
//                index = i+1;//从i+1这里开始无序
//                break;
//            }
//        }
//        for(int i = index;i<n;i++){
//            if(a[i]!=b[i]){
//                type = "Merge Sort";//如果是插入排序，从index开两个数组的顺序是一样的
//                break;
//            }
//        }
//        if(type.equals("Insertion Sort")){
//            int num = b[index];
//            for(int j = index;j>0;j--){
//                if(b[j]<b[j-1]){
//                    b[j] = b[j-1];
//                    b[j-1] = num;
//                }
//            }
//        }else{
//            //如果是归并排序 index的值表示这么多的规模已经排序完，
//            //比如index==2 说明规模为2的已经排序完 下一次排序规模为4
//            index = 2*index;
//            for(int i = 0;i<n;i+=index){
//                int next = i+index>n?n:i+index;
//                Arrays.sort(b,i,next);
//            }
//        }
//        System.out.println(type);
//        for(int i = 0;i<n-1;i++)
//            System.out.print(b[i]+" ");
//        System.out.print(b[n-1]);
//    }
//}