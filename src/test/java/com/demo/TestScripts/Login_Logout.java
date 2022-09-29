package com.demo.TestScripts;

import org.testng.annotations.Test;

import com.demo.config.StartBrowser;
import com.demo.reuse.CommonFunction;

public class Login_Logout extends StartBrowser
{
	@Test
	public void Login_LogoutTestCase() throws Exception
	{
		CommonFunction cfs = new CommonFunction();
		cfs.login();
		Thread.sleep(5000);
	}

}
