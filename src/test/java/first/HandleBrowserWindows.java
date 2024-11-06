package first;
import java.time.Duration;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[3]/div[2]/p[2]/a")).click();

		Set<String> handles=driver.getWindowHandles();
		List<String> myList=new ArrayList(handles);
		String parentId=myList.get(0);
		String childId=myList.get(1);
		
		for(String winId:myList) {
			String title=driver.switchTo().window(winId).getTitle();
			System.out.println(title);
			
			if(title.equals("Human Resources Management Software | OrangeHRM")){
				
				driver.close();
				
			}
			
		}
		
	}

}
