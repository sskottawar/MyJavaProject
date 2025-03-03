package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class SignUpTwo extends JFrame implements ActionListener{

	
	JTextField religionTextField,catagoryTextField, incomeTextField, educationalQualificationTextField,occupationTextField,panNoTextField,adhaarNoTextField;
	JButton next;
	JRadioButton yes,no,yes1,no1;
	JDateChooser dateChooser;
	JComboBox religion1,catagory1,income1,educationalQualification1,occupation1;
	String formno;
	
	SignUpTwo(){
		
		this.formno= formno;
		setTitle("New Account Application Page - 2");
		setLayout(null);
		
		
		
		
		JLabel personalDetails = new JLabel("Page 2: Additional Details");
		personalDetails.setFont(new Font("Raleway",Font.BOLD, 22));
		personalDetails.setBounds(290,80,400,30);
		add(personalDetails);
		
		JLabel religion = new JLabel("Religion:");
		religion.setFont(new Font("Raleway",Font.BOLD, 20));
		religion.setBounds(100,140,100,30);
		add(religion);
		
		String valReligion[] = {"Hindu", "Muslim", "Sikh", "Cristian", "Other"};
		religion1 = new JComboBox(valReligion);
		religion1.setBackground(Color.WHITE);
		religion1.setBounds(300,140,400,30);
		add(religion1);
	
		
		JLabel catagory = new JLabel("Catagory:");
		catagory.setFont(new Font("Raleway",Font.BOLD, 20));
		catagory.setBounds(100,190,200,30);
		add(catagory);
		
		String valCatagory[] = {"General", "OBC", "ST", "SC", "Other"};
		catagory1 = new JComboBox(valCatagory);
		catagory1.setBackground(Color.WHITE);
		catagory1.setBounds(300,190,400,30);
		add(catagory1);
		
		JLabel income = new JLabel("Income:");
		income.setFont(new Font("Raleway",Font.BOLD, 20));
		income.setBounds(100,240,200,30);
		add(income);
		
		String valIncome[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
		income1 = new JComboBox(valIncome);
		income1.setBackground(Color.WHITE);
		income1.setBounds(300,240,400,30);
		add(income1);
		
		JLabel EducationalQualification = new JLabel("Educational Qualification:");
		EducationalQualification.setFont(new Font("Raleway",Font.BOLD, 20));
		EducationalQualification.setBounds(100,290,200,30);
		add(EducationalQualification);
		
		String valEduQua[] = {"UnderGraduate", "Graduate", "Post Graduate","Doctarate", "Other"};
		educationalQualification1 = new JComboBox(valEduQua);
		educationalQualification1.setBackground(Color.WHITE);
		educationalQualification1.setBounds(300,290,400,30);
		add(educationalQualification1);
		
		JLabel occupation = new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway",Font.BOLD, 20));
		occupation.setBounds(100,340,200,30);
		add(occupation);
		
		String valoccupation[] = {"Engineer", "Doctor", "Business", "Student","Other"};
		occupation1 = new JComboBox(valoccupation);
		occupation1.setBackground(Color.WHITE);
		occupation1.setBounds(300,340,400,30);
		add(occupation1);
		
		JLabel panNo = new JLabel("Pan No:");
		panNo.setFont(new Font("Raleway",Font.BOLD, 22));
		panNo.setBounds(100,390,200,30);
		add(panNo);
		
		panNoTextField = new JTextField();
		panNoTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		panNoTextField.setBounds(300,390,400,30);
		add(panNoTextField);
		
		JLabel adhaarNo = new JLabel("Adhaar No:");
		adhaarNo.setFont(new Font("Raleway",Font.BOLD, 22));
		adhaarNo.setBounds(100,440,200,30);
		add(adhaarNo);
		
		adhaarNoTextField = new JTextField();
		adhaarNoTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		adhaarNoTextField.setBounds(300,440,400,30);
		add(adhaarNoTextField);
		
		
	
		
		JLabel seniorCitizen = new JLabel("Senior Citizen:");
		seniorCitizen.setFont(new Font("Raleway",Font.BOLD, 20));
		seniorCitizen.setBounds(100,490,200,30);
		add(seniorCitizen);
		
		
		yes = new JRadioButton("Yes");
		yes.setBounds(300, 490, 60, 30);
		yes.setBackground(Color.WHITE);
		add(yes);
		
		no = new JRadioButton("No");
		no.setBounds(450, 490, 120, 30);
		no.setBackground(Color.WHITE);
		add(no);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(yes);
		gendergroup.add(no);
		
		
		
		
		JLabel existingAccount = new JLabel("Existing Account:");
		existingAccount.setFont(new Font("Raleway",Font.BOLD, 20));
		existingAccount.setBounds(100,540,200,30);
		add(existingAccount);
		
		yes1 = new JRadioButton("Yes");
		yes1.setBounds(300, 540, 100, 30);
		yes1.setBackground(Color.WHITE);
		add(yes1);
		
		no1 = new JRadioButton("No");
		no1.setBounds(450, 540, 100, 30);
		no1.setBackground(Color.WHITE);
		add(no1);
		
		
		
		ButtonGroup existingAccount1 = new ButtonGroup();
		existingAccount1.add(yes1);
		existingAccount1.add(no1);

		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setBounds(620,590,80,30);
		add(next);
		next.addActionListener(this);
		
		
		
		
		
		
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850,800);
		setVisible(true);
		setLocation(350,10);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String Religion = (String)religion1.getSelectedItem();
		String Catagory = (String) catagory1.getSelectedItem();
		String Income = (String) income1.getSelectedItem();
		String EducationalQualification= (String) educationalQualification1.getSelectedItem();
		String Occupation= (String) occupation1.getSelectedItem();;
		String PanNo = panNoTextField.getText();
		String  AdhaarNo= adhaarNoTextField.getText();
		String SeniorCitizen = null;
		if (yes.isSelected()) {
			SeniorCitizen = "Yes";
		}
		else  if
			(no.isSelected()){
			SeniorCitizen = "No";
		}
		

		String ExistingAccount = null;
		if (yes1.isSelected()) {
			ExistingAccount = "Yes";
		}
		else  if
			(no1.isSelected()){
			ExistingAccount = "No";
		}
		
	
		
		
		try{
			if(Religion.equals("")) {
				JOptionPane.showMessageDialog(null, "Religion is Required");
			}
			else {
				Conn c = new Conn();
				String query = "insert into signupTwo values('"+formno+"','"+Religion+"','"+Catagory+"','"+Income+"','"+EducationalQualification+"','"+Occupation+"','"+PanNo+"','"+AdhaarNo+"','"+SeniorCitizen+"','"+ExistingAccount+"')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new SignUpThree(formno).setVisible(true);
			}
		}catch(Exception e1) {
			System.out.println(e1);
		}
		

		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new SignUpTwo();

	}

	

}
