package com.briup.jd1721.corejava.day33;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIDemo_0010{
	public static void main(String[] args){
		// 1.创建窗体对象
		Frame frame=new Frame();
		// 让最初不可见的窗体显示出来，但是该方法已过时。
		//frame.show();
		frame.setVisible(true);

		// 设置Frame的布局方式为流式布局
		frame.setLayout(null);
		// 当布局方式设置为null的时候，就是绝对布局。


		// 默认的Java创建的窗体的大小是，
		// 宽0px，高0px。位置：(0,0)
		// 设置该窗体的显示的位置
		frame.setLocation(200,100);
		// 设置该窗体的大小
		frame.setSize(400,300);

		// 在Frame上添加其他组件：Button
		Button button=new Button("OK");
		// 设置按钮的坐标
		button.setLocation(100,100);
		// 设置按钮的大小
		button.setSize(50,20);
		// button.setName("");
		frame.add(button);

		/**
		 * 当点击“OK”按钮的时候，关闭窗体。
		 */
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});

		/**
		 * 在界面上添加一个单行文本框，再添加一个多行
		 * 文本框，在单行文本框的右边有一个按钮，点击
		 * 该按钮，将单行文本框中的内容显示到多行文本
		 * 框中，并清空单行文本框。
		 */
	}
}
