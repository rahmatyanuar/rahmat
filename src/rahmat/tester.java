package rahmat;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Test;

import picocli.CommandLine;

public class tester {
	@Test
    public void test() {
//        String[] args = "D:\\myapptest.txt JSON".split(" ");
//        new CommandLine(new BidirectionParser()).execute(args);
		
		BidirectionParser app = new BidirectionParser();
		CommandLine cmd = new CommandLine(app);
		
		StringWriter sw = new StringWriter();
		cmd.setOut(new PrintWriter(sw));
//		cmd.execute("convert -");
//		cmd.execute("D:\\account-service-logger.log","-o=D:\\test\\account-service-logger.json");
		cmd.execute("D:\\account-service-logger.log","-t=txt","-o=D:\\test\\account-service-logger.txt");
//		cmd.execute("D:\\account-service-logger.log","-o=D:\\test\\account-service-logger.txt");
//		cmd.execute("D:\\account-service-logger.log");
    }
}
