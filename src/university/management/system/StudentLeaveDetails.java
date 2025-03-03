package university.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;

public class StudentLeaveDetails extends JFrame implements ActionListener{
	
	JTable table;
	Choice crollno;
	JButton search,print,update,add,cancel;
	StudentLeaveDetails(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("Search by Roll Number");
		heading.setBounds(20,20,150,20);
		add(heading);
		
		table = new JTable();
		crollno = new Choice();
		crollno.setBounds(180,20,300,20);
		add(crollno);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("Select * from studentleave");
			while(rs.next()) {
				crollno.add(rs.getString("rollno"));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		table = new JTable();
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("Select * from studentleave");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0,100,690,600);
		add(jsp);
		
		
		search = new JButton("Search");
		search.setBounds(20,70,80,20);
		search.addActionListener(this);
		add(search);
		
		print = new JButton("Print");
		print.setBounds(120,70,80,20);
		print.addActionListener(this);
		add(print);
		
		
		cancel = new JButton("Cancel");
		cancel.setBounds(220,70,80,20);
		cancel.addActionListener(this);
		add(cancel);
		
		setVisible (true);
		setLocation(350,50);
		setSize(700,600);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== search) {
			String query = "select * from studentleave where rollno = '"+crollno.getSelectedItem()+"'";
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
			catch(Exception ae) {
				ae.printStackTrace();
			}
		}
		
		
		else if(e.getSource() == print) {
			try {
				table.print();
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
		new StudentLeaveDetails();

	}

	

}
