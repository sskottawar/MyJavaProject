package university.management.system;

import java.awt.*;
import java.sql.ResultSet;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame{
	
	FeeStructure(){
		setSize(1000,500);
		setLocation(200,60);
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		
		
		
		JLabel heading = new JLabel("Fee Structure");
		heading.setBounds(170,30,500,25);
		heading.setFont(new Font("Tahoma",Font.BOLD,24));
		add(heading);
		
		JTable table = new JTable();
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("Select * from fee");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		catch(Exception ae) {
			ae.printStackTrace();
		}
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0,60,1000,700);
		add(jsp);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FeeStructure();

	}

}
