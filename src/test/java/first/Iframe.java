package first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		String url="https://ui.vision/demo/webtest/frames/";
		driver.get(url);
		WebElement e1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(e1);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("selenium");
		
		//to move into original page
		driver.switchTo().defaultContent();
		
		WebElement e2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(e2);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("selenium java");
		
		
		

	}

}
