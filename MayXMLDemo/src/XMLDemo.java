import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class XMLDemo {

	public static void main(String[] args) throws DocumentException {
		File inputFile = new File(System.getProperty("user.dir")+"\\config.xml");
				
		SAXReader saxReader = new SAXReader();		
		Document doc = saxReader.read(inputFile);
		
		String name = doc.selectSingleNode("//menu/name").getText();
		System.out.println(name);
		String company = doc.selectSingleNode("//menu/company").getText();
		System.out.println(company);
		String desig = doc.selectSingleNode("//menu/desig").getText();
		System.out.println(desig);
		//
		
	}

}
