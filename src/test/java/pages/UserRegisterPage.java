package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tests.BaseTest;

public class UserRegisterPage extends BaseTest {

	WebDriver driver;

	public UserRegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//label[@for='accountFrm_accountregister']")
	WebElement registerRadioBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement continueBtn;
	
	@FindBy(xpath = "//input[@id='AccountFrm_firstname']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='AccountFrm_lastname']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='AccountFrm_email']")
	WebElement emailip;
	
	@FindBy(xpath = "//input[@id='AccountFrm_address_1']")
	WebElement address;
	
	@FindBy(xpath = "//input[@id='AccountFrm_city']")
	WebElement city;
	
	@FindBy(xpath = "//select[@id='AccountFrm_zone_id']")
	WebElement state;
	
	@FindBy(xpath = "//input[@id='AccountFrm_postcode']")
	WebElement zipCode;
	
	@FindBy(xpath = "//input[@id='AccountFrm_loginname']")
	WebElement loginName;
	
	@FindBy(xpath = "//input[@id='AccountFrm_password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='AccountFrm_confirm']")
	WebElement confirmPass;
	
	@FindBy(xpath = "//input[@id='AccountFrm_agree']")
	WebElement agreeCheckBox;
	
	@FindBy(xpath = "//span[@class='maintext']")
	WebElement userCreatedMsg;
	
	public String getUserCreatedText() {
		return userCreatedMsg.getText();
	}
	
	public void agreeAndContinue() {
		agreeCheckBox.click();
		continueBtn.click();
	}
	
	public void setLoginDetails(String loginnameText,String passText) {
		loginName.sendKeys(loginnameText);
		password.sendKeys(passText);
		confirmPass.sendKeys(passText);
	}
	
	public void setAddress(String street,String cityText,String stateSelect, String zipCodeText) {
		address.sendKeys(street);
		city.sendKeys(cityText);
		Select s = new Select(state);
		s.selectByVisibleText(stateSelect);
		zipCode.sendKeys(zipCodeText);
		
	}
	
	
	
	public void selectRegisterAndContinue() {
		registerRadioBtn.click();
		continueBtn.click();
	}
	
	public void setPersonalDetails(String firstname,String lastname,String email) {
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		emailip.sendKeys(email);
		
	}
	
	
	
}
