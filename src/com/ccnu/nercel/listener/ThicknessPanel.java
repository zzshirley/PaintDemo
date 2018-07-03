package com.ccnu.nercel.listener;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;





public class ThicknessPanel extends JPanel{
	
	
	public static int thick = 1;
	JSlider jSlider;
	JPanel jPanel_data;

	public ThicknessPanel() {
		super(new GridLayout(2, 1));
		setBorder(new TitledBorder("Thickness"));
		setPreferredSize(new Dimension(120, 60));

		jSlider = new JSlider();
		jPanel_data = new JPanel();

		jPanel_data.setLayout(new GridLayout(1, 2));

		jPanel_data.add(jSlider);

		add(jPanel_data);

		jSlider.setMaximum(100);
		jSlider.setMinimum(thick);
		jSlider.setValue(thick);
		jSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				thick = jSlider.getValue() / 3;
				repaint();
				PaintPanel.thick = thick;
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setStroke(new BasicStroke(thick));
		graphics2d.setColor(ColorPanel.color);
		graphics2d.drawLine(20, 45, 100, 45);
		graphics2d.setStroke(new BasicStroke());
	}
}
