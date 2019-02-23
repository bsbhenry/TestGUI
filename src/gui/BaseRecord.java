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
	
	//��ȡ��������
	private void getLocation() { 
		xLocation = frame.getX();
		yLocation = frame.getY();
	}
	
	//����λ��
	void updateLocation() {
		getLocation();
		label.setText("X: " + xLocation + " Y: " + yLocation);
	}	
	
	//��¼���굽�ļ�
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
