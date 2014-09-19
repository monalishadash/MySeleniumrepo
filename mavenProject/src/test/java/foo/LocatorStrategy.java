package foo;

import java.io.File;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LocatorStrategy {

	@Test
	public void locatorMethod() {

		//System.setProperty("webdriver.ie.driver", "C:\\JAVA Soft\\trg\\chromedriver.exe");
		//System.setProperty("webdriver.ie.driver", "C:\\JAVA Soft\\trg\\IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://wordpress.com/wp-login.php");
		//driver.get("https://wordpress.com");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		// User Login to wordpress
		WebElement userLogin_txtbox = driver.findElement(By.id("user_login"));
		WebElement userPasswd_txtbox = driver.findElement(By.id("user_pass"));
		WebElement submit_btn = driver.findElement(By.id("wp-submit"));
		WebElement remember_chkbox = driver.findElement(By.id("rememberme"));

		userLogin_txtbox.clear();
		userLogin_txtbox.sendKeys("monadash");

		userPasswd_txtbox.clear();
		userPasswd_txtbox.sendKeys("Secret123$");
		remember_chkbox.click();

		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, 	new File("./screenshot/wordpress_login.png"));
		} catch (Exception e) {
			System.out.println("Error: "+ e);
		}
		
		submit_btn.click();
		
		driver.findElement(By.className("ab-display-name")).click();
		
		driver.findElement(By.xpath("//a[text()='My Sites']")).click();
		driver.findElement(By.xpath("//a[text()='Dashboard']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		for(String s: windows)
		{
			System.out.println("Window name: " + s);
		}
		
		/*
			WebElement postLink = driver.findElement(By.xpath("//div[text()='Posts']"));
			postLink.click();
		
			WebElement addNewPostLink = driver.findElement(By.xpath("//a[@href='post-new.php']"));
			addNewPostLink.click();
		
			WebElement postText = driver.findElement(By.xpath("//h2[text()='Add New Post']"));
			if(postText.isDisplayed())
			{
				WebElement postTitle_txtbox= driver.findElement(By.xpath("//labelBy.xpath("//la[@id='title-prompt-text']"));
				if(postTitle_txtbox.isEnabled())
				{
					//postTitle_txtbox.clear();
					postTitle_txtbox.sendKeys("My post1");
				}
			
				driver.switchTo().frame("content_ifr");
				WebElement enterPostArea = driver.findElement(By.xpath("//body[@id='tinymce']"));
				//enterPostArea.clear();
				enterPostArea.sendKeys("Description for my post1");
				driver.switchTo().defaultContent();
				
				driver.close();
				Alert alert = driver.switchTo().alert();
				alert.dismiss();
				driver.switchTo().defaultContent();
				
				WebElement permaLink = driver.findElement(By.xpath("//span[@id='sample-permalink']"));
				if(permaLink.isDisplayed())
				{
					WebElement publish_butn= driver.findElement(By.xpath("//input[@name='publish']"));
					publish_butn.click();
				}
				
				
			}*/
		
		// Login action
		/*
		driver.findElement(By.cssSelector("input#user_login")).sendKeys("monadash");
		driver.findElement(By.cssSelector("input#user_pass")).sendKeys("Secret123$");
		driver.findElement(By.cssSelector("input#rememberme")).click();
		driver.findElement(By.cssSelector("input#wp-submit")).click();
		
		WebDriverWait wait30 = new WebDriverWait(driver, 30);
		wait30.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[text()='Dashboard']")), "Dashboard"));
		System.out.println(driver.findElement(By.xpath("//*[text()='Dashboard']")).getText());
		
		////Adding a new post
		WebElement mouseHoverElement = driver.findElement(By.xpath("//*[text()='Posts']"));
		WebElement post_Title = driver.findElement(By.xpath("//label[@id='title-prompt-text']"));
		
		Actions action = new Actions(driver);
		
		//Composite action in one event
		//action.moveToElement(mouseHoverElement)
		//.click(mouseHoverElement)
		//.click(driver.findElement(By.xpath("//a[text()='Add New']")))
		//.sendKeys(post_Title,"My first post");
		
		//action.build().perform();
		
		
		// driver.findElement(By.xpath("//a[text()='Add New']")).click();
		
		//Go to settings and change some attributes
		driver.findElement(By.cssSelector("li#menu-settings a.wp-has-submenu")).click();
			
		driver.findElement(By.cssSelector("input#blogname")).clear();
		driver.findElement(By.cssSelector("input#blogname")).sendKeys("Monalisha Dash");
		driver.findElement(By.cssSelector("input#blogdescription")).clear();
		driver.findElement(By.cssSelector("input#blogdescription")).sendKeys("monalishadash's blog in Wordpress.com");
		
		
		WebElement dropDownList = driver.findElement(By.id("start_of_week"));
		
		Select dropdown = new Select(dropDownList);
		dropdown.selectByVisibleText("Wednesday");
		dropdown.selectByIndex(2);
		
		ArrayList <WebElement> options = (ArrayList<WebElement>) dropdown.getOptions();
		
		for(WebElement e:options)
		{
			System.out.println(e.getText());
		}
		System.out.println(options);
		
		driver.findElement(By.cssSelector("input#submit")).click();
		
		WebElement settingMesg = driver.findElement(By.id("setting-error-settings_updated"));
		wait30.until(ExpectedConditions.visibilityOf(settingMesg));
		
		if(settingMesg.getText().equalsIgnoreCase("Settings saved."))
		{
			System.out.println("Settings saved successfully: "+settingMesg.getText());
		}
		else
		{
			System.out.println("Settings not saved properly " +settingMesg.getText());
		}
		
		
		
		
		///Drag and drop element
		WebElement appearence = driver.findElement(By.xpath("//div[text()='Appearance']"));
		action.moveToElement(appearence).build().perform();
		driver.findElement(By.xpath("//a[@href='widgets.php']")).click();
				
		WebElement elementToBeDragged = driver.findElement(By.xpath("//*[text()='Archives']"));
		WebElement placeToDrop = driver.findElement(By.cssSelector("div.widgets-holder-wrap div#sidebar-1"));
		action.dragAndDrop(elementToBeDragged, placeToDrop).build().perform();
		
		//WebElement signout = driver.findElement(By.xpath("//*[text()='monadash']"));
		//action.moveToElement(signout).build().perform();
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		 * */
		 
		driver.quit();
		
		
	}
}
