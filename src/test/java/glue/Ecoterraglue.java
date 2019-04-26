package glue;

import java.io.FileInputStream;
import java.util.Properties;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Adminhomepage;
import pages.Customerhomepage;
import pages.Employeehomepage;
import pages.Loginpage;

public class Ecoterraglue
{
	public WebDriver driver;
	public WebDriverWait wait;
	public Adminhomepage ahp;
	public Employeehomepage ehp;
	public Customerhomepage chp;
	public Loginpage lp;
	public Scenario s;
	public Properties p;
	
	@Before
	public void method1(Scenario s)throws Exception
	{
		this.s=s;
		FileInputStream fi=new FileInputStream("E:\\CSTECH0786\\ecoterraconsulting\\src\\test\\resources\\repository\\file1.properties");
		p=new Properties();
		p.load(fi);
	}
	
	@Given("^launch site$")
	public void method2()
	{
		System.setProperty("webdriver.chrome.driver",p.getProperty("cdpath"));
		driver=new ChromeDriver();
		ahp=new Adminhomepage(driver);
		ehp=new Employeehomepage(driver);
		chp=new Customerhomepage(driver);
		lp=new Loginpage(driver);
		driver.get(p.getProperty("url"));
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(lp.logintype));
		driver.manage().window().maximize();
	}
	
	@When("^click on dropdown and select admin from dropdown$")
	public void method3()
	{
		wait.until(ExpectedConditions.visibilityOf(lp.logintype));
		lp.selectDropDown();
	}
	@When("^click on dropdown and select employee from dropdown$")
	public void method4()
	{
		wait.until(ExpectedConditions.visibilityOf(lp.logintype));
		lp.selectDropDown1();
	}
	@When("^click on dropdown and select customer from dropdown$")
	public void method5()
	{
		wait.until(ExpectedConditions.visibilityOf(lp.logintype));
		lp.selectDropDown2();
	}
	@And("^fill username \"(.*)\"$")
	public void method6(String x)
	{
		wait.until(ExpectedConditions.visibilityOf(lp.uid));
		lp.filluid(x);
	}
	
	@And("^fill password \"(.*)\"$")
	public void method7(String y)
	{
		wait.until(ExpectedConditions.visibilityOf(lp.pwd));
		lp.fillpwd(y);
	}
	
	@And("^click login button$")
	public void method8()
	{
		wait.until(ExpectedConditions.visibilityOf(lp.loginbtn));
		lp.clickLogin();
	}
	
	@Then("^validate output for admin criteria \"(.*)\" for \"(.*)\" and \"(.*)\" for \"(.*)\"$")
	public void method9(String uc,String u,String pc,String p)throws Exception
	{
		Thread.sleep(5000);
	    try 
	    {
	    	if(uc.equals("valid") && pc.equals("valid") && ahp.welcomemessg.isDisplayed())
	    	{
	    		s.write("valid userid and password test passed");
	    	}
	    	else if(uc.equals("uid_blank") && pc.equals("valid") && lp.blankuidmessg.isDisplayed())
	    	{
	    		s.write("blank userid test passed");
	    	}
	    	else if(uc.equals("valid") && pc.equals("pwd_blank") && lp.blankpwdmessg.isDisplayed())
	    	{
	    		s.write("blank pwd test passed");
	    	}
	    	else if(uc.equals("invalid") && pc.equals("valid") && lp.uiderrmessg.isDisplayed())
	    	{
	    		s.write("invalid uid test passed");
	    	}
	    	else
	    	{
	    		byte[] ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	    		s.embed(ss,"login test failed");	
	    	}
	    }
	    catch(Exception ex)
	    {
	    	byte[] ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    		s.embed(ss,ex.getMessage());
    		
	    }
	}
	@And("^close site$")
	public void close_site_for_admin()
	{
		driver.close();
	}
	    @Then("^validate output for employee criteria \"(.*)\" for \"(.*)\" and \"(.*)\" for \"(.*)\"$")
		public void method10(String uc,String u,String pc,String p)throws Exception
		{
			Thread.sleep(5000);
		    try 
		    {
		    	if(uc.equals("valid") && pc.equals("valid") && ehp.welcomemsgemp.isDisplayed())
		    	{
		    		wait.until(ExpectedConditions.visibilityOf(ehp.welcomemsgemp));
		    		s.write("valid userid and password test passed");
		    	}
		    	else if(uc.equals("uid_blank") && pc.equals("valid") && lp.blankuidmessg.isDisplayed())
		    	{
		    		s.write("blank userid test passed");
		    	}
		    	else if(uc.equals("valid") && pc.equals("pwd_blank") && lp.blankpwdmessg.isDisplayed())
		    	{
		    		s.write("blank pwd test passed");
		    	}
		    	else if(uc.equals("invalid") && pc.equals("valid") && lp.uiderrmessg.isDisplayed())
		    	{
		    		s.write("invalid uid test passed");
		    	}
		    	else
		    	{
		    		byte[] ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		    		s.embed(ss,"login test failed");
		    		
		    	}
		    }
		    catch(Exception ex)
		    {
		    	byte[] ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	    		s.embed(ss,ex.getMessage());
	    		
		    }
	    }
	    
	    @When("^close site for employee$")
	    public void close_site_for_employee()
	    {
	    	driver.close();
	    }
	    @Then("^validate output for customer criteria \"(.*)\" for \"(.*)\" and \"(.*)\" for \"(.*)\"$")
		public void method12(String uc,String u,String pc,String p)throws Exception
		{
			Thread.sleep(5000);
		    try 
		    {
		    	if(uc.equals("valid") && pc.equals("valid") && chp.welcomemsgcus.isDisplayed())
		    	{
		    		wait.until(ExpectedConditions.visibilityOf(chp.welcomemsgcus));
		    		s.write("valid userid and password test passed");	
		    	}
		    	else if(uc.equals("uid_blank") && pc.equals("valid") && lp.blankuidmessg.isDisplayed())
		    	{
		    		s.write("blank userid test passed");
		    	}
		    	else if(uc.equals("valid") && pc.equals("pwd_blank") && lp.blankpwdmessg.isDisplayed())
		    	{
		    		s.write("blank pwd test passed");
		    	}
		    	else if(uc.equals("invalid") && pc.equals("valid") && lp.uiderrmessg.isDisplayed())
		    	{
		    		s.write("invalid uid test passed");
		    	}
		    	else
		    	{
		    		byte[] ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		    		s.embed(ss,"login test failed");
		    		
		    	}
		    }
		    catch(Exception ex)
		    {
		    	byte[] ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	    		s.embed(ss,ex.getMessage());
	    		
		    }
		}
	    
	   @When("^close site for customer$")
	   public void close_site_for_customer()
	   {
		   driver.close();
	   }
	    
}
