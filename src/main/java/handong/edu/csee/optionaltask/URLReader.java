package handong.edu.csee.optionaltask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLReader {
	
	String urlPath;
	StringBuilder contents = new StringBuilder();
	String result="";
	
	public URLReader(String urlPath) {
		this.urlPath = urlPath;
	}
	
	public String getResult() {
		
		try {
			URL url = new URL(urlPath);
			URLConnection connection = (URLConnection)url.openConnection();
			InputStreamReader reader = new InputStreamReader(connection.getInputStream(),"utf-8");
			BufferedReader buff = new BufferedReader(reader);
			
			while((result = buff.readLine())!=null) {
				contents.append(result);
				contents.append("\r\n");
			}
			buff.close();
			    System.out.println(contents.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	

}
