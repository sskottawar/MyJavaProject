package university.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class AddTeacher extends JFrame implements ActionListener{
	
	Random ran = new Random();
	Long first4 = Math.abs((ran.nextLong()%9000L)+ 1000L);
	JButton submit,cancel;
	JTextField tfName,name,tfAddress,tfEmail,tclass12,tfFName,tfPhone,tfclass10,tfadhaar,tfbranch;
	JLabel rollNO,adhaarNo,tfEmpId,branch1;
	JComboBox tfbranch1;
	JComboBox tfCompBox,tfcourse;
	JComboBox branch;
	JDateChooser tfdob;
	AddTeacher(){
		setLayout(null);
		
		JLabel text = new JLabel("New Teacher Details");
		text.setFont(new Font("Arial", Font.BOLD, 22));
		text.setBounds(190,50,250,30);
		add(text);
		
		
		JLabel name = new JLabel("Name:");
		name.setBounds(50,150,120,20);
		add(name);
		
		tfName= new JTextField();
		tfName.setBounds(130,150,120,20);
		add(tfName);
		
		rollNO = new JLabel("Employee Id:");
		rollNO.setBounds(50,200,120,20);
		add(rollNO);
		
		tfEmpId= new JLabel("101"+first4);
		tfEmpId.setBounds(130,200,120,20);
		add(tfEmpId);
		
		

		JLabel address = new JLabel("Address:");
		address.setBounds(50,250,120,20);
		add(address);
		
		tfAddress= new JTextField();
		tfAddress.setBounds(130,250,120,20);
		add(tfAddress);
		
		JLabel email = new JLabel("Email Id:");
		email.setBounds(50,300,120,20);
		add(email);
		
		tfEmail= new JTextField();
		tfEmail.setBounds(130,300,120,20);
		add(tfEmail);
		
		JLabel class12 = new JLabel("Class XII(%):");
		class12.setBounds(50,350,120,20);
		add(class12);
		
		tclass12= new JTextField();
		tclass12.setBounds(130,350,120,20);
		add(tclass12);
		
		JLabel course = new JLabel("Qualification:");
		course.setBounds(50,400,120,20);
		add(course);
		
		String course1[] = {"BTech","BBA","BSC","BCA","MSC","MCA","BBA","MCom","BCom","BA","MA"};
		
		tfcourse= new JComboBox(course1);
		tfcourse.setBounds(130,400,120,20);
		add(tfcourse);
		
		
		
		
		
		
		
		
		
		
		
		JLabel Fname = new JLabel("Father's Name:");
		Fname.setBounds(300,150,120,20);
		add(Fname);
		
		tfFName= new JTextField();
		tfFName.setBounds(420,150,120,20);
		add(tfFName);
		
		JLabel dob = new JLabel("Date Of Birth:");
		dob.setBounds(300,200,120,20);
		add(dob);
		
		tfdob= new JDateChooser();
		tfdob.setBounds(420,200,120,20);
		add(tfdob);
		
		

		JLabel phone = new JLabel("Phone:");
		phone.setBounds(300,250,120,20);
		add(phone);
		
		tfPhone= new JTextField();
		tfPhone.setBounds(420,250,120,20);
		add(tfPhone);
		
		JLabel class10 = new JLabel("Class X(%):");
		class10.setBounds(300,300,120,20);
		add(class10);
		
		tfclass10= new JTextField();
		tfclass10.setBounds(420,300,120,20);
		add(tfclass10);
		
		adhaarNo = new JLabel("Adhaar No:");
		adhaarNo.setBounds(300,350,120,20);
		add(adhaarNo);
		
		tfadhaar= new JTextField();
		tfadhaar.setBounds(420,350,120,20);
		add(tfadhaar);
        
		
		branch1 = new JLabel("Department:");
		branch1.setBounds(300,400,120,20);
		add(branch1);
		
		String Branch[] = {"EEE","ECE","CS","CIVIL","MECH","IT","Instru"};
		
		tfbranch1= new JComboBox(Branch);
		tfbranch1.setBounds(420,400,120,20);
		add(tfbranch1);
		
		
		
		submit = new JButton("Submit");
		submit.setBounds(220,500,80,40);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(320,500,80,40);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);
		
		
		setVisible (true);
		setLocation(350,50);
		setSize(600,600);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == submit) {
			String name = tfName.getText();
			String fname = tfFName.getText();
			String empId = tfEmpId.getText();
			String dob = ((JTextField)tfdob.getDateEditor().getUiComponent()).getText();
		    String address = tfAddress.getText();
		    String phone = tfPhone.getText();
		    String email = tfEmail.getText();
		    String X = tfclass10.getText();
		    String XII = tclass12.getText();
		    String adhaar = tfadhaar.getText();
		    String course = (String) tfcourse.getSelectedItem();
		    String branch = (String) tfbranch1.getSelectedItem();
		    
		    try {
		    	
		    	String query = "insert into teacher values('"+name+"','"+fname+"','"+empId+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+X+"','"+XII+"','"+adhaar+"','"+course+"','"+branch+"');";
		    	
		    	Conn con = new Conn();
		    	con.s.executeUpdate(query);
		    	
		    	JOptionPane.showMessageDialog(null, "Teacher Details inserted Successfully");
		    	setVisible(false);
		    	
		    }catch(Exception ae) {
		    	ae.printStackTrace();
		    };
		    
		}else {
			setVisible(false);
		}
			
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddTeacher();

	}



	

}
