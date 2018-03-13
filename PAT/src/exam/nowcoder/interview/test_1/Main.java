//今年的第几天？
//输入年、月、日，计算该天是本年的第几天。
//
//输入描述:
//包括三个整数年(1<=Y<=3000)、月(1<=M<=12)、日(1<=D<=31)。
//
//
//输出描述:
//输入可能有多组测试数据，对于每一组测试数据，
//输出一个整数，代表Input中的年、月、日对应本年的第几天。
//
//输入例子1:
//1990 9 20
//2000 5 1

//输出例子1:
//263
//122
//
//例子说明1:

	
package exam.nowcoder.interview.test_1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String[] strs = sc.nextLine().split(" ");
			int y = Integer.valueOf(strs[0]);
			int m = Integer.valueOf(strs[1]);
			int d = Integer.valueOf(strs[2]);
			
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	        Date fDate=sdf.parse(y + "-01-01");
	        Date oDate=sdf.parse(y + "-" + m + "-" + d);
	        Calendar aCalendar = Calendar.getInstance();
	        aCalendar.setTime(fDate);
	        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
	        aCalendar.setTime(oDate);
	        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
	        int days=day2 - day1 + 1;
	        System.out.print(days);
		}
	}

}
