package com.eyny.download;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.eyny.swing.MainFrame;
import com.eyny.swing.RowPanel;
import com.eyny.utility.Utility;


public class DownloadFile  implements Runnable{
	  private ParamBean param;
	  private static int count=0;
	  //
	  
	  public DownloadFile(ParamBean theParam){
		  this.param = theParam;
	  }
	  
	  public void run() { // override Thread's run()
	        	
		  String theURL = param.getPicURL();
		  int picNo = param.getPicNo()+1;
		  int totalNum = param.getTotalNum();
		  String tarPos = param.getTarPos();
		  RowPanel rowPanel = param.getRowPanel();
		  MainFrame mainFrame = param.getMainFrame();
		  
		  try {
			  rowPanel.setUrlName(theURL);
			  rowPanel.setProgBar();
			  
			  download(rowPanel,theURL,tarPos+"/pic"+Utility.getFullStr(Integer.toString(picNo),3)+".jpg");
			  
			  //�p�G�i�H�b�o�̩I�s �h��Y�ӨC��Thread�@�P�s�����ܼ�+1
			  methodAdd(mainFrame,mainFrame.getInputPanel().getTotalAmount());
		  } catch (Exception e) {
			System.out.println("ERROR In DownloadFile:"+theURL);
		  }
	  }
	  
	  public void download(RowPanel rowPanel,String source, String destination) throws IOException{
		  
		  
		  int downloadFileSize =0;
		  
		  URL downLoadURL = new URL(source);
		  URLConnection conn = downLoadURL.openConnection();
		  
		  //�p���`�ɮפj�p
		  int contentLength = conn.getContentLength();
			if (contentLength == -1) {
				System.out.println("unknown content length");
			}
			
			int datakb = contentLength/1024;
			
			rowPanel.addProgText(" 0 KB/"+datakb+" KB ");
//		  /�p��ثe�U���q	
			
		  InputStream is = conn.getInputStream();
		  FileOutputStream fos = new FileOutputStream(destination);
		  byte [] buffer = new byte[1024];
		  for(int lenght; (lenght = is.read(buffer))>0;fos.write(buffer, 0, lenght)){
			  downloadFileSize +=lenght;
			  rowPanel.setProgBarValue(downloadFileSize*100/contentLength);
			  int currentKb = downloadFileSize/1024;
			  rowPanel.setProgCurrent(" "+currentKb+" KB/"+datakb+" KB ");
		  }  
			  
		  fos.close();
		  is.close();
	  }
	  
	  
	  public static synchronized void methodAdd(MainFrame mainFrame, int totolAmount){
		  count++;
		  if(count!=totolAmount){
			  mainFrame.setMessage("�}�l�U���A�`�p�ɮ׼�["+count+"/"+totolAmount+"]");
		  }else{
			  mainFrame.setMessage("�U�������A�`�p�ɮ׼�["+count+"/"+totolAmount+"]");
		  }
	  }
	  
	  public static void resetCount(){
		  count=0;
	  }
	  
	  
}
