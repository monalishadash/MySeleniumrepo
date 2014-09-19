package persistent.code;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
	
	
	WebDriver driver;
	
	@FindBy(css="li#menu-settings a.wp-has-submenu")
	@CacheLookup
	WebElement setting_link;
	
	public Dashboard(WebDriver driver1)
	{
		this.driver = driver1;
	}
	
	public SettingsPage clickOnSetting()
	{
		setting_link.click();
		//return new SettingsPage(driver);
		return PageFactory.initElements(driver, SettingsPage.class);
		
	}

}
