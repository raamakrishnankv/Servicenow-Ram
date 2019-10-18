package org.tl.servicenow.testcases;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tl.servicenow.pages.Login_page;
import org.tl.servicenow.utils.Common_methods;

public class ServiceNow_TC_01 extends Common_methods {
	
	@BeforeClass
	public void setData() {
		enterExcelName ="ServiceNow";
	}

	@Test(dataProvider="serviceNowDB")
	public void ServiceNowTestcase(String userName, String password, String filterData, String callerName, String stDescription) throws InterruptedException {
		Login_page SN = new Login_page();
		SN.enterUserName(userName)
		.enterPassword(password)
		.enterFilterData(filterData)
		.clickCreateNew()
		.getIncidentNum()
		.enterCallerName(callerName+Keys.TAB)
		.enterShortDescription(stDescription)
		.clickRecordSubmit()
		.searchIncidentNum()
		.incidentCrossCheck();
		

	}
}