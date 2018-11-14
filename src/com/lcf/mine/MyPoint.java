package com.lcf.mine;

public class MyPoint {
	private boolean isLei;
	private int leinum;
	private boolean isOpen;
	private boolean isSao;
	
	


	public MyPoint(boolean isLei,boolean isOpen) {
		this.isLei=isLei;
		this.isOpen=isOpen;
	}
	
	public boolean isSao() {
		return isSao;
	}


	public void setSao(boolean isSao) {
		this.isSao = isSao;
	}
	
	public boolean isLei() {
		return isLei;
	}
	public void setLei(boolean isLei) {
		this.isLei = isLei;
	}
	public int getLeinum() {
		return leinum;
	}
	public void setLeinum(int leinum) {
		this.leinum = leinum;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
	
	
	
	
}
