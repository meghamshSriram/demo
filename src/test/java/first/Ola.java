package first;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class Ola {
 
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		//opening Ola Booking website
		driver.get("https://book.olaelectric.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//selecting the variety
		driver.findElement(By.xpath("//div[@id='ola_s1_air']")).click();
		
		//clicking on continue button
		driver.findElement(By.className("btn-reserve")).click();
		
		//entering Pincode
		driver.findElement(By.xpath("//input[@id='pin']")).sendKeys("641035");
		Thread.sleep(2000);
		driver.findElement(By.className("next-button")).click();
		
		//unselecting the additional covers
		driver.findElement(By.xpath("(//img[@class='add-on-select-icon'])[4]")).click();		
		driver.findElement(By.xpath("(//img[@class='add-on-select-icon'])[5]")).click();
		
		//clicking on next button
		driver.findElement(By.className("continue-btn")).click();
		//clicking on next button
		driver.findElement(By.className("btns-list")).click();
		
		//closing the browser
		driver.close();
 
	}
 
}