package exam.nowcoder.interview.test_3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt(), s = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}
		Arrays.sort(p);
		
		int sum = 0;
		int cornNum = 0;
		
		while (sum < s) {
			sum = sum + p[cornNum];
			cornNum++;
		}
		if (sum == s) {
			
		}
		else {
			int max = -1;
			for (int i = 0; i < cornNum; i++) {
				if ((p[i] <= sum - s) && (p[i] > max)) {
					max = i;
				}
			}
			if (sum - max >= s) {
				cornNum--;
			}
		}
		
		System.out.println(cornNum);
	}

}

//5 9
//4 1 3 5 4