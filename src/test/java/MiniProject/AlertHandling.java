package MiniProject;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
 
public class AlertHandling {
 
	public static void main(String[] args) throws InterruptedException {
		
	// Opening the site

	WebDriver driver= new ChromeDriver();



	driver.get("https://rediff.com/");
	driver.findElement(By.xpath("//a[@class='mailicon']")).click();
	driver.manage().window().maximize();
	
	 //sign-in click without login details
	driver.findElement(By.name("proceed")).click();
	Thread.sleep(1000);
	
	//Alert handling
	String alertText= driver.switchTo().alert().getText();
	 if(alertText.contains("Please enter a valid user name"))
	 {
		 System.out.println("correct alert is displayed");
	 }
	 else
	 {
		 System.out.println("wrong alert message is displayed");
	 }
	 driver.switchTo().alert().accept();
	 
	 //Forgot password
	
	 driver.findElement(By.linkText("Forgot Password?")).click();
	 driver.findElement(By.name("next")).click();	
	 Alert myalert = driver.switchTo().alert();
	 String alertText1=myalert.getText();
	 
	 if(alertText1.contains("Please enter your email ID"))
	 {
		 System.out.println("correct alert is displayed");
	 }
	 else
	 {
		 System.out.println("wrong alert message is displayed");
	 }
	
	 Thread.sleep(3000);
	 driver.switchTo().alert().accept();
	 
	 //navigating back
	
	 driver.navigate().back();
	 System.out.println(driver.getCurrentUrl());
	 Thread.sleep(3000);	
	
	 //scrolling down to privacy policy
	 
	 JavascriptExecutor js=(JavascriptExecutor)driver;  
	 js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.linkText("Privacy Policy")) );
	 Thread.sleep(3000);
	 
	 //opening privacy policy
	 driver.findElement(By.linkText("Privacy Policy")).click();
	 Thread.sleep(3000);
	  
	 //collecting window ids
	Set<String> windowIDs= driver.getWindowHandles();
	List<String> windowList= new ArrayList(windowIDs);
	String parentId =windowList.get(0);
	String childId =windowList.get(1);
	
	 //System.out.println(driver.getTitle());
	 //switching to child window
	 driver.switchTo().window(childId);
	 String pageTitle=driver.getTitle();
	 System.out.println(pageTitle);
	 
  if(pageTitle.equals("Welcome to rediff.com"))
  {
	     Thread.sleep(3000);
		 driver.close();	
  }
	
	 driver.switchTo().window(parentId);
	 driver.close();
	
	}
 
}