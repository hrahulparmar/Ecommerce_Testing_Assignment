package tests;

import java.util.logging.Level;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class HomepageVerificationTest extends BaseTest {

	@Test(priority = 1, enabled = true)
	public void printAllCategory() {
		HomePage hp = new HomePage(driver);
		hp.getAllCategory();
		logger.log(Level.INFO, "Printed all categories");
		hp.moveToRandomCategory();
		int catCount = hp.getSubCategoryCount();
		System.out.println(catCount);
		logger.log(Level.INFO, "Visible Products count " + catCount);
		if (catCount <= 3) {
			logger.log(Level.SEVERE, "Subcategories less than 3 Test Fail");

		}
		Assert.assertTrue(catCount >= 3, "Subcategories less than 3");
	}

}
