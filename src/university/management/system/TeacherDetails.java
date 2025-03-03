package university.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;


public class TeacherDetails extends JFrame implements ActionListener{
	JTable table;
	Choice cEmpId;
	JButton search,print,update,add,cancel;
	
	TeacherDetails(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("Search by Employee Id");
		heading.setBounds(20,20,150,20);
		add(heading);
		
		table = new JTable();
		cEmpId = new Choice();
		cEmpId.setBounds(180,20,300,20);
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
		
		//table = new JTable();
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("Select * from teacher");
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
		
		update = new JButton("Update");
		update.setBounds(220,70,80,20);
		update.addActionListener(this);
		add(update);
		
		add = new JButton("Add");
		add.setBounds(320,70,80,20);
		add.addActionListener(this);
		add(add);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(420,70,80,20);
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
			String query = "select * from teacher where empId = '"+cEmpId.getSelectedItem()+"'";
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
		else if(e.getSource()==add) {
			setVisible(false);
			new AddTeacher();
		}
		else if(e.getSource() == update) {
			setVisible(false);
			// new UpdateTeacher()
		}
		else {
			setVisible(false);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TeacherDetails();

	}

	

}
