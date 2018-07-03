package com.ccnu.nercel.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import com.ccnu.nercel.ui.DrawShapes;
import com.ccnu.nercel.ui.Paint;
/*
 * Button监听，获取Button内容
 * 画相应的图形
 */
public class BtnLinstener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton target = (JButton)e.getSource();
	    String actionCommand = target.getActionCommand();
	    System.out.println(actionCommand);
	    if(actionCommand.contentEquals("Line")) {
	    		DrawShapes.type = DrawShapes.LINE;
	    		}
	    if(actionCommand.contentEquals("Rectangle")) {
	    		DrawShapes.type = DrawShapes.RECT;
    			}
	    if(actionCommand.contentEquals("Circle")) {
	    		DrawShapes.type = DrawShapes.CIRCLE;
			}
	    if(actionCommand.contentEquals("Write")) {
	    		DrawShapes.type = DrawShapes.write;
    			}
	    if(actionCommand.contentEquals("redo")) {
	    	Function.redo();
	    }
	    if(actionCommand.contentEquals("undo")) {
	    	Function.undo();
	    }
	    if(actionCommand.contentEquals("clear")) {
	    	Function.clear();
	    } 
	    if(actionCommand.contentEquals("save")) {
	    	Function.save();
	    }
	}

}
