package first;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
 
 
public class asf {
    public static void main(String[] args) {
      
 
        // Initialize WebDriver
//        WebDriver driver = new ChromeDriver();
  
    	
    	EdgeOptions options=new EdgeOptions();
    	options.addArguments("start-maximized");
    	 WebDriver driver = new EdgeDriver(options);
    	  
 
       try {
            // Navigate to Rediff
            driver.get("https://rediff.com");
            driver.manage().window().maximize();
 
            // Click on "Sign in" link
            WebElement signInLink = driver.findElement(By.linkText("Sign in"));
            signInLink.click();
            Thread.sleep(5000);
 
            // Click on "Sign In" button without filling details
            WebElement signInButton = driver.findElement(By.name("proceed"));
            signInButton.click();
            Thread.sleep(5000);
 
            // Handle alert and verify text
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert text: " + alertText);
            assert alertText.equals("Please enter a valid user name");
            alert.accept();
            Thread.sleep(5000);
 
            // Click on "Forgot password" link
            WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));
            forgotPasswordLink.click();
            Thread.sleep(5000);
 
            // Click on "Next" button without filling details
            WebElement nextButton = driver.findElement(By.name("next"));
            nextButton.click();
            Thread.sleep(5000);
 
            // Handle alert and verify text
            alert = driver.switchTo().alert();
            alertText = alert.getText();
            System.out.println("Alert text: " + alertText);
            alertText.equals("Please enter your email ID");
            alert.accept();
            Thread.sleep(5000);
 
            // Navigate back to the main page
           driver.navigate().back();
           Thread.sleep(5000);
           WebElement see = driver.findElement(By.xpath("/html/body/div/div[3]/a[2]")); // Scroll till See more
           JavascriptExecutor js = (JavascriptExecutor)driver;
           js.executeScript("arguments[0].scrollIntoView()", see);
           //js.executeScript("window.scrollBy(0,2000)","");
           //js.executeScript("window.scrollBy(0,document.body.ScrollHeight)","");
           Thread.sleep(5000);
 
            // Click on "Privacy Policy" link at the bottom of the page
            WebElement privacyPolicyLink = driver.findElement(By.linkText("Privacy Policy"));
            privacyPolicyLink.click();
            Thread.sleep(5000);
 
            // Switch to the new tab and verify the page title
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
             driver.getTitle().contains("Privacy Policy");
            // Close the new tab and the browser
            driver.close();
            driver.switchTo().window(driver.getWindowHandles().iterator().next());
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}