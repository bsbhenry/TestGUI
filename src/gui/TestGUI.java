package gui;
import java.io.DataInputStream;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestGUI {
	static File file = new File("record.txt");
	private static int xLocation = 300;
	private static int yLocation = 300;	
	
	//���ļ���ȡ������Ϣ
	private static void getLocation() {
        if(file.length() == 0) return;
    	try(
                FileInputStream fis  = new FileInputStream(file);
                DataInputStream dis =new DataInputStream(fis);        			
    	){
    		xLocation = dis.readInt();  
    		yLocation = dis.readInt();
    	} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
    public static void main(String[] args) {
        // ������
        JFrame frame = new JFrame("TestGUI");
 
        // ���������ô�С
        frame.setSize(400, 300);
 
        // ����������λ��
        getLocation();
        frame.setLocation(xLocation,yLocation);        	

        // �������е��������Ϊ���Զ�λ
        frame.setLayout(null);
 
        // label��ʾ����λ��
        JLabel label = new JLabel("X: " + xLocation + " Y: " + yLocation);
 
        // ͬʱ��������Ĵ�С��λ��
        label.setBounds(150, 100, 280, 30);
 
        // �Ѱ�ť���뵽��������
        frame.add(label);

        //�˳������ʱ���˳�����
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // �ô����ÿɼ�
        
        //ʹ�ü�����
        Listener listener = new Listener(frame, label);        
        frame.addComponentListener(listener);
        frame.addWindowListener(listener);
        
        frame.setVisible(true);
        //�����̸߳���λ����Ϣ
        Record record = new Record(frame,label);
        record.start();
        
    }
}
