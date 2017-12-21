package basic.basic_005;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		int[][] num = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
////		swap(num, 0, 2);
//		for (int i = 0; i < num.length; i++) {
//			for (int j = 0; j < num[i].length; j++) {
//				System.out.print(num[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), l = sc.nextInt(), h = sc.nextInt();
		int[][] all = new int[n][5];
		int len = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				all[i][j] = sc.nextInt();
			}
			all[i][3] = all[i][1] + all[i][2];
			int kind = getKind(all[i], h, l);
			all[i][4] = kind;
			if (kind > 0) {
				len++;
			}
		}
		
		all = sort(all);
		System.out.println(len);
		for (int i = n - len; i < n; i++) {
			System.out.println(all[i][0] + " " + all[i][1] + " " + all[i][2] + " " + all[i][3] + " " + all[i][4]);
		}
		
		
	}
	
	
	
	public static int[][] sort(int[][] num) {
		int matrix[][] = num;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix.length; j++) {
				
				if (matrix[i][4] > matrix[j][4] ) {
					swap(matrix, i, j);
				}
				else if (matrix[i][4] == matrix[j][4]) {
					if (matrix[i][3] < matrix[j][3]) {	//i总分低于j总分
						swap(matrix, i, j);
					}
					else if (matrix[i][3] == matrix[j][3]) {	//i总分等于j总分
						if (matrix[i][1] < matrix[j][1]) {	//i德分小于j德分
							swap(matrix, i, j);
						}
						else if (matrix[i][1] == matrix[j][1]) {	//i编号大于j编号
							if (matrix[i][0] > matrix[j][0]) {
								swap(matrix, i, j);
							}
						}
					}
					else {	//i总分高于j总分
						
					}
				}
				
//5 60 80
//1011 85 80
//1002 80 85
//1003 85 80
//1004 80 85
//1004 85 80
			}
		}
		return matrix;
	}
	
	private static void swap (int[][] num, int i, int j) {
		int[] temp = num[j];
		num[j] = num[i];
		num[i] = temp;
	}
	
	public static int getKind(int[] num, int h, int l) {
		if(num[1] >= h) {
			if(num[2] >= h) {	
				return 1;	//德才全尽	一
			}
			else if(num[2] >= l) {
				return 2;	//德胜才		二
			}
			else {
				return 0;	//不取
			}
		}
		else if (num[1] >= l) {
			if (num[2] >= l) {
				if(num[1] >= num[2]) {
					return 3;	//德才兼亡、德胜才	三
				}
				else {
					return 4;	//其他录取		四
				}
			}
			else {
				return 0;	//不取
			}
		}
		else {
			return 0;	//不取
		}
		
	}

}
