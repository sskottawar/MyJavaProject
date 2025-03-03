package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {
	
	JLabel rpin, pin;
	JPasswordField pinText, rpinText,repinText;
	JButton change;
	static String pinnumber2;
	PinChange(String pinnumber2){
		this.pinnumber2 = pinnumber2;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons1/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 580,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,500,580);
		add(image);
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(110, 200, 700, 35);
		image.add(text);
		
		pin = new JLabel("New PIN: ");
		pin.setForeground(Color.WHITE);
		pin.setFont(new Font("System", Font.BOLD, 10));
		pin.setBounds(100, 250, 70, 20);
		image.add(pin);
		
		rpin = new JLabel("Re-Enter PIN: ");
		rpin.setForeground(Color.WHITE);
		rpin.setFont(new Font("System", Font.BOLD, 10));
		rpin.setBounds(100, 280, 70, 20);
		image.add(rpin);
		
		pinText = new JPasswordField();
		pinText.setForeground(Color.WHITE);
		pinText.setFont(new Font("System", Font.BOLD, 16));
		pinText.setBounds(180, 280, 100, 20);
		image.add(pinText);
		
		repinText = new JPasswordField();
		repinText.setForeground(Color.WHITE);
		repinText.setFont(new Font("System", Font.BOLD, 16));
		repinText.setBounds(180, 250, 100, 20);
		image.add(repinText);
		
		change = new JButton("CHANGE");
		change.setFont(new Font("System", Font.BOLD, 8));
		change.setBounds(205, 320, 70, 25);
		change.addActionListener(this);
		image.add(change);
		
		JButton back = new JButton("BACK");
		back.setFont(new Font("System", Font.BOLD, 8));
		back.setBounds(130, 320, 70, 25);
		back.addActionListener(this);
		image.add(back);
		
		setSize(500,580);
		setLocation(300,0);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == change) {
		try {
			String npin = pinText.getText();
			String repin = repinText.getText();
			
			if(!npin.equals(repin)) {
				JOptionPane.showMessageDialog(null, "Entered PIN does not match");
				return;
			}
			
			if(npin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter New PIN");
				return;
			}
			
			if(rpin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
				return;
			}
			
			Conn conn = new Conn();
			String query1 = "update bank set pin = '"+rpin+"' where pin= '"+pinnumber2+"'";
			String query2 = "update login set pin = '"+rpin+"' where pin= '"+pinnumber2+"'";
			String query3 = "update signUpThree set pin = '"+rpin+"' where pin= '"+pinnumber2+"'";
			
			JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
			
			setVisible(false);
			new Transactions(pinnumber2).setVisible(true);
			
		}
		catch(Exception ae1) {
			System.out.println(ae1);
		}
	}
		else {
			setVisible(false);
			new Transactions(pinnumber2).setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PinChange(pinnumber2);

	}

	

}
