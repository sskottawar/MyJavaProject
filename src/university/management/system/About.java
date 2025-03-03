package university.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

public class About extends JFrame{
	
	About(){
		setSize(700,500);
		setLocation(300,60);
		setLayout(null);
		
		JLabel heading = new JLabel("<html>University<br>Management System</html>");
		heading.setBounds(70,20,300,130);
		heading.setFont(new Font("Tahoma",Font.BOLD,24));
		add(heading);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons1/about.jpg"));
		Image i2 =i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(380,20,300,200);
		add(image);
		
		JLabel name = new JLabel("Developed By: Sanket");
		name.setBounds(70,240,550,30);
		name.setFont(new Font("Tahoma",Font.BOLD,25));
		add(name);
		
		JLabel rollNo = new JLabel("Roll No: 46144303");
		rollNo.setBounds(70,300,550,30);
		rollNo.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(rollNo);
		
		JLabel contact = new JLabel("Contact: sanket.kottawar@gmail.com");
		contact.setBounds(70,330,550,30);
		contact.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(contact);
		
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new About();

	}

}
