package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adminhomepage
{
	@FindBy(xpath="//*[text()='Welcome Back, admin admin of EcoTerra Consulting LLC']")
	public WebElement welcomemessg;
	
	public Adminhomepage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
}
