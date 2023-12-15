package com.actions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.locators.registerPageLocators;
import com.utility.BaseClass;
import com.utility.ExcelReader;

public class registerPageActions {
	WebDriver driver;
	ExcelReader exr = new ExcelReader();
	Actions act = new Actions(BaseClass.getDriver());
	registerPageLocators registerLocators= null;
	WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(15));
	JavascriptExecutor jse = (JavascriptExecutor)BaseClass.getDriver();
		
	
	public registerPageActions(){
		this.registerLocators = new registerPageLocators();
		PageFactory.initElements(BaseClass.getDriver(), registerLocators);
	}
	
	public void clickLogin() {
		registerLocators.loginButton.click();
	}
	
	public void clickRegisterUser() {
		registerLocators.registerUser.click();
	}
	
	public void setFirstname(String firstname) {
		wait.until(ExpectedConditions.visibilityOf(registerLocators.firstname)).sendKeys(firstname);
		//registerLocators.firstname.sendKeys(firstname);
	}
	
	public void setLastname(String lastname) {
		registerLocators.lastname.sendKeys(lastname);
	}
	
	public void setEmail(String email) {
		registerLocators.email.sendKeys(email);
	}
	
	public void setMobile(String mobile) {
		wait.until(ExpectedConditions.visibilityOf(registerLocators.mobile)).sendKeys(mobile);
		//registerLocators.mobile.sendKeys(mobile);
	}
	
	public void setPassword(String password) {
		registerLocators.password.sendKeys(password);
	}
	
	public void setCpassword(String cpassword) {
		registerLocators.cPassword.sendKeys(cpassword);
	}
	
	public void clickRegister() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(registerLocators.registerButton)).click();
		jse.executeScript("document.getElementById('registerButton').click()");
		
	}
	
	public void registerAssert() {

		act.moveToElement(registerLocators.dropDown).click().perform();
//		boolean regAssert = registerLocators.logoutButton.isDisplayed();
//		Assert.assertTrue(regAssert);
//		System.out.println("logout button is visible and registration is ASSERTED");
		}
	
	
	public void registerAccount(String sheetname, Integer rownumber) throws InvalidFormatException, IOException {
		List<Map<String,String>> testdata=exr.getData("C:\\BlackSquad_PilotProject_1\\Thomascook\\src\\test\\resources\\registerData.xlsx", sheetname);
		String firstname = testdata.get(rownumber).get("firstname");
		String lastname = testdata.get(rownumber).get("lastname");
		String email = testdata.get(rownumber).get("email");
		String mobile = testdata.get(rownumber).get("mobile");
		String password = testdata.get(rownumber).get("password");
		String cpassword = testdata.get(rownumber).get("cpassword");
		setFirstname(firstname);
		setLastname(lastname);
		setEmail(email);
		setMobile(mobile);
		setPassword(password);
		setCpassword(cpassword);
	}
}