//题目描述
//本题要求读入N名学生的成绩，将获得某一给定分数的学生人数输出。
//
//输入描述:
//输入在第1行给出不超过105的正整数N，即学生总人数。随后1行给出N名学生的百分制整数成绩，中间以空格分隔。最后1行给出要查询的分
//
//数个数K（不超过N的正整数），随后是K个分数，中间以空格分隔。
//
//
//输出描述:
//在一行中按查询顺序给出得分等于指定分数的学生人数，中间以空格分隔，但行末不得有多余空格。
//
//输入例子:
//10
//60 75 90 55 75 99 82 90 75 50
//3 75 90 88
//
//输出例子:
//3 2 0


package basic.basic_1028;

//方法一(AC)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.valueOf(bf.readLine());
//		String[] strs = bf.readLine().split(" ");
//		String[] search = bf.readLine().split(" ");
//		
//		int[] nums = new int[n];
//		int searchLen = Integer.valueOf(search[0]);
//		int[] searchInt = new int[searchLen];
//		for (int i = 0; i < n; i++) {
//			nums[i] = Integer.valueOf(strs[i]);
//		}
//		for (int i = 0; i < searchLen; i++) {
//			searchInt[i] = Integer.valueOf(search[i+1]);
//		}
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		int searchLen = sc.nextInt();
		int[] searchInt = new int[searchLen];
		for (int i = 0; i < searchLen; i++) {
			searchInt[i] = sc.nextInt();
		}
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			if (map.containsKey(nums[i])) {
				int value = map.get(nums[i]);
				map.put(nums[i], value+1);
			}
			else {
				map.put(nums[i], 1);
			}
		}
		
		String result = "";
		for (int i = 0; i < searchLen; i++) {
			if (map.containsKey(searchInt[i])) {
//				System.out.print(map.get(searchInt[i]) + " ");
				result = result + map.get(searchInt[i]) + " ";
			}
			else {
//				System.out.print("0 ");
				result = result + "0 ";
			}
		}
		result = result.substring(0, result.length()-1);
		System.out.println(result);
				
	}

}
