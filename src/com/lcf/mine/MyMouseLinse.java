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
	
	
	
	//�����¼�����ʱ,�õ����������Ӷ�������������ꡣ
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		int x=e.getX();
		int y=e.getY();
		X=(x-10)/20;
		Y=(y-10)/20;
		System.out.println(X+"  "+Y);
		//�������¼�
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
		//�Ҽ�����¼�
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
	
	//���ǵ�һ�ΰ���
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
	//�������Ƶķ�����������
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
	
	
	//��һ�ΰ���
	public void first(int x, int y) {
		//�Ƚ���һ�ΰ��µ�λ������Ϊһ��������ֵ���
		
		//ѭ��������
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
	
	//�ж��Ƿ�ʤ��
	public boolean isIswin() {
		iswin=true;
		
		for(int i=0;i<xnum;i++) {
			for(int j=0;j<ynum;j++) {
				if(!border[i][j].isOpen()&&!border[i][j].isSao()) {
					iswin=false;
				}
			}
		}	
		System.out.println("�Ƿ�ɹ�"+iswin);
		return iswin;
	}
	
	
	//�ж��Ƿ�ʧ��
	public boolean isIslose() {
		return islose;
	}
	
	
	//�õ�����
	public MyPoint[][] getBorder(){
		//������ȫ����������
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
