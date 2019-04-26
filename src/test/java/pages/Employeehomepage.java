package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Employeehomepage 
{
	@FindBy(xpath="Welcome Back, Test  Emp of EcoTerra Consulting LLC")
	public WebElement welcomemsgemp;
	
	public Employeehomepage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
}
