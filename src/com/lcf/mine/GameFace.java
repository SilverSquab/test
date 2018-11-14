package com.lcf.mine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class GameFace extends JFrame{
	 
	private static final long serialVersionUID = 1L;
	private int width;			//定义长
	private int height;			//定义宽
	private int number;			//剩余雷数
	private int time;			//时间
	private JPanel panel;		//存储容器1
	private JLabel label1;		//存储时间
	private JLabel label2;		//存储剩余雷数
	private JMenuBar menubar;	//定义菜单栏
	private JMenu menu;			//定义菜单
	private JMenuItem lowItem;	//低难度
	private JMenuItem midItem;	//中难度
	private JMenuItem heightItem;//高难度
	private JMenuItem restare; 		//重新开始按钮
	
	
	public GameFace(int width,int height,int number) {
		this.width=width;
		this.height=height;
		this.number=number;
		setTitle("扫雷");
		setBounds(100,100,width,height);
		initMenu();
		init();	
		
		//创建子容器对象
		MyPanel mypanel = new MyPanel(number);
		
		//添加菜单和显示列表
		add(menubar,BorderLayout.NORTH);
		add(panel,BorderLayout.SOUTH);
		add(mypanel,BorderLayout.CENTER);
		
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	//初始化界面组件
		public void init() {
			//初始化数据和组件
			panel=new JPanel(new FlowLayout());
			label1=new JLabel("时间："+time,SwingConstants.LEFT);
			label2=new JLabel("余雷："+number,SwingConstants.RIGHT);

			//添加组件
			panel.add(label1);
			panel.add(label2);
		}
	
	
	
	//初始化菜单
	public void initMenu() {
		menubar = new JMenuBar();
		menu = new JMenu("选择难度");
		restare = new JMenuItem("重新开始");
		lowItem = new JMenuItem("低难度（10颗雷）");
		midItem = new JMenuItem("中等难度（44颗雷）");
		heightItem = new JMenuItem("高等难度（99颗雷）");
		menu.add(restare);
		menu.add(lowItem);
		menu.add(midItem);
		menu.add(heightItem);
		menubar.add(menu);
		
		//添加菜单的点击事件
		restare.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//销毁当前的窗口
				dispose();
				//重新创建一个新的窗口
				new GameFace(width,height,number);
				
			}
		});
		
		
		lowItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//销毁当前的窗口
				dispose();
				//重新创建一个新的窗口
				new GameFace(220,305,10);
			}
		});
		midItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GameFace(360,460,44);
			}
		});
		heightItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GameFace(650,460,99);
			}
		});
		
		
	}
	
	
	

	
	
	public static void main(String[] args) {
		new GameFace(200,300,10);
	}
}
