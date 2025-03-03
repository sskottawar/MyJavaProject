package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Date;
import java.awt.*;

import javax.swing.*;

public class Deposit extends JFrame implements ActionListener{
	
	
	JButton deposit,back;
	JTextField amount;
	JLabel text;
	String pinnumber;
	Deposit(String pinnumber){
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons1/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 580, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,500, 580);
		add(image);
		
		text = new JLabel("ENTER THE AMOUNT YOU WANT TO DEPOSIT");
		text.setBounds(95, 200, 500, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 8));
		image.add(text);
		
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 10));
		amount.setBounds(95, 250, 180, 15);
		image.add(amount);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(200,320,80,25);
		deposit.addActionListener(this);
		image.add(deposit);
		
		back = new JButton("Back");
		back.setBounds(100,320,80,25);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(500,580);
		setLocation(300,0);
		setVisible(true);
	}

	




	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == deposit) {
			String number = amount.getText();
			Date date = new Date();
			
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
			}
			else {
				
				Conn conn = new Conn();
				String query = "INSERT INTO bank (pin, date, type, amount) VALUES ('" + pinnumber + "', '" + date + "', 'Deposit', '" + number + "')";
				try {
					conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs " +number+ " Deposited Successfully");
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}
			
		}
		else if(ae.getSource() == back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Deposit("");

	}


}
