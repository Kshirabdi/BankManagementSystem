package com.kshirabdi.atmapp;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Transaction extends JFrame implements ActionListener{
	
	String pinnumber;
	JButton deposite,withdrawl,fastcash,ministmt,pinchange,balance,exit;
	Transaction(String pinnumber)
	{
		
		this.pinnumber = pinnumber;
		setLayout(null);
		
		setTitle("TRANSACTION");
		
		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = icon.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		icon = new ImageIcon(i2);
		JLabel image = new JLabel(icon);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Please select your Transction");
		text.setBounds(215,300,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("system",Font.BOLD,16));
		image.add(text);
		
		deposite = new JButton("Deposite");
		deposite.setBounds(170,417,150,30);
		deposite.addActionListener(this);
		image.add(deposite);
		
		withdrawl = new JButton("Withdrawl");
		withdrawl.setBounds(355,417,150,30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(170,452,150,30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministmt = new JButton("Mini Statement");
		ministmt.setBounds(355,452,150,30);
		ministmt.addActionListener(this);
		image.add(ministmt);
		
		pinchange = new JButton("Pin Change");
		pinchange.setBounds(170,487,150,30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balance = new JButton("Balance Enquiry");
		balance.setBounds(355,487,150,30);
		balance.addActionListener(this);
		image.add(balance);
		
		exit = new JButton("Exit");
		exit.setBounds(355,520,150,30);
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true); //alwaye at end because after set visible what ever we wrote its not visible
		
		
	}

	public static void main(String[] args) {
		new Transaction ("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == exit)
		{
			System.exit(0);
		}
		else if(e.getSource() == deposite)
		{
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		}
		
		else if(e.getSource() == withdrawl)
		{
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);
		}
		else if (e.getSource() == fastcash)
		{
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		}
		
		else if (e.getSource() == pinchange)
		{
			setVisible(false);
			new PinChange(pinnumber).setVisible(true);
		}
		
		else if (e.getSource() == balance)
		{
			setVisible(false);
			new BalanceEnquiry(pinnumber).setVisible(true);
		}
		
		else if (e.getSource() == ministmt)
		{
			new MiniStatement(pinnumber).setVisible(true);
		}
		
		
	}

}
