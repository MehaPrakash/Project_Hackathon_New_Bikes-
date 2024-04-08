package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features={".//FeatureFiles/"},
//		features={".//FeatureFiles/UpcomingBikeBasicFunctionality.feature"},
//		features={".//FeatureFiles/UpcomingBikeDetails.feature"},
//		features={".//FeatureFiles/LoginBasicFunctionality.feature"},
//		features={".//FeatureFiles/NewLoginDDT.feature"},
//		features={".//FeatureFiles/UsedCarsBasicFunctionality.feature"},
//		features={".//FeatureFiles/UsedCars.feature"},
//		features= {"@target/rerun.txt"},
		

		glue = "stepDefinitions",
		
		plugin= {"pretty", "html:reports/myreport.html", 
			     "rerun:target/rerun.txt",
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},
		
		dryRun=false,    // checks mapping between scenario steps and step definition methods
		monochrome=true,    // to avoid junk characters in output
		publish=true  // to publish report in cucumber server
		
		//tags="@sanity"
		//tags="@regression"
		//tags="@sanity and @regression" 
		//tags="@sanity and not @regression"
		//tags="@sanity or @regression" 
		)

public class TestRun{
	
}