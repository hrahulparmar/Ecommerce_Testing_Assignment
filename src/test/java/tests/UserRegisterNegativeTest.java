package tests;

import java.util.logging.Level;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserRegisterPage;
import utils.CSVDataProvider;

public class UserRegisterNegativeTest extends BaseTest {

	@Test(priority = 5, enabled = true, dataProvider = "provideUserData")
	public void UserRegisterNegative(String firstname, String lastname, String email, String address, String city,
			String state, String zipcode, String loginName, String password) {
		HomePage hp = new HomePage(driver);
		hp.clickApperal();
		hp.selectProductToAdd(1);
		hp.clickAddToCart();
		logger.log(Level.INFO, "Cart Products Added");
		driver.navigate().back();
		driver.navigate().back();
		hp.selectProductToAdd(2);
		hp.clickAddToCart();
		hp.clickCheckOut();

		UserRegisterPage rp = new UserRegisterPage(driver);
		rp.selectRegisterAndContinue();
		rp.setPersonalDetails(firstname, lastname, email);
		rp.setAddress(address, city, state, zipcode);
		// rp.setLoginDetails(loginName, password);
		rp.agreeAndContinue();
		logger.log(Level.WARNING, "User Registeration failed ");
		Assert.assertEquals(rp.getUserCreatedText(), "CHECKOUT CONFIRMATION");

	}

	@DataProvider(name = "provideUserData")
	public Object[][] provideUserData() {
		return CSVDataProvider.readCSVData("..\\\\Ecommerce_Testing_Assignment\\\\testData.csv");
	}
}
