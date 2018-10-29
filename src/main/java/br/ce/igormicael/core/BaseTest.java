package br.ce.igormicael.core;

import static br.ce.igormicael.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.ce.igormicael.pages.LoginPage;

public class BaseTest {

	private LoginPage page = new LoginPage();
	
	@Rule
	public TestName testName = new TestName();

	@Before
	public void inicializa() {
		page.acessarTelaInicial();
		page.logar("igor@gmail.com", "12345");
	}

	@After
	public void finaliza() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		
		String prefix = "target" + File.separator + "screenshot" + File.separator;
		String pathname = prefix + testName.getMethodName() + ".png";
		FileUtils.copyFile(arquivo, new File( pathname));
		
		if(Propriedades.FECHAR_BROWSER)
			killDriver();
	}
	
}
