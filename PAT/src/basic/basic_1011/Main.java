//题目描述
//给定一个k位整数N = dk-1*10k-1 + ... + d1*101 + d0 (0<=di<=9, i=0,...,k-1, dk-1>0)，请编写程序统计每种不同的个位数字出现的次数。例如：给定N = 100311，则有2个0，3个1，和1个3。
//
//输入描述:
//每个输入包含1个测试用例，即一个不超过1000位的正整数N。
//
//
//输出描述:
//对N中每一种不同的个位数字，以D:M的格式在一行中输出该位数字D及其在N中出现的次数M。要求按D的升序输出。
//
//输入例子:
//100311
//
//输出例子:
//0:2
//
//1:3
//
//3:1


package basic.basic_1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String n = bf.readLine();
		String[] str = n.split("");
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < str.length; i++) {
			int key = Integer.valueOf(str[i]);
			if (map.containsKey(key))	{
				int temp = map.get(key);
				map.put(key, temp+1);
			}
			else {
				map.put(key, 1);
			}
		}
		
		//遍历输出HashMap
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			System.out.println(key + ":" + value);
		}
	}

}
