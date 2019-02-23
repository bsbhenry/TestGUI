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
        // 主窗体
        JFrame frame = new JFrame("TestGUI");
 
        // 主窗体设置大小
        frame.setSize(400, 300);
 
        // 主窗体设置位置
        getLocation();
        frame.setLocation(xLocation,yLocation);        	

        // 主窗体中的组件设置为绝对定位
        frame.setLayout(null);
 
        // Label显示窗体位置
        JLabel label = new JLabel("X: " + xLocation + " Y: " + yLocation);
 
        // 同时设置组件的大小和位置
        label.setBounds(150, 100, 280, 30);
 
        // 把按钮加入到主窗体中
        frame.add(label);

        //退出窗体的时候退出程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 让窗体变得可见
        frame.setVisible(true);
        Record record = new Record(frame,label);
        record.start();
    }
}
