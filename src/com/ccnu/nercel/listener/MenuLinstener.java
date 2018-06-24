package com.ccnu.nercel.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;

import com.ccnu.nercel.ui.Menu;


public class MenuLinstener implements ActionListener {


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JMenuItem target = (JMenuItem)e.getSource();
	    String actionCommand = target.getActionCommand();
	    System.out.println(actionCommand);
	    if(actionCommand.contentEquals("line")) {
	    		Menu.type = Menu.LINE;
	    		}
	    if(actionCommand.contentEquals("rectangle")) {
    			Menu.type = Menu.RECT;
    			}
	    if(actionCommand.contentEquals("circle")) {
			Menu.type = Menu.CIRCLE;
			}
	    if(actionCommand.contentEquals("write")) {
    			Menu.type = Menu.write;
    			}
	}

}
