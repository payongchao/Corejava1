package com.briup.jd1721.corejava.day33;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GUIDemo_0030{
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
		// 5.创建单行文本的对象
		TextField field=new TextField(50);
		field.setFont(new Font("宋体",0,20));
		//field.setLocation(100,10);
		//field.setSize(200,100);
		// 6.将TextField添加到Frame中
		frame.add(field);


		// 添加按钮：
		Button button=new Button("Add");
		frame.add(button);


		// 添加多行文本
		TextArea area=new TextArea(30,100);
		frame.add(area);


		// 给按钮添加相应的监听器
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				area.setText("");
				// 获取单行文本框中的数据
				String text=field.getText();
				File dir=new File(text);
				if(dir.isDirectory()){
					File[] files=dir.listFiles();
					for(File file:files){
						area.setText(area.getText()+"\r\n"+file.getName());
					}
				}
			}
		});
	}
}
