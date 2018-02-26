//题目描述
//小红想买些珠子做一串自己喜欢的珠串。卖珠子的摊主有很多串五颜六色的珠串，但是不肯把任何一串拆散了卖。于是小红要你帮忙判断一
//
//下，某串珠子里是否包含了全部自己想要的珠子？如果是，那么告诉她有多少多余的珠子；如果不是，那么告诉她缺了多少珠子。
//
//
//
//为方便起见，我们用[0-9]、[a-z]、[A-Z]范围内的字符来表示颜色。例如，YrR8RrY是小红想做的珠串；那么ppRYYGrrYBR2258可以买，因为包含了
//
//全部她想要的珠子，还多了8颗不需要的珠子；ppRYYGrrYB225不能买，因为没有黑色珠子，并且少了一颗红色的珠子。
//
//输入描述:
//每个输入包含1个测试用例。每个测试用例分别在2行中先后给出摊主的珠串和小红想做的珠串，两串都不超过1000个珠子。
//
//
//输出描述:
//如果可以买，则在一行中输出“Yes”以及有多少多余的珠子；如果不可以买，则在一行中输出“No”以及缺了多少珠子。其间以1个空格分隔。
//
//输入例子:
//ppRYYGrrYBR2258
//YrR8RrY
//ppRYYGrrYB225
//YrR8RrY
//
//输出例子:
//Yes 8


package basic.basic_1029;


//方法一(AC)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str0 = bf.readLine().split("");
		String[] str1 = bf.readLine().split("");
		
		//先将现有珠子及数量存入 map，
		//再根据目前 map 存入所需珠子及数量修改 map
		//最终 map 为珠子及其对应的数量：若大于0， 则多余；若小于0，则缺少
		HashMap<String, Integer> map = new HashMap<String, Integer> ();
		for (int i = 0; i < str0.length; i++) {
			if (map.containsKey(str0[i])) {
				map.put(str0[i], map.get(str0[i])+1);
			}
			else {
				map.put(str0[i], 1);
			}
		}
		for (int i = 0; i < str1.length; i++) {
			if (map.containsKey(str1[i]) ) {
				map.put(str1[i], map.get(str1[i])-1);
			}
			else {
				map.put(str1[i], -1);
			}
		}
		
		String result = "Yes";
		Iterator iter = map.keySet().iterator();
		int more = 0, less = 0;
		while (iter.hasNext()) {
			String key = (String) iter.next();
//			System.out.println(key + " " + map.get(key));
			int value = map.get(key);
			if (value >= 0) {
				more += value;
			}
			else {
				less += value;
				result = "No";
			}
		}
		
		System.out.println(result + " " + (result.equals("Yes") ? more : -1 * less)); 
		
	}
	
	

}
