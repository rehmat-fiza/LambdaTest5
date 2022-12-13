package methods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lambdatest {
	
	WebDriver driver;
	
	public Lambdatest(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnLink() {
	   	WebElement simpleFormDemo = driver.findElement(By.xpath("//a[text() ='Simple Form Demo']"));
	    	simpleFormDemo.click();  
	    	String expectedText = "Simple Form Demo";
	    	String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Simple Form Demo')]")).getText();
	    	Assert.assertEquals(actualText, expectedText, "Test case fail");
	  }
	
	 public void singleInputField() {
		 
	    	WebElement enterMessage = driver.findElement(By.xpath("//input[@id='user-message']"));
			enterMessage.sendKeys("Hi , this is Rehmat here");
			WebElement getCheckedValue = driver.findElement(By.xpath("//button[@id='showInput']"));
			getCheckedValue.click();
			
			String expectedMsg = "Hi , this is Rehmat here";
			String actualMsg = driver.findElement(By.xpath("//p[contains(text(),'Hi , this is Rehmat here')]")).getText();
			Assert.assertEquals(actualMsg, expectedMsg, "Test case fail");

	   	
	   }
	 
	 public void twoInputField() {
	    	WebElement getTextOne = driver.findElement(By.xpath("//input[@id='sum1']"));
			getTextOne.sendKeys("Hi!!!");
			WebElement getTextTwo = driver.findElement(By.xpath("//input[@id='sum2']"));
			getTextTwo.sendKeys("from Rehmat");
			WebElement getValue = driver.findElement(By.xpath("(//button[@type = 'button'])[2]"));
			getValue.click();
			String expectedMsg = "NaN";
			String actualMsg = driver.findElement(By.xpath("//p[contains(text(),'NaN')]")).getText();
			Assert.assertEquals(actualMsg, expectedMsg, "Test case fail");
	    	
	    }
	 
	 public void backToHome() {
		 driver.navigate().back();
		 String title = driver.getTitle();
	    	System.out.println("The page title is:" +title);
	    	
	    	Assert.assertEquals(title, "Selenium Grid Online | Run Selenium Test On Cloud");
	 }

	public void clickOnCheckboxDemo() {
		WebElement simpleFormDemo = driver.findElement(By.xpath("//a[text() ='Checkbox Demo']"));
    	simpleFormDemo.click(); 
    	String expectedText = "Checkbox Demo";
    	String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Checkbox Demo')]")).getText();
    	Assert.assertEquals(actualText, expectedText, "Test case fail");
		
	}
	
	public void clickOnSingleCheckbox() {
		WebElement singleCheckbox = driver.findElement(By.id("isAgeSelected"));
    	singleCheckbox.click();
    	String expectedText = "Success - Check box is checked";
    	String actualText = driver.findElement(By.xpath("//div[contains(text(),'Success - Check box is checked')]")).getText();
    	Assert.assertEquals(actualText, expectedText, "Test case fail");
		
	}
	
	public void clickOnMultipleCheckbox() {

    	WebElement clickAll = driver.findElement(By.xpath("//input[@id='box']"));
    	clickAll.click();
    	String expectedText = "uncheck all";
    	String actualText = driver.findElement(By.xpath("//input[@value='uncheck all']")).getAttribute("value");
    	Assert.assertEquals(actualText, expectedText, "Test case fail");
    	WebElement clickUncheckAll = driver.findElement(By.xpath("//input[@id='box']"));
    	clickUncheckAll.click();
    	WebElement option1 = driver.findElement(By.xpath("//label[contains(text(),'option 1')]"));
    	option1.click();
    	String expectedMsg = "check all";
    	String actualMsg = driver.findElement(By.xpath("//input[@value='check all']")).getAttribute("value");
    	Assert.assertEquals(actualMsg, expectedMsg, "Test case fail");
		
	}
	public void clickOnInputForm() {
		WebElement inputFormSubmit = driver.findElement(By.xpath("//a[text() ='Input Form Submit']"));
    	inputFormSubmit.click(); 
    	String expectedText = "Dropdown Demo";
    	String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Dropdown Demo')]")).getText();
    	Assert.assertEquals(actualText, expectedText, "Test case fail");
		
	}
	
	public void dropDown() {
		WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
		WebElement email = driver.findElement(By.xpath("//input[@id='inputEmail4']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='inputPassword4']"));
		WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
		WebElement website = driver.findElement(By.xpath("//input[@id='websitename']"));
		Select selcountry = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		//selcountry.selectByVisibleText("India");
		WebElement city = driver.findElement(By.id("inputCity"));
		WebElement address1 = driver.findElement(By.id("inputAddress1"));
		WebElement address2 = driver.findElement(By.id("inputAddress2"));
		WebElement state = driver.findElement(By.xpath("//input[@id='inputState']"));
		WebElement zipCode = driver.findElement(By.xpath("//input[@id='inputZip']"));
		WebElement submit = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		name.sendKeys("Rehmat Fiza");
		email.sendKeys("rehmatfizaetw@gmail.com");
		password.sendKeys("Fiza@123");
		company.sendKeys("Qualitrix");
		website.sendKeys("https://github.com/rehmat-fiza/webdev1");
		selcountry.selectByVisibleText("India");
		city.sendKeys("Etawah");
		address1.sendKeys("109, Naurangabad, Etawah");
		address2.sendKeys("109, Naurangabad, Etawah");
		state.sendKeys("Uttar Pradesh");
		zipCode.sendKeys("206001");
		submit.click();
		
		String expectedText = "Thanks for contacting us, we will get back to you shortly.";
    	String actualText = driver.findElement(By.xpath("//p[contains(text(),'Thanks for contacting us, we will get back to you shortly.')]")).getText();
    	Assert.assertEquals(actualText, expectedText, "Test case fail");
	}
	
	public void javascriptAlerts() {
		WebElement alert = driver.findElement(By.xpath("//a[contains(text(),'Javascript Alerts')]"));
    	alert.click();
    	String expectedText = "Javascript Alert Box Demo";
    	String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Javascript Alert Box Demo')]")).getText();
    	Assert.assertEquals(actualText, expectedText, "Test case fail");
	}
	
	public void alerts() {
		WebElement alert1 = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
    	alert1.click();
    	Alert simpleAlert = driver.switchTo().alert();
    	simpleAlert.accept();
    	WebElement alert2 = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
    	alert2.click();
    	Alert simpleAlert1 = driver.switchTo().alert();
    	simpleAlert1.dismiss();
    
    	String expectedText = "You pressed Cancel!";
    	String actualText = driver.findElement(By.xpath("//p[contains(text(),'You pressed Cancel!')]")).getText(); 
    	Assert.assertEquals(actualText, expectedText, "Test case fail");
    	
    	WebElement alert3 = driver.findElement(By.xpath("(//button[@type='button'])[3]"));
    	alert3.click();
    	Alert simpleAlert2 = driver.switchTo().alert();
    	System.out.println(simpleAlert2.getText());
    	simpleAlert2.sendKeys("rehmat");
    	simpleAlert2.accept();
    	
    	//driver.switchTo().alert().sendKeys("rehmat");
    	String expectedMsg = "You have entered 'rehmat' !";
    	String actualMsg = driver.findElement(By.xpath("//p[@id='prompt-demo']")).getText(); 
    	Assert.assertEquals(actualMsg, expectedMsg, "Test case fail");
        
    	
    	
    	
	}
	
//	public void pagination() {
//		List<WebElement> namesElements = driver.findElements(By.cssSelector("#table-id>tbody>tr>td:nth-child(2)"));
//		
//		List<String> names = new ArrayList<String>();
//		
//		for(WebElement namesElement : namesElements) {
//			names.add(namesElement.getText());
//		}
//		String nextButtonClass = driver.findElement(By.id("prev")).getAttribute("id");
//		
//		while(!nextButtonClass.contains("prev"));
//		{
//			driver.findElement(By.id("prev")).click();
//			namesElements = driver.findElements(By.cssSelector("#table-id>tbody>tr>td:nth-child(2)"));
//		}
//	}
	
	
 
	
}

