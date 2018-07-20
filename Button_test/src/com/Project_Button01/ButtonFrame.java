package com.Project_Button01;

/*
Java中的事件处理机制：

监听器对象 是一个实现了特定监听器接口（Listener Interface）类的实例
事件源 是一个能够注册监听器对象并发送事件对象的对象
当事件发送时候，事件源将事件对象传递给所以注册的监听器
监听器对象将利用事件对象中的信息决定如何做出响应

创建一个Buttontest窗体，里面包含三个按钮，点击按钮改变面板的背景颜色： 
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.html.HTMLEditorKit.HTMLTextAction;
 
public class ButtonFrame extends JFrame{
	public ButtonFrame(){
		this.setTitle("Buttontest");
		this.setSize(400,400);
		
		//create button
		JButton yellowbutton=new JButton("Yellow");
		JButton bluebutton=new JButton("Blue");
		JButton redbutton=new JButton("red");
		JButton blackbutton=new JButton("black");
		
		//add buttons to panel面板
		buttonPanel=new JPanel();
		buttonPanel.add(yellowbutton);
		buttonPanel.add(bluebutton);
		buttonPanel.add(redbutton);
		buttonPanel.add(blackbutton);
		
		//add panel to frame框架窗体
		this.add(buttonPanel);
		
		//craete button actions
		yellowbutton.addActionListener(new ColorAction(Color.YELLOW));
		bluebutton.addActionListener(new ColorAction(Color.BLUE));
		redbutton.addActionListener(new ColorAction(Color.RED));
		blackbutton.addActionListener(new ColorAction(Color.BLACK));
		
//		yellowbutton.addMouseListener(new MouseListener() {
//			
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("mouseReleased");
//			}
//			
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("mousePressed");
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("mouseExited");
//			}
//			
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("mouseEntered");
//			}
//			
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
	}
	
	public class ColorAction implements ActionListener{
		public ColorAction(Color c){
			backgroundColor=c;
		}

		private Color backgroundColor;
 
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			buttonPanel.setBackground(backgroundColor);
		}
	}
	
	private JPanel buttonPanel;
}