package TestNG.SDET_TestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity4_5_6 {
	WebDriver driver;
	 
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("before method");
		  String path = "C:\\Driver\\geckodriver.exe";
		    System.setProperty("webdriver.gecko.driver",path);
		    driver=new FirefoxDriver();
			//Open browser
			
	      driver.get("https://alchemy.hguy.co/lms");
		
	  }
	  @Test(enabled=true)
	  public void verifyCourse2() { 
		 
		  System.out.println("verifyCourse2Title");
	      // Check the heading of Page
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  List<WebElement> courseList = driver.findElements(By.xpath("//div[@id = 'ld_course_list']//div[@class='caption']//h3"));
	        for(WebElement courseName: courseList ) {
	        	if(courseName.getText()=="Email Marketing Strategiess") {
	        	System.out.println("courseName:"+courseName.getText());
	        	Assert.assertTrue(true);
	        	}
	        }
	        
	  }
	  
	  @Test(enabled=true)
	  public void verifyAccountPageTitle() { 
		 
		  System.out.println("verifyAccountPageTitle");
	      // Check the Account Page
		  driver.findElement(By.xpath("//li[@id='menu-item-1507']/a")).click();
		  String acctTitle =
				  driver.findElement(By.xpath("//div[@id='uagb-column-04847d5a-4fcc-4aea-bd8e-129fb1266a54']//h1")).getText();
		  System.out.println("acctTitle: "+acctTitle);
		  String expectedAcctTilte= "My Account";
		  Assert.assertEquals(acctTitle, expectedAcctTilte);
	  }


	  
	  @Test
	    public void Login() {
	        
	        driver.findElement(By.xpath("//li[@id='menu-item-1507']/a[1]")).click();
	    	String title = driver.getTitle();	        
	        System.out.println("Title is " + title);
	      //Assertion
	        Assert.assertEquals("My Account – Alchemy LMS", title);
	        
	        //login using credentials
	        driver.findElement(By.linkText("Login")).click();;
	        
	        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
	        driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
	        driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
	      
	        //verify logged in
	        String title2 = driver.getTitle();
	        System.out.println("Title after login is " + title2);
	      //Assertion
	        Assert.assertEquals("My Account – Alchemy LMS", title2);
	            
	        Reporter.log("Title after login is " + title2);
	                    
	        
	    }

    @AfterTest
    public void afterMethod() {
        //Close the browser
        driver.close();
    }

}