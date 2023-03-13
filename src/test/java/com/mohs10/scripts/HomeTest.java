package com.mohs10.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.mohs10.ActionDriver.SSreuseclass;
import com.mohs10.ActionDriver.XLUtils;
import com.mohs10.base.StartBrowser;
import com.mohs10.reuse.CommonFuns;

public class HomeTest extends StartBrowser {

	
	  String excelfile = "C:\\Users\\DELL\\demo\\TestData\\Data.xlsx";
	  String excelsheet = "Login"; 
	 
      //WebDriver driver;

	@Test
	public void LoginTestCase() throws Exception {

		CommonFuns hm2 = new CommonFuns();

		
		  int rowcount = XLUtils.getRowCount(excelfile, excelsheet); for (int i = 1; i
		  < rowcount; i++) { String Email = XLUtils.getStringCellData(excelfile,
		  excelsheet, i, 0); String Pwd = XLUtils.getStringCellData(excelfile,
		  excelsheet, i, 1);}
		 
		driver = StartBrowser.launchapp("firefox", "https://mohs10.io/");
		System.out.println(driver);
		
		//hm2.CommonsFun("Dipanwita","dipanwita.chakraborty@mohs10.io", "abc", "abd");

		SSreuseclass.SSReusablemethod(driver,"login");
		Thread.sleep(5000);

		
		// hm2.logout();
	}
	


@Test 
public void LoginTestCase2() throws Exception {

	CommonFuns hm2 = new CommonFuns();

	
	  int rowcount = XLUtils.getRowCount(excelfile, excelsheet); for(int
	  i=1;i<rowcount;i++) { String Email = XLUtils.getStringCellData(excelfile,
	  excelsheet, i, 0); String Pwd = XLUtils.getStringCellData(excelfile,
	  excelsheet, i, 1);}
	 
					driver=StartBrowser.launchapp("chrome","https://mohs10.io/");
					//hm2.CommonsFun("Dipanwita","dipanwita.chakraborty@mohs10.io", "abc", "abd");
							//hm2.Blogbtn("http://demowebshop.tricentis.com/","chrome");

							SSreuseclass.SSReusablemethod(driver, "Login");
							Thread.sleep(5000);

							// hm2.logout(); }

	}


}
