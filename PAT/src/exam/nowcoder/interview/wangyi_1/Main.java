//小易准备去魔法王国采购魔法神器,购买魔法神器需要使用魔法币,但是小易现在一枚魔法币都没有,但是小易有两台魔法机器可以通过投入x(x可以为0)个魔法币产生更多的魔法币。
//魔法机器1:如果投入x个魔法币,魔法机器会将其变为2x+1个魔法币
//魔法机器2:如果投入x个魔法币,魔法机器会将其变为2x+2个魔法币
//小易采购魔法神器总共需要n个魔法币,所以小易只能通过两台魔法机器产生恰好n个魔法币,小易需要你帮他设计一个投入方案使他最后恰好拥有n个魔法币。 
//输入描述:
//输入包括一行,包括一个正整数n(1 ≤ n ≤ 10^9),表示小易需要的魔法币数量。
//
//
//输出描述:
//输出一个字符串,每个字符表示该次小易选取投入的魔法机器。其中只包含字符'1'和'2'。
//
//输入例子1:
//10
//
//输出例子1:
//122


package exam.nowcoder.interview.wangyi_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(getBefore(n));
	}
	
	private static String getBefore(int a) {
		int bef = 0;
		String res = "";
		if (a <= 0) {
			return "";
		}
		if (a % 2 == 1) {
			bef = (a - 1) / 2;
			res = getBefore(bef) + "1";
		}
		else {
			bef = (a - 2) / 2;
			res = getBefore(bef) + "2";
		}
		return res;
		
	}

}
