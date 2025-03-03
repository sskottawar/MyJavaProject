package university.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.mysql.cj.protocol.Resultset;

public class Marks extends JFrame implements ActionListener{

	String rollno;
	JButton back;
	Marks(String rollno){
		this.rollno = rollno;
		
		setSize(500,600);
		setLocation(400,60);
        setLayout(null);
        
		JLabel heading = new JLabel("Savitribai Phule University");
		heading.setBounds(100,10,500,25);
		heading.setFont(new Font("Tahoma",Font.BOLD,20 ));
		add(heading);
		
		JLabel Subheading = new JLabel("Result of Examination 2025");
		Subheading.setBounds(100,50,500,20);
		Subheading.setFont(new Font("Tahoma",Font.BOLD,18 ));
		add(Subheading);
		
		JLabel lblrollNo = new JLabel("Roll No "+ rollno);
		lblrollNo.setBounds(60,100,500,20);
		lblrollNo.setFont(new Font("Tahoma",Font.PLAIN,20 ));
		add(lblrollNo);
		
		JLabel lblsemister = new JLabel();
		lblsemister.setBounds(60,130,500,20);
		lblsemister.setFont(new Font("Tahoma",Font.PLAIN,18 ));
		add(lblsemister);
		
		JLabel sub1 = new JLabel();
		sub1.setBounds(100,200,500,20);
		sub1.setFont(new Font("Tahoma",Font.PLAIN,18 ));
		add(sub1);
		
		JLabel sub2 = new JLabel();
		sub2.setBounds(100,230,500,20);
		sub2.setFont(new Font("Tahoma",Font.PLAIN,18 ));
		add(sub2);
		
		JLabel sub3 = new JLabel();
		sub3.setBounds(100,260,500,20);
		sub3.setFont(new Font("Tahoma",Font.PLAIN,18 ));
		add(sub3);
		
		JLabel sub4 = new JLabel();
		sub4.setBounds(100,290,500,20);
		sub4.setFont(new Font("Tahoma",Font.PLAIN,18 ));
		add(sub4);
		
		JLabel sub5 = new JLabel();
		sub5.setBounds(100,320,500,20);
		sub5.setFont(new Font("Tahoma",Font.PLAIN,18 ));
		add(sub5);
		
		back = new JButton("Back");
        back.setBounds(250, 500, 120, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(back);
		
		try {
			Conn c = new Conn();
			ResultSet rs1 = c.s.executeQuery("Select * from subject where rollno = '"+rollno+"'");
			while(rs1.next()) {
				sub1.setText(rs1.getString("subject1"));
				sub2.setText(rs1.getString("subject2"));
				sub3.setText(rs1.getString("subject3"));
				sub4.setText(rs1.getString("subject4"));
				sub5.setText(rs1.getString("subject5"));
				
			}
			
			ResultSet rs2 = c.s.executeQuery("Select * from marks where rollno = '"+rollno+"'");
			while(rs2.next()) {
				sub1.setText(sub1.getText()+"----------"+rs2.getString("marks1"));
				sub2.setText(sub2.getText()+"----------"+rs2.getString("marks2"));
				sub3.setText(sub3.getText()+"----------"+rs2.getString("marks3"));
				sub4.setText(sub4.getText()+"----------"+rs2.getString("marks4"));
				sub5.setText(sub5.getText()+"----------"+rs2.getString("marks5"));
				
				lblsemister.setText("Semester " + rs2.getString("semester"));
				}
		}
		catch(Exception ae){
			ae.printStackTrace();
		}
		
		
		
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Marks("");
	}
	

}
