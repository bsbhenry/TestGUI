package gui;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Record extends Thread{
	private JFrame frame;
	private JLabel label;
	private int xLocation;
	private int yLocation;
	static File file = new File("record.txt");
	public Record(JFrame frame,JLabel label) {
		this.frame = frame;
		this.label = label;
	}
	public void run() {
		while(true) {
			getLocation();
			writeRecord();
			updateLabel();
			try {
				Thread.sleep(100);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
			
	}
	
	//读取横纵坐标
	private void getLocation() { 
		xLocation = frame.getX();
		yLocation = frame.getY();
	}
	
	//记录坐标到文件
	private void writeRecord() {
        try (
                FileOutputStream fos  = new FileOutputStream(file);
                DataOutputStream dos =new DataOutputStream(fos);
        ){
            dos.writeInt(xLocation);
            dos.writeInt(yLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }			
	}
	
	//更新label
	private void updateLabel() {
		label.setText("X: " + xLocation + " Y: " + yLocation);
	}
}
