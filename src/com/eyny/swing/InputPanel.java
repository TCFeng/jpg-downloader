package com.eyny.swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

import com.eyny.download.DownloadFile;
import com.eyny.download.ParamBean;
import com.eyny.utility.Utility;

public class InputPanel extends JPanel{

	private MainFrame mainFrame;
	private DownLoadPanel downloadPanel;
	private JTextField targetFolder;
	private JTextArea textArea;
	private JScrollPane jScrollPane1;
	private JButton btnSelectFolder, btnDownload;
	private JFileChooser chooser;
	private int totalAmount;
	
	
	public InputPanel(){}
	
	public InputPanel(MainFrame theFrane){
		this.mainFrame = theFrane;
		downloadPanel = mainFrame.getDownloadPanel();
		initComponents();
	}
	
	private void initComponents(){
		
		//new 
		JLabel firstLabel = new JLabel();
		targetFolder = new JTextField("");
		textArea = new JTextArea();
		btnSelectFolder = new JButton("挑選目錄");
		btnDownload = new JButton("下載");
				
		//set Text
		firstLabel.setText("下載位置");
		
		
		textArea.setColumns(20);
        textArea.setLineWrap(true); //自動換行
        textArea.setRows(5);
        textArea.setWrapStyleWord(true); //自動換行加斷字
        textArea.setEditable(true);
        Font font = new Font(Font.SERIF, Font.PLAIN, 14);
        textArea.setFont(font);
        jScrollPane1 = new JScrollPane(textArea);
		
		GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        
        //Create a parallel group for the horizontal axis
    	ParallelGroup hGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        
    	
    	//Create a sequential and a parallel groups
    	SequentialGroup h1 = layout.createSequentialGroup();
    	ParallelGroup h2 = layout.createParallelGroup(GroupLayout.Alignment.TRAILING);
    	
    	//Add a container gap to the sequential group h1
    	h1.addContainerGap();
    	
    	//Add a scroll pane and a label to the parallel group h2
    	h2.addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE);
    	
    	//Create a sequential group h3
    	SequentialGroup h3 = layout.createSequentialGroup();
    	h3.addComponent(firstLabel);
    	h3.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
    	h3.addComponent(targetFolder, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE);
    	h3.addComponent(btnSelectFolder);
    	h3.addContainerGap();
    	h3.addComponent(btnDownload);
    	
    	//Add the group h3 to the group h2
    	h2.addGroup(h3);
    	//Add the group h2 to the group h1
    	h1.addGroup(h2);

    	h1.addContainerGap();
    	
    	//Add the group h1 to the hGroup
    	hGroup.addGroup(GroupLayout.Alignment.TRAILING, h1);
    	//Create the horizontal group
    	layout.setHorizontalGroup(hGroup);
    	
            
    	//Create a parallel group for the vertical axis
    	ParallelGroup vGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
    	//Create a sequential group v1
    	SequentialGroup v1 = layout.createSequentialGroup();
    	//Add a container gap to the sequential group v1
    	v1.addContainerGap();
    	//Create a parallel group v2
    	ParallelGroup v2 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
    	v2.addComponent(firstLabel);
    	v2.addComponent(targetFolder, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
    	v2.addComponent(btnSelectFolder);
    	
    	v2.addComponent(btnDownload);
    	//Add the group v2 tp the group v1
    	v1.addGroup(v2);
    	v1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
    	v1.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE);
    	v1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
    	//v1.addContainerGap();
    	
    	//Add the group v1 to the group vGroup
    	vGroup.addGroup(v1);
    	//Create the vertical group
    	layout.setVerticalGroup(vGroup);
    	
    	ActionListener folderBtnListener = new ActionListener() {
    		public void actionPerformed(ActionEvent actionEvent) {
    	        
    			chooser = new JFileChooser(); 
    			chooser.setCurrentDirectory(new java.io.File("D:/"));
    			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    			chooser.setAcceptAllFileFilterUsed(false);
    	    	    
    			if (chooser.showOpenDialog(getParent()) == JFileChooser.APPROVE_OPTION) {     	    	      
    				targetFolder.setText(chooser.getSelectedFile()+"");
    			}else {
    				System.out.println("No Selection ");
    			}
    	    }
    	};
    	
    	ActionListener donwloadBtnListener = new ActionListener() {
  	      public void actionPerformed(ActionEvent actionEvent) {
  	    	
  	    	  if(textArea.getText().equals("")){
  	    		mainFrame.setMessage("請輸入網址");
  	    	  }else{
  	    		downloadPanel.removeAll();
  	    		DownloadFile.resetCount();
  	    		Utility.checkLocate(targetFolder.getText());
  	    		mainFrame.getTabbePane().setSelectedIndex(1);
  	    		List<String> lineList = Utility.getURLList(textArea.getText());
  	    		
  	    		
  	    		totalAmount = lineList.size();
  	    		
  	    		mainFrame.setMessage("開始下載，總計檔案數[0/"+totalAmount+"]");
  	    		
  	    		for(int i=0;i<totalAmount;i++){
  	    			
  	    			//處理掉網址列
  	    			String url = lineList.get(i);
  	    			RowPanel rowPanel = new RowPanel(downloadPanel);
  	    			rowPanel.addRowPanel();
  	    			ParamBean param = new ParamBean(url,targetFolder.getText(),i,totalAmount,rowPanel,mainFrame);
  	    			Thread DownLoadFile = new Thread(new DownloadFile(param));
  	    			DownLoadFile.start();
  	    		}
  	    		
  	    	  }
  	      }
    	};
    	
    	btnSelectFolder.addActionListener(folderBtnListener);
    	btnDownload.addActionListener(donwloadBtnListener);
	}
	
	public int getTotalAmount(){
		return totalAmount;
	}
}
