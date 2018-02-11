//题目描述
//月饼是中国人在中秋佳节时吃的一种传统食品，不同地区有许多不同风味的月饼。现给定所有种类月饼的库存量、总售价、以及市场的最大需
//
//求量，请你计算可以获得的最大收益是多少。
//
//
//
//注意：销售时允许取出一部分库存。样例给出的情形是这样的：假如我们有3种月饼，其库存量分别为18、15、10万吨，总售价分别为75、
//
//72、45亿元。如果市场的最大需求量只有20万吨，那么我们最大收益策略应该是卖出全部15万吨第2种月饼、以及5万吨第3种月饼，获得
//
// 72 + 45/2 = 94.5（亿元）。
//
//输入描述:
//每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N表示月饼的种类数、以及不超过500（以万吨为单位）的正整数
//
//D表示市场最大需求量。随后一行给出N个正数表示每种月饼的库存量（以万吨为单位）；最后一行给出N个正数表示每种月饼的总售价（以亿
//
//元为单位）。数字间以空格分隔。
//
//
//输出描述:
//对每组测试用例，在一行中输出最大收益，以亿元为单位并精确到小数点后2位。
//
//输入例子:
//3 20
//
//18 15 10
//
//75 72 45
//
//输出例子:
//94.50


package basic.basic_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");
		int n = Integer.valueOf(str[0]);
		int d = Integer.valueOf(str[1]);
		
		//获取value商品重量、商品总售价		price商品编号、商品单价
		str = bf.readLine().split(" ");
		int[][] value = new int[2][n];
		float[][] price = new float[2][n]; 
		for (int i = 0; i < n; i++) {
			value[0][i] = Integer.valueOf(str[i]);
		}
		str = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			value[1][i] = Integer.valueOf(str[i]);
		}
		for (int i = 0; i < n; i++) {
			price[0][i] = i;
			price[1][i] = (float)value[1][i] / (float)value[0][i];
		}
		
		//对price排序
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (price[1][i] < price[1][j]) {
					float temp = price[0][i];
					price[0][i] = price[0][j];
					price[0][j] = temp;
					temp = price[1][i];
					price[1][i] = price[1][j];
					price[1][j] = temp;
				}
			}
		}
		
		//根据单价判断是否购买
		int rest = d;
		float result = 0;
		int i = 0;
		while (rest > 0) {
			if (value[0][(int) price[0][i]] > rest) {
				result = result + rest * (float)value[1][(int) price[0][i]] / (float)value[0][(int) price[0][i]];
				rest = 0;
			}
			else {
				result = result + value[1][(int) price[0][i]];
				rest = rest - value[0][(int) price[0][i]];
			}
			i++;
		}
		
		System.out.printf("%.2f", result);
	}

}