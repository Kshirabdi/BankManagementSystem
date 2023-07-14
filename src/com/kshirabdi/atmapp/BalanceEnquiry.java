package com.kshirabdi.atmapp;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
	String pinnumber;
	JButton back;
	int balance =0;
	BalanceEnquiry(String pinnumber)
	{
		this.pinnumber = pinnumber;
		
		setLayout(null);
		
		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = icon.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		icon = new ImageIcon(i2);
		JLabel image = new JLabel(icon);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		back = new JButton("Back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
		try {
			DBConnection con = new DBConnection();
			con.rs = con.statement.executeQuery("SELECT * FROM BANK WHERE PIN ='"+pinnumber+"' ");
			while(con.rs.next())
			{
				
				if(con.rs.getString("TYPE_OF_TRANSACTION").equals("Deposit"))
				{
					balance += Integer.parseInt(con.rs.getString("AMOUNT"));
					
				}else{
					balance -= Integer.parseInt(con.rs.getString("AMOUNT"));
				

				}
			}
					
		}catch(Exception ex)
		{
			System.out.println(ex);
		}

		
		JLabel text = new JLabel ("Your current Account Balance is Rs :"+ balance);
		text.setBounds(170, 300, 400, 30);
		text.setForeground(Color.white);
		image.add(text);
	
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true); //alwaye at end because after set visible what ever we wrote its not visible
		
		
	}

	public static void main(String[] args) {
		new BalanceEnquiry("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Transaction(pinnumber).setVisible(true);
		
	}

}
