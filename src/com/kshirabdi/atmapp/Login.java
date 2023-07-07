package com.kshirabdi.atmapp;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	
	JButton login,clear,signup;
	JTextField cardTextField;
	JPasswordField pinTextField;

	public Login(){
		
		setTitle("AUTOMATED TELLER MACHINE"); // setTitle set the title of the frame
		
		setLayout(null);
		
		
		/**
		 * image for log in page 
		 * and set the size as well as location
		 */
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		i1 = new ImageIcon(i2);
		/**
		 * //we can not pass Image class obj to JLable constructor so change the type to ImageIcon
		 * the pass
		 */
		JLabel label = new JLabel(i1);
		label.setBounds(70,10,100,100);
		add(label);
		
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(200,40,400,40);
		add(text);
		
		JLabel cardNo = new JLabel("Card No:");
		cardNo.setFont(new Font("Raleway",Font.BOLD,28));
		cardNo.setBounds(120,150,150,30);
		add(cardNo);
		
		cardTextField = new JTextField();
		cardTextField.setBounds(300, 150, 230, 30);
		cardTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(cardTextField);
		
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway",Font.BOLD,28));
		pin.setBounds(120,220,150,30);
		add(pin);
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(300, 220, 230, 30);
		pinTextField.setFont(new Font("Georgia",Font.BOLD,14));
		add(pinTextField);
		
		login = new JButton("SIGN IN");
		login.setBounds(300, 300, 100, 30);
		login.setBackground(Color.black);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBounds(430, 300, 100, 30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup.setBounds(300, 350, 230, 30);
		signup.setBackground(Color.black);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
		
		getContentPane().setBackground(Color.white);
		
		
		setSize(800,480); //to create frame size with dimension (800,480)
		setVisible(true); //to make the frame visible we need to set setVisible (true) 
		setLocation(300,200); //seting the frame location 
		
		

		

		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == login)
		{
			DBConnection con = new DBConnection();
			String cardnumber = cardTextField.getText();
			String pinnumber = pinTextField.getText();
			String query = "SELECT * FROM LOGIN WHERE CARDNUMBER = '"+cardnumber+"' AND PIN ='"+pinnumber+"'";
			
			try {
				con.rs=con.statement.executeQuery(query);
				if(con.rs.next())
				{
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect card number or pin");
				}
			}catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
		else if(ae.getSource() == clear )
		{
			cardTextField.setText("");
			pinTextField.setText("");
			
		}
		else if(ae.getSource()== signup)
		{
			setVisible(false);
			new SignUpOne().setVisible(true);
			
		}
		
	}

	public static void main(String[] args) {
		new Login();
		

	}

}
