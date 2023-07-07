
/*
 * Sign up form 2
 * Additional details
 */
package com.kshirabdi.atmapp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SignUpTwo extends JFrame implements ActionListener{
	
	JTextField aadharTextField,panTextField;
	JRadioButton syes,sno,hyes,hno;
	JButton next;
	JComboBox religion,category,income,educationalQualification,occupation;
	String formno;
	SignUpTwo(String formno)
	{
		this.formno=formno;
		setLayout(null);
		
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		additionalDetails.setBounds(290,80,400,30);
		add(additionalDetails);
		
		JLabel setReligion = new JLabel("Religion :");
		setReligion.setFont(new Font("Raleway",Font.BOLD,20));
		setReligion.setBounds(100,140,200,30);
		add(setReligion);
		
		String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
		religion = new JComboBox(valReligion);
		religion.setBounds(300, 140, 400, 30);
		religion.setBackground(Color.white);
		add(religion);
		
		JLabel setCategoty = new JLabel("Category :");
		setCategoty.setFont(new Font("Raleway",Font.BOLD,20));
		setCategoty.setBounds(100,190,200,30);
		add(setCategoty);
		
		String valCategory[] = {"General","OBC","SC","ST","SEBC","Other"};
		category = new JComboBox(valCategory);
		category.setBounds(300, 190, 400, 30);
		category.setBackground(Color.white);
		add(category);
		
		JLabel setIncome = new JLabel("Income :");
		setIncome.setFont(new Font("Raleway",Font.BOLD,20));
		setIncome.setBounds(100,240,200,30);
		add(setIncome);
		
		String valIncome[]={"Null","<1,50,000","< 2,50,000","<5,00,000","Upto 10,00,000"};
		income = new JComboBox(valIncome);
		income.setBounds(300, 240, 400, 30);
		income.setBackground(Color.white);
		add(income);
		
		JLabel edu = new JLabel("Educational ");
		edu.setFont(new Font("Raleway",Font.BOLD,20));
		edu.setBounds(100,290,200,30);
		add(edu);
		
		JLabel setqalification = new JLabel("Qualification :");
		setqalification.setFont(new Font("Raleway",Font.BOLD,20));
		setqalification.setBounds(100,315,200,30);
		add(setqalification);
		
		String valEducationalQualification[]={"Intermediate","Graduation","Post graduation","Doctrate","Other"};
		educationalQualification = new JComboBox(valEducationalQualification);
		educationalQualification.setBounds(300, 315, 400, 30);
		educationalQualification.setBackground(Color.white);
		add(educationalQualification);
		
		JLabel setOccupation = new JLabel("Occupation :");
		setOccupation.setFont(new Font("Raleway",Font.BOLD,20));
		setOccupation.setBounds(100,390,200,30);
		add(setOccupation);
		
		String valOccupation[]={"Self employeed","Salaried","Student","Business","Retired","Other"};
		occupation = new JComboBox(valOccupation);
		occupation .setBounds(300, 390, 400, 30);
		occupation .setBackground(Color.white);
		add(occupation);
		
		JLabel pan = new JLabel("PAN Number :");
		pan.setFont(new Font("Raleway",Font.BOLD,20));
		pan.setBounds(100,440,200,30);
		add(pan);
		
		panTextField = new JTextField();
		panTextField.setFont(new Font("raleway",Font.BOLD,14));
		panTextField.setBounds(300, 440, 400, 30);
		add(panTextField);
		
		JLabel aadharNo = new JLabel("Aadhar number :");
		aadharNo.setFont(new Font("Raleway",Font.BOLD,20));
		aadharNo.setBounds(100,490,200,30);
		add(aadharNo);
		
		aadharTextField = new JTextField();
		aadharTextField.setFont(new Font("raleway",Font.BOLD,14));
		aadharTextField.setBounds(300, 490, 400, 30);
		add(aadharTextField);
		
		JLabel seniorCitizzen = new JLabel("Senior Citizzen :");
		seniorCitizzen.setFont(new Font("Raleway",Font.BOLD,20));
		seniorCitizzen.setBounds(100,540,200,30);
		add(seniorCitizzen);
		
		syes = new JRadioButton("Yes");
		syes.setBounds(300,540,80,30);
		syes.setBackground(Color.white);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(400,540,80,30);
		sno.setBackground(Color.white);
		add(sno);
		
		ButtonGroup seniorCitizen =new ButtonGroup();
		seniorCitizen.add(syes);
		seniorCitizen.add(sno);
		
		
		JLabel haveAccount = new JLabel("Existing Account :");
		haveAccount.setFont(new Font("Raleway",Font.BOLD,20));
		haveAccount.setBounds(100,590,200,30);
		add(haveAccount);
		
		hyes = new JRadioButton("Yes");
		hyes.setBounds(300,590,80,30);
		hyes.setBackground(Color.white);
		add(hyes);
		
		hno = new JRadioButton("No");
		hno.setBounds(400,590,80,30);
		hno.setBackground(Color.white);
		add(hno);
		
		ButtonGroup accountGroup =new ButtonGroup();
		accountGroup.add(hyes);
		accountGroup.add(hno);
		
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
		
		new SignUpTwo("");
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String sreligion = (String)religion.getSelectedItem();
		String scategory = (String)category.getSelectedItem();
		String sincome = (String)income.getSelectedItem();
		String education = (String)educationalQualification.getSelectedItem();
		String soccupation = (String)occupation.getSelectedItem();
		String pan = panTextField.getText();
		String aadhar = aadharTextField.getText();
		String isSeniorCitizen=null;
		if(syes .isSelected()) {
			isSeniorCitizen = "Yes";
		}
		else if(sno.isSelected())
		{
			isSeniorCitizen = "No";
		}
		String haveAccount = null;

		if(hyes.isSelected())
		{
			haveAccount= "Yes";
		}
		else if(hno .isSelected())
		{
			haveAccount = "No";
		}
		
		try {
			if(sreligion.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Select Religion");
			}
			
			if(scategory.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Select Category ");
			}
			
			if(sincome.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Select Income");
			}
			
			if(education.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Select Education");
			}
			
			if(soccupation.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Select Occupation");
			}
			
			if(pan.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Fill the PAN Number");
			}
			
			if(aadhar.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Fill the Aadhar Number");
			}
			
			if(isSeniorCitizen == null)
			{
				JOptionPane.showMessageDialog(null, "Select the Senior citizen ");
			}
			
			if(haveAccount == null)
			{
				JOptionPane.showMessageDialog(null, "Select existing Account");
			}
			
			else
			{
				DBConnection con = new DBConnection();

				//String query = "INSERT INTO SIGNUP VALUES('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+
														//	email+"','"+maritalStatus+"','"+address+"','"+city+"','"+state+",'"+pin+"')";
				//con.statement.executeUpdate(query);
				con.pstmt = con.connection.prepareStatement("INSERT INTO SIGNUPTWO VALUES(?,?,?,?,?,?,?,?,?,?)");
				con.pstmt.setString(1,formno);
				con.pstmt.setString(2,sreligion);
				con.pstmt.setString(3,scategory);
				con.pstmt.setString(4,sincome);
				con.pstmt.setString(5,education);
				con.pstmt.setString(6,soccupation);
				con.pstmt.setString(7,pan);
				con.pstmt.setString(8,aadhar);
				con.pstmt.setString(9,isSeniorCitizen);
				con.pstmt.setString(10,haveAccount);
				con.pstmt.executeUpdate();
				
				
				setVisible(false);
				new SignUpThree(formno).setVisible(true);
				
			}			
			
			
		}catch(Exception e1)
		{
			e1.fillInStackTrace();
		}
		
	}

}


