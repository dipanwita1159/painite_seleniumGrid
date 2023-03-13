package com.mohs10.reuse;
	import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;



import com.mohs10.ActionDriver.Action;
import com.mohs10.base.StartBrowser;
import com.mohs10.or.HomePage;



	public class CommonFuns {
		
		public Action aDriver;
		public static WebDriver driver;
		public CommonFuns() {
			aDriver = new Action();
			driver = StartBrowser.driver;
		}

		


		  public void CommonsFun(String name,String email,String sub,String Msg) throws Exception {
			  StartBrowser.childTest =StartBrowser.parentTest.createNode("Login to DemoWeb shop");
			 
			  JavascriptExecutor je=(JavascriptExecutor)driver;//Instance of js executor
			  je.executeScript("window.scroll(0,1000)\r\n");
			  Thread.sleep(2000);
			  aDriver.click(HomePage.Analog,"click on analoge");
			  Thread.sleep(2000);
			
				je.executeScript("window.scroll(0,2000)\r\n");
			  aDriver.click(HomePage.contactUs, "clicked on contact us");
			  je.executeScript("window.scroll(0,600)\r\n");
			  Thread.sleep(2000);
			  aDriver.type(HomePage.INputname, name,"name");
			  Thread.sleep(100);
			  aDriver.type(HomePage.InputEmail,email, "email");
			  Thread.sleep(100);
			  aDriver.type(HomePage.InputSubject,sub,"sub");
			  Thread.sleep(100);
			  aDriver.type(HomePage.InputMassage,Msg,"msg type");
			  Thread.sleep(100);
			  aDriver.click(HomePage.Sendmsg,"the click to submit");
			  Thread.sleep(2000);
		  }}
		
		
		
	

		
		 