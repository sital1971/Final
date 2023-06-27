package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public Properties config;
	public FileInputStream fis;
	
	public BaseClass() throws IOException {
		config=new Properties();
		fis=new FileInputStream("C:\\Users\\sital\\eclipse-workspace\\Final\\src\\main\\java\\resources\\configuration.properties");
		config.load(fis);
	}
	@BeforeSuite
	public void setUp() {
		
		if(config.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(config.getProperty("browser").equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		} else if(config.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
	}//setUp
	
	public boolean isElementPresent() {
		try {
			driver.findElement(By.xpath("//input[@id='usernam_show']"));
			return true;
		}catch(Throwable t) {
			
			return false;
		} }//presence....
		
		public String takeScreenShot(WebDriver driver) throws IOException {
			Date d=new Date(); String str=d.toString().replace(" ", "_").replace(":","_");
			String path="C:\\Users\\sital\\eclipse-workspace\\Final\\SCREENSHOTS\\" +str+".png";
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest=new File(path);
			FileUtils.copyFile(src, dest);
			return path;
		}//screen
	
	@AfterSuite
   public void tearDown() {
		
		//driver.close();
		
	}

}
