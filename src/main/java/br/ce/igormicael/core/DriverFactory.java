package br.ce.igormicael.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static WebDriver driver;

	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		
		System.setProperty("webdriver.gecko.driver", 
				"/media/igor/Grande Igor/Desenvolvimento/webdrivers/geckodriver");
		
		if(driver == null) {
			
			switch (Propriedades.browser) {
				case FIREFOX: driver = new FirefoxDriver(); break;
				case CHROME: driver = new ChromeDriver(); break;
			}
			driver.manage().window().setSize(new Dimension(600, 800));
		}
		return driver;
	}
	
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
}
