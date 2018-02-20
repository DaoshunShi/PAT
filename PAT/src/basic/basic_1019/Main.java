//题目描述
//旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及实际被输入的文字，请你列出
//
//肯定坏掉的那些键。
//
//输入描述:
//输入在2行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过80个字符的串，由字母A-Z（包括大、小写）、数字0-9、
//
//以及下划线“_”（代表空格）组成。题目保证2个字符串均非空。
//
//
//输出描述:
//按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次。题目保证至少有1个坏键。
//
//输入例子:
//7_This_is_a_test
//_hs_s_a_es
//
//输出例子:
//7TI


package basic.basic_1019;


//方法一(AC)
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.Iterator;
//
//public class Main {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		String str1 = bf.readLine();
//		String str2 = bf.readLine();
//		HashMap<String, Integer> map = new HashMap<String, Integer> ();
//		
//
//
//		for (int i = 0; i < str2.length(); i++) {
//			String tempStr = str2.charAt(i) + "";
//			tempStr = tempStr.toUpperCase();
//			map.put(tempStr, 1);
//		}
//		
//		for (int i = 0; i < str1.length(); i++) {
//			String tempStr = str1.charAt(i) + "";
//			tempStr = tempStr.toUpperCase();
//			if (!map.containsKey(tempStr)) {	//记录各字符是否出现
//				map.put(tempStr, 1);
//				System.out.print(tempStr);
//			}
//		}
//
//	}
//}


//方法二
import java.io.*;
import java.util.*;
  
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
  
        String str1 = bd.readLine();
        String str2 = bd.readLine();
  
        Set<Character> characters = solve(str1,str2);
  
        for(Character character : characters){
            out.print(character);
        }
  
        out.print("\n");
        out.close();
    }
  
    public static Set<Character> solve(String str1,String str2){
        Set<Character> characters = new LinkedHashSet<>();
        int i = 0;
        int j = 0;
        for (i = 0; i < str2.length(); i++) {
            while (j < str1.length() && str1.charAt(j) != str2.charAt(i)){
                characters.add(Character.toUpperCase(str1.charAt(j)));
                j++;
            }
            j++;
        }
        while (j < str1.length()){
            characters.add(Character.toUpperCase(str1.charAt(j)));
            j++;
        }
        return characters;
    }
}