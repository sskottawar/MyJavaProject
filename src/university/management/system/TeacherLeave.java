package university.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import com.mysql.cj.xdevapi.Table;
import com.toedter.calendar.JDateChooser;


public class TeacherLeave extends JFrame implements ActionListener {
	Choice cEmpId,ctime;
	JTable table;
	JDateChooser dcdate;
	JButton submit,cancel;
	TeacherLeave(){
		
		setLayout(null);
		setSize(500,550);
		setLocation(550, 100);
		
		getContentPane().setBackground(Color.WHITE);
		
		JLabel heading = new JLabel("Apply Leave (Teacher)");
		heading.setBounds(40,50,300,30);
		heading.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(heading);
		
		JLabel lblrollno = new JLabel("Search by Employee Id");
		lblrollno.setBounds(60,100,200,20);
		heading.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblrollno);
		
		//table = new JTable();
		cEmpId = new Choice();
		cEmpId.setBounds(60,130,200,20);
		add(cEmpId);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("Select * from teacher");
			while(rs.next()) {
				cEmpId.add(rs.getString("empId"));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		JLabel lbldate = new JLabel("Date");
		lbldate.setBounds(60,180,100,20);
		heading.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lbldate);
		
		dcdate = new JDateChooser();
		dcdate.setBounds(60,210,200,20);
		add(dcdate);
		
		
		JLabel lbltime = new JLabel("Time Duration");
		lbltime.setBounds(60,260,200,20);
		lbltime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lbltime);
		
		//table = new JTable();
		ctime = new Choice();
		ctime.setBounds(60,290,200,20);
		ctime.add("Full Day");
		ctime.add("Half Day");
		add(ctime);
		
		
		submit = new JButton("Submit");
		submit.setBounds(60,350,100,25);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(200,350,100,25);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == submit) {
			String empId = cEmpId.getSelectedItem();
			String date = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
			String duration = ctime.getSelectedItem();
			
			String query = "insert into teacherleave values('"+empId+"','"+date+"','"+duration+"');";
			
			try {
				Conn c = new Conn();
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Leave Confirmed");
				setVisible(false);
			}
			catch(Exception ae) {
				ae.printStackTrace();
			}
		}
		else {
			setVisible(false);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TeacherLeave();

	}

	

}
