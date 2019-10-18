package org.tl.servicenow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.tl.servicenow.utils.Common_methods;

public class System_admin_page extends Common_methods{

	public System_admin_page() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='filter']")WebElement elefliter;
	@FindBy(how=How.XPATH, using="(//*[contains(text(),'Create New')])[1]")WebElement eleCreateNew;
	
	public System_admin_page enterFilterData(String filterData) throws InterruptedException {
		elefliter.sendKeys(filterData);
		
		return this;
	}
	
	public Create_incident_page clickCreateNew() {
		eleCreateNew.click();
		return new Create_incident_page();
	}
	
	
	
	
	
	
	
}