package com.ccnu.nercel.file;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.ccnu.nercel.listener.PaintPanel;
import com.ccnu.nercel.ui.Menu;
import com.ccnu.nercel.shape.*;

public class Save {
	
	FileWriter fileWriter;
	PrintWriter printWriter;
	JFileChooser jFileChooser;
	public static boolean hassave=true;
	public Save() {
		// TODO Auto-generated constructor stub
		jFileChooser=new JFileChooser();
		jFileChooser.setCurrentDirectory(new File("/Users/xiaotong/Documents/program"));
		FileNameExtensionFilter fileNameExtensionFilter=new FileNameExtensionFilter("png", "png");
		jFileChooser.setFileFilter(fileNameExtensionFilter);
		jFileChooser.showSaveDialog(null);
		try {
			fileWriter =new FileWriter(jFileChooser.getSelectedFile());
			printWriter = new PrintWriter(fileWriter);
			for (Shape s : Menu.shapes)
				s.print(printWriter);
			printWriter.close();
			fileWriter.close();
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
