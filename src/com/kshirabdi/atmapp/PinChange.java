package com.kshirabdi.atmapp;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
	String pinnumber;
	JPasswordField pinTextField,repinTextField;
	JButton changepin , back;
	PinChange(String pinnumber)
	{
		this.pinnumber=pinnumber;
		
		setLayout(null);
		
		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = icon.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		icon = new ImageIcon(i2);
		JLabel image = new JLabel(icon);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setBounds(252,280,500,35);
		text.setForeground(Color.white);
		text.setFont(new Font("system",Font.BOLD,16));
		image.add(text);
		
		JLabel pintext = new JLabel("New  PIN :");
		pintext.setBounds(167,320,180,25);
		pintext.setForeground(Color.white);
		pintext.setFont(new Font("system",Font.BOLD,16));
		image.add(pintext);
		
		pinTextField = new JPasswordField();
		pinTextField.setFont(new Font("raleway",Font.BOLD,25));
		pinTextField.setBounds(330, 320, 180, 30);
		image.add(pinTextField);

		JLabel repintext = new JLabel("Re-Enter New  PIN :");
		repintext.setBounds(167,360,180,25);
		repintext.setForeground(Color.white);
		repintext.setFont(new Font("system",Font.BOLD,16));
		image.add(repintext);
		
		repinTextField = new JPasswordField();
		repinTextField.setFont(new Font("raleway",Font.BOLD,25));
		repinTextField.setBounds(330, 360, 180, 30);
		image.add(repinTextField);
		
		changepin = new JButton("CHANGE");
		changepin.setBounds(355, 485, 150, 30);
		changepin.addActionListener(this);
		image.add(changepin);
		
		back = new JButton("BACK");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true); //alwaye at end because after set visible what ever we wrote its not visible
		
	}

	public static void main(String[] args) {
		new PinChange("").setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == changepin) {
			try {
				String newpin =pinTextField.getText();
				String repin = repinTextField.getText();
			
				if(!newpin.equals(repin))
				{
					JOptionPane.showMessageDialog(null, "PIN does not match!!");
					return;
				}
				
				if(newpin.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please enter new PIN");
					return;
				}
				
				if(repin.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please re-Enter New PIN");
					return;
				}

					DBConnection con = new DBConnection();
					String query1 = "UPDATE BANK SET PIN = '"+repin+"' WHERE PIN = '"+pinnumber+"'";
					String query2 = "UPDATE LOGIN SET PIN = '"+repin+"' WHERE PIN = '"+pinnumber+"'";
					String query3 = "UPDATE SIGNUPTHREE SET PIN = '"+repin+"' WHERE PIN = '"+pinnumber+"'";
					con.statement.executeUpdate(query1);
					con.statement.executeUpdate(query2);
					con.statement.executeUpdate(query3);
					
					JOptionPane.showMessageDialog(null, "PIN changed Successfully");
					
					setVisible(false);
					new Transaction(repin).setVisible(true);

			
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		
		}
		else if (e.getSource() == back)
		{
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
			
		}
	}

}
