package com.ccnu.nercel.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import com.ccnu.nercel.ui.Menu;


public class MenuLinstener implements ActionListener {
	public static Color color = new Color(0, 0, 0);

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JMenuItem target = (JMenuItem)e.getSource();
	    String actionCommand = target.getActionCommand();
	    System.out.println(actionCommand);
	    if(actionCommand.contentEquals("save")) {
	    			Function.save();
	    		}
	    if(actionCommand.contentEquals("undo")) {
	    			Function.undo();
    			}
	    if(actionCommand.contentEquals("redo")) {
	    			Function.redo();
			}
	    if(actionCommand.contentEquals("Red")) {
    			}
	}

}
