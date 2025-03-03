package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener{

	long random;
	JTextField nameTextField,fnameTextField, emailTextField, addressTextField,cityTextField,stateTextField,pincodeTextField;
	JButton next;
	JRadioButton male,female,other, married,unmarried;
	JDateChooser dateChooser;
	
	SignUpOne(){
		setTitle("New Account Application Page - 2");
		setLayout(null);
		
		Random ran = new Random();
		long random = Math.abs((ran.nextLong() % 9000L) + 1000L);
		
		
		JLabel formno = new JLabel("APPLICATION FORM NO. "+ random);
		formno.setFont(new Font("Raleway",Font.BOLD, 38));
		formno.setBounds(120,40,600,40);
		add(formno);
		
		JLabel personalDetails = new JLabel("Page 1: Personal Details");
		personalDetails.setFont(new Font("Raleway",Font.BOLD, 22));
		personalDetails.setBounds(290,80,400,30);
		add(personalDetails);
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Raleway",Font.BOLD, 20));
		name.setBounds(100,140,100,30);
		add(name);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		nameTextField.setBounds(300,140,400,30);
		add(nameTextField);
		
		
		JLabel fname = new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway",Font.BOLD, 20));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		fnameTextField.setBounds(300,190,400,30);
		add(fnameTextField);
		
		JLabel dob = new JLabel("Date of Birth:");
		dob.setFont(new Font("Raleway",Font.BOLD, 20));
		dob.setBounds(100,240,200,30);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300,240,400,30);
		add(dateChooser);
	
		
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway",Font.BOLD, 20));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		
		JLabel email = new JLabel("Email:");
		email.setFont(new Font("Raleway",Font.BOLD, 20));
		email.setBounds(100,340,200,30);
		add(email);
		
		male = new JRadioButton("Male");
		male.setBounds(300, 290, 60, 30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(450, 290, 120, 30);
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		emailTextField.setBounds(300,340,400,20);
		add(emailTextField);
		
		JLabel marital = new JLabel("Marital status:");
		marital.setFont(new Font("Raleway",Font.BOLD, 20));
		marital.setBounds(100,390,200,30);
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBounds(300, 390, 100, 30);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450, 390, 100, 30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		other = new JRadioButton("Other");
		other.setBounds(630, 390, 100, 30);
		other.setBackground(Color.WHITE);
		add(other);
		
		ButtonGroup maritalStatus = new ButtonGroup();
		maritalStatus.add(married);
		maritalStatus.add(unmarried);
		maritalStatus.add(other);
		
		
		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Raleway",Font.BOLD, 20));
		address.setBounds(100,440,200,30);
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		addressTextField.setBounds(300,440,400,30);
		add(addressTextField);
		
		JLabel city = new JLabel("City:");
		city.setFont(new Font("Raleway",Font.BOLD, 20));
		city.setBounds(100,490,200,30);
		add(city);
		
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		cityTextField.setBounds(300,490,400,30);
		add(cityTextField);
		
		JLabel state = new JLabel("State:");
		state.setFont(new Font("Raleway",Font.BOLD, 20));
		state.setBounds(100,540,200,30);
		add(state);
		
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		stateTextField.setBounds(300,540,400,30);
		add(stateTextField);
		
		JLabel pincode = new JLabel("Pincode:");
		pincode.setFont(new Font("Raleway",Font.BOLD, 22));
		pincode.setBounds(100,590,200,30);
		add(pincode);
		
		pincodeTextField = new JTextField();
		pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		pincodeTextField.setBounds(300,590,400,30);
		add(pincodeTextField);
		
		
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setBounds(620,630,80,30);
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
		String formno = "" +random; // long
		String name = nameTextField.getText();
		String fname = fnameTextField.getText();
		String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if (male.isSelected()) {
			gender = "Male";
		}
		else  if
			(female.isSelected()){
			gender = "Female";
		}
		
		String email = emailTextField.getText();
		
		String marrital = null;
		if (married.isSelected()) {
			marrital = "Married";
		}
		else  if
			(unmarried.isSelected()){
			marrital = "Unmarried";
		}
		else  if
		(other.isSelected()){
		marrital = "Other";
	}
		
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pincode = pincodeTextField.getText();
		
		try{
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required");
			}
			else {
				Conn c = new Conn();
				String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marrital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
				c.s.executeUpdate(query);
			}
		}catch(Exception e1) {
			System.out.println(e1);
		}
		

		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new SignUpOne();

	}

	

}
