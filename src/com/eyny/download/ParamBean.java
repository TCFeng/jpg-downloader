package com.eyny.download;

import com.eyny.swing.MainFrame;
import com.eyny.swing.RowPanel;

public class ParamBean implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public ParamBean(){
		
	}
	
	public ParamBean(String theURL,String theTargetPos, int thePicNo, int thetotalNum, RowPanel theRowPanel, MainFrame mainFrame){
		this.picURL = theURL;
		this.picNo = thePicNo;
		this.totalNum = thetotalNum;
		this.targetPos = theTargetPos;
		this.rowPanel = theRowPanel;
		this.mainFrame = mainFrame;
		
	}
	
	private String picURL = "";
	private String targetPos="";
	private int picNo = 0;
	private int totalNum = 0;
	private RowPanel rowPanel=null;
	private MainFrame mainFrame=null;
	
	public String getPicURL() {
		return picURL;
	}

	public void setPicURL(String picURL) {
		this.picURL = picURL;
	}
	
	public String getTarPos() {
		return targetPos;
	}

	public void setTarPos(String targetPos) {
		this.targetPos = targetPos;
	}

	public int getPicNo() {
		return picNo;
	}

	public void setPicNo(int picNo) {
		this.picNo = picNo;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	
	public RowPanel getRowPanel(){
		return rowPanel;
	}
	
	public void setRowPanel(RowPanel rowPanel){
		this.rowPanel=rowPanel;
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}



}
