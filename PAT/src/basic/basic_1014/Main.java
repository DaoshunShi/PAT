//题目描述
//科学计数法是科学家用来表示很大或很小的数字的一种方便的方法，其满足正则表达式[+-][1-9]"."[0-9]+E[+-][0-9]+，即数字的整数部分
//
//只有1位，小数部分至少有1位，该数字及其指数部分的正负号即使对正数也必定明确给出。
//
//
//
//现以科学计数法的格式给出实数A，请编写程序按普通数字表示法输出A，并保证所有有效位都被保留。
//
//输入描述:
//每个输入包含1个测试用例，即一个以科学计数法表示的实数A。该数字的存储长度不超过9999字节，且其指数的绝对值不超过9999。
//
//
//输出描述:
//对每个测试用例，在一行中按普通数字表示法输出A，并保证所有有效位都被保留，包括末尾的0。
//
//输入例子:
//+1.23400E-03		+1.23400E+10		-1.2E+10
//
//输出例子:
//0.00123400


package basic.basic_1014;

//方法一
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		String str = bf.readLine();
//		String[] value = str.split("E");
//		char fh = value[0].charAt(0);
//		value[0] = value[0].substring(1, value[0].length());
//		int wy = Integer.valueOf(value[1]);
//		//打印正负号
//		System.out.print(fh == '-' ? "-" : "");
//		
//		//移动小数点位置，并补零
//		while(wy != 0) {
//			String[] temp = new String[2];
//			temp = value[0].split("\\.");
//			if (wy > 0) {
//				if (temp.length == 1) {
//					temp[0] = temp[0] + "0";
//					value[0] = temp[0];
//				}
//				else {
//					temp[0] = temp[0] + temp[1].substring(0, 1);
//					temp[1] = temp[1].substring(1, temp[1].length());
//					value[0] = temp[0] + "." + temp[1];
//				}
//				wy--;
//			}
//			else {
//				temp[1] = temp[0].substring(temp[0].length()-1, temp[0].length()) + temp[1];
//				temp[0] = temp[0].substring(0, temp[0].length()-1);
//				while(temp[0].length() <= 0) {
//					temp[0] = temp[0] + "0";
//				}
//				
//				value[0] = temp[0] + "." + temp[1];
//				wy++;
//			}
//		}
//		
//		System.out.println(value[0]);
//	}
//}


//方法二
//import java.util.*;
//import java.math.BigDecimal;
//public class Main {
//    public static void main(String[] args) {
//        Scanner scan=new Scanner(System.in);
//        BigDecimal s=scan.nextBigDecimal();
//        System.out.println(s.toPlainString());
//        scan.close();
//    }
//}


//方法三
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
         
        String argument = bufferedReader.readLine();
         
        String speedUpString = "000000000000000000000000000000000000000000000000000000000000";
         
        String[] s1 = argument.split("E");
         
        String radixString = s1[0].replaceAll("[+.]", "");
 
        int exponent = Integer.parseInt(s1[1]);
         
        if(exponent < 0) {
            StringBuffer temp = new StringBuffer("");
             
            if(radixString.charAt(0) == '-') {
                temp.append("-");
                radixString = radixString.replaceAll("-", "");
            }
             
            temp.append("0.");
            while((exponent + 1) < 0) {
                 
                if(exponent < -61) {
                    temp.append(speedUpString);
                    exponent += 60;
                }else {
                    temp.append('0');
                    exponent++;
                }
            }
            temp.append(radixString);
            System.out.println(temp);
        }else if(exponent > 0) {
             
            StringBuffer temp = new StringBuffer("");
             
            if(radixString.charAt(0) == '-') {
                radixString = radixString.replaceAll("-", "");
                temp.append("-");
            }
            temp.append(radixString.charAt(0));
             
            int flag = 1;
             
            while(exponent > 0) {
                if(flag < radixString.length()) {
                    temp.append(radixString.charAt(flag));
                    flag++;
                }else {
                    while(exponent > 0) {
                        if(exponent > 60) {
                            temp.append(speedUpString);
                            exponent -= 60;
                        }else {
                            temp.append('0');
                            exponent--;
                        }
                    }
                }
                exponent--;
            }
             
            if(flag < radixString.length()) {
                temp.append(".");
                while(flag < radixString.length()) {
                    temp.append(radixString.charAt(flag));
                    flag++;
                }
            }
 
            System.out.print(temp);
        }
         
 
    }
}

