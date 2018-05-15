package jdk.lambda;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Example2 {

	public static void main(String[] args) {
		// Java 8之前：
		JButton show =  new JButton("Show");
		show.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    System.out.println("Event handling without lambda expression is boring");
		    }
		});
		
		// Java 8方式：
		show.addActionListener((e) -> {
		    System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
		});
	}
}
