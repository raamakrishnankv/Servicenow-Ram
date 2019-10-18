package org.tl.servicenow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.tl.servicenow.utils.Common_methods;

public class Create_incident_page extends Common_methods {
	
	
	
	public Create_incident_page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH, using="//input[@id='incident.number']")WebElement eleNewRecordNum;
	@FindBy(how=How.XPATH, using="//input[@id='sys_display.incident.caller_id']")WebElement eleCaller;
	@FindBy(how=How.XPATH, using="//input[@id='incident.short_description']")WebElement eleDescription;
	@FindBy(how=How.XPATH, using="(//button[@type='submit'])[3]")WebElement eleRecordSubmit;
	
	public Create_incident_page getIncidentNum() {
		driver.switchTo().frame(0);
		genIncidentNum = eleNewRecordNum.getAttribute("value");
		System.out.println("Generated Incident Number is:  "+genIncidentNum);
		return this;
	}
	
	public Create_incident_page enterCallerName(String callerName) throws InterruptedException {
		eleCaller.clear();
		eleCaller.sendKeys(callerName);
		return this;
	}
	
	public Create_incident_page enterShortDescription(String StDescription) throws InterruptedException {
		eleDescription.sendKeys(StDescription);
		return this;
	}
	
	public Incident_retrive_page clickRecordSubmit() throws InterruptedException {
		
		
		WebElement submit = driver.findElementByXPath("(//button[@id='sysverb_insert'])[2]");
		new Actions(driver).click(submit).build().perform();
		System.out.println("click worked");
		return new Incident_retrive_page();
	}
	
	
	
	
	

	
}
