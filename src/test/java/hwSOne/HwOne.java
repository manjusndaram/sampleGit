package hwSOne;
/*Selenium HW1
 Scenario: Users will be able to add Account
1: Open Browser and go to site http://www.techfios.com/billing/?ng=admin/ 
2. Enter username: demo@techfios.com 
3. Enter password: abc123
4. Click login button
5. Click on Bank & Cash button
6. Click on New Account button 
7. Fill out the Add New Account form
8. Click on submit button
9. Visually check if the account has been created*/
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HwOne {
	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Manju\\Eclipse\\Selenium\\seleniumHwOne\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.close();	
	}

	@Test
	public void xPathTest() throws InterruptedException {
		// <input type="text" class="form-control" id="username" name="username"
		// placeholder="Email Address">
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demo@techfios.com");
		// <input type="password" class="form-control" id="password" name="password"
		// placeholder="Password">
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
		// <button class="btn btn-success block full-width" name="login"
		// type="submit">Sign in</button>
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		// <span class="nav-label">Bank & Cash</span>
		driver.findElement(By.xpath("//span[text()='Bank & Cash']")).click();
		// <a href="https://techfios.com/billing/?ng=accounts/add/">New Account</a>
		driver.findElement(By.xpath("//a[contains(text(),'New Account')]")).click();
		// <input type="text" class="form-control" id="account" name="account">
		driver.findElement(By.xpath("//input[@id='account']")).sendKeys("MS-Savings02");
		// <input type="text" class="form-control" id="description" name="description">
		driver.findElement(By.xpath("//input[@id='description'and @name='description']"))
				.sendKeys("My first Savings a/c");
		// <input type="text" class="form-control amount" id="balance" name="balance"
		// data-a-sign="$ " data-a-dec="." data-a-sep="," data-d-group="2">
		driver.findElement(By.xpath("//input[@id='balance']")).sendKeys("100");
		// <input type="text" class="form-control" id="account_number"
		// name="account_number">
		driver.findElement(By.xpath("//input[@id='account_number']")).sendKeys("58963");
		// <input type="text" class="form-control" id="contact_person"
		// name="contact_person">
		driver.findElement(By.xpath("//input[@id='contact_person']")).sendKeys("Techfios");
		// <input type="text" class="form-control" id="contact_phone"
		// name="contact_phone">
		driver.findElement(By.xpath("//input[@id='contact_phone']")).sendKeys("000-000-0000");
		// <input type="text" class="form-control" id="ib_url" name="ib_url">
		driver.findElement(By.xpath("//input[@id='ib_url']")).sendKeys("abc.com");
	    // <button type="submit" class="btn btn-primary"><i class="fa fa-check"></i>
		// Submit</button>
		driver.findElement(By.xpath("//button[text()=' Submit']")).click();
		Thread.sleep(5000);
	}

}
