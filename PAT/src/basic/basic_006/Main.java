package basic.basic_006;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), pa = sc.nextInt(), b = sc.nextInt(), pb = sc.nextInt();
		System.out.println(getRes(a, pa) + getRes(b, pb));
		
//		System.out.println(getRes(3862767, 6));
		
	}
	
	private static int getRes(int a, int pa) {
		String str = "";
		int result = 0;
		int count[] = new int[10];
		
		str = a + "";
		for(int i = 0; i < str.length(); i++) {
			count[Integer.valueOf(str.charAt(i) + "")]++;
		}
		
		for(int i = 0; i < count[pa]; i++) {
			result = result * 10 + pa;
		}
		return result;
		
		
	}

}
