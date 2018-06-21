package handong.edu.csee.optionaltask;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DataWriter {

	String filename;
	String result;

	public DataWriter(String outputpath,String result) {
		this.filename = outputpath+"output.html"; 
		this.result=result;
	}

	public void getOutputFile() {

		PrintWriter out = null;
		//System.out.println(result);

		try {
			out = new PrintWriter(filename);

			out.write(result+"\n");
		}catch(FileNotFoundException e) {
			System.out.println("Error opening the file " + filename);
			System.exit(0);
		}

		out.close();
	}

}
