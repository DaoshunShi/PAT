//小易有一个长度为N的正整数数列A = {A[1], A[2], A[3]..., A[N]}。
//牛博士给小易出了一个难题:
//对数列A进行重新排列,使数列A满足所有的A[i] * A[i + 1](1 ≤ i ≤ N - 1)都是4的倍数。
//小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。 
//输入描述:
//输入的第一行为数列的个数t(1 ≤ t ≤ 10),
//接下来每两行描述一个数列A,第一行为数列长度n(1 ≤ n ≤ 10^5)
//第二行为n个正整数A[i](1 ≤ A[i] ≤ 10^9)
//
//
//输出描述:
//对于每个数列输出一行表示是否可以满足牛博士要求,如果可以输出Yes,否则输出No。
//
//输入例子1:
//2
//3
//1 10 100
//4
//1 2 3 4

//输出例子1:
//Yes
//No


package exam.nowcoder.interview.wangyi_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	//当4的倍数  >= 奇数的数量时，能成立，否则不成立
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(bf.readLine());
		String[] result = new String[t];
		
		for (int i = 0; i < t; i++) {
			int len = Integer.valueOf(bf.readLine());
			String[] strs = bf.readLine().split(" ");
			int[] nums = new int[len];	//记录当前数列
			int jishu = 0, sibeishu = 0;	//记录奇数与4的倍数的个数
			
			//记录奇数与4的倍数的个数
			for (int j = 0; j < len; j++) {
				nums[j] = Integer.valueOf(strs[j]);
				if (nums[j] % 2 != 0) {
					jishu++;
				}
				else if (nums[j] % 4 == 0) {
					sibeishu++;
				}
			}
			if (sibeishu >= jishu) {
				result[i] = "Yes";
			}
			else {
				result[i] = "No";
			}
		}
		
		//输出结果
		for (int i = 0; i < t; i++) {
			System.out.println(result[i]);
		}
	}

}
