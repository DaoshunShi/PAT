//题目描述
//一个合法的身份证号码由17位地区、日期编号和顺序编号加1位校验码组成。校验码的计算规则如下：
//
//
//
//首先对前17位数字加权求和,权重分配为：{7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2}；然后将计算的和对11取模得
//
//到值Z；最后按照以下关系对应Z值与校验码M的值：
//
//
//
//Z：0 1 2 3 4 5 6 7 8 9 10
//
//M：1 0 X 9 8 7 6 5 4 3 2
//
//
//
//现在给定一些身份证号码,请你验证校验码的有效性,并输出有问题的号码。
//
//输入描述:
//输入第一行给出正整数N（<= 100）是输入的身份证号码的个数。随后N行,每行给出1个18位身份证号码。
//
//
//输出描述:
//按照输入的顺序每行输出1个有问题的身份证号码。这里并不检验前17位是否合理,只检查前17位是否全为数字且最后1位校验码计算准确。如果所有号码都正常,
//
//则输出“All passed”。
//
//输入例子:
//4
//
//320124198808240056
//
//12010X198901011234
//
//110108196711301866
//
//37070419881216001X
//
//输出例子:
//12010X198901011234
//
//110108196711301866
//
//37070419881216001X


package basic.basic_1021;


//方法一(AC)
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.regex.Pattern;
//
//public class Main {
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
////		boolean result = judge("320124198808240056");
////		boolean result2 = judge("12010X198901011234");
////		
////		boolean result3 = judge("110108196711301866");
////		boolean result4 = judge("37070419881216001X");
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.valueOf(bf.readLine());
//		boolean printed = false;
//		for (int i = 0; i < n; i++) {
//			String str = bf.readLine();
//			boolean res = judge(str);
//			if (!res) {
//				System.out.println(str);
//				printed = true;
//			}
//		}
//		if (!printed ) {
//			System.out.println("All passed");
//		}
//	}
//	
//	/**
//	 * 判断字符串 str 若为字符串，前17位是否合理
//	 * @param str
//	 * @return
//	 */
//	private static boolean judge(String str) {
//		//用正则表达式判断前17位是否全为数字
//		String pattern = "^(\\d{17})([0-9]|X)$";
//		if (!Pattern.matches(pattern, str)) {
//			return false;
//		}
//		
//		String[] value = str.split("");
//		int z = 0;	//记录加权求和 并对11 取模的值
//		int[] num = new int[17];	//记录原数值
//		int[] times = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};	//记录权重分配
//		String[] zTom = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};	//记录z对应校验码M的值
//		
//		for (int i = 0; i < 17; i++) {
//			num[i] = Integer.valueOf(value[i] + "");
//			z = (z + num[i] * times[i]) % 11;
//		}
//		
//		if (zTom[z].equals(value[17] + "")) {
//			return true;
//		}
//		else {
//			return false;
//		}
//		
//	}
//
//}


//方法二
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N_str = br.readLine();
        int N = Integer.parseInt(N_str);
        boolean isAllPassed = true;
        String[] str = new String[N];
        for (int i = 0; i < N; i ++) {
            str[i] = br.readLine();
        }
        for (int i = 0; i < N; i ++) {
            if (!checkM(str[i])) {
                isAllPassed = false;
                System.out.println(str[i]);
            }
        }
 
        if (isAllPassed) {
            System.out.println("All passed");
        }
             
    }
     
    public static boolean checkM(String str) {
        int[] w = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        char[] m = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        int z = 0;
        for (int i = 0; i < str.length() - 1; i ++) {
            z += w[i] * (str.charAt(i) - '0');
        }
        z = z % 11;
        if (str.charAt(str.length() - 1) == m[z]) {
            return true;
        }
        return false;
    }
 
}
