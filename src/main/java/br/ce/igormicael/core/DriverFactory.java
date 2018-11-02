package br.ce.igormicael.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.ce.igormicael.core.Propriedades.TipoExecucao;

public class DriverFactory {

//	private static WebDriver driver;
	private static ThreadLocal<WebDriver> threadDriver = 
			new ThreadLocal<WebDriver>() {
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};

	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		return threadDriver.get();
	}
	
	public static WebDriver initDriver() {
		WebDriver driver = null;
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
			System.setProperty("webdriver.gecko.driver", 
					"/media/igor/Grande Igor/Desenvolvimento/webdrivers/geckodriver");
				
			switch (Propriedades.BROWSER) {
				case FIREFOX: driver = new FirefoxDriver(); break;
				case CHROME: driver = new ChromeDriver(); break;
			}
		}else {
			DesiredCapabilities cap = null;
			switch (Propriedades.BROWSER) {
				case FIREFOX: 

					cap = new DesiredCapabilities();
					
					FirefoxProfile fp = new FirefoxProfile();
					fp.setPreference("network.proxy.type", 0);
					cap.setCapability(FirefoxDriver.PROFILE, fp);
					
					
					break;
				case CHROME: cap=DesiredCapabilities.chrome(); break;
			}
			
			try {
				driver = new RemoteWebDriver(new URL("http://192.168.25.72:4444/wd/hub"), cap);
			} catch (MalformedURLException e) {
				System.out.println("Falha na conexão com o grid");
			}
		}
		
		driver.manage().window().setSize(new Dimension(600, 800));
		
		return driver;
	}
	
	public static void killDriver() {
		WebDriver driver = getDriver();
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		if(threadDriver != null) {
			threadDriver.remove();
		}
		
	}
	
}
