package tests;

import java.util.logging.Level;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserRegisterPage;
import utils.CSVDataProvider;

public class UserRegistrationTest extends BaseTest {

	@Test(priority = 4, enabled = true, dataProvider = "provideUserData")
	public void userRegisterPositive(String firstname, String lastname, String email,String address,String city,String state,String zipcode,String loginName,String password) {
		HomePage hp = new HomePage(driver);
		hp.clickApperal();
		hp.selectProductToAdd(1);
		String priceOne = hp.getProductPrice();
		String trimPrice1 = priceOne.substring(1);
		double p1 = Double.parseDouble(trimPrice1);
		hp.clickAddToCart();
		logger.log(Level.INFO, "Cart Products Added");
		driver.navigate().back();
		driver.navigate().back();
		hp.selectProductToAdd(2);
		String priceTwo = hp.getProductPrice();
		String trimPrice2 = priceTwo.substring(1);
		double p2 = Double.parseDouble(trimPrice2);
		hp.clickAddToCart();
		logger.log(Level.INFO, "Cart Products Added");
		logger.log(Level.INFO, "First Product Price " + p1);
		logger.log(Level.INFO, "One Product Price " + p2);
		logger.log(Level.INFO, "Flat shipping rate " + 2);
		logger.log(Level.INFO, "Actual Total Displayed " + hp.getTotalAmount());
		hp.clickCheckOut();

		UserRegisterPage rp = new UserRegisterPage(driver);
		rp.selectRegisterAndContinue();
		rp.setPersonalDetails(firstname, lastname, email);
		rp.setAddress(address,city,state,zipcode);
		rp.setLoginDetails(loginName, password);
		rp.agreeAndContinue();
		logger.log(Level.INFO, "User Registeration Done ");
		Assert.assertEquals(rp.getUserCreatedText(), "CHECKOUT CONFIRMATION");
	}
	
	@DataProvider(name = "provideUserData")
    public Object[][] provideUserData() {
        return CSVDataProvider.readCSVData("..\\Ecommerce_Testing_Assignment\\testData.csv");
    }

}
