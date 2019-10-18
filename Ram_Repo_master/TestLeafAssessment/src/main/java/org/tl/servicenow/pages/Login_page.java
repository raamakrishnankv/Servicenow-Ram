package org.tl.servicenow.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.tl.servicenow.utils.Common_methods;

public class Login_page extends Common_methods{

	public Login_page() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="(//*[contains(@id,'user_name')])[1]")WebElement eleUserName;
	@FindBy(how=How.XPATH, using="(//*[contains(@id,'user_password')])[1]")WebElement elePassword;
	
	
	public Login_page enterUserName(String username) {
		driver.switchTo().frame(0);
		eleUserName.sendKeys(username);
		return this;
	}
	
	public System_admin_page enterPassword(String password) {
		elePassword.sendKeys(password, Keys.ENTER);
		return new System_admin_page();
	}
	
	
}