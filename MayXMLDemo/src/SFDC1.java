import java.io.File;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SFDC1 {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws DocumentException, InterruptedException {
		File inputFile = new File(System.getProperty("user.dir")+"\\config.xml");
		
		SAXReader saxReader = new SAXReader();		
		Document doc = saxReader.read(inputFile);
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		driver = new ChromeDriver();
		
		String URL = doc.selectSingleNode("//menu/URL").getText();
		String UName = doc.selectSingleNode("//menu/UName").getText();
		String PWD = doc.selectSingleNode("//menu/PWD").getText();
		String ID = doc.selectSingleNode("//menu/ID").getText();
		
		driver.get(URL);
		driver.findElement(By.name("username")).sendKeys(UName);
		driver.findElement(By.name("pw")).sendKeys(PWD);
		driver.findElement(By.id(ID)).click();
		
		Thread.sleep(3000);
		
		driver.quit();
		// unable to push code?
		//Changes to readme are not registered as unstaged changes.
	}

}
