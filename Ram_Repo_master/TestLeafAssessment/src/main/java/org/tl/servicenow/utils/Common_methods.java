package org.tl.servicenow.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class Common_methods {
	public static RemoteWebDriver driver;
	public String enterExcelName;
	public static String genIncidentNum;

	@Parameters({ "BROWSER", "URL" })
	@BeforeMethod
	public void wakeUpBrowser(String browser, String url) {

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "opera":
			System.setProperty("webdriver.opera.driver","./drivers/operadriver.exe");
			driver = new OperaDriver();
			break;
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}

	@AfterMethod
	public void killBrowser() {
		driver.quit();
	}

	@DataProvider(name = "serviceNowDB")
	public String[][] dataBase() throws IOException {
		String[][] data = Excel_library.readExcel(enterExcelName);
		return data;

	}

}
