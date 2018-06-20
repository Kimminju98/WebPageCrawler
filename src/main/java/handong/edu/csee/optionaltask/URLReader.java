package handong.edu.csee.optionaltask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLReader {

	String urlPath;
	StringBuilder contents = new StringBuilder();
	String result="";

	public URLReader(String urlPath) {
		this.urlPath = urlPath;
	}

	public String getResult() throws Exception{


		URL oracle = new URL(urlPath);
		BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

		String inputLine;
		while ((inputLine = in.readLine()) != null)
			//System.out.println(inputLine);
			result=result+inputLine;
		in.close();


		return result;
	}


}
