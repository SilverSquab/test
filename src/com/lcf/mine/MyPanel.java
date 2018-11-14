package com.lcf.mine;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class MyPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private int number;
	private int xnum;
	private int ynum;
	private MyMouseLinse mouse;
	private Image myImage[] = new MyImage().getImage();
	private MyPoint[][] border ;
	
	public MyPanel(int number) {
		this.number=number;
		init();
		mouse=new MyMouseLinse(xnum, ynum, this.number,this);
		addMouseListener(mouse);
	}
	
	public void init() {
		
		switch(number) {
			case 10:xnum=9;
					ynum=9;
					break;
			case 44:xnum=16;
					ynum=16;
					break;
			case 99:xnum=30;
					ynum=16;
		}
	}
	
	//绘制图形
	public void paint(Graphics g) {
		super.paint(g);
		border=mouse.getBorder();
		for(int i=0;i<xnum;i++) {
			 for(int j=0;j<ynum;j++){
				 if(!mouse.isIslose()) {
					 if(border[i][j].isSao()) {
						 g.drawImage(myImage[11], 10+20*i, 10+20*j, 19, 19, null);
						 continue;
					 }
					 if(!border[i][j].isOpen()) {
						 g.drawImage(myImage[12], 10+20*i, 10+20*j, 19, 19, null);
						 continue;
					 }else {
						 draw(g,i,j);
					 } 
					 
				 }else {
					 draw(g,i,j);
				 }	   
			 }
		 }
		//判断是否
		if(mouse.isIswin()) {
			 System.out.println("进入判断语句");
			 g.drawString("恭喜你胜利了", xnum/2, ynum/2);
			 
		 }
	}
	
	//将共性提出来
	public void draw(Graphics g,int i,int j) {	 
			 if(mouse.isIslose()) {
				 System.out.println("死了");
			 }
			 int n=border[i][j].getLeinum();
			 switch(n) {
			 case 0:
				 g.drawImage(myImage[0], 10+20*i, 10+20*j, 19, 19, null);
				 break;
			 case 1:
				 g.drawImage(myImage[1], 10+20*i, 10+20*j, 19, 19, null);
				 break;
			 case 2:
				 g.drawImage(myImage[2], 10+20*i, 10+20*j, 19, 19, null);
				 break;
			 case 3:
				 g.drawImage(myImage[3], 10+20*i, 10+20*j, 19, 19, null);
				 break;
			 case 4:
				 g.drawImage(myImage[4], 10+20*i, 10+20*j, 19, 19, null);
				 break;
			 case 5:
				 g.drawImage(myImage[5], 10+20*i, 10+20*j, 19, 19, null);
				 break;
			 case 6:
				 g.drawImage(myImage[6], 10+20*i, 10+20*j, 19, 19, null);
				 break;
			 case 7:
				 g.drawImage(myImage[7], 10+20*i, 10+20*j, 19, 19, null);
				 break;
			 case 8:
				 g.drawImage(myImage[8], 10+20*i, 10+20*j, 19, 19, null);
				 break;
			 case 9:
				 g.drawImage(myImage[9], 10+20*i, 10+20*j, 19, 19, null);
				 break;
			 case 10:
				 g.drawImage(myImage[10], 10+20*i, 10+20*j, 19, 19, null);
				 break;
			 
			 } 
		 
	}
	

	
	
}
