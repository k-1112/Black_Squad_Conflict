package com.actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.locators.tourPackageLocators;
import com.utility.BaseClass;

public class tourPackageActions {
	WebDriver driver;
	Actions act = new Actions(BaseClass.getDriver());
	tourPackageLocators tourLocators =null;
	WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(15));
	
	public tourPackageActions() {
		this.tourLocators = new tourPackageLocators();
		PageFactory.initElements(BaseClass.getDriver(), tourLocators);
	}
	
	public void selectPlace(String place) {
		tourLocators.holidayPlace.sendKeys(place);
	}
	
	public void selectBudget() {
		tourLocators.budgetSelect.click();
		tourLocators.budget.click();
	}
	
	public void selectMonth() {
		tourLocators.monthSelect.click();
		tourLocators.month.click();
	}
	
	public void clickSearch() {
		tourLocators.searchButton.click();
	}
	
	public void sort() {
		Select select = new Select(tourLocators.sortButton);
		select.selectByVisibleText("Duration - High to Low");
	}
	
	public void sortAssert() {
		String assertText = tourLocators.sortassert.getText();
		Assert.assertEquals(assertText, "Paradise In Perth");
		//System.out.println("Asserted successfully");
	}
}

