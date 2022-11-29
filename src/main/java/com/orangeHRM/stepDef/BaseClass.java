package com.orangeHRM.stepDef;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.aventstack.extentreports.ExtentTest;
import com.orangeHRM.reports.Report;
import com.orangeHRM.utils.Util;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class BaseClass {

	public static WebDriver driver;
	public static ExtentTest report;
	static String reportsPath = "", htmlPath = "";

	@BeforeAll
	public static void before_all() {
		reportsPath = System.getProperty("user.dir") + "//Reports//" + Util.getFolderName();

	}

	@org.junit.Before
	@Before
	public void beforeMethod(Scenario scenario) {
		String browser = Util.readProperty("browser");
		String url = Util.readProperty("url");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.driver.chromedriver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.driver.geckodriver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.driver.edgedriver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			System.setProperty("webdriver.driver.safaridriver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new SafariDriver();
		}
		htmlPath = reportsPath + "\\" + scenario.getName() +"_"+Util.getRandomNumWithCurrentDate()+ ".html";
		report = Report.startReport(htmlPath, scenario.getName(), "");
		report.info("************* Execution started ******************");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		System.out.println(browser + " was launched, and '" + url + "' opened.");
	}

	@org.junit.After
	@After
	public void afterMethod() {
		if (driver != null) {
			driver.quit();
		}
		Report.getReporter(htmlPath).flush();
		report.info("**************** Execution completed ****************");
	}

	@AfterAll
	public static void after_all() {

	}

}
