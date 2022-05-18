package com.uiFramework.KTCTC.Pages;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.uiFramework.KTCTC.helper.logger.LoggerHelper;

public class WebTablePract {
	
	private Logger log = LoggerHelper.getLogger(WebTablesPage.class);
	WebDriver driver;
	
	By addbuttononwebpage = By.id("addNewRecordButton");
	By firstNameOnRegistrationForm = By.id("firstName");
	By lastNameOnRegistrationForm = By.id("lastName");
	By emailOnRegistrationForm = By.id("userEmail");
	By ageOnRegistrationForm = By.id("age");
	By salaryOnRegistrationForm = By.id("salary");
	By departmentOnRegistrationForm = By.id("department");
	By submitButtonOnRegistrationForm = By.id("submit");
	
    By searchBoxOnWebTablePage = By.id("searchBox");
	
	// edit button
	By editButtonOnWebTablePage = By.xpath("//*[contains(@id,'edit-record')]");
	// delete button
	By deleteButtonOnWebTablePage = By.xpath("//*[contains(@id,'delete-record')]");
	
	
	public WebTablePract(WebDriver driver) {
		
		this.driver = driver;
	}
	

    public void navigateToWebTablePage() {
    	
    	log.info("Navigating to Webtable page.");
    	
    	 driver = new ChromeDriver();
    	 driver.findElement(By.xpath("//*[contains(text(),'Web Tables')]")).click();
    	 log.info("Navigated to webtable page successfully");
    	  }
    
     public void addNewUserOnWebTablePage(String fname, String lName,String email,String age, String salary, String department) {
    	
    	log.info("Adding new User on webtable page...");
    	driver.findElement(addbuttononwebpage).click();
    	driver.findElement(firstNameOnRegistrationForm).sendKeys(fname);
    	driver.findElement(lastNameOnRegistrationForm).sendKeys(lName);
    	driver.findElement(emailOnRegistrationForm).sendKeys(email);
		driver.findElement(ageOnRegistrationForm).sendKeys(age);
		driver.findElement(salaryOnRegistrationForm).sendKeys(salary);
		driver.findElement(departmentOnRegistrationForm).sendKeys(department);
    	driver.findElement(submitButtonOnRegistrationForm).click();
    	log.info("New user added succsessfully");
    	 }
     
     public void searchStringInSearchBox(String email) {
    	 
    	 driver.findElement(searchBoxOnWebTablePage).clear();
    	 driver.findElement(searchBoxOnWebTablePage).sendKeys(email);
    }
     
     public HashMap<String,String>  getAllDetailsOfProvidedUser(String email) {
    	 
    	 searchStringInSearchBox(email);
    	 HashMap<String,String> data = new HashMap<>();
    	 data.put("FirstName", driver.findElement(By.xpath("//*[contains(text(),'"+email+"')]/preceding-sibling::div[3]")).getText());
    	 data.put("LastName", driver.findElement(By.xpath("//*[contains(text(),'"+email+"')]/preceding-sibling::div[2]")).getText());
 		 data.put("Age", driver.findElement(By.xpath("//*[contains(text(),'"+email+"')]/preceding-sibling::div[1]")).getText());
 		 data.put("Email", driver.findElement(By.xpath("//*[contains(text(),'"+email+"')]")).getText());
 		 data.put("Salary", driver.findElement(By.xpath("//*[contains(text(),'"+email+"')]/following-sibling::div[1]")).getText());
 		 data.put("Department", driver.findElement(By.xpath("//*[contains(text(),'"+email+"')]/following-sibling::div[2]")).getText());
 		 log.info("User details are provided succsessfully");
 		 
 		 return data;
     }
}