package com.briup.jd1721.corejava.day35.web;

import com.briup.jd1721.corejava.project.bean.Student;
import com.briup.jd1721.corejava.project.service.StudentService;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LoginFrame{
	// 声明用户输入学号的JTextField的成员变量
	private JTextField idField;
	// 声明用户输入密码的JPasswordField的成员变量
	private JPasswordField passwordField;
	// 设置提示的Label
	private JLabel tipLabel;

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException{
		LoginFrame frame=new LoginFrame();
		frame.init();
	}

	public void init() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException{
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		// 1.创建JFrame对象。
		JFrame frame=new JFrame("学生管理系统");
		// 设置窗体的大小
		frame.setBounds(500,200,600,450);
		// 设置窗体在运行的时候可见
		frame.setVisible(true);
		// 设置窗体在关闭的时候并结束整个程序的运行
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗体禁止调整大小
		frame.setResizable(true);
		// 由于对于窗体的大小做了限制，所以更改窗体的布局
		// 方式在绝对布局
		frame.setLayout(null);

		// 2.添加各种组件，最上面的Label
		JLabel topLabel=new JLabel("学生管理系统-登录");
		topLabel.setBounds(100,50,400,40);
		//topLabel.setBackground(new Color(255,10,10));
		topLabel.setFont(new Font("微软雅黑",Font.PLAIN,40));
		frame.getContentPane().add(topLabel);

		// 添加Label：“学号：”
		JLabel idLabel=new JLabel("学号：");
		idLabel.setBounds(80,150,100,40);
		idLabel.setFont(new Font("微软雅黑",Font.PLAIN,30));
		frame.getContentPane().add(idLabel);

		// 添加用于输入学号的单行文本框
		// 由于可能在其他方法中会用到该文本框对象，所以
		// 将该对象声明为成员变量
		idField=new JTextField();
		idField.setBounds(200,150,300,40);
		frame.getContentPane().add(idField);
		idField.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				tipLabel.setVisible(false);
				idField.selectAll();
			}
		});

		// 添加Label：“密码：”
		JLabel passwdLabel=new JLabel("密码：");
		passwdLabel.setBounds(80,200,100,50);
		passwdLabel.setFont(new Font("微软雅黑",Font.PLAIN,30));
		frame.add(passwdLabel);

		// 添加输入密码的文本框
		// 声明为成员变量
		passwordField=new JPasswordField();
		passwordField.setBounds(200,200,300,40);
		frame.add(passwordField);

		// 添加重置按钮
		JButton resetButton=new JButton("重置");
		resetButton.setBounds(80,270,190,40);
		resetButton.setFont(new Font("微软雅黑",Font.PLAIN,20));
		frame.add(resetButton);

		// 添加登录按钮
		JButton loginButton=new JButton("登录");
		loginButton.setBounds(310,270,190,40);
		loginButton.setFont(new Font("微软雅黑",Font.PLAIN,20));
		frame.add(loginButton);
		// 给登录按钮添加监听器
		loginButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// 获取学号和密码信息
				String id=idField.getText();
				String passwd=passwordField.getText();
				// 将获取到的这俩信息封装成Student对象
				Student student=
					new Student(Integer.parseInt(id),passwd);
				// 创建Service层类的对象，用来处理相关逻辑
				StudentService service=new StudentService();
				// 用Service层的isExist方法来判断该学生是否存在
				boolean exist=service.isExist(student);
				if(exist){
					// 此处的代码是当exist为true的时候执行的代码
					// 也就是判断了该学生存在的时候执行的代码
				}else{
					tipLabel.setText("该学生不存在，请检查学号！");
					tipLabel.setVisible(true);
				}
			}
		});


		// 添加同于做提示的Label，刚开始，此Label不显示
		tipLabel=new JLabel("");
		tipLabel.setBounds(80,350,450,20);
		tipLabel.setForeground(new Color(255,0,0));
		tipLabel.setFont(new Font("楷体",Font.BOLD,20));
		tipLabel.setVisible(false);
		frame.add(tipLabel);
	}
}
