package org.tl.servicenow.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.tl.servicenow.utils.Common_methods;

public class Incident_retrive_page extends Common_methods {

	public Incident_retrive_page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "(//input[@class='form-control'])[1]")WebElement eleSeach;
	@FindBy(how = How.XPATH, using = "//a[@class='linked formlink']")WebElement eleRetrivedIncident;

	public Incident_retrive_page searchIncidentNum() throws InterruptedException {
		eleSeach.sendKeys(genIncidentNum, Keys.ENTER);
		return this;
	}

	public Incident_retrive_page incidentCrossCheck() {
		String retrivedincident = eleRetrivedIncident.getText();
		System.out.println("The Incident Number is: " + retrivedincident);
		if (retrivedincident.equals(genIncidentNum)) {
			System.out.println("Incident creation successful");
		} else {
			System.out.println("Incident created get into error / failed");
		}
		return this;
	}
}


