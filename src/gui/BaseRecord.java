package gui;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public abstract class BaseRecord {
	private JFrame frame;
	private JLabel label;
	private int xLocation;
	private int yLocation;
	static File file = new File("record.txt");
	public BaseRecord(JFrame frame,JLabel label) {
		this.frame = frame;
		this.label = label;
	}
	
	//读取横纵坐标
	private void getLocation() { 
		xLocation = frame.getX();
		yLocation = frame.getY();
	}
	
	//更新位置
	void updateLocation() {
		getLocation();
		label.setText("X: " + xLocation + " Y: " + yLocation);
	}	
	
	//记录坐标到文件
	void writeRecord() {
		getLocation();
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
}
