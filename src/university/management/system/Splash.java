package university.management.system;

import java.awt.*;

import javax.swing.*;

public class Splash extends JFrame implements Runnable {
	
	Thread t;
	Splash(){
		
		//setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons1/first.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1500, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image);
		
		
		t=new Thread(this);
		t.start();
		setVisible(true);
		
		int x = 1;
		for(int i=2; i<=600; i++) {
			setLocation(900 - (i+x/2),350 - (i/2));
			setSize(i+ 3*x,i+x/2);
			
			try{
				Thread.sleep(1/10);
			}
			catch(Exception e) {}
		}
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Splash();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
			setVisible(false);
			new Login();
		}
		catch(Exception e){
			
		}
	}

}
