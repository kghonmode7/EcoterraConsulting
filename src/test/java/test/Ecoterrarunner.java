package test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"E:\\CSTECH0786\\ecoterraconsulting\\src\\test\\resources\\feature\\feature1.feature"},
                 monochrome=true,                             
                 glue={"glue"},
                 plugin={"pretty","html:target\\result1","rerun:target\\failed.txt"})
public class Ecoterrarunner
{
	
}
