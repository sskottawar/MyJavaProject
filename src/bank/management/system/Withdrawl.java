package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Date;
import java.awt.*;

import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener{
	
	
	JButton withdrawl,back;
	JTextField amount;
	JLabel text;
	String pinnumber2;
	
	Withdrawl(String pinnumber2){
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons1/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 580, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,500, 580);
		add(image);
		
		text = new JLabel("Enter the amount you want to withdraw");
		text.setBounds(95, 200, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 10));
		image.add(text);
		
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 10));
		amount.setBounds(95, 250, 180, 15);
		image.add(amount);
		
		withdrawl = new JButton("Withdraw");
		withdrawl.setBounds(200,320,80,25);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
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
		if(ae.getSource() == withdrawl) {
			String number = amount.getText();
			Date date = new Date();
			
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
			}
			else {
				
				Conn conn = new Conn();
				String query = "INSERT INTO bank (pin, date, type, amount) VALUES ('" + pinnumber2 + "', '" + date + "', 'withdraw', '" + number + "')";
				try {
					conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs " +number+ " Withdraw Successfully");
					setVisible(false);
					new Transactions(pinnumber2).setVisible(true);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}
			
		}
		else if(ae.getSource() == back) {
			setVisible(false);
			new Transactions(pinnumber2).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Withdrawl("");

	}


}
