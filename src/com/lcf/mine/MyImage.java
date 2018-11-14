package com.lcf.mine;

import java.awt.Image;
import java.awt.Toolkit;

public class MyImage {
	private Image[] myImage = new Image[16];
	
	public MyImage() {
		Toolkit tk = Toolkit.getDefaultToolkit();	
		myImage[0]=tk.getImage("Image/0.jpg");
		myImage[1]=tk.getImage("Image/1.jpg");
		myImage[2]=tk.getImage("Image/2.jpg");
		myImage[3]=tk.getImage("Image/3.jpg");
		myImage[4]=tk.getImage("Image/4.jpg");
		myImage[5]=tk.getImage("Image/5.jpg");
		myImage[6]=tk.getImage("Image/6.jpg");
		myImage[7]=tk.getImage("Image/7.jpg");
		myImage[8]=tk.getImage("Image/8.jpg");
		myImage[9]=tk.getImage("Image/bomb.jpg");
		myImage[10]=tk.getImage("Image/bomb0.jpg");
		myImage[11]=tk.getImage("Image/flag.jpg");
		myImage[12]=tk.getImage("Image/s.jpg");
		myImage[13]=tk.getImage("Image/win.jpg");	
	}
	
	public Image[] getImage() {return myImage;}
	
	
}
