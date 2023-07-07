/**
 * sign up form /final form 
 * Bank details and services
 */

package com.kshirabdi.atmapp;

import java.awt.*;

import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class SignUpThree extends JFrame implements ActionListener{
	
	JRadioButton current,savings,fda,rda;
	JCheckBox atmcard,ebanking,mbanking,alert,cbook,estmt,declaration;
	JButton submit,cancel;
	String formno;
	
	SignUpThree(String formno)
	{
		this.formno=formno;
		setLayout(null);
		
		JLabel l1 = new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Raleway",Font.BOLD,22));
		l1.setBounds(280, 40, 400, 40);
		add(l1);
		
		JLabel type = new JLabel("Account Type");
		type.setFont(new Font("Raleway",Font.BOLD,22));
		type.setBounds(100, 140, 200, 30);
		add(type);
		
		savings= new JRadioButton("Saving Account");
		savings.setFont(new Font("raleway",Font.BOLD,16));
		savings.setBackground(Color.white);
		savings.setBounds(100,180,150,20);
		add(savings);
		
		fda= new JRadioButton("Fixed Diposit Account");
		fda.setFont(new Font("raleway",Font.BOLD,16));
		fda.setBackground(Color.white);
		fda.setBounds(350,180,250,20);
		add(fda);
		
		current= new JRadioButton("Current Account");
		current.setFont(new Font("raleway",Font.BOLD,16));
		current.setBackground(Color.white);
		current.setBounds(100,220,150,20);
		add(current);
		
		rda= new JRadioButton("Reccuring Deposite Account");
		rda.setFont(new Font("raleway",Font.BOLD,16));
		rda.setBackground(Color.white);
		rda.setBounds(350,220,250,20);
		add(rda);
		
		ButtonGroup accountGroup = new ButtonGroup();
		accountGroup.add(current);
		accountGroup.add(savings);
		accountGroup.add(fda);
		accountGroup.add(rda);
		
		JLabel card = new JLabel("Card Number");
		card.setFont(new Font("Raleway",Font.BOLD,22));
		card.setBounds(100, 300, 200, 30);
		add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-2428");
		number.setFont(new Font("Raleway",Font.BOLD,22));
		number.setBounds(350, 300, 400, 30);
		add(number);
		
		JLabel cardDetails = new JLabel("Your 16 Digit Card Number ");
		cardDetails.setFont(new Font("Raleway",Font.BOLD,12));
		cardDetails.setBounds(100, 330, 200, 15);
		add(cardDetails);
		
		
		JLabel pin = new JLabel("PIN :");
		pin.setFont(new Font("Raleway",Font.BOLD,22));
		pin.setBounds(100, 370, 200, 30);
		add(pin);
		
		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway",Font.BOLD,22));
		pnumber.setBounds(350, 370, 400, 30);
		add(pnumber);
		
		JLabel pinDetails = new JLabel("Your 4 Digit Password ");
		pinDetails.setFont(new Font("Raleway",Font.BOLD,12));
		pinDetails.setBounds(100, 400, 200, 15);
		add(pinDetails);
		
		JLabel services = new JLabel("Services Required :");
		services.setFont(new Font("Raleway",Font.BOLD,22));
		services.setBounds(100, 440, 300, 30);
		add(services);
		
		atmcard = new JCheckBox("ATM CARD");
		atmcard.setFont(new Font("raleway",Font.BOLD,16));
		atmcard.setBounds(100,500,200,30);
		atmcard.setBackground(Color.white);
		add(atmcard);
		
		ebanking = new JCheckBox("Internet Banking");
		ebanking.setFont(new Font("raleway",Font.BOLD,16));
		ebanking.setBounds(350,500,200,30);
		ebanking.setBackground(Color.white);
		add(ebanking);
		
		mbanking = new JCheckBox("Mobile Banking");
		mbanking.setFont(new Font("raleway",Font.BOLD,16));
		mbanking.setBounds(100,550,200,30);
		mbanking.setBackground(Color.white);
		add(mbanking);
		
		alert = new JCheckBox("Email & SMS Alerts");
		alert.setFont(new Font("raleway",Font.BOLD,16));
		alert.setBounds(350,550,200,30);
		alert.setBackground(Color.white);
		add(alert);
		
		cbook = new JCheckBox("Check Book");
		cbook.setFont(new Font("raleway",Font.BOLD,16));
		cbook.setBounds(100,600,200,30);
		cbook.setBackground(Color.white);
		add(cbook);
		
		estmt = new JCheckBox("E-Statement");
		estmt.setFont(new Font("raleway",Font.BOLD,16));
		estmt.setBounds(350,600,200,30);
		estmt.setBackground(Color.white);
		add(estmt);
		
		declaration = new JCheckBox("I hearby declare that the above entered details are correct to the best of my knowledge.");
		declaration.setFont(new Font("raleway",Font.BOLD,12));
		declaration.setBounds(100,680,600,30);
		declaration.setBackground(Color.white);
		add(declaration);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setFont(new Font("raleway",Font.BOLD,14));
		submit.setBounds(220,720,100,30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("raleway",Font.BOLD,14));
		cancel.setBounds(420,720,100,30);
		cancel.addActionListener(this);
		add(cancel);
		
		
		getContentPane().setBackground(Color.white);
		
		setSize(850,820);
		setLocation(350,0);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new SignUpThree(" ");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submit)
		{
			String accountType = null;
			if(savings.isSelected())
			{
				accountType = "Saving Account";
			}
			else if(current.isSelected())
			{
				accountType ="Current Account";
			}
			else if(fda.isSelected())
			{
				accountType ="Fixed Diposit Account";
			}
			else if(rda.isSelected())
			{
				accountType ="Reccuring Deposite Account";
			}

			Random random = new Random(); 
			String cardnumber=""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);		
			
			String pinnumber=""+Math.abs((random.nextLong()%9000L)+1000L);
			
			String facility ="";
			if(atmcard .isSelected())
			{
				facility = facility+" ATM CARD";
			}
			else if(ebanking.isSelected())
			{
				facility = facility+" Internet Banking";
			}
			else if(mbanking.isSelected())
			{
				facility = facility + " Mobile Banking";
			}
			else if(alert.isSelected())
			{
				facility= facility + " Email & SMS Alert"; 
			}
			else if(cbook.isSelected())
			{
				facility = facility+" Check Book";
			}
			else if(estmt.isSelected())
			{
				facility= facility + " E-Statement";
			}
			
			
			try {
				
				if(facility.equals(""))
				{
					JOptionPane.showMessageDialog(null, "No services selected");
				}
				
				if(accountType.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Account Type required"); //if any option not choosen
				}
				if(!(declaration.isSelected()))
				{
					JOptionPane.showMessageDialog(null, "Check the Declaration");
				}
				else {
				
				
				DBConnection con = new DBConnection();
				con.pstmt= con.connection.prepareStatement("INSERT INTO SIGNUPTHREE VALUES(?,?,?,?,?) ");
				con.pstmt.setString(1, formno);
				con.pstmt.setString(2,accountType);
				con.pstmt.setString(3,cardnumber);
				con.pstmt.setString(4, pinnumber);
				con.pstmt.setString(5, facility);
				con.pstmt.executeUpdate();
				
				con.pstmt= con.connection.prepareStatement("INSERT INTO LOGIN VALUES(?,?,?) ");
				con.pstmt.setString(1, formno);
				con.pstmt.setString(2,cardnumber);
				con.pstmt.setString(3, pinnumber);
				con.pstmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null,"Card Number : "+cardnumber +"\nPin : "+pinnumber );
				
				setVisible(false);
				new Deposit(pinnumber).setVisible(true);
				
				}	
				
				
			}catch(Exception e1)
			{
				System.out.println(e1);
			}
			
			
			
		}
		else if(e.getSource() == cancel)
		{
			setVisible(false);
			new Login().setVisible(true);
		}

		
	}

}
