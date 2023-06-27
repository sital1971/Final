package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.LoginPage;
@Listeners(resources.Listener.class)
public class LoginTest extends BaseClass {
	
	
	public LoginTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(dataProvider="getData")
	public void doLogin(String name, String password) {
		driver.get(config.getProperty("url"));
		driver.manage().window().maximize();
		LoginPage login =new LoginPage(driver);
		login.enterUserName(name);
		login.enterUserPassword(password);
		login.clickLoginButton();
		Assert.assertEquals(isElementPresent(), true);
	}

	@ DataProvider
	public String[][] getData() throws IOException {
		FileInputStream f=new FileInputStream("C:\\Users\\sital\\eclipse-workspace\\Final\\src\\main\\java\\resources\\testData.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet sheet=wb.getSheetAt(0);
		XSSFRow row=sheet.getRow(0);
		XSSFCell cell;
		int rows=sheet.getPhysicalNumberOfRows();
		int cols=row.getLastCellNum();
		String[][]data=new String[rows-1][cols];
		for(int i=0; i<rows-1;i++) {
			row=sheet.getRow(i+1);
			
			for(int j=0; j<cols; j++) {
				cell=row.getCell(j);
				data[i][j]=cell.getStringCellValue();
			                                       } 		
	                                	}//for
		
		
		return data;
		
	}
}
