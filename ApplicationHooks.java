package com.Hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.factory.*;

public class ApplicationHooks {
	private Driver_Factory driverFactory;
	private WebDriver driver;
	private ConfigReader configreader;
	Properties prop;
	
	@Before(order = 0)
	public void getProperty() {
		
		configreader = new ConfigReader();
		prop = configreader.init_prop();
	}

	@Before ( order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new Driver_Factory();
		driver = driverFactory.init_driver(browserName);
	}
	
	@After (order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	@After (order = 1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			// take screenshot,
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
}
