package week2.day2.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");		
		driver.manage().window().maximize();
		//create lead
		WebElement usernameElement = driver.findElement(By.id("username"));
		usernameElement.sendKeys("Demosalesmanager");
		WebElement passwordElement = driver.findElement(By.name("PASSWORD"));
		passwordElement.sendKeys("crmsfa");
		WebElement loginButton = driver.findElement(By.className("decorativeSubmit"));
		loginButton.click();
		WebElement crmLink = driver.findElement(By.linkText("CRM/SFA"));
		crmLink.click();
		WebElement leadsTab = driver.findElement(By.linkText("Leads"));
		leadsTab.click();
		WebElement createLeadSubtab = driver.findElement(By.linkText("Create Lead"));
		createLeadSubtab.click();
		WebElement companyName = driver.findElement(By.id("createLeadForm_companyName"));
		companyName.sendKeys("MNC");
		WebElement firstName = driver.findElement(By.id("createLeadForm_firstName"));
		firstName.sendKeys("Spring");
		WebElement lastName = driver.findElement(By.id("createLeadForm_lastName"));
		lastName.sendKeys("water");
		WebElement firstNameLocal = driver.findElement(By.id("createLeadForm_firstNameLocal"));
		firstNameLocal.sendKeys("nandy");
		WebElement departmentName = driver.findElement(By.name("departmentName"));
		departmentName.sendKeys("test description");
		WebElement description = driver.findElement(By.id("createLeadForm_description"));
		description.sendKeys("testing department");
		WebElement email = driver.findElement(By.id("createLeadForm_primaryEmail"));
		email.sendKeys("nandy@test.com");
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateObj = new Select(state);
		stateObj.selectByVisibleText("New York");
		WebElement createLeadButton = driver.findElement(By.className("smallSubmit"));
		createLeadButton.click();
		System.out.println(driver.getTitle());
		if (driver.getTitle().contains("View Lead")) {
			System.out.println("Title is correct");}
			else {
				System.out.println("Something wrong");}
		//duplicate lead
		
				WebElement duplicateLead = driver.findElement(By.linkText("Duplicate Lead"));
				duplicateLead.click();
				//Need clarification on why the below locators did not work ???????????
			/*	companyName.clear();
				companyName.sendKeys("ABC");
				firstName.clear();
				firstName.sendKeys("Jack");*/
				
				WebElement duplicateCompanyName = driver.findElement(By.id("createLeadForm_companyName"));
				duplicateCompanyName.clear();
				duplicateCompanyName.sendKeys("HPL");
				WebElement duplicateFirstName = driver.findElement(By.id("createLeadForm_firstName"));
				duplicateFirstName.clear();
				duplicateFirstName.sendKeys("Tommy");
				WebElement duplicateCreateLeadButton = driver.findElement(By.className("smallSubmit"));
				duplicateCreateLeadButton.click();
				System.out.println(driver.getTitle());
				if (driver.getTitle().contains("View Lead")) {
					System.out.println("Title is correct after duplicate lead");}
					else {
						System.out.println("Something wrong");}
				}
				
			}





