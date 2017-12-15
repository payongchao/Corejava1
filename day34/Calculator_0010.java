package com.briup.jd1721.corejava.day34;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculator_0010 {
	private JFrame frame;
	private JTextField tf_display;
	private JPanel panel;
	private JButton btn_7;
	private JButton btn_8;
	private JButton btn_9;
	private JButton btn_div;
	private JButton btn_bs;
	private JButton btn_4;
	private JButton btn_5;
	private JButton btn_6;
	private JButton btn_by;
	private JButton btn_clear;
	private JButton btn_1;
	private JButton btn_2;
	private JButton btn_3;
	private JButton btn_sub;
	private JButton btn_sqrt;
	private JButton btn_addsub;
	private JButton btn_0;
	private JButton btn_point;
	private JButton btn_add;
	private JButton btn_equals;
	private double num1;
	private double num2;
	private String op="";

	public static void main(String[] args) {
		Calculator_0010 window =
			new Calculator_0010();
		window.frame.setVisible(true);
	}

	public Calculator_0010() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 714, 718);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// --------------------------------------------------------------------------
		tf_display = new JTextField("0");
		tf_display.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_display.setEditable(false);
		tf_display.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		frame.getContentPane().add(tf_display, BorderLayout.NORTH);
		tf_display.setColumns(10);
		// --------------------------------------------------------------------------
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 5, 0, 0));
		// --------------------------------------------------------------------------
		btn_7 = new JButton("7");
		btn_7.setBackground(new Color(135, 206, 235));
		btn_7.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(btn_7);
		// --------------------------------------------------------------------------
		btn_8 = new JButton("8");
		btn_8.setBackground(new Color(135, 206, 235));
		btn_8.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(btn_8);
		// --------------------------------------------------------------------------
		btn_9 = new JButton("9");
		btn_9.setBackground(new Color(135, 206, 235));
		btn_9.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(btn_9);
		// --------------------------------------------------------------------------
		btn_div = new JButton("/");
		btn_div.setBackground(new Color(135, 206, 235));
		btn_div.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(btn_div);
		// --------------------------------------------------------------------------
		btn_bs = new JButton("\u2190");
		btn_bs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = tf_display.getText();
				if(text.length()==1){
					tf_display.setText("0");
				}else{
					text=text.substring(0, text.length()-1);
					tf_display.setText(text);
				}
			}
		});
		btn_bs.setBackground(new Color(135, 206, 235));
		btn_bs.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(btn_bs);
		// --------------------------------------------------------------------------
		btn_4 = new JButton("4");
		btn_4.setBackground(new Color(135, 206, 235));
		btn_4.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(btn_4);
		// --------------------------------------------------------------------------
		btn_5 = new JButton("5");
		btn_5.setBackground(new Color(135, 206, 235));
		btn_5.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(btn_5);
		// --------------------------------------------------------------------------
		btn_6 = new JButton("6");
		btn_6.setBackground(new Color(135, 206, 235));
		btn_6.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(btn_6);
		// --------------------------------------------------------------------------
		btn_by = new JButton("*");
		btn_by.setBackground(new Color(135, 206, 235));
		btn_by.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(btn_by);
		// --------------------------------------------------------------------------
		btn_clear = new JButton("C");
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_display.setText("0");
				num1=0;
				num2=0;
				op="";
			}
		});
		btn_clear.setBackground(new Color(135, 206, 235));
		btn_clear.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(btn_clear);
		// --------------------------------------------------------------------------
		btn_1 = new JButton("1");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
			}
		});
		btn_1.setBackground(new Color(135, 206, 235));
		btn_1.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(btn_1);
		// --------------------------------------------------------------------------
		btn_2 = new JButton("2");
		btn_2.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String commad =e.getActionCommand();
					String text = tf_display.getText();
					if ("0".equals(text)) {
						tf_display.setText(commad);
					}else{
						tf_display.setText(text+commad);
					}

					if (text.length()>=10) {
						tf_display.setText(text);
					}
				}
			});
		btn_2.setBackground(new Color(135, 206, 235));
		btn_2.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(btn_2);
		// --------------------------------------------------------------------------
		btn_3 = new JButton("3");
		btn_3.setBackground(new Color(135, 206, 235));
		btn_3.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(btn_3);
		// --------------------------------------------------------------------------
		btn_sub = new JButton("-");
		btn_sub.setBackground(new Color(135, 206, 235));
		btn_sub.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(btn_sub);
		// --------------------------------------------------------------------------
		btn_sqrt = new JButton("Sqrt");
		btn_sqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = tf_display.getText();
				double sqrt =
					Math.sqrt(
						Double.parseDouble(text));
				tf_display.setText(sqrt+"");
			}
		});
		btn_sqrt.setBackground(new Color(135, 206, 235));
		btn_sqrt.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(btn_sqrt);
		// --------------------------------------------------------------------------
		btn_addsub = new JButton("+/-");
		btn_addsub.setBackground(new Color(135, 206, 235));
		btn_addsub.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(btn_addsub);
		// --------------------------------------------------------------------------
		btn_0 = new JButton("0");
		btn_0.setBackground(new Color(135, 206, 235));
		btn_0.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(btn_0);
		// --------------------------------------------------------------------------
		btn_point = new JButton(".");
		btn_point.setBackground(new Color(135, 206, 235));
		btn_point.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(btn_point);
		// --------------------------------------------------------------------------
		btn_add = new JButton("+");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text =
					tf_display.getText();
				num1=Double.parseDouble(text);
				op="+";
				tf_display.setText("0");
				System.out.println(num1);
			}
		});
		btn_add.setBackground(new Color(135, 206, 235));
		btn_add.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(btn_add);
		// --------------------------------------------------------------------------
		btn_equals = new JButton("=");
		btn_equals.addActionListener(new ActionListener() {
			public void actionPerformed(
				ActionEvent e) {
				String text = tf_display.getText();
				num2=Double.parseDouble(text);
				double result=0;
				switch (op) {
					case "+":
						result=num1+num2;
						break;
					case "-":
						result=num1-num2;
						break;
					case "*":
						result=num1*num2;
						break;
					case "/":
						result=num1/num2;
						break;
				}
				tf_display.setText(result+"");
			}
		});
		btn_equals.setBackground(new Color(135, 206, 235));
		btn_equals.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(btn_equals);
	}
}
