package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener{
	
	JButton back;
	static String pinnumber2;
	BalanceEnquiry(String pinnumber2){
		
		this.pinnumber2 = pinnumber2;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons1/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 580,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		
		image.setBounds(0,0,500,580);
		add(image);
		
		back = new JButton("Back");
		back.setBounds(190, 320, 70, 25);
		back.addActionListener(this);
		image.add(back);
		
		Conn conn = new Conn();
		int balance = 0;
		try {
			ResultSet rs = conn.s.executeQuery("Select * from bank where pin = '"+pinnumber2+"'");
			
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}
				else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		}
			catch(Exception ae) {
				System.out.println(ae);
			}
		
		JLabel text = new JLabel("Your current account balance is Rs "+ balance);
		text.setForeground(Color.WHITE);
		text.setBounds(95, 200, 700, 35);
		text.setFont(new Font("System", Font.BOLD, 8));
		image.add(text);
		
		setSize(500,580);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);
		new Transactions(pinnumber2).setVisible(true);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BalanceEnquiry(pinnumber2);

	}




}
