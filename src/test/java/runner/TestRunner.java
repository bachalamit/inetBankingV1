/**
 * 
 */
package runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

/**
 * @author AMIT123
 *
 */
public class TestRunner {

	public static void main(String[] args) {

		TestNG runner = new TestNG();
		
		List<String> list = new ArrayList<String>();
		list.add("C:\\Users\\AMIT123\\eclipse-workspace\\inetBankingV1\\test-output\\Failed suite [Failed suite [Failed suite [Failed suite [InetBankingV1]]]]\\testng-failed.xml");
		
		runner.setTestSuites(list);
		runner.run();
	}

}
