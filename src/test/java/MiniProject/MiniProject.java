package MiniProject;

//public class MiniProject {
//
//}

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
public class MiniProject {
	WebDriver driver;
 
@Parameters({"browser"})
@BeforeClass
	public void createDriver(String br){
		// TODO Auto-generated method stub
			switch(br) {
			case "chrome":
				driver  = new ChromeDriver();
				driver.get("https://mail.rediff.com");
				driver.manage().window().maximize();
			case "edge":
				driver=new EdgeDriver();
				driver.get("https://mail.rediff.com");
				driver.manage().window().maximize();
		}
}
	@Test	
	public void validation() throws InterruptedException {	
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@title='Sign in']")).click();
	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Alert signalert= driver.switchTo().alert();
		String res1=signalert.getText();
		if(res1.contains("Please enter a valid user name")) {
			Thread.sleep(1000);
			signalert.accept();
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//u[normalize-space()='Forgot Password?']")).click();
		driver.findElement(By.cssSelector("input[value='Next >']")).click();
		Alert nextalert=driver.switchTo().alert();
		String res2=nextalert.getText();
		if(res2.contains("Please enter your email ID")) {
			Thread.sleep(1000);
			nextalert.accept();
			driver.navigate().back();
		}
        Thread.sleep(5000);
        //WebElement see = driver.findElement(By.xpath("/html/body/div/div[3]/a[2]")); // Scroll till See more
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //js.executeScript("arguments[0].scrollIntoView()");
        js.executeScript("window.scrollTo(0,7000)","");
        //js.executeScript("window.scrollBy(0,document.body.ScrollHeight)","");
        Thread.sleep(5000);
		driver.findElement(By.cssSelector("a[href='http://www.rediff.com/w3c/policy.html']")).click();
		//String curl=driver.getCurrentUrl();
		//if(curl.equals("https://www.rediff.com/w3c/policy.html")) 
			Set<String> windowid=driver.getWindowHandles();
			for(String ids:windowid) {
				if(driver.switchTo().window(ids).getTitle().equalsIgnoreCase("Welcome to rediff.com")) 
				{
					Thread.sleep(2000);
					driver.close();
				}

		}

}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
