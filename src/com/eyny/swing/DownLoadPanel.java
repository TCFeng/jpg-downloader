package com.eyny.swing;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;


public class DownLoadPanel extends JPanel{
		
	public DownLoadPanel(){
		this.setBackground(Color.WHITE);
		this.setLayout(new ModifiedFlowLayout(FlowLayout.LEFT));
	}	
}
