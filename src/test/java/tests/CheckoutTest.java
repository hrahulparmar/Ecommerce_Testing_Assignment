package tests;

import java.util.logging.Level;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class CheckoutTest extends BaseTest {

	@Test(priority = 3, enabled = true)
	public void verifyCheckoutFlow() {
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
		logger.log(Level.INFO, "Second Product Price " + p2);
		logger.log(Level.INFO, "Flat shipping rate " + 2);
		logger.log(Level.INFO, "Actual Total Displayed " + hp.getTotalAmount());
		Assert.assertEquals(hp.getTotalAmount(), p1 + p2 + 2);
	}
}
