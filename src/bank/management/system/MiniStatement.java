package bank.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame implements ActionListener {
	
	MiniStatement(String pinnumber2){
		
		setLayout(null);
		
		JLabel mini = new JLabel();
		add(mini);
		
		
		setTitle("Mini Statement");
		
		JLabel card = new JLabel();
		add(card);
		
		JLabel bank = new JLabel("Indian Bank");
		bank.setBounds(210,20,100,20);
		bank.setForeground(Color.BLACK);
		add(bank);
		
		
		
		mini.setBounds(20,80,300,20);
		add(mini);
		
		
		try {
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("Select * from login where pin = '" +pinnumber2+"'");
			while(rs.next()) {
				card.setText("Card Number: " + rs.getString("cardnumber").substring(0,4)+ "XXXXXXXXX" + rs.getString("cardnumber").substring(12));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		try {
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("Select * from bank where pin = '" +pinnumber2+"'");
			while(rs.next()) {
				mini.setText(mini.getText()+ "<html>" + rs.getString("Date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount"));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		mini.setBounds(20,140,400,200);
		setSize(500,580);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MiniStatement("");

	}

	

}
