//题目描述
//如果你是哈利·波特迷，你会知道魔法世界有它自己的货币系统 —— 就如海格告诉哈利的：“十七个银西可(Sickle)兑一个加隆(Galleon)，二
//
//十九个纳特(Knut)兑一个西可，很容易。”现在，给定哈利应付的价钱P和他实付的钱A，你的任务是写一个程序来计算他应该被找的零钱。
//
//输入描述:
//输入在1行中分别给出P和A，格式为“Galleon.Sickle.Knut”，其间用1个空格分隔。这里Galleon是[0, 107]]区间内的整数，Sickle是[0, 
//
//17)区间内的整数，Knut是[0, 29)区间内的整数。
//
//
//输出描述:
//在一行中用与输入同样的格式输出哈利应该被找的零钱。如果他没带够钱，那么输出的应该是负数。
//
//输入例子:
//10.16.27 14.1.28
//14.1.28 10.16.27
//
//输出例子:
//3.2.1
//-3.2.1


package basic.basic_1027;



//方法一(AC)
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		String[] strs = bf.readLine().split(" ");
//		String[] strs0 = strs[0].split("\\.");
//		String[] strs1 = strs[1].split("\\.");
//		int[][] value = new int[2][3];
//		for (int i = 0; i < 3; i++) {
//			value[0][i] = Integer.valueOf(strs0[i]);
//			value[1][i] = Integer.valueOf(strs1[i]);
//		}
//		
//		int[] result = new int[3];
//		for (int i = 2; i >= 0; i--) {
//			result[i] = value[1][i] - value[0][i];
//		}
//		
//		if (result[0] < 0) {
//			while (result[2] > 0) {
//				result[1]++;
//				result[2] = result[2] - 29;
//			}
//			result[2] = result[2] * -1;
//			while (result[1] > 0) {
//				result[0]++;
//				result[1] = result[1] - 17;
//			}
//			result[1] = result[1] * -1;
//		}
//		else {
//			while (result[2] < 0) {
//				result[1]--;
//				result[2] = result[2] + 29;
//			}
//			while (result[1] < 0) {
//				result[0]--;
//				result[1] = result[1] + 17;
//			}
//		}
//		System.out.println(result[0] + "." + result[1] + "." + result[2]);
//	}
//}


//方法二(AC)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = bf.readLine().split(" ");
		String[] strs0 = strs[0].split("\\.");
		String[] strs1 = strs[1].split("\\.");
		int[][] value = new int[2][3];
		for (int i = 0; i < 3; i++) {
			value[0][i] = Integer.valueOf(strs0[i]);
			value[1][i] = Integer.valueOf(strs1[i]);
		}
		
		long[] result = new long[3];
		long[] v = new long[2];
	    v[0] = value[0][0] * 17 * 29 + value[0][1] * 29 + value[0][2];
	    v[1] = value[1][0] * 17 * 29 + value[1][1] * 29 + value[1][2];
	    result[2] = v[1] - v[0];
	    if (result[2] >= 0) {
	    	result[1] = result[2] / 29;
	    	result[2] = result[2] % 29;
	    	result[0] = result[1] / 17;
	    	result[1] = result[1] % 17;
	    }
	    else {
	    	result[1] = result[2] / 29;
	    	result[2] = result[2] % 29;
	    	result[2] = result[2] * -1;
	    	result[0] = result[1] / 17;
	    	result[1] = result[1] % 17;
	    	result[1] = result[1] * -1;
	    }
		
		System.out.println(result[0] + "." + result[1] + "." + result[2]);
	}

}
