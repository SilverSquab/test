package com.lcf.mine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class GameFace extends JFrame{
	 
	private static final long serialVersionUID = 1L;
	private int width;			//���峤
	private int height;			//�����
	private int number;			//ʣ������
	private int time;			//ʱ��
	private JPanel panel;		//�洢����1
	private JLabel label1;		//�洢ʱ��
	private JLabel label2;		//�洢ʣ������
	private JMenuBar menubar;	//����˵���
	private JMenu menu;			//����˵�
	private JMenuItem lowItem;	//���Ѷ�
	private JMenuItem midItem;	//���Ѷ�
	private JMenuItem heightItem;//���Ѷ�
	private JMenuItem restare; 		//���¿�ʼ��ť
	
	
	public GameFace(int width,int height,int number) {
		this.width=width;
		this.height=height;
		this.number=number;
		setTitle("ɨ��");
		setBounds(100,100,width,height);
		initMenu();
		init();	
		
		//��������������
		MyPanel mypanel = new MyPanel(number);
		
		//��Ӳ˵�����ʾ�б�
		add(menubar,BorderLayout.NORTH);
		add(panel,BorderLayout.SOUTH);
		add(mypanel,BorderLayout.CENTER);
		
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	//��ʼ���������
		public void init() {
			//��ʼ�����ݺ����
			panel=new JPanel(new FlowLayout());
			label1=new JLabel("ʱ�䣺"+time,SwingConstants.LEFT);
			label2=new JLabel("���ף�"+number,SwingConstants.RIGHT);

			//������
			panel.add(label1);
			panel.add(label2);
		}
	
	
	
	//��ʼ���˵�
	public void initMenu() {
		menubar = new JMenuBar();
		menu = new JMenu("ѡ���Ѷ�");
		restare = new JMenuItem("���¿�ʼ");
		lowItem = new JMenuItem("���Ѷȣ�10���ף�");
		midItem = new JMenuItem("�е��Ѷȣ�44���ף�");
		heightItem = new JMenuItem("�ߵ��Ѷȣ�99���ף�");
		menu.add(restare);
		menu.add(lowItem);
		menu.add(midItem);
		menu.add(heightItem);
		menubar.add(menu);
		
		//��Ӳ˵��ĵ���¼�
		restare.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//���ٵ�ǰ�Ĵ���
				dispose();
				//���´���һ���µĴ���
				new GameFace(width,height,number);
				
			}
		});
		
		
		lowItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//���ٵ�ǰ�Ĵ���
				dispose();
				//���´���һ���µĴ���
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
