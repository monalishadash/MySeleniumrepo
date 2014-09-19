package persistent.code;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SettingsPage {
	
	WebDriver driver;
	@FindBy(css="input#blogname")
	@CacheLookup
	WebElement blogname;
	
	@FindBy(css="input#blogdescription")
	@CacheLookup
	WebElement blogDes;
	
	@FindBy(css="input#submit")
	@CacheLookup
	WebElement saveChanges_butn;
	
	public SettingsPage(WebDriver driver1)
	{
		this.driver = driver1;
	}
	
	public void modifyBlogName(String blogNm)
	{
		blogname.clear();
		blogname.sendKeys(blogNm);
	}
	
	public void modifyBlogDesc(String blogDesc)
	{
		blogDes.clear();
		blogDes.sendKeys(blogDesc);
	}
	
	public void submitModifiedSettings()
	{
		saveChanges_butn.click();
	}

}
