//题目描述
//大家应该都会玩“锤子剪刀布”的游戏：
//
//现给出两人的交锋记录，请统计双方的胜、平、负次数，并且给出双方分别出什么手势的胜算最大。
//
//输入描述:
//输入第1行给出正整数N（<=105），即双方交锋的次数。随后N行，每行给出一次交锋的信息，即甲、乙双方同时给出的的手势。C代表“锤子”、J代表“剪刀”、B代
//
//表“布”，第1个字母代表甲方，第2个代表乙方，中间有1个空格。
//
//
//输出描述:
//输出第1、2行分别给出甲、乙的胜、平、负次数，数字间以1个空格分隔。第3行给出两个字母，分别代表甲、乙获胜次数最多的手势，中间有1个空格。如果解不唯
//
//一，则输出按字母序最小的解。
//
//输入例子:
//10
//
//C J
//
//J B
//
//C B
//
//B B
//
//B C
//
//C C
//
//C B
//
//J B
//
//B C
//
//J J
//
//输出例子:
//5 3 2
//
//2 3 5
//
//B B


package basic.basic_1008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(bf.readLine());
		
		int[][] result = new int[2][3];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				result[i][j] = 0;
			}
		}
		for (int i = 0; i < n; i++) {
//			bf.readLine();
			String str = bf.readLine();
			result = judge(str, result);
		}

		int jiaWin =  result[0][0] + result[0][1] + result[0][2];
		int yiWin = result[1][0] + result[1][1] + result[1][2];
		System.out.println(jiaWin + " " + (n - jiaWin - yiWin) + " " + yiWin);
		System.out.println(yiWin + " " + (n - jiaWin - yiWin) + " " + jiaWin);
		
		if (result[0][0] >= result[0][1] && result[0][0] >= result[0][2]) {
			System.out.print("B ");
		}
		else if (result[0][1] >= result[0][2]) {
			System.out.print("C ");
		}
		else {
			System.out.println("J ");
		}
		if (result[1][0] >= result[1][1] && result[1][0] >= result[1][2]) {
			System.out.print("B");
		}
		else if (result[1][1] >= result[1][2]) {
			System.out.print("C");
		}
		else {
			System.out.println("J");
		}
		
	}
	
	/**
	 * 根据某行输入判断该行下的输赢
	 * @param value
	 * @param result
	 * @return
	 */
	public static int[][] judge(String value, int[][] result) {
		int[][] res = result;
		
		String[] temp = value.split(" ");
		String jia = temp[0];
		String yi = temp[1];
		
		if (jia.equals("B")) {
			if (yi.equals("C")) {
				res[0][0]++;
			}
			else if (yi.equals("J")) {
				res[1][2]++;
			}
		}
		else if(jia.equals("C")) {
			if (yi.equals("B")) {
				res[1][0]++;
			}
			else if (yi.equals("J")) {
				res[0][1]++;
			}
		}
		else if (jia.equals("J")) {
			if (yi.equals("B")) {
				res[0][2]++;
			}
			else if (yi.equals("C")) {
				res[1][1]++;
			}
		}
		
		return res;
	}

}
