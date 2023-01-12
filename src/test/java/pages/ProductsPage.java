package pages;

import java.util.List;

//import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductsPage extends LoginPage{


	public ProductsPage(WebDriver rdriver) {
		super(rdriver);
	}
	
	@FindBy(className = "active_option")
	WebElement DropDownDefaultValue;
	
	//@FindBy(tagName="option") //index 0 
	//List<WebElement> op;
	
	@FindBy(xpath="//*[@id=\"add-to-cart-sauce-labs-backpack\"]") //first Add to cart btn
	WebElement firstProduct;
	
	@FindBy(xpath="//a/span[contains(text(),'1')]/parent::a[@class='shopping_cart_link']")
	//WebElement cart;
	List<WebElement> cart1;
	
	@FindBy(xpath="//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")
	WebElement lastProduct;
	
	@FindBy(xpath="//a/span[contains(text(),'2')]/parent::a[@class='shopping_cart_link']")
	WebElement cart2;

	@FindBy(xpath="//*[@id=\"remove-sauce-labs-backpack\"]")
	WebElement removefirstProduct;
	
	@FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a")
	WebElement cart_btn;
	
	@FindBy(className="inventory_item_name")
	WebElement cartProduct;
	
	@FindBy(id="continue-shopping")
	WebElement continueBtn;
	
	@FindBy(xpath="//*[@id=\"header_container\"]/div[2]/div[2]/span/select")
	WebElement dropdownContainer;
	
	//4. Verify default filter dropdown is A-Z
 	public void verifyDefaultDropDownValue(String expected) {
 		
 		//String actual=op.get(0).getText(); //index 0 value
 		//Assert.assertEquals(actual, expected);
 		
 		String actual=DropDownDefaultValue.getText();
 		System.out.println("Default dropdown value: " +DropDownDefaultValue.getText());
 		Assert.assertEquals(actual, expected);
 	}
	
 	
 	//5.Add the first product to the cart
 	public void addFirstProduct() throws InterruptedException {
 		
 		firstProduct.click();
 		System.out.println("Added first product successfully");
 		Thread.sleep(3000);
 		
 	}
 	
 	//6.Verify the cart badge has 1 product
 	public void verifyCartValue() throws InterruptedException {
 		
 		Thread.sleep(3000);
 		
 		List<WebElement> Itemscount=cart1;
 		if(Itemscount.isEmpty()) {
 			System.out.println("Cart is empty");
 		}else {
 			System.out.println(Itemscount.size()+ ": Item added successfully");
 		}
 		Thread.sleep(3000);
 	}
 	
 	
 	//7. Add the last product to the cart
 	public void addLastProduct() throws InterruptedException {
 		lastProduct.click();
 		System.out.println("Added last product successfully");
 		Thread.sleep(3000);
 	}
	
 	//8. Verify the cart badge value is increased
 	public void verifyCartValueIncreased(String expected) throws InterruptedException {
 		Assert.assertEquals(cart2.getText(), expected);
		System.out.println(cart2.getText() + " : Item added successfully ");
		Thread.sleep(3000);
 	}
 	
 	//9. Remove the first product from the cart
 	public void removeFirstProduct() throws InterruptedException {
 		removefirstProduct.click();
 		System.out.println("Removed First product from the cart successfully");
 		Thread.sleep(2000);
 	}
 	
 	//10.Verify the cart badge has 1 product
 	 public void verifyCartValue2() throws InterruptedException {
 	 		 	 		
 	 	List<WebElement> Itemscount=cart1;
 	 	if(Itemscount.isEmpty()) {
 	 		System.out.println("Cart is empty");
 	 	}else {
 	 		System.out.println(Itemscount.size()+ ": Item is there in cart");
 	 	}
 	 		Thread.sleep(3000);
 	 }
 	 	
 	 //11. Click on the cart 🛒
 	 public void clickOnCartBtn() throws InterruptedException {
 		cart_btn.click();
 		Thread.sleep(3000);
 	 }

 	//12. Verify the added product is available
 	public void verifyAddedProduct(String expected) throws InterruptedException {
 		Assert.assertEquals(cartProduct.getText(), expected);
 		System.out.println("'"+cartProduct.getText()+"'" + " product is available");
 		Thread.sleep(3000);
 	}
 	

 	//13. Click on the continue shopping
 	public void clickOnContinueShoppingBtn() throws InterruptedException {
 		continueBtn.click();
 		Thread.sleep(3000);
 	}
 	
 	//before sorting low to high
 	@FindBy(className="inventory_item_price")
 	WebElement beforePrices;

 	//before sorting low to high
 	 @FindBy(className="inventory_item_price")
 	 WebElement afterPrices;
 	
 	//14. Change the price filter from low to high
 	public void filterPriceValue() throws InterruptedException {
 		
 		System.out.println("Before Sorting Prices starts from: "+ beforePrices.getText()); //$29.99
 		Thread.sleep(3000);
 		
 		
 		dropdownContainer.click();
 		Thread.sleep(2000);
 		
 		Select opt=new Select(dropdownContainer);
 		opt.selectByVisibleText("Price (low to high)");
 		Thread.sleep(2000);
 		
 	 	//15. Verify the price sorted properly
 		System.out.println("After Sorting Prices starts from: "+ afterPrices.getText()); //$7.99

 	}
 	
 	 	
}
