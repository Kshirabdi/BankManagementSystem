package com.kshirabdi.atmapp;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.Date;
//import java.sql.Date;
public class FastCash extends JFrame implements ActionListener{
	
	String pinnumber;
	JButton option1,option2,option3,option4,option5,option6,back;
	FastCash(String pinnumber)
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
		
		JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
		text.setBounds(215,300,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("system",Font.BOLD,16));
		image.add(text);
		
		option1 = new JButton("Rs 100");
		option1.setBounds(170,417,150,30);
		option1.addActionListener(this);
		image.add(option1);
		
		option2 = new JButton("Rs 500");
		option2.setBounds(355,417,150,30);
		option2.addActionListener(this);
		image.add(option2);
		
		option3 = new JButton("Rs 1000");
		option3.setBounds(170,452,150,30);
		option3.addActionListener(this);
		image.add(option3);
		
		option4 = new JButton("Rs 2000");
		option4.setBounds(355,452,150,30);
		option4.addActionListener(this);
		image.add(option4);
		
		option5 = new JButton("Rs 5000");
		option5.setBounds(170,487,150,30);
		option5.addActionListener(this);
		image.add(option5);
		
		option6 = new JButton("Rs 10000");
		option6.setBounds(355,487,150,30);
		option6.addActionListener(this);
		image.add(option6);
		
		back = new JButton("Back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true); //alwaye at end because after set visible what ever we wrote its not visible
		
		
	}

	public static void main(String[] args) {
		new FastCash ("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == back)
		{
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
		else 
		{
			String amount = ((JButton)e.getSource()).getText().substring(3);
			DBConnection con = new DBConnection();
			try {

				con.rs=con.statement.executeQuery("SELECT * FROM BANK WHERE PIN =' "+pinnumber+"'");
				int balance = 0;
				while(con.rs.next())
				{
					if(con.rs.getString("TYPE_OF_TRANSACTION").equals("Deposit"))
					{
						balance += Integer.parseInt(con.rs.getString("AMOUNT"));
					}else{
						balance -= Integer.parseInt(con.rs.getString("AMOUNT"));
					}
				}
				if( (e.getSource() != back) && (balance < Integer.parseInt(amount)))
				{
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				
				Date date = new Date();
				
				String query = "INSERT INTO BANK VALUES('"+ pinnumber+"', '"+date+"', 'Withdraw', '"+amount+"')"; 
				con.statement.executeUpdate(query);
//				con.pstmt=con.connection.prepareStatement("INSERT INTO BANK VALUES(?,?,?,?");
//				con.pstmt.setString(1, pinnumber);
//				con.pstmt.setDate(2, new Date(3366144000000L));
//				con.pstmt.setString(3, "Withdraw");
//				con.pstmt.setString(4, amount);
//				con.pstmt.executeUpdate();
				
				
				JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");
				setVisible(false);
				new Transaction(pinnumber).setVisible(true);
				
			}catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
		
		
	}

}
