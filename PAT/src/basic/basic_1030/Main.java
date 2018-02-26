//题目描述
//字符串APPAPT中包含了两个单词“PAT”，其中第一个PAT是第2位(P),第4位(A),第6位(T)；第二个PAT是第3位(P),第4位(A),第6位(T)。
//
//
//
//现给定字符串，问一共可以形成多少个PAT？
//
//输入描述:
//输入只有一行，包含一个字符串，长度不超过105，只包含P、A、T三种字母。
//
//
//输出描述:
//在一行中输出给定字符串中包含多少个PAT。由于结果可能比较大，只输出对1000000007取余数的结果。
//
//输入例子:
//APPAPT
//
//输出例子:
//2


package basic.basic_1030;


//方法一(思路错误)
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//
//public class Main {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
////		String str = bf.readLine();
//		String str = "APTTPAPTAPTP";
//		
//		String[] strs = str.split("T");
//		int[] value = new int[str.length()];	//记录对应“PAT”的个数
//		for (int i = 0; i < strs.length - 1; i++) {
//			strs[i] = strs[i] + "T";
//		}
//		
//		int index = 0;
//		int total = 0;
//		for (int i = 0; i < strs.length; i++) {
//			
//			
////			total = total + c;
//			if (strs[i].length() >= 3) {
//				int c = count(strs[i]);
//				total = total * 2 + c;
//			}
//			else {
////				total = 2 * 
//			}
//			
//			for (int m = index; m < index + strs[i].length(); m++) {
//				value[m] = total;
//			}
//			
//			index = index + strs[i].length();
//		}
//		
//		System.out.println(count("APPAPT"));
//	}
//	
//	private static int count (String str) {
//		int i = 0;
//		int count = 0;
////		for (;i != -1; i = str.indexOf("P", i+1)) {
////			for (int j = str.indexOf("A", i); j!= -1; j = str.indexOf("A", j)) {
////				String temp = str.substring(i, i+1) + str.substring(j, j+1) + "T";
////				if (temp.equals("PAT")) {
////					count++;
////				}
////			}
////		}
//		
//		for (i = 0; i < str.length()-2; i++) {
//			for (int j = i+1; j < str.length()-1; j++) {
//				String temp = str.substring(i, i+1) + str.substring(j, j+1) + "T";
//				if (temp.equals("PAT")) {
//					count++;
//				}
//			}
//		}
//		
//		return count;
//	}
//	
//	
//
//}


//方法二
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String S=bufferedReader.readLine();
        bufferedReader.close();
        int mod=1000000007;
        int t=0;
        int pat=0;
        int at=0;
        for (int i = S.length()-1; i >=0 ; i--) {
            char ch=S.charAt(i);
            if (ch=='T') {
                t++;
            }
            if (ch=='A') {
                at=(at+t)%mod;
            }
            if (ch=='P') {
                pat=(pat+at)%mod;
            }
        }
         
        System.out.println(pat);
    }
     
 
}