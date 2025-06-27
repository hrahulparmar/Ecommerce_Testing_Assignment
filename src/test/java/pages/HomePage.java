package pages;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tests.BaseTest;

public class HomePage extends BaseTest {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='nav-pills categorymenu']/li/a")
	List<WebElement> categoryNames;

	@FindBy(xpath = "//ul[@class='thumbnails row']/li")
	List<WebElement> subCategories;

	@FindBy(xpath = "//div[@class='col-md-3 col-sm-6 col-xs-12']//a[@title='Add to Cart']")
	List<WebElement> addTocart;

	@FindBy(xpath = "//a[normalize-space()='Add to Cart']")
	WebElement addToCartBtn;

	@FindBy(xpath = "(//span[@class='label label-orange font14'])[2]")
	WebElement cartItemCount;

	@FindBy(xpath = "//span[@class='bgnone']")
	WebElement productName;

	@FindBy(xpath = "//div[@class='productfilneprice']")
	WebElement productPrice;

	@FindBy(xpath = "//input[@id='product_quantity']")
	WebElement productQuantity;

	@FindBy(xpath = "//div[@class='thumbnail']//span[@class='nostock']")
	List<WebElement> noStockProduct;
	
	@FindBy(xpath = "//span[@class='bold totalamout']")
	WebElement totalAmount;
	
	@FindBy(xpath = "//a[@id='cart_checkout1']")
	WebElement checkOutBtn;
	
	public void clickCheckOut() {
		checkOutBtn.click();
	}

	public double getTotalAmount() {
		String totalS = totalAmount.getText().substring(1);
		double totalD=Double.parseDouble(totalS);
		return totalD;
	}
	
	public String getProductQty() {
		return productQuantity.getDomAttribute("value");
	}

	public String getProductPrice() {
		return productPrice.getText();
	}

	public String getProductName() {
		return productName.getText();
	}

	public String getProductUrl() {
		return driver.getCurrentUrl();
	}

	public String getCartItemCount() {
		return cartItemCount.getText();
	}

	public void selectProductToAdd(int num) {
		if (addTocart.get(num).isDisplayed()) {
			addTocart.get(num).click();
			logger.log(Level.INFO, "Product Name " + productName.getText());
			logger.log(Level.INFO, "Product Price " + productPrice.getText());
			logger.log(Level.INFO, "Product Quantity " + productQuantity.getDomAttribute("value"));
			logger.log(Level.INFO, "Product URL " + driver.getCurrentUrl());

		} else {
			logger.log(Level.INFO, "Out of Stock Product " + addTocart.get(num).getText());
		}
	}

	public void clickAddToCart() {
		addToCartBtn.click();
	}

	public void clickApperal() {
		categoryNames.get(1).click();
	}

	public void getAllCategory() {
		for (WebElement name : categoryNames) {
			System.out.println(name.getText());
		}
	}

	public void moveToRandomCategory() {

		Random random = new Random();
		int randomNumber = random.nextInt(2, 8);
		WebElement catElement = categoryNames.get(randomNumber);
		Actions act = new Actions(driver);
		act.moveToElement(catElement).click().perform();

	}

	public int getSubCategoryCount() {
		int count = subCategories.size();
		return count;
	}

}
