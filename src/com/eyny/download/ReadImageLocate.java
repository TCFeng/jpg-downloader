package com.eyny.download;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadImageLocate {

	public static List getURLList() throws IOException{
		
		List urlList = new ArrayList();
		
		FileInputStream fStream = new FileInputStream("D:/imagSource/picURL.txt");
		
		DataInputStream in = new DataInputStream(fStream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String strLine;
		
		while((strLine = br.readLine()) != null){
			
			
			int urlPosE = strLine.indexOf(".jpg")+4;			
			String tempURL = strLine.substring(0, urlPosE);			
			int urlPosS = tempURL.lastIndexOf("http://");
			
			//³B²z±¼ºô§}¦C
			String url = tempURL.substring(urlPosS);
			
			urlList.add(url);
		}
		
		return urlList;
	}
	
}
