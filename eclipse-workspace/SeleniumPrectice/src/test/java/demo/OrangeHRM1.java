package demo;

	import java.util.List;
	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.*;

	import junit.framework.Assert;
	import net.bytebuddy.description.method.ParameterDescription.Token.TypeList;

public class OrangeHRM1 {
	
	public class OrangeHRM {
		
		public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		public WebDriver driver;
		private Object system;
		
		@BeforeTest
		public void setup()
		{
			System.out.println("Before Test executed");
			//TODO auto generated method stub 
			driver=new ChromeDriver();
			
			//maximize windows
			driver.manage().window().maximize();
			
			//open url 
			driver.get(baseUrl);
			
			//timer i kept as 60you can keep 40
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		}
		@SuppressWarnings("unused")
		@Test
		public void loginTest()
		{
			//find username and usernmae = "Admin"
			driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		
			//find password and password "Admin"
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		
			//login button click 
			driver.findElement(By.xpath("//button[@type='submit']")).submit();
			
			// Verify if the login was successfully by checking the pages title 
			String pageTitle = driver.getTitle();
			
			/*if (pageTitle.equals("OrangeHRM")) 
			{
				System.out.println("Login successfully");
			}
			else 
			{
				System.out.println("LOgin Failed!");
			}*/
			
			Assert.assertEquals("OrangeHRM", pageTitle);
		}
		
		public void logOut() throws InterruptedException
		{
			driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
			
			//driver.findElement(By.xpath("//a[@href='/web/index.php/auth/logout']")).click();
			
			List <WebElement> elementlist = driver.findElements(By.xpath("//ul[@class='oxd-dropdown-menu']//li"));
			
			for (int i=0; i<elementlist.size(); i++)
			{
				Thread.sleep(1000);
					System.out.println(i + ":" + elementlist.get(i).getText());
				
			}
			
			elementlist.get(3).click(); // click on logOut 
			
		
		}
		@AfterTest
		public void tearDown() throws InterruptedException
		{
			
			logOut();
			
			Thread.sleep(5000);// wait for 5 second Before quit 
			
			driver.close();
			driver.quit();
		}
	}
}
