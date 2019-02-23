package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class NewRecord extends BaseRecord implements Runnable {

	public NewRecord(JFrame frame, JLabel label) {
		super(frame, label);
		// TODO Auto-generated constructor stub
	}

	public void run() {
		while(true) {
			updateLocation();
			writeRecord();			
			try {
				Thread.sleep(100);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
			
	}
}
