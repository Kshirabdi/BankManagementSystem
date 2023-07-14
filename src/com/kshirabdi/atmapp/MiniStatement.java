package com.kshirabdi.atmapp;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class MiniStatement extends JFrame implements ActionListener {
	String pinnumber;
	int rupees = 0;
	MiniStatement(String pinnumber)
	{
		this.pinnumber = pinnumber;
		
		setLayout(null);
		setTitle("Mini Statement");
		
		JLabel mini = new JLabel();
	
		add(mini);
		
		JLabel bank = new JLabel(" STATE BANK OF INDIA");
		bank.setBounds(130, 20, 200, 20);
		add(bank);
		
		JLabel balance = new JLabel();
		balance.setBounds(20, 400, 300, 20);
		add(balance);
		
		JLabel card = new JLabel();
		card.setBounds(20, 80, 300, 20);
		add(card);
		
		try {
			
			DBConnection con = new DBConnection();
			con.rs=con.statement.executeQuery("SELECT * FROM LOGIN WHERE PIN = '"+pinnumber+"'");
			while(con.rs.next())
			{
				card.setText("Card Number : "+ con.rs.getString("CARDNUMBER").substring(0,4)+"XXXXXXXX"+con.rs.getString("CARDNUMBER").substring(12));
			}
			
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		try {
			DBConnection con = new DBConnection();
			
			con.rs=con.statement.executeQuery("SELECT * FROM BANK WHERE PIN = '"+pinnumber+"'");
			while(con.rs.next())
			{
				mini.setText(mini.getText()+"<html>"+con.rs.getString("DATE_OF_TRANSACTION")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
							con.rs.getString("TYPE_OF_TRANSACTION")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
							con.rs.getString("AMOUNT")+"<br><br><html>");
				
				if(con.rs.getString("TYPE_OF_TRANSACTION").equals("Deposit"))
				{
					rupees += Integer.parseInt(con.rs.getString("AMOUNT"));
				}else{
					rupees -= Integer.parseInt(con.rs.getString("AMOUNT"));
				}
			}
			balance.setText("Your current account balance is Rs "+ rupees);
			
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
		mini.setBounds(20, 140, 400, 200);
		
		setSize(400,600);
		setLocation(20,20);
		//setUndecorated(true);
		getContentPane().setBackground(Color.white);
		setVisible(true); //alwaye at end because after set visible what ever we wrote its not visible
		
		
		
	}
	
	

	public static void main(String[] args) {
		new MiniStatement("");

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
