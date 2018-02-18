//题目描述
//某城镇进行人口普查，得到了全体居民的生日。现请你写个程序，找出镇上最年长和最年轻的人。
//
//
//
//这里确保每个输入的日期都是合法的，但不一定是合理的——假设已知镇上没有超过200岁的老人，而今天是2014年9月6日，所以超过200
//
//岁的生日和未出生的生日都是不合理的，应该被过滤掉。
//
//输入描述:
//输入在第一行给出正整数N，取值在(0, 105]；随后N行，每行给出1个人的姓名（由不超过5个英文字母组成的字符串）、以及
//
//按“yyyy/mm/dd”（即年/月/日）格式给出的生日。题目保证最年长和最年轻的人没有并列。
//
//
//输出描述:
//在一行中顺序输出有效生日的个数、最年长人和最年轻人的姓名，其间以空格分隔。
//
//输入例子:
//5
//John 2001/05/12
//Tom 1814/09/06
//Ann 2121/01/30
//James 1814/09/05
//Steve 1967/11/20
//
//3
//John 2001/05/12
//Tom 1814/09/06
//Ann 2121/01/30
//
//输出例子:
//3 Tom John


package basic.basic_1018;


//方法一(WA)
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Scanner;
//import java.util.Set;
//
//public class Main {
//
//	@SuppressWarnings("deprecation")
//	public static void main(String[] args) throws NumberFormatException, IOException {
////		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
////		int n = Integer.valueOf(bf.readLine());
////
////		HashMap<Date, String> map = new HashMap<Date, String> ();
////		for (int i = 0; i < n; i++) {
////			String[] tempStr = bf.readLine().split(" ");
////			String name = tempStr[0];
////			Date date = new Date(tempStr[1]);
////			if (date.after(new Date("1814/09/05")) && date.before(new Date("2014/09/07"))) {
////				if (map.containsKey(date)) {
////					map.put(date, name);
////				}
////				else {
////					map.put(date, name);
////				}
////			}
////		}
//		
////		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
////		int n = Integer.valueOf(bf.readLine());
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		HashMap<Date, String> map = new HashMap<Date, String> ();
//		for (int i = 0; i < n; i++) {
////			String[] tempStr = bf.readLine().split(" ");
////			String name = tempStr[0];
////			Date date = new Date(tempStr[1]);
//			String name = sc.next();
//			Date date = new Date(sc.next());
//			if (date.after(new Date("1814/09/05")) && date.before(new Date("2014/09/07"))) {
//				if (map.containsKey(date)) {
//					map.put(date, name);
//				}
//				else {
//					map.put(date, name);
//				}
//			}
//		}
//		
//
//		//遍历并记录
////		Iterator iter = map.keySet().iterator();
////		int count = 0;
////		String old = "", young = "";
////		while (iter.hasNext()) {
//////			Date date = (Date) iter.next();
//////			System.out.println(date + " " + map.get(date));
////			
////			Date date = (Date) iter.next();
////			if (count == 0) {
////				young = map.get(date);
////			}
////			if (count == map.size() - 1) {
////				old = map.get(date);
////			}
////			count++;
////		}
//		
//		//排序
//		Date young = new Date("1814/09/05"), old = new Date("2014/09/07");
//		Iterator iter = map.keySet().iterator();
//		while (iter.hasNext()) {
//			Date date = (Date) iter.next();
//			if (date.before(old)) {
//				old = date;
//			}
//			if (date.after(young)) {
//				young = date;
//			}
//		}
//		
//		System.out.println(map.size() + " " + map.get(old) + " " + map.get(young));
//	}
//
//}


//方法二(AC)
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
 
public class Main {
     
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Person> list = new ArrayList<Person> ();
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			String name = sc.next();
			String birthday = sc.next();
			
			Person person = new Person();
			person.setName(name);
			person.setBirthday(birthday);
			list.add(person);
		}
		
		String big = "2014/09/06";
		String small = "1814/09/06";
		List<Person> list2 = new ArrayList<Person>();
		for (Person person :  list) {
			int a = big.compareTo(person.birthday);
			int b = small.compareTo(person.birthday);
			if (a >= 0 && b <= 0) {
				list2.add(person);
			}
		}
		Collections.sort(list2, new PersonCompare());
		
		System.out.println(list2.size() + " " + list2.get(0).getName() + " " + list2.get(list2.size()-1).getName());
		sc.close();
	}

    
    private static class PersonCompare implements Comparator<Person> {
    	@Override
    	public int compare (Person o1, Person o2) {
    		return o1.getBirthday().compareTo(o2.getBirthday());
    	}
    }
    
    private static class Person {
    	private String name;
    	private String birthday;
    	public String getName() {
    		return name;
    	}
    	public void setName(String name) {
    		this.name = name;
    	}
    	public String getBirthday() {
    		return birthday;
    	}
    	public void setBirthday(String birthday) {
    		this.birthday = birthday;
    	}
    }
 
}
