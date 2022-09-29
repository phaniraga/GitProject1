package com.demo.reuse;

import org.openqa.selenium.WebDriver;

import com.demo.ObjectRepo.LoginPage;
import com.demo.config.StartBrowser;
import com.demo.wdcmd.ActionDriver;

public class CommonFunction 
{

	public ActionDriver aDriver;
	public WebDriver driver;
	
	public CommonFunction()
	{
		aDriver  = new ActionDriver();
		driver = StartBrowser.driver;
	}
	
	public void login() throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to Application");
		aDriver.navigateToApplication("https://demo.guru99.com/V1/index.php");
		aDriver.type(LoginPage.txtUsername, "mngr442204", "uid");
		aDriver.type(LoginPage.txtPassword, "Etanyva", "password");
		aDriver.click(LoginPage.btnSubmit, "btnLogin");
		Thread.sleep(5000);
		aDriver.getTitle(LoginPage.txttitle, "/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee");
	}
}

