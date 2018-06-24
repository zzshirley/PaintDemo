package com.ccnu.nercel.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import com.ccnu.nercel.ui.Menu;

public class BtnLinstener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton target = (JButton)e.getSource();
	    String actionCommand = target.getActionCommand();
	    //System.out.println(actionCommand);
	    if(actionCommand.contentEquals("Line")) {
	    			Menu.type = Menu.LINE;
	    		}
	    if(actionCommand.contentEquals("Rectangle")) {
    				Menu.type = Menu.RECT;
    			}
	    if(actionCommand.contentEquals("Circle")) {
				Menu.type = Menu.CIRCLE;
			}
	    if(actionCommand.contentEquals("Write")) {
    				Menu.type = Menu.write;
    			}
	    if(actionCommand.contentEquals("Red")) {
	    	
	    		}
	    if(actionCommand.contentEquals("Black")) {
	    	
	    		}
	    if(actionCommand.contentEquals("Blue")) {
	    	
	    		}
	}

}
