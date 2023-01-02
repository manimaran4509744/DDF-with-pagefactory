package org.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pageObjects.LoginPageObjects;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public Object[][] data;
	public LoginPageObjects page;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		page = new LoginPageObjects(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();

	}

	@DataProvider(name = "credentials")
	public Object[][] getExcelData() throws IOException {

		String path = "C:\\Users\\admin\\eclipse-workspace\\DataDrivenTest\\TestData\\TestData.xlsx";
		File f = new File(path);
		FileInputStream file = new FileInputStream(f);
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheetAt(0);
		int rowsCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row1 = sheet.getRow(0);
		int columnCount = row1.getPhysicalNumberOfCells();
		data = new Object[rowsCount - 1][columnCount];

		for (int i = 1; i < rowsCount; i++) {
			XSSFRow row = sheet.getRow(i);
			int colCount = row.getPhysicalNumberOfCells();

			for (int j = 0; j < colCount; j++) {
				DataFormatter data2 = new DataFormatter();
				data[i - 1][j] = data2.formatCellValue(row.getCell(j));

			}
		}
		workBook.close();
		return data;
	}

}
