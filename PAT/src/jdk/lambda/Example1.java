package jdk.lambda;

public class Example1 {
	
	public static void main(String[] args) {
		
		//Java8之前
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Before Java8, too muck code for too littel to do");
			}
		}).start();
		
		//Java8
		new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
		
	}
}
