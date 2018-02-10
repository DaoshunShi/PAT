package test.sort;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num = {1, 34, 52, 0, -4, 2, 91, 234} ;
		
		getArraysSort(num);
	}
	
	private static void getArraysSort(int[] num) {
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
			
		}
			
	}

}
