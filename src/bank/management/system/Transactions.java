package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener{
	
	String pinnumber2;
	JButton exit,deposit,balanceEnquiry,cashwithdraw, fastcash,minstatement,pinchange;
	
	
	Transactions(String pinnumber2){
		
		this.pinnumber2 = pinnumber2;
		setLayout(null);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons1/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 580,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,500,580);
		
		add(image);
		
		
		
		JLabel text = new JLabel("Please Select your Transactions");
		text.setBounds(95, 200, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 12));
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(92, 230, 95, 25);
		deposit.addActionListener(this);
		image.add(deposit);
		
		cashwithdraw = new JButton("Withdraw");
		cashwithdraw.setBounds(190, 230, 95, 25);
		cashwithdraw.addActionListener(this);
		image.add(cashwithdraw);
		
		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(92, 260, 95, 25);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		minstatement = new JButton("Statement");
		minstatement.setBounds(190, 260, 95, 25);
		minstatement.addActionListener(this);
		image.add(minstatement);
		
		pinchange = new JButton("Pin Change");
		pinchange.setBounds(92, 290, 95, 25);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceEnquiry = new JButton("Enquiry");
		balanceEnquiry.setBounds(190, 290, 95, 25);
		balanceEnquiry.addActionListener(this);
		image.add(balanceEnquiry);
		
		exit = new JButton("Exit");
		exit.setBounds(92, 320, 95, 25);
		image.add(exit);
		
		setSize(500,580);
		setLocation(300,0);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == exit) {
			System.exit(0);
			
		}
		else if(ae.getSource() == deposit) {
			setVisible(false);
			new Deposit(pinnumber2).setVisible(true);
		}
		else if(ae.getSource() == cashwithdraw) {
			setVisible(false);
			new Withdrawl(pinnumber2).setVisible(true);
		}
		else if(ae.getSource() == fastcash) {
			setVisible(false);
			new FastCash(pinnumber2).setVisible(true);
		}
		else if(ae.getSource() == pinchange) {
			setVisible(false);
			new PinChange(pinnumber2).setVisible(true);
		}
		else if(ae.getSource() == balanceEnquiry) {
			setVisible(false);
			new BalanceEnquiry(pinnumber2).setVisible(true);
		}
		else if(ae.getSource() == minstatement) {
			setVisible(false);
			new MiniStatement(pinnumber2).setVisible(true);
		}
	
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Transactions("");
	}

	

}
