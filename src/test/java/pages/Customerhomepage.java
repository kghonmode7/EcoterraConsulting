package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customerhomepage 
{
	@FindBy(xpath="Welcome Back, itecy itecy of Posillico Environmental, Inc")
	public WebElement welcomemsgcus;
	
	public Customerhomepage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

}
