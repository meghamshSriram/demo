package first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rediff.com/");
		driver.manage().window().maximize();
		//using sendkeys method
		driver.findElement(By.xpath("//a[@class='mailicon']")).click();

	}

}
