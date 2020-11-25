package TestNG.SDET_TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


public class Activity1_2_3 {
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
  public void verifyTitle() {
	  System.out.println("verifyTitle");
      // Check the title of the page
	  String  ActualAppTitle= driver.getTitle();
 	 System.out.println("ActualAppTitle:  "+ActualAppTitle);
	  String expectedAppTitle = "Alchemy LMS – An LMS Application" ;
			  Assert.assertEquals(ActualAppTitle,expectedAppTitle);

	  }
  @Test(enabled=true)
  public void verifyHeading() {
	  System.out.println("verifyHeading");
      // Check the heading of Page
	  String  ActualHeading= driver.findElement(By.xpath("//h1[@class='uagb-ifb-title']")).getText();
 	 System.out.println("ActualHeading:  "+ActualHeading);
	  String expectedHeading = "Learn from Industry Experts" ;
			  Assert.assertEquals(ActualHeading,expectedHeading);
	  }
  
  @Test(enabled=true)
  public void verifyinfoTilte() {
	  System.out.println("verifyinfoTilte");
      // Check the heading of Page
	  String  actualInfoboxTitle= driver.findElement(By.xpath("//div[@id='uagb-infobox-f08ebab0-fbf1-40ec-9b2a-c9feeb3d4810']//h3[@class='uagb-ifb-title']")).getText();
 	 System.out.println("actualInfoboxTitle:  "+actualInfoboxTitle);
	  String expectedInfoboxTitle = "Actionable Training" ;
			  Assert.assertEquals(actualInfoboxTitle,expectedInfoboxTitle);
}
  
  @AfterMethod
	
  public void afterMethod() {
	  System.out.println("after method");
	
      //Close the browser
      driver.quit();
	
  }
	

}
