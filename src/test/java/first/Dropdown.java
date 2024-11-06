package first;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) {
		// Select dropdown
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement e=driver.findElement(By.xpath("//select[@id=\"country\"]"));
		Select e1=new Select(e);
		e1.selectByVisibleText("Canada");
		e1.selectByValue("uk");
		e1.selectByIndex(3);
		//printing text in the dropdown
		
		List<WebElement> options=e1.getOptions();
		for(WebElement x:options) {
			System.out.println(x.getText());
		}


	}

}
