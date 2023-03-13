package com.mohs10.base;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class StartBrowser {
	public static WebDriver driver;
	//set up report
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	ExtentSparkReporter sparkReporter;
	//keyword
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void generateReport()
	{
		sparkReporter = new ExtentSparkReporter("Report/AutomationReport.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
	}

	@BeforeMethod
	public void methodName(Method method)
	{
		parentTest = extent.createTest(method.getName()); 
	}
	@Test
	public static  WebDriver launchapp(String browser,String Url) throws MalformedURLException, InterruptedException { 


		if (browser.equalsIgnoreCase("firefox")) {
			DesiredCapabilities capability =new DesiredCapabilities();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.ANY);
			FirefoxOptions Options=new FirefoxOptions();
			Options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			Options.merge(capability);
			String Node = "http://localhost:4444/wd/hub";
			driver = new RemoteWebDriver(new URL(Node), Options);
			driver.get(Url);
			driver.manage().window().maximize();
			System.out.println("firefox closed");
			Thread.sleep(5000);



		}


		else if(browser.equalsIgnoreCase("chrome")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WIN10);

			ChromeOptions options = new ChromeOptions();
			options.merge(cap);

			System.out.println(" Executing on CHROME");
			String Node = "http://localhost:4444/wd/hub"; 
			driver = new RemoteWebDriver(new URL(Node), options);

			// Launch website 
			driver.get(Url);
			driver.manage().window().maximize();
			Thread.sleep(5000);
			System.out.println("chrome closed");

		}


		else if (browser.equalsIgnoreCase("msedge")) { // Check if the browser is Microsoft Edge
			DesiredCapabilities cap =  new DesiredCapabilities();
			cap.setBrowserName("msedge");
			cap.setPlatform(Platform.WIN10);
			EdgeOptions option = new EdgeOptions();
			option.merge(cap);


			String node = "http://localhost:4444/wd/hub";
			System.out.println("Executing on edge");

			driver = new RemoteWebDriver(new URL(node), option);



			// Create a new RemoteWebDriver to run the Edge driver on a remote machine

			// Launch website
			driver.get(Url);
			driver.manage().window().maximize();
			Thread.sleep(5000);
			System.out.println("edge closed");
			driver.close();

		}


		else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}



		return driver;
	}

	@Test(priority = 2)
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		// WebDriverManager.firefoxdriver().setup();
		//WebDriverManager.edgedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@AfterClass public void afterClass() {

		driver.close();
		extent.flush(); 
	}


}

