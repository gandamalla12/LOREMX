package com.LOREM.Actions;

import org.testng.annotations.Listeners;

import com.LOREM.Pages.LoginPage;
import com.LOREM.genericLib.BaseTest;
import com.LOREM.genericLib.FileLib;
import com.LOREM.genericLib.WebDriverCommonLib;

@Listeners(com.LOREM.genericLib.MyListeners.class)
public class ValidLoginTest extends BaseTest{


	public void loginToApp() throws Throwable {
		LoginPage lp=new LoginPage();
	    FileLib fl=new FileLib();
		lp.login(fl.readPropData(PROP_PATH, "username"), fl.readPropData(PROP_PATH, "password"));
	    WebDriverCommonLib wlib = new WebDriverCommonLib();
	    wlib.verify(wlib.getPageTitle(), fl.readPropData(PROP_PATH,"homeTitle"), "Home page");
	
	}
}