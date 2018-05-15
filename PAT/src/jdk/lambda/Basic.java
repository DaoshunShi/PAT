package jdk.lambda;

import java.util.Arrays;
import java.util.List;

public class Basic {

	public static void main(String[] args) {
		
		example2();
		
		
	}
	
	public static void example1() {
		
		
	}
	
	public static void example2() {
		String[] atp = {"Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer","Roger Federer", "Andy Murray","Tomas Berdych", "Juan Martin Del Potro"};
		List<String> players = Arrays.asList(atp);
		
		//以前的循环方式
		for (String player : players) {
			System.out.println(player + "; "); 
		}
		
		//使用lambda表达式以及函数操作(functional operation)
		players.forEach( (player) -> System.out.println(player + "; ") );
		
		//在Java8中使用双冒号操作符(double colon operator)
		players.forEach(System.out::println);
	}

}