package com.ccnu.nercel.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.ccnu.nercel.ui.Paint;

/*
 * Menu 监听
 */
public class MenuLinstener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JMenuItem target = (JMenuItem)e.getSource();
	    String actionCommand = target.getActionCommand();	    
	    if(actionCommand.contentEquals("save")) {
	    			Function.save();
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
	}

}
