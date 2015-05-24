package com.eyny.swing;


import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class MainFrame extends JFrame{

	private JTabbedPane tabbePane; 
	private DownLoadPanel downloadPanel;
	private InputPanel inputPanel;
	private JScrollPane scrollPane;
	private JLabel status;
	
	
	public MainFrame(){
		
		tabbePane = new JTabbedPane();
		downloadPanel = new DownLoadPanel();
		inputPanel = new InputPanel(this);
		scrollPane = new JScrollPane(downloadPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		status = new JLabel("歡迎使用，請挑選下載目錄~^_^");
		tabbePane.add("輸入區",inputPanel);
		tabbePane.add("下載進度",scrollPane);
		
		add(tabbePane,BorderLayout.CENTER);
		add(status,BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				//UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				//UIManager.setLookAndFeel("com.sun.java.swing.plaf.mac.MacLookAndFeel");
				
			} catch (Exception e) {
			e.printStackTrace();
			}
		
		MainFrame MFrame = new MainFrame();
		MFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		MFrame.setSize(1000, 1000);
		MFrame.setVisible(true);
	}
	
	
	public void setMessage(String msg) {
        status.setText(msg);
    }

	public JTabbedPane getTabbePane() {
		return tabbePane;
	}

	public void setTabbePane(JTabbedPane tabbePane) {
		this.tabbePane = tabbePane;
	}

	public DownLoadPanel getDownloadPanel() {
		return downloadPanel;
	}

	public void setDownloadPanel(DownLoadPanel downloadPanel) {
		this.downloadPanel = downloadPanel;
	}

	public InputPanel getInputPanel () {
		return inputPanel;
	}

	public void setInputPanel (InputPanel inputPanel) {
		this.inputPanel = inputPanel;
	}

}
