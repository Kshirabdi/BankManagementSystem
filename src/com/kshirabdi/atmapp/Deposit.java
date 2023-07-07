package com.kshirabdi.atmapp;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

public class Deposit extends JFrame implements ActionListener{
	
	JTextField amount;
	JButton deposit, back;
	String pinnumber;
	
	Deposit(String pinnumber)
	{
		this .pinnumber = pinnumber;
		
		setLayout(null);
		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image image = icon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		icon =new ImageIcon(image);
		
		JLabel imageicon = new JLabel(icon);
		imageicon.setBounds(0,0,900,900);
		add(imageicon);
		
		JLabel text = new JLabel("Enter the amount you want to Deposit");
		text.setBounds(170,300,400,20);
		text.setForeground(Color.white);
		text.setFont(new Font("system",Font.BOLD,14));
		imageicon.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("raleway",Font.BOLD,22));
		amount.setBounds(170,350,320,25);
		imageicon.add(amount);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(355,485,150,30);
		deposit.addActionListener(this);
		imageicon.add(deposit);
		
		back = new JButton("Back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		imageicon.add(back);
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Deposit("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==deposit)
		{
			String snumber = amount.getText();
			Date date = new Date();
			if(snumber.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
			}
			else
			{
				try {
					DBConnection con = new DBConnection();
					String query = "INSERT INTO BANK VALUES ('"+ pinnumber+"', '"+ date+"', 'Deposit','"+snumber+"')";
					con.statement.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+snumber+" Deposited Successfully");
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		}
		else if(e.getSource()== back)
		{
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
		
	}

}
