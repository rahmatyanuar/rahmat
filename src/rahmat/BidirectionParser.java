package rahmat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "convert", mixinStandardHelpOptions = true, version = "parser 1.0 created By Rahmat Yanuar (rachmat.januar1990@gmail.com)", description = "Converting Plain text to JSON or JSON to Plain text.")
class BidirectionParser implements Callable<Integer> {
	@Parameters(index = "0", description = "The file whose to convert.")
	private File file;

	@Option(names = { "-t" }, description = "Text, JSON")
	private String type = null;
	
	@Option(names = { "-o" }, description = "Destination Location")
	private String destination;
	
	@Override
	public Integer call() throws Exception {
		String status = this.parseProcess(file,destination,type);
		System.out.println(status);
		return null;
	}
	
	private String doParse(String dest, String ext) {
		byte[] fileContents = null;
		try {
			fileContents = Files.readAllBytes(file.toPath());
			FileOutputStream stream = null;
			if(dest == null) {
				stream = new FileOutputStream(file.getPath().replace(".log", "."+ext));
			}else {
				stream = new FileOutputStream(dest);
			}
			stream.write(fileContents);
			return "Done";
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			return e2.getMessage();
		}
	}
	
	private String parseProcess(File file, String dest, String type) {
		String res = null;
		if(type == null) {
			type = "txt";	
		}
		type.toLowerCase();
		try {
			res=this.doParse(dest, type);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return res;
	}
	
	public static void main(String... args) {
        int exitCode = new CommandLine(new BidirectionParser()).execute(args);
        System.exit(exitCode);
    }
}
