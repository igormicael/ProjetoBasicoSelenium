package br.ce.igormicael.suites;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.igormicael.core.DriverFactory;
import br.ce.igormicael.pages.LoginPage;
import br.ce.igormicael.tests.ContaTest;
import br.ce.igormicael.tests.MovimentacaoTest;
import br.ce.igormicael.tests.RemoverMovimentacaoContaTest;
import br.ce.igormicael.tests.ResumoTest;
import br.ce.igormicael.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})
public class SuiteGeral {
	
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void reset() {
		page.acessarTelaInicial();
		page.logar("igor@gmail.com", "12345");
		
		page.resetar();
		
		DriverFactory.killDriver();
		
	}

}
