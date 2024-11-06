package first;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OlaBooking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		
		//Adding implicit wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Opening the Website
		driver.get("https://book.olaelectric.com/bike");
		
		//selecting the variant
		driver.findElement(By.xpath("//*[@id=\"ola_bike_roadster_x_2.5kWh\"]")).click();
		driver.findElement(By.className("estimated-dispatch-container")).click();
		
		//reserve button click
		driver.findElement(By.className("btn-reserve")).click();
		
		//Entering pincode 
		driver.findElement(By.name("pin")).sendKeys("506132");;
		Thread.sleep(2000);
		driver.findElement(By.className("next-button")).click();
	    
	    //screenshot 
	    
	    TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		//System.out.println(System.getProperty("user.dir"));
		File targetFile = new File(System.getProperty("user.dir")+".//Screenshot//img.png");
		sourceFile.renameTo(targetFile);
		
		
		driver.close();
		
	    
	}

}
