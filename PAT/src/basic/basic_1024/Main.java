//题目描述
//本题要求编写程序，计算2个有理数的和、差、积、商。
//
//输入描述:
//输入在一行中按照“a1/b1 a2/b2”的格式给出两个分数形式的有理数，其中分子和分母全是整型范围内的整数，负号只可能出现在分子前，分
//
//母不为0。
//
//
//输出描述:
//分别在4行中按照“有理数1 运算符 有理数2 = 结果”的格式顺序输出2个有理数的和、差、积、商。注意输出的每个有理数必须是该有理数的
//
//最简形式“k a/b”，其中k是整数部分，a/b是最简分数部分；若为负数，则须加括号；若除法分母为0，则输出“Inf”。题目保证正确的输出中
//
//没有超过整型范围的整数。
//
//输入例子:
//5/3 0/6
//
//输出例子:
//1 2/3 + 0 = 1 2/3
//
//1 2/3 - 0 = 1 2/3
//
//1 2/3 * 0 = 0
//
//1 2/3 / 0 = Inf


package basic.basic_1024;

//方法一(AC)
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		String[] str = bf.readLine().split(" ");
//		String[] num1 = str[0].split("/");
//		String[] num2 = str[1].split("/");
//		
//		int a1 = Integer.valueOf(num1[0]);
//		int b1 = Integer.valueOf(num1[1]);
//		int a2 = Integer.valueOf(num2[0]);
//		int b2 = Integer.valueOf(num2[1]);
//		
////		System.out.println(a1 + " " + b1 + " " + a2 + " " + b2);
//		Fraction f1 = new Fraction(a1, b1);
//		Fraction f2 = new Fraction(a2, b2);
////		System.out.println(f1.getSimplestStr());
////		System.out.println(f2.getSimplestStr());
//		
//		String f1S = f1.getSimplestStr();
//		String f2S = f2.getSimplestStr();
//		
//		System.out.println(f1S + " + " + f2S + " = " + f1.add(f2).getSimplestStr());
//		System.out.println(f1S + " - " + f2S + " = " + f1.substract(f2).getSimplestStr());
//		System.out.println(f1S + " * " + f2S + " = " + f1.multiply(f2).getSimplestStr());
//		System.out.println(f1S + " / " + f2S + " = " + f1.divide(f2).getSimplestStr());
//	}
//
//	
//	public static class Fraction {
//		int nume;	//分子
//		int deno;	//分母
//		
//		public int getNume() {
//			return nume;
//		}
//		public void setNume(int nume) {
//			this.nume = nume;
//		}
//		public int getDeno() {
//			return deno;
//		}
//		public void setDeno(int deno) {
//			this.deno = deno;
//		}
//		public Fraction(int nume, int deno) {
//			super();
//			this.nume = nume;
//			this.deno = deno;
//		}
//		
//		//分数加法
//		public Fraction add(Fraction f) {
//			int a = this.nume * f.deno + f.nume * this.deno;
//			int b = this.deno * f.deno;
//			
//			Fraction result = new Fraction(a, b);
//			
//			return result;
//		}
//		
//		//分数减法
//		public Fraction substract(Fraction f) {
//			int a = this.nume * f.deno - f.nume * this.deno;
//			int b = this.deno * f.deno;
//			
//			Fraction result = new Fraction(a, b);
//			
//			return result;
//		}
//		
//		//分数乘法
//		public Fraction multiply(Fraction f) {
//			int a = this.nume * f.nume;
//			int b = this.deno * f.deno;
//			
//			Fraction result = new Fraction(a, b);
//			
//			return result;
//		}
//		
//		//分数除法
//		public Fraction divide(Fraction f) {
//			int a = this.nume * f.deno;
//			int b = this.deno * f.nume;
//			
//			Fraction result = new Fraction(a, b);
//			
//			return result;
//		}
//
//		public Fraction getSimlest() {
//			//约分分数至最简 形式
//			int temp = 2;
//			while (temp <= deno) {
//				if (nume % temp == 0 && deno % temp == 0) {
//					nume = nume / temp;
//					deno = deno / temp;
//				}
//				else {
//					temp++;
//				}
//			}
//			
//			Fraction f = new Fraction(this.nume, this.deno) ;
//			return f;
//
//		}
//		public String getSimplestStr() {
//			if (this.deno == 0) {
//				return "Inf";
//			}
//			
//			//约分分数至最简 形式
//			int temp = 2;
//			while (temp <= Math.abs(deno)) {
//				if (nume % temp == 0 && deno % temp == 0) {
//					nume = nume / temp;
//					deno = deno / temp;
//				}
//				else {
//					temp++;
//				}
//			}
//			
//			if (this.nume * this.deno < 0) {
//				int temp1 = Math.abs(this.nume);
//				this.nume = -1 * temp1;
//				this.deno = Math.abs(this.deno);
//			}
//			String result = "";
//			int k = nume / deno;
//			int a = nume % deno;
//
//			
//			if (Math.abs(k) > 0) {
//				result = k + "";
//			}
//			if (Math.abs(k) > 0 && Math.abs(a) > 0) {
//				result = k + " ";
//			}
//			if (k != 0 && Math.abs(a) > 0) {
//				result = result + "" + Math.abs(a) + "/" +deno;
//			}
//			else if (k == 0 && Math.abs(a) > 0) {
//				result = result + "" + a + "/" +deno;
//			}
//			if (k == 0 && a == 0) {
//				result = result + "0";
//			}
//			if (this.nume * this.deno < 0) {
//				result = "(" + result + ")";
//			}
//			
//			return result;
//		}
//	}
//}

