package com.Project_Button01;

import java.awt.EventQueue;
 
import javax.swing.JFrame;
 
public class StartMian {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ButtonFrame frame=new ButtonFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
 
}

