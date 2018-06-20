package handong.edu.csee.optionaltask;


import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;


public class Runner {
	
	String urlPath;
	String outputPath;
	boolean help;
	
	
	public static void main(String[] args) {
		Runner myRunner = new Runner();
		myRunner.run(args);
	}
	
	private void run(String[] args) {
		Options options = createOptions();
		
		if(parseOptions(options, args)){
			if (help){
				printHelp(options);
				return;
			}
			
			URLReader urlreader = new URLReader(urlPath);
			String result = urlreader.getResult();
			DataWriter urlwriter = new DataWriter(outputPath,result);
			
		}
	}
	
	
	private boolean parseOptions(Options options,String[] args) {
		CommandLineParser parser = new DefaultParser();
		
		try {
			CommandLine cmd = parser.parse(options, args);
			
			urlPath = cmd.getOptionValue("u");
			outputPath = cmd.getOptionValue("d");
			help = cmd.hasOption("h");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			printHelp(options);
			return false;
		}
		
		return true;
		
	}
	
	
	private Options createOptions() {
		Options options = new Options();
		
		options.addOption(Option.builder("u").longOpt("urlPath")
				.desc("Set a urlPath")
				.hasArg()
				.argName("URL Path")
				.required()
				.build());
		
		options.addOption(Option.builder("d").longOpt("ouputdir")
				.desc("Set a filename")
				.hasArg()
				.argName("filename to display")
				.required()
				.build());
		
		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help")
				.build());
		
		return options;
		
	}
	
	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "WebPageCrawler program";
		String footer ="\nPlease report issues to 21700097@handong.edu (emails)"; //옵션 설명 후 등장!
		formatter.printHelp("CLIExample", header, options, footer, true);
	}

}
