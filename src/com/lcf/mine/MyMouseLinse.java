package com.lcf.mine;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseLinse extends MouseAdapter{
	private int X;
	private int Y;
	private MyPoint[][] border ;
	private int count=0;
	private int number;
	private int xnum;
	private int ynum;
	private boolean iswin;
	private boolean islose;
	private MyPanel panel;
	
	public MyMouseLinse(int xnum,int ynum,int number,MyPanel panel) {
		this.xnum=xnum;
		this.ynum=ynum;
		this.number=number;
		this.panel=panel;
		border=new MyPoint[xnum][ynum];
	}
	public MyMouseLinse() {}
	
	
	
	//单击事件发生时,得到点击处坐标从而换算成数组坐标。
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		int x=e.getX();
		int y=e.getY();
		X=(x-10)/20;
		Y=(y-10)/20;
		System.out.println(X+"  "+Y);
		//左键点击事件
		if(e.getButton()==MouseEvent.BUTTON1) {
			if(count==0) {
				first(X,Y);
				recursion1(X,Y);
				count++;
			}else {
				next(X,Y);
				System.out.println(X+" "+Y+" "+islose);
			}
		}
		//右键点击事件
		if(e.getButton()==MouseEvent.BUTTON3) {
			if(!border[X][Y].isOpen()) {
				if(!border[X][Y].isSao()) {
					border[X][Y].setSao(true);
				}else border[X][Y].setSao(false);
				
			}
		}
			
		System.out.println(X+" "+Y+border[X][Y].isLei());
		panel.repaint();
	}
	
	//不是第一次按下
	public void next(int x,int y) {
		if(border[x][y].isLei()) {
			for(int i=0;i<xnum;i++) {
				for(int j=0;j<ynum;j++) {
					if(border[i][j].isLei()) {
						border[i][j].setLeinum(10);
					}
				}
			}
			border[x][y].setLeinum(9);
			islose=true;
		}else {
			recursion1(x,y);
		}	
		
	}
	//放弃治疗的方法，迭代中
	public void recursion1(int x,int y) {
		border[x][y].setOpen(true);
		int leinum=0;
		int saonum=0;
		if(x+1<xnum&&border[x+1][y].isLei()) {
			leinum++;
			if(border[x+1][y].isSao()) saonum++;
		}
			
		if(0<=x-1&&border[x-1][y].isLei()) {
			leinum++;
			if(border[x-1][y].isSao()) saonum++;
		}
		if(y+1<ynum&&border[x][y+1].isLei()) {
			leinum++;
			if(border[x][y+1].isSao()) saonum++;
		}
		if(0<=y-1&&border[x][y-1].isLei()) {
			leinum++;
			if(border[x][y-1].isSao()) saonum++;
		}
		if(0<=x-1&&0<=y-1&&border[x-1][y-1].isLei()) {
			leinum++;
			if(border[x-1][y-1].isSao()) saonum++;
		}
		if(x+1<xnum&&y+1<ynum&&border[x+1][y+1].isLei()) {
			leinum++;
			if(border[x+1][y+1].isSao()) saonum++;
		}
		if(x+1<xnum&&0<=y-1&&border[x+1][y-1].isLei()) {
			leinum++;
			if(border[x+1][y-1].isSao()) saonum++;
		}
		if(0<=x-1&&y+1<ynum&&border[x-1][y+1].isLei()) {
			leinum++;
			if(border[x-1][y+1].isSao()) saonum++;
		}
		border[x][y].setLeinum(leinum);
		if(leinum==saonum) {
			if(x+1<xnum&&!border[x+1][y].isOpen()) recursion1(x+1,y);
			if(0<=x-1&&!border[x-1][y].isOpen()) recursion1(x-1,y);
			if(y+1<ynum&&!border[x][y+1].isOpen()) recursion1(x,y+1);
			if(0<=y-1&&!border[x][y-1].isOpen()) recursion1(x,y-1);
			if(0<=x-1&&0<=y-1&&!border[x-1][y-1].isOpen()) recursion1(x-1,y-1);
			if(x+1<xnum&&y+1<ynum&&!border[x+1][y+1].isOpen()) recursion1(x+1,y+1);
			if(x+1<xnum&&0<=y-1&&!border[x+1][y-1].isOpen()) recursion1(x+1,y-1);
			if(0<=x-1&&y+1<ynum&&!border[x-1][y+1].isOpen()) recursion1(x-1,y+1);
		}
		
	}
	
	
	//第一次按下
	public void first(int x, int y) {
		//先将第一次按下的位置设置为一定不会出现地雷
		
		//循环放置雷
		int c=0;
		int xl=0;
		int yl=0;
		while(true) {
			if(c==number) {
				break;
			}else {
				xl=(int)(Math.random()*xnum);
				yl=(int)(Math.random()*ynum);
				if(!border[xl][yl].isLei()&&(xl!=x&&yl!=y)) {
					border[xl][yl].setLei(true);
					c++;
				}
			}
		}
	}		
	
	//判断是否胜利
	public boolean isIswin() {
		iswin=true;
		
		for(int i=0;i<xnum;i++) {
			for(int j=0;j<ynum;j++) {
				if(!border[i][j].isOpen()&&!border[i][j].isSao()) {
					iswin=false;
				}
			}
		}	
		System.out.println("是否成功"+iswin);
		return iswin;
	}
	
	
	//判断是否失败
	public boolean isIslose() {
		return islose;
	}
	
	
	//得到数组
	public MyPoint[][] getBorder(){
		//将雷区全部布置完整
		if(count==0) {
			for(int i=0;i<xnum;i++) {
				for(int j=0;j<ynum;j++) {
						border[i][j]=new MyPoint(false,false);	
				}
			}
		}
		
		return border;
	}
	

}