//方法二(AC)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = (br.readLine()).split(" ");
        String[] str1 = str[0].split("/");
        String[] str2 = str[1].split("/");
        int a1 = Integer.parseInt(str1[0]);
        int b1 = Integer.parseInt(str1[1]);
        int a2 = Integer.parseInt(str2[0]);
        int b2 = Integer.parseInt(str2[1]);
        add(a1, b1, a2, b2);
        minus(a1, b1, a2, b2);
        multiply(a1, b1, a2, b2);
        divide(a1, b1, a2, b2);    
    }
 
    public static void printSimple(int a, int b) {
        boolean isNegative = false;
        if (a < 0) {
            isNegative = true;
            a = a * (-1);
        }
        int gcd = getGcd(a, b);
        a = a / gcd;
        b = b / gcd;
        int k = a / b;
        int x = a % b;
        int y = b;
        if (isNegative) {
            System.out.print("(-");
            if (k == 0) {
                if (x != 0) {
                    System.out.print(x + "/" + y);
                } else {
                    System.out.print(0);
                }
            } else {
                System.out.print(k);
                if (x != 0) {
                    System.out.print(" " + x + "/" + y);
                }
            }
            System.out.print(")");
        } else if (k == 0) {
            if (x != 0) {
                System.out.print(x + "/" + y);
            } else {
                System.out.print(0);
            }
        } else {
            System.out.print(k);
            if (x != 0) {
                System.out.print(" " + x + "/" + y);
            }
        }
    }
     
    public static int getGcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return getGcd(y, x%y);
        }
    }
     
    public static void add(int a1, int b1, int a2, int b2) {
        int x = a1 * b2 + a2 *b1;
        int y = b1 * b2;
        printSimple(a1, b1);
        System.out.print(" + ");
        printSimple(a2, b2);
        System.out.print(" = ");
        printSimple(x, y);
        System.out.print("\n");
    }
     
    public static void minus(int a1, int b1, int a2, int b2) {
        int x = a1 * b2 - a2 *b1;
        int y = b1 * b2;
        printSimple(a1, b1);
        System.out.print(" - ");
        printSimple(a2, b2);
        System.out.print(" = ");
        printSimple(x, y);
        System.out.print("\n");
    }
     
    public static void multiply(int a1, int b1, int a2, int b2) {
        int x = a1 * a2;
        int y = b1 * b2;
        printSimple(a1, b1);
        System.out.print(" * ");
        printSimple(a2, b2);
        System.out.print(" = ");
        printSimple(x, y);
        System.out.print("\n");
    }
     
    public static void divide(int a1, int b1, int a2, int b2) {
        int x = a1 * b2;
        int y = b1 * a2;
        if (y < 0) {
            x = (-1) * x;
            y = (-1) * y;
        }
        printSimple(a1, b1);
        System.out.print(" / ");
        printSimple(a2, b2);
        System.out.print(" = ");
        if (y == 0) {
            System.out.print("Inf");
        } else {
            printSimple(x, y);
        }
        System.out.print("\n");
    }
 
}
