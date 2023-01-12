package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.LoginPage;
import pages.ProductsPage;
import utility.ReadConfig;

public class BaseTest {

	WebDriver driver;
	ReadConfig conf;
	LoginPage lp;
	ProductsPage pp;
	
	@BeforeTest
	public void launchApp() throws Exception {

		// launching application
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		conf = new ReadConfig();
		driver.get(conf.appURL());
		
		lp = new LoginPage(driver);
		pp=new ProductsPage(driver);
			
	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(3000);
		driver.close();
	}

}
