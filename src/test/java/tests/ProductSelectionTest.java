package tests;

import java.util.logging.Level;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductSelectionTest extends BaseTest {

	@Test(priority = 2, enabled = true)
	public void selectAddProductToCart() {
		HomePage hp = new HomePage(driver);
		hp.clickApperal();
		hp.selectProductToAdd(1);
		hp.clickAddToCart();
		logger.log(Level.INFO, "Cart Products Added");
		driver.navigate().back();
		driver.navigate().back();
		hp.selectProductToAdd(2);
		hp.clickAddToCart();
		logger.log(Level.INFO, "Cart Products Added");
		logger.log(Level.INFO, "Cart Products count " + hp.getCartItemCount());
		Assert.assertEquals(hp.getCartItemCount(), "2");
	}
}
