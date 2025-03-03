package university.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.*;

import com.mysql.cj.xdevapi.Table;

import net.proteanit.sql.DbUtils;


public class ExaminationDetails extends JFrame implements ActionListener{
    JButton submit, back;
	JTextField search;
	JTable table;
	ExaminationDetails(){
		setLocation(100,100);
		setSize(1000,475);
		setLayout(null);
		
		
		JLabel heading = new JLabel("Check Result");
		heading.setBounds(80,15,250,20);
		heading.setFont(new Font("Tahoma",Font.BOLD,24 ));
		add(heading);
		
		search = new JTextField();
		search.setBounds(80,90,150,20);
		search.setFont(new Font("Tahoma",Font.PLAIN,18 ));
		add(search);
		
		 submit = new JButton("Result");
	        submit.setBounds(250, 90, 90, 20);
	        submit.setBackground(Color.BLACK);
	        submit.setForeground(Color.WHITE);
	        submit.addActionListener(this);
	        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
	        add(submit);
	        
	        back = new JButton("Back");
	        back.setBounds(350, 90, 90, 20);
	        back.setBackground(Color.BLACK);
	        back.setForeground(Color.WHITE);
	        back.addActionListener(this);
	        back.setFont(new Font("Tahoma", Font.BOLD, 15));
	        add(back);
	        
	        JTable table = new JTable();
	        table.setFont(new Font("Tahoma",Font.PLAIN, 16));
	        
	        JScrollPane jsp = new JScrollPane(table);
	        jsp.setBounds(0,130,1000,310);
	        add(jsp);
	        
	        try {
	        	Conn c = new Conn();
	        	ResultSet rs = c.s.executeQuery("Select * from student");
	        	table.setModel(DbUtils.resultSetToTableModel(rs));
	        }
	        catch(Exception ae)
	        {
	        	ae.printStackTrace();
	        }
	        
	        table.addMouseListener(new MouseAdapter() {
	        	public void mouseClicked(MouseEvent ae) {
	        		int row = table.getSelectedRow();
	        		search.setText(table.getModel().getValueAt(row, 2).toString());
	        	}
	        });

		
		
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==submit) {
			setVisible(false);
			new Marks(search.getText());
			
		}
		else {
			setVisible(false);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ExaminationDetails();

	}
	

}
