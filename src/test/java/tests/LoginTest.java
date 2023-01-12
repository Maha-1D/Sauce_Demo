package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

	@Test
	public void verifyLogin() throws Exception {
		
		Thread.sleep(3000);
		
		//1. Verify the title as Swag Labs
		lp.verificationAppTitle("Swag Labs");
		
		//2.Verify the login button value is Login or not.
		lp.verifyLoginValue(true);
		
		//3.Login with standard_user & secret_sauce
		lp.enterUsername(conf.getUsername());
		lp.enterPass(conf.getPassword());
		lp.clickLoginButton();
		System.out.println("Logged in successfully");
		
		//4. Verify default filter dropdown is A-Z
		//pp.verifyDropDownValue("Name (A to Z)"); //index 0 value
		pp.verifyDefaultDropDownValue("NAME (A TO Z)"); //active value
		
		//5.Add the first product to the cart
		pp.addFirstProduct();
		
		//6.Verify the cart badge has 1 product
		pp.verifyCartValue();
	
	 	//7. Add the last product to the cart
		pp.addLastProduct();
	
		//8. Verify the cart badge value is increased
		pp.verifyCartValueIncreased("2");
		
	 	//9. Remove the first product from the cart
		pp.removeFirstProduct();
		
		//10.Verify the cart badge has 1 product
		pp.verifyCartValue2();
		
		//11. Click on the cart 🛒
		pp.clickOnCartBtn();
		
		//12. Verify the added product is available
		pp.verifyAddedProduct("Test.allTheThings() T-Shirt (Red)");
		
		//13. Click on the continue shopping
		pp.clickOnContinueShoppingBtn();
		
	 	//14. Change the price filter from low to high
		pp.filterPriceValue();
	}
	
	
	
//	//@Test
//	public void verifyLogout() {
//		
//		lp.clickLogoutButton();
//	}
}
