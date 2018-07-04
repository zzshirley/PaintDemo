package com.ccnu.nercel.Tools;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.ccnu.nercel.listener.PaintPanel;
import com.ccnu.nercel.ui.Paint;
import com.ccnu.nercel.shape.*;

public class Save {
	
	JFileChooser jFileChooser;	
	public static boolean hassave=true;
	public Save() {
		// TODO Auto-generated constructor stub
		Dimension imageSize = Paint.pnlDisplayArea.getSize();
		jFileChooser=new JFileChooser();
		//设置文件路径
		jFileChooser.setCurrentDirectory(new File("./"));
		//设置默认文件名
		jFileChooser.setSelectedFile(new File("未命名.png"));
		//获取点击的是确定or取消
		int returnVal = jFileChooser.showSaveDialog(null);		
		BufferedImage image = new BufferedImage(imageSize.width,imageSize.height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = image.createGraphics();
		Paint.pnlDisplayArea.paint(g);
        g.dispose();
        File fileW =jFileChooser.getSelectedFile();
//        System.out.println(jFileChooser.CANCEL_OPTION);
        if(returnVal == jFileChooser.APPROVE_OPTION & fileW != null) {
        	try {
    			ImageIO.write(image,"png", fileW);
//    			JOptionPane notice=new JOptionPane ();
    			JOptionPane.showMessageDialog(null, "图片已保存！","保存成功",JOptionPane.INFORMATION_MESSAGE);
    			hassave=true;
    		} catch (FileNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
		
	}
}
