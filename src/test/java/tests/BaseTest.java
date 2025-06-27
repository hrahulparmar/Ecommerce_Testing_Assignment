package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	public static WebDriver driver;
	protected static Logger logger;

	@BeforeSuite
	public void startReport() throws SecurityException, IOException {
		logger = Logger.getLogger(BaseTest.class.getName());
		FileHandler fileHandler = new FileHandler("report.txt", true);
		fileHandler.setFormatter(new SimpleFormatter());
		logger.addHandler(fileHandler);
	}

	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();
		logger.log(Level.INFO, "Browser started");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://automationteststore.com/");
		logger.log(Level.INFO, "navigated to  https://automationteststore.com/");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		logger.log(Level.INFO, "Browser Closed");
	}

	public String captureScreen(String tname) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;
	}
}
