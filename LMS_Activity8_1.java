package TestNG.SDET_TestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LMS_Activity8_1{
//	Count the number of coursesGoal: 
//	Navigate to the “All Courses” page and count the number of courses.
//	a.Open a browser.
//	b.Navigate to ‘https://alchemy.hguy.co/lms’. 
//	c.Find the navigation bar.
//	d.Select the menu item that says “Contact” and click it.
//	e.Find the contact form fields (Full Name, email, etc.)
//	f.Fill in the information and leave a message.
//	g.Click submit.
//	h.Read and print the message displayed after submission.
//	i.Close the browser



WebDriver driver;

@BeforeTest
public void beforeMethod() {
    //Create a new instance of the Firefox driver
	 System.out.println("before method");
	  String path = "C:\\Driver\\geckodriver.exe";
	    System.setProperty("webdriver.gecko.driver",path);
	   driver=new FirefoxDriver();
    //Open the browser
    driver.get("https://alchemy.hguy.co/lms");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@DataProvider(name = "ContactForm")
public static Object[][] personalInfo() {
    return new Object[][] { { "Deepali", "deep@gmail.com", "Need LMS Support", "comments'"}, { "Neha", "deep@gmail.com", "reminder Need LMS Support", "comments2"}};
}


@Test(dataProvider = "ContactForm")
public void testCase1(String name, String mail,String subject, String comments) {
    //This test case will pass
//   Select the menu item that says “Contact” and click it.
    WebElement contactMenu = driver.findElement(By.xpath("//li[@id='menu-item-1506']/a"));
    contactMenu.click();
//	e.Find the contact form fields (Full Name, email, etc.)
//	f.Fill in the information and leave a message.

    driver.findElement(By.xpath("//input[@id = 'wpforms-8-field_0']")).sendKeys(name);
    driver.findElement(By.xpath("//input[@id = 'wpforms-8-field_1']")).sendKeys(mail);
    driver.findElement(By.xpath("//input[@id = 'wpforms-8-field_3']")).sendKeys(subject);
    driver.findElement(By.xpath("//textarea[@id = 'wpforms-8-field_2']")).sendKeys(comments);
    
//	g.Click submit.
    WebElement sendMessageButton = driver.findElement(By.xpath("//button[@id = 'wpforms-submit-8']"));
    sendMessageButton.click();
    WebDriverWait wait=new WebDriverWait(driver, 20);
   
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //div[@id= 'wpforms-confirmation-8']")));
    WebElement confirmationblock = driver.findElement(By.xpath("//div[@id= 'wpforms-confirmation-8']"));
    System.out.println("confirmation message:  "+confirmationblock.getText());
}


@AfterTest
public void afterMethod() {
    //Close the browser
    driver.close();
}

}
