package com.LOREM.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LOREM.Pages.CreateCampaignPage;
import com.LOREM.Pages.DisplayCustomViewPage;
import com.LOREM.Pages.HomePage;
import com.LOREM.genericLib.BaseTest;
import com.LOREM.genericLib.FileLib;
import com.LOREM.genericLib.WebDriverCommonLib;


@Listeners(com.LOREM.genericLib.MyListeners.class)
    public class VerifyActionsCreation extends BaseTest{
	
	@Test
		public void verifyActionTest() throws Throwable {
	//Open the browser and Enter the Test url and click on Go button and Verify Login Page
	
//	Login to App and verify HOME PAGE
	ValidLoginTest vl= new ValidLoginTest();
	vl.loginToApp();
		
	//Click on 'Action' module on the Home Page
    HomePage hp= new HomePage();
    hp.clickCampaignTab();
    
    WebDriverCommonLib wlib= new WebDriverCommonLib();
    FileLib flib= new FileLib();
    wlib.waitForPage(flib.readPropData(PROP_PATH, "customViewTitle"));
    wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "customViewTitle"), "Custom View Page");

	//click on New Action button
    DisplayCustomViewPage dcvp=new DisplayCustomViewPage();
	dcvp.clickNewCampaignBtn();
	wlib.waitForPage(flib.readPropData(PROP_PATH, "createCampaignTitle"));
	wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "createCampaignTitle" ), "Create Campaign Page");
	
	CreateCampaignPage ccp= new CreateCampaignPage();
	ccp.enterCapaignName("Harika");
	ccp.clickSaveBtn();
	Thread.sleep(2000);
	hp.clickCampaignTab();
	Thread.sleep(2000);
	dcvp.verifyCampaignCreation("Harika");
		
	}
}
