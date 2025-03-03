package university.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Project extends JFrame implements ActionListener{
	
	JMenuItem facultyDetails,studentDetails;
	Project(){
		setSize(1540,800);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons1/third.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1500, 700,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image);
		
		JMenuBar mb = new JMenuBar();
		//Info
		JMenu newInfo = new JMenu("New Information");
		newInfo.setForeground(Color.BLUE);
		mb.add(newInfo);
		
		JMenuItem mi = new JMenuItem("New Faculty Information ");
		newInfo.setBackground(Color.WHITE);
		mi.addActionListener(this);
		newInfo.add(mi);
		
		JMenuItem mi2 = new JMenuItem("New Student Information ");
		newInfo.setBackground(Color.WHITE);
		mi2.addActionListener(this);
		newInfo.add(mi2);
		
		//Details
		JMenu details = new JMenu("View Details");
		details.setForeground(Color.RED);
		mb.add(details);
		
		facultyDetails = new JMenuItem("View Faculty Details");
		details.setBackground(Color.WHITE);
		facultyDetails.addActionListener(this);
		details.add(facultyDetails);
		
		studentDetails = new JMenuItem("View Student Details");
		details.setBackground(Color.WHITE);
		studentDetails.addActionListener(this);
		details.add(studentDetails);
		
		
		//Leave
		JMenu leave = new JMenu(" Apply Leave");
		leave.setForeground(Color.BLUE);
		mb.add(leave);
		
		JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
		leave.setBackground(Color.WHITE);
		facultyLeave.addActionListener(this);
		leave.add(facultyLeave);
		
		JMenuItem studentLeave = new JMenuItem("Student Leave");
		leave.setBackground(Color.WHITE);
		studentLeave.addActionListener(this);
		leave.add(studentLeave);
		
		//Leave Details
		
		JMenu leaveDeatails = new JMenu("Leave Details");
		leaveDeatails.setForeground(Color.RED);
		mb.add(leaveDeatails);
		
		JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
		leaveDeatails.setBackground(Color.WHITE);
		facultyLeaveDetails.addActionListener(this);
		leaveDeatails.add(facultyLeaveDetails);
		
		JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
		leaveDeatails.setBackground(Color.WHITE);
		studentLeaveDetails.addActionListener(this);
		leaveDeatails.add(studentLeaveDetails);
		
		
		//Examination
		
		JMenu Examination = new JMenu("Examination");
		Examination.setForeground(Color.BLUE);
		mb.add(Examination);
		
		JMenuItem results = new JMenuItem("Results");
		Examination.setBackground(Color.WHITE);
		results.addActionListener(this);
		Examination.add(results);
		
		JMenuItem marks = new JMenuItem("Enter Marks");
		Examination.setBackground(Color.WHITE);
		marks.addActionListener(this);
		Examination.add(marks);
		
		//Update
		JMenu UpdateDetails = new JMenu("Update Details");
		UpdateDetails.setForeground(Color.RED);
		mb.add(UpdateDetails);
		
		JMenuItem UpdateFacultyInfo = new JMenuItem("Update Faculty Details");
		UpdateDetails.setBackground(Color.WHITE);
		UpdateFacultyInfo.addActionListener(this);
		UpdateDetails.add(UpdateFacultyInfo);
		
		JMenuItem UpdateStudentDetails  = new JMenuItem("Update Student Details");
		UpdateDetails.setBackground(Color.WHITE);
		UpdateStudentDetails.addActionListener(this);
		UpdateDetails.add(UpdateStudentDetails);
		
		
		//Fee
		JMenu FeeDetails = new JMenu("Fee Details");
		FeeDetails.setForeground(Color.BLUE);
		mb.add(FeeDetails);
		
		JMenuItem FeeStructure = new JMenuItem("Fee Structure");
		FeeDetails.setBackground(Color.WHITE);
		FeeStructure.addActionListener(this);
		FeeDetails.add(FeeStructure);
		
		JMenuItem FeeForm  = new JMenuItem("Student Fee Form");
		FeeDetails.setBackground(Color.WHITE);
		FeeForm.addActionListener(this);
		FeeDetails.add(FeeForm);
		
		
		//Utility
		
		JMenu utility = new JMenu("Utility");
		utility.setForeground(Color.RED);
		mb.add(utility);
		
		JMenuItem notepad = new JMenuItem("Notepad");
		utility.setBackground(Color.WHITE);
		notepad.addActionListener(this);
		utility.add(notepad);
		
		JMenuItem calculator  = new JMenuItem("Calculator");
		utility.setBackground(Color.WHITE);
		calculator.addActionListener(this);
		utility.add(calculator);
		
		//About
		
		JMenu ab = new JMenu("About");
		ab.setForeground(Color.BLUE);
		mb.add(ab);
				
	    JMenuItem ab1 = new JMenuItem("About");
	    ab.setBackground(Color.WHITE);
		ab1.addActionListener(this);
		ab.add(ab1);
				
		//Exit
		
		JMenu exit = new JMenu("Exit");
		exit.setForeground(Color.RED);
		mb.add(exit);
		
		JMenuItem exit1 = new JMenuItem("Exit");
		exit.setBackground(Color.WHITE);
		exit1.addActionListener(this);
		exit.add(exit1);
		
		setJMenuBar(mb);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String msg = ae.getActionCommand();
		if(msg.equals("Exit")) {
			setVisible(false);
		}else if(msg.equals("Calculator")) {
			try {
			Runtime.getRuntime().exec("calc.exe");
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}else if(msg.equals("Notepad")) {
			try {
			Runtime.getRuntime().exec("notepad.exe");
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		else if(msg.equals("New Faculty Information ")) {
			new AddTeacher();
		}
		else if(msg.equals("New Student Information ")) {
			new AddStudent();
		}
		else if(msg.equals("View Faculty Details")) {
			new TeacherDetails();
		}
		else if(msg.equals("View Student Details")) {
			new StudentDetails();
		}
		else if(msg.equals("Faculty Leave")) {
			new TeacherLeave();
		}
		else if(msg.equals("Student Leave")) {
			new StudentLeave();
		}
		else if(msg.equals("Faculty Leave Details")) {
			new TeacherLeaveDetails();
		}
		else if(msg.equals("Student Leave Details")) {
			new StudentLeaveDetails();
		}
		else if(msg.equals("Update Faculty Details")) {
			new UpdateTeacher();
		}
		else if(msg.equals("Update Student Details")) {
			new UpdateStudent();
		}
		else if(msg.equals("Enter Marks")) {
			new EnterMarks();
		}
		else if(msg.equals("Results")) {
			new ExaminationDetails();
		}
		else if(msg.equals("Fee Structure")) {
			new FeeStructure();
		}
		else if(msg.equals("About")) {
			new About();
		}
		else if(msg.equals("Student Fee Form")) {
			new StudentFeesForm();
		}
		 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Project();

	}

	

}
