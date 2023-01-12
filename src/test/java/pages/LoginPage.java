package pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	private static final boolean NULL = false;

	WebDriver driver;

	//constructor
	public LoginPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText="Login")
	WebElement LoginBtnText;

	@FindBy(id = "user-name")
	WebElement UserName;
	
	@FindBy(id = "password")
	WebElement UserPassword;
	
	@FindBy(id  = "login-button")
	WebElement btn_Login;
	
	
	// Methods
	
	//Verify the title
	public void verificationAppTitle(String expectedValue) {
		Assert.assertEquals(driver.getTitle(), expectedValue);
		System.out.println("Application Title: " + driver.getTitle());

	}
	
	
	//verify value of login button is login or not.
	public void verifyLoginValue(boolean LoginBtnText) {
		
		if(LoginBtnText!=NULL) {
			System.out.println("Login Button Value is present");
		}else {
			System.out.println("Login Button Value is not present");
		}
	}
	
	
	//Login
	public void enterUsername(String username) {
		UserName.sendKeys(username);
	}
	
	public void enterPass(String pwd) {
		UserPassword.sendKeys(pwd);
	}

	public void clickLoginButton() {

		btn_Login.click();
	}

	
	public ProductsPage navigateToProductsPage() {
		return new ProductsPage(driver);
	}
}
