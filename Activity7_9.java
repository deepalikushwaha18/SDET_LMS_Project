package TestNG.SDET_TestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity7_9 {
//	Count the number of coursesGoal: 
//		Navigate to the “All Courses” page and count the number of courses.
//		a.Open a browser.
//		b.Navigate to ‘https://alchemy.hguy.co/lms’. 
//		c.Find the navigation bar.
//		d.Select the menu item that says “All Courses” and click it.
//		e.Find all the courses on the page.
//	    f.Print the number of courses on the page
	
	
	
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
    
    @Test
    void viewCourseTest() {
    	System.out.println("viewCourseTest");
        //This test case will pass
//        find the AllCourse menu and click on it
        WebElement courseMenu = driver.findElement(By.xpath("//li[@id='menu-item-1508']/a"));
        courseMenu.click();
        List<WebElement> courseList = driver.findElements(By.xpath("//div[@id = 'ld_course_list']//div[@class='caption']//h3"));
        int count =0;
        for(WebElement courseName: courseList ) {
        	System.out.println("courseName:"+courseName.getText());
        	count++;
        }
        System.out.println("number of courses: "+count);
    }
    
    @Test(dependsOnMethods = {"viewCourseTest"})
    public void completeCourseTest() {
    	System.out.println("completeCourseTest");
    	//click on course
    	 WebElement course1 = driver.findElement(By.xpath("//div[@class='caption']//a"));
    	 course1.click();
    	 //verify the title of course
    	 String titleCourse1 = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
    	 System.out.println("titleCourse1:  "+titleCourse1);
    	 String expectedTitleCourse1 ="Social Media Marketing" ;
    	 Assert.assertEquals(titleCourse1, expectedTitleCourse1);
    	
    }
    
    
    @AfterTest
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
    
}
