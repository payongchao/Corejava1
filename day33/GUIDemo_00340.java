package com.briup.jd1721.corejava.day33;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class GUIDemo_00340{
	public static void main(String[] args){
		/**
		 * 在界面上添加一个单行文本框，再添加一个多行
		 * 文本框，在单行文本框的右边有一个按钮，点击
		 * 该按钮，将单行文本框中的内容显示作为本地
		 * 磁盘的一个路径，然后在多行文本框中显示该路
		 * 径下的所有文件名。
		 */
		// 1.创建Frame对象，创建窗体容器
		Frame frame=new Frame("迷你窗体");
		// 2.设置窗体的位置和大小
		frame.setBounds(300,200,800,600);
		// 3.显示该窗体
		frame.setVisible(true);
		// 4.设置窗体添加组件的方式为坐标形式
		frame.setLayout(new FlowLayout());
		// 添加按钮：
		Button button0=new Button("Add");
		frame.add(button0);
		Button button1=new Button("Add");
		frame.add(button1);
		Button button2=new Button("Add");
		frame.add(button2);
		Button button3=new Button("Add");
		frame.add(button3);
		Button button4=new Button("Add");
		frame.add(button4);
		Button button5=new Button("Add");
		frame.add(button5);
		String name=button5.getLabel();
		System.out.println(name);

	}
}
