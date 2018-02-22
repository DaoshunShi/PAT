//题目描述
//旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及坏掉的那些键，打出的结果文
//
//字会是怎样？
//
//输入描述:
//输入在2行中分别给出坏掉的那些键、以及应该输入的文字。其中对应英文字母的坏键以大写给出；每段文字是不超过10^5个字符的串。可用的
//
//字符包括字母[a-z, A-Z]、数字0-9、以及下划线“_”（代表空格）、“,”、“.”、“-”、“+”（代表上档键）。题目保证第2行输入的文字串非空。
//
//
//
//注意：如果上档键坏掉了，那么大写的英文字母无法被打出。
//
//
//输出描述:
//在一行中输出能够被打出的结果文字。如果没有一个字符能被打出，则输出空行。
//
//输入例子:
//7+IE.
//7_This_is_a_test.
//
//输出例子:
//_hs_s_a_tst


package basic.basic_1023;

//方法一(AC)
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//
//public class Main {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		String broken = bf.readLine();
//		String origin = bf.readLine();
//		HashMap<String, Integer> map = new HashMap<String, Integer>();
//		
//		for (int i = 0; i < broken.length(); i++) {
//			String tempStr = broken.charAt(i) + "";
//			if (tempStr.equals("+")) {
//				for (int j = 0; j < 26; j++) {
//					char tempChar = (char) ('A' + j);
//					map.put(tempChar + "", 1);
//				}
//			}
//			else {
//				map.put(tempStr.toUpperCase(), 1);
//				map.put(tempStr.toLowerCase(), 1);
//			}
//		}
//		
//		for (int i = 0; i < origin.length(); i++) {
//			String tempStr = origin.charAt(i) + "";
//			if (map.containsKey(tempStr)) {
//				
//			}
//			else {
//				System.out.print(tempStr);
//			}
//		}

//		System.out.println();
//	}
//}

//方法二(AC)
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String brokenStr = sc.next();
        String oldStr = sc.next();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < oldStr.length(); i++) {
            if (canShow(brokenStr, oldStr.charAt(i))) {
                char ch= oldStr.charAt(i);
                    sb.append(ch);
                    count++;
            }
        }
        if (count == 0){
            System.out.println();
        }
        else{
            System.out.print(sb.toString());
        }
 
    }
 
    public static boolean canShow(String brokenStr, char ch) {
        if (brokenStr.indexOf(Character.toUpperCase(ch)) >= 0 || brokenStr.indexOf(Character.toLowerCase(ch)) >= 0) {
            return false;
        }
        if (brokenStr.indexOf('+') >= 0 && ch - 'A' >= 0 && ch - 'A' <= 25) {
            return false;
        }
        return true;
    }
}
