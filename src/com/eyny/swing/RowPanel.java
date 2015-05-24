package com.eyny.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class RowPanel extends JPanel{

	private DownLoadPanel downloadPanel = null;
	private JLabel fileName;
	private JLabel progressText;
	private JProgressBar progressbar;
	private JPanel rowPanel;
	
	public RowPanel(){}
	
	public RowPanel(DownLoadPanel downloadPanel){
		this.downloadPanel=downloadPanel;
	}

	public void addRowPanel(){
		
		rowPanel = new JPanel();
		rowPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		rowPanel.setBackground(Color.WHITE);
		rowPanel.setPreferredSize(new Dimension(950 , 30));
		downloadPanel.add(rowPanel);
	}
	
	public void setUrlName(String labelText){
		fileName = new JLabel(labelText);
		fileName.setPreferredSize(new Dimension(200 , 30));
		rowPanel.add(fileName);
	}
	
	public JLabel getJLabel(){
		return fileName;
	}	
	
	public void setProgBar(){
		
		progressbar = new JProgressBar();
		progressbar.setOrientation(JProgressBar.HORIZONTAL);
		progressbar.setMinimum(0);
		progressbar.setMaximum(100);
		progressbar.setValue(0);
		progressbar.setStringPainted(true);
		progressbar.setPreferredSize(new Dimension(550,20));
		progressbar.setBorderPainted(true);
		progressbar.setBackground(Color.pink);		
		rowPanel.add(progressbar,BorderLayout.CENTER);
		
	}
	
	public void setProgBarValue(int percent){
		this.progressbar.setValue(percent);
	}
	
	public JProgressBar getProgBar(){
		return progressbar;
	}
	
	public void addProgText(String text){
		progressText = new JLabel(text);
		progressText.setPreferredSize(new Dimension(100 , 30));
		rowPanel.add(progressText);
	}
	
	public void setProgCurrent(String text){
		progressText.setText(text);
	}
	
}
