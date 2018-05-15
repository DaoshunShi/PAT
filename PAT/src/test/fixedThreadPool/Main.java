package test.fixedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);  
        int i = 0;  
        while (i++<10) {  
            fixedThreadPool.execute(new Runnable() {  
                @Override  
                public void run() {  
                    System.out.println(Thread.currentThread().getName() + "执行");  
                }  
            });  
        }  
        fixedThreadPool.shutdown(); 
	}

}
