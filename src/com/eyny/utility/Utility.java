package com.eyny.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;



public class Utility {

	  public static String getFullStr(String str, int n){
		  
		  if(str == null|| str.length() >n)
			  return str;
		  else {
			  while (str.length() <n){
				  str="0"+str;
			  }
		  }
		  return str;
	  }
	  
	  public static List<String> getURLList(String text){
		  
		  List<String> urlList = new ArrayList<String>();
		  
		  String [] tempArray = text.split(".jpg|.png");
		   
		 for(int i=0;i<tempArray.length-1;i++){
			  String tempData = tempArray[i];
    		  int urlPosS = tempData.lastIndexOf("http://");
    		  String url = tempData.substring(urlPosS)+".jpg";
    		  urlList.add(url);
		  }
		  
		  return urlList;
	  }
	  
	  public static void checkLocate(String target){
		  
		  File file_date = new File(target); 
		  if (file_date.exists()==false) { 
			  boolean file_true = file_date.mkdirs(); 
			  
		  }
	  }
}
