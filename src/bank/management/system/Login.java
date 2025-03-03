package bank.management.system;
import java.awt.*;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public  class Login extends JFrame implements ActionListener{
	JButton login, signup,clear;
	JTextField cardTextField; 
	JPasswordField pinTextField;
	
	Login(){
		setTitle("Automated Tellar Machine");
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons1/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		ImageIcon i3 =new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		
		label.setBounds(70,10,100,100);
		add(label);
		
		JLabel text = new JLabel("Welcome To ATM");
		text.setFont(new Font("Osward",Font.BOLD, 38));
		text.setBounds(250,40,500,40);
		add(text);
		
		JLabel cardno = new JLabel("CARD NO: ");
		cardno.setFont(new Font("Raleway",Font.BOLD, 20));
		cardno.setBounds(120,150,150,20);
		add(cardno);
		
		cardTextField = new JTextField();
		cardTextField.setBounds(300, 150, 230, 30);
		cardTextField.setFont(new Font("Areal", Font.BOLD,14));
		add(cardTextField);
		
		JLabel pin = new JLabel("PIN: ");
		pin.setFont(new Font("Raleway",Font.BOLD, 20));
		pin.setBounds(120,220,250,20);
		add(pin);
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(300, 220, 230, 30);
		add(pinTextField);
		
		
		login = new JButton("SIGN IN");
		login.setBounds(300, 300, 100, 30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		

		clear = new JButton("CLEAR");
		clear.setBounds(430, 300, 100, 30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup.setBounds(300, 350, 230, 30);
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.addActionListener(this);
		add(signup);
		
		getContentPane().setBackground(Color.white);
		
		setSize(750,500);
		setLocation(300,0);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()== clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		}else if(ae.getSource()== login) {
			Conn conn= new Conn();
			String cardnumber = cardTextField.getText();
			String pinnumber = pinTextField.getText();
			String query = "Select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
		    try {
		    	ResultSet rs = conn.s.executeQuery(query);
		    	if(rs.next()) {
		    		setVisible(false);
		    		new Transactions(query).setVisible(true);
		    	}
		    	else
		    	{
		    		JOptionPane.showMessageDialog(null, "Incorrect card no or pin");
		    	}
		    }
		    catch(Exception e) {
		    	System.out.println(e);
		    }
		    
		}else if(ae.getSource()== signup) {
			setVisible(false);
			new SignUpOne().setVisible(true);
		}
		
		
	}

	public static void main(String[] args) {
		
		new Login();
		
	}

	
}
