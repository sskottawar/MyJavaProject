package university.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.*;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;


public class Login extends JFrame implements ActionListener{
	JButton login,cancel;
	JTextField tfUsername,tfPassword;
	Login(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel username = new JLabel("Username: ");
		username.setBounds(70, 40, 150, 20);
		add(username);
		
		
		
		tfUsername = new JTextField();
		tfUsername.setBounds(140,40,150,20);
		add(tfUsername);
		
		JLabel password = new JLabel("Password: ");
		password.setBounds(70, 80, 150, 20);
		add(password);
		
		
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(140,80,150,20);
		add(tfPassword);
		
	    login = new JButton("Login");
		login.setBounds(100,150,80,20);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		login.setFont(new Font("Serif", Font.BOLD,15));
		add(login);
		
		
		cancel = new JButton("Cancel");
		cancel.setBounds(190,150,80,20);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		cancel.setFont(new Font("Serif", Font.BOLD,15));
		add(cancel);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons1/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350,0,200,200);
		add(image);
		
		setLocation(330,200);
		setSize(600,300);
		setVisible(true);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == login) {
			Conn c = new Conn();
			String Username = tfUsername.getText();
			String Password = tfPassword.getText();
			
			String query = "Select * from Login where username='"+Username+"' and password= '"+Password+"'";
			
			try {
				Conn c1 = new Conn();
			    ResultSet rs = c1.s.executeQuery(query);
			    
			    if(rs.next()) {
			    	setVisible(false);
			    	new Project();
			    }
			    else {
			    	JOptionPane.showMessageDialog(null, "Invalid username or password");
			    }
			}
			catch(Exception ae) {
				ae.printStackTrace();
			}	
		}
		else if(e.getSource() == cancel){
			setVisible(false);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();

	}

	

}
