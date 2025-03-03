package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener{
	
	String pinnumber2;
	JButton back,hundred,FiveHundred,Thousand, TwoThousand,FiveThousand,TenThousand;
	
	
	FastCash(String pinnumber2){
		
		this.pinnumber2 = pinnumber2;
		setLayout(null);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons1/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 580,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,500,580);
		
		add(image);
		
		
		
		JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
		text.setBounds(95, 200, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 12));
		image.add(text);
		
		hundred = new JButton("Rs 100");
		hundred.setBounds(92, 230, 95, 25);
		hundred.addActionListener(this);
		image.add(hundred);
		
		FiveHundred = new JButton("Rs 500");
		FiveHundred.setBounds(190, 230, 95, 25);
		FiveHundred.addActionListener(this);
		image.add(FiveHundred);
		
		Thousand = new JButton("Rs 1000");
		Thousand.setBounds(92, 260, 95, 25);
		FiveHundred.addActionListener(this);
		image.add(Thousand);
		
		TwoThousand = new JButton("Rs 2000");
		TwoThousand.setBounds(190, 260, 95, 25);
		TwoThousand.addActionListener(this);
		image.add(TwoThousand);
		
		FiveThousand = new JButton("Rs 5000");
		FiveThousand.setBounds(92, 290, 95, 25);
		FiveThousand.addActionListener(this);
		image.add(FiveThousand);
		
		TenThousand = new JButton("Rs 10000");
		TenThousand.setBounds(190, 290, 95, 25);
		TenThousand.addActionListener(this);
		image.add(TenThousand);
		
		back = new JButton("Back");
		back.setBounds(92, 320, 95, 25);
		back.addActionListener(this);
		image.add(back);
		
		setSize(500,580);
		setLocation(300,0);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == back) {
			setVisible(false);
			new Transactions(pinnumber2).setVisible(true);
			
		}
		else {	
			String amount = ((JButton)ae.getSource()).getText().substring(3);
			Conn conn = new Conn();
			
			try {
				ResultSet rs = conn.s.executeQuery("Select * from bank where pin = '"+pinnumber2+"'");
				int balance = 0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
					}
					else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
				
				if(ae.getSource() != back && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance ");
					return;
				}
				
				Date date = new Date();
				String  query = "insert into bank values('"+pinnumber2+"', '"+date+"', 'withdrawl', '"+amount+"')";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs " + amount + "Debited Successfully");
				
				setVisible(false);
				new Transactions(pinnumber2).setVisible(true);
				
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		
		
		
}
		
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FastCash("");
	}

	

}
