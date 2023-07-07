/*
 * Sign up form 1
 * 
 * Personal Details
 */


package com.kshirabdi.atmapp;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.*;

import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener{
	
	long no;
	JTextField nameTextField,fnameTextField,emailTextField,stateTextField,pinTextField,addressTextField,cityTextField;
	JRadioButton male,female,other,married,unmarried;
	JDateChooser dateChooser;
	JButton next;
	SignUpOne()
	{
		setLayout(null);
		
		
		Random random = new Random();
		no=Math.abs((random.nextInt()%9000L) + 1000L);
		
		JLabel formno = new JLabel("APPLICATION FORM NO. "+no);
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(140,20,600,40);
		add(formno);
		
		JLabel personalDetails = new JLabel("Page 1: Personal Details");
		personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		personalDetails.setBounds(290,80,400,30);
		add(personalDetails);
		
		JLabel name = new JLabel("Name :");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100,140,200,30);
		add(name);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("raleway",Font.BOLD,14));
		nameTextField.setBounds(300, 140, 400, 30);
		add(nameTextField);
		
		JLabel fname = new JLabel("Father's Name :");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("raleway",Font.BOLD,14));
		fnameTextField.setBounds(300, 190, 400, 30);
		add(fnameTextField);
		
		JLabel dob = new JLabel("Date of Birth :");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(100,240,200,30);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300,240,400,30);
		dateChooser.setForeground(new Color(105,105,105));
		add(dateChooser);
		
		JLabel gender = new JLabel("Gender :");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300, 290, 60, 30);
		male.setBackground(Color.white);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(450, 290, 100, 30);
		female.setBackground(Color.white);
		add(female);
		
		other = new JRadioButton("Other");
		other.setBounds(630, 290, 100, 30);
		other.setBackground(Color.white);
		add(other);
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		genderGroup.add(other);
		
		JLabel email = new JLabel("Email Address :");
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(100,340,200,30);
		add(email);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("raleway",Font.BOLD,14));
		emailTextField.setBounds(300, 340, 400, 30);
		add(emailTextField);
		
		JLabel maritalStatus = new JLabel("Marital Status :");
		maritalStatus.setFont(new Font("Raleway",Font.BOLD,20));
		maritalStatus.setBounds(100,390,200,30);
		add(maritalStatus);
		
		married = new JRadioButton("Married");
		married.setBounds(300, 390, 100, 30);
		married.setBackground(Color.white);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450, 390, 100, 30);
		unmarried.setBackground(Color.white);
		add(unmarried);
		
		other = new JRadioButton("Other");
		other.setBounds(630, 390, 100, 30);
		other.setBackground(Color.white);
		add(other);
		
		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(married);
		maritalGroup.add(unmarried);
		maritalGroup.add(other);
		
		JLabel address = new JLabel("Address :");
		address.setFont(new Font("Raleway",Font.BOLD,20));
		address.setBounds(100,440,200,30);
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("raleway",Font.BOLD,14));
		addressTextField.setBounds(300, 440, 400, 30);
		add(addressTextField);
		
		JLabel city = new JLabel("City :");
		city.setFont(new Font("Raleway",Font.BOLD,20));
		city.setBounds(100,490,200,30);
		add(city);
		
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("raleway",Font.BOLD,14));
		cityTextField.setBounds(300, 490, 400, 30);
		add(cityTextField);
		
		JLabel state = new JLabel("State :");
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(100,540,200,30);
		add(state);
		
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("raleway",Font.BOLD,14));
		stateTextField.setBounds(300, 540, 400, 30);
		add(stateTextField);
		
		JLabel pin = new JLabel("Pin Code :");
		pin.setFont(new Font("Raleway",Font.BOLD,20));
		pin.setBounds(100,590,200,30);
		add(pin);
		
		pinTextField = new JTextField();
		pinTextField.setFont(new Font("raleway",Font.BOLD,14));
		pinTextField.setBounds(300, 590, 400, 30);
		add(pinTextField);
		
		
		next = new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("raleway",Font.BOLD,14));
		next.setBounds(620, 660, 80, 30);
		add(next);
		next.addActionListener(this);
		
		
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850,800);
		setVisible(true);
		setLocation(350 , 10);
		
	}

	public static void main(String[] args) {
		
		new SignUpOne();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String formno = ""+no;//long to string
		String name = nameTextField.getText();//through get text we get the name through set text we set the name
		String fname = fnameTextField.getText();
		String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if(male .isSelected()) {
			gender = "Male";
		}
		else if(female.isSelected())
		{
			gender = "Female";
		}
		else if(other.isSelected())
		{
			gender = "Other";
		}
		String email = emailTextField.getText();
		String state = stateTextField.getText();
		String address = addressTextField.getText();
		String pin = pinTextField.getText();
		String city = cityTextField.getText();
		String maritalStatus = null;
		if(married.isSelected())
		{
			maritalStatus= "Married";
		}
		else if(unmarried .isSelected())
		{
			maritalStatus = "Unmarried";
		}
		else if(other .isSelected())
		{
			maritalStatus = "Other";
		}
		
		try {
			if(name.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Name Required");
			}
			
			if(fname.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Fill Father's name ");
			}
			
			if(dob.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Fill Date of Birth");
			}
			
			if(gender == null)
			{
				JOptionPane.showMessageDialog(null, "Gender field is Empty");
			}
			
			if(email.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Email Required");
			}
			
			if(maritalStatus == null)
			{
				JOptionPane.showMessageDialog(null, "Marital Status Required");
			}
			
			if(address.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Fill the Addess");
			}
			
			if(city.equals(""))
			{
				JOptionPane.showMessageDialog(null, "City Required");
			}
			
			if(state.equals(""))
			{
				JOptionPane.showMessageDialog(null, "State Required");
			}
			
			if(pin.equals(""))
			{
				JOptionPane.showMessageDialog(null, "PIN Required");
			}
			else
			{
				DBConnection con = new DBConnection();
				//String query = "INSERT INTO SIGNUP VALUES('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+
														//	email+"','"+maritalStatus+"','"+address+"','"+city+"','"+state+",'"+pin+"')";
				//con.statement.executeUpdate(query);
				con.pstmt = con.connection.prepareStatement("INSERT INTO SIGNUP VALUES(?,?,?,?,?,?,?,?,?,?,?)");
				con.pstmt.setString(1,formno);
				con.pstmt.setString(2,name);
				con.pstmt.setString(3,fname);
				con.pstmt.setString(4,dob);
				con.pstmt.setString(5,gender);
				con.pstmt.setString(6,email);
				con.pstmt.setString(7,maritalStatus);
				con.pstmt.setString(8,address);
				con.pstmt.setString(9,city);
				con.pstmt.setString(10,state);
				con.pstmt.setString(11,pin);
				con.pstmt.executeUpdate();
				
				setVisible(false);
				new SignUpTwo(formno).setVisible(true);
				
				
			}			

			
		}catch(Exception e1)
		{
			e1.fillInStackTrace();
		}
		
	}

}
