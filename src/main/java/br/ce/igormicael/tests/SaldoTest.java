package br.ce.igormicael.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.igormicael.core.BaseTest;
import br.ce.igormicael.core.Propriedades;
import br.ce.igormicael.pages.HomePage;
import br.ce.igormicael.pages.MenuPage;

public class SaldoTest extends BaseTest {
	
	private HomePage homePage = new HomePage();
	private MenuPage menu = new MenuPage();
	
	@Test
	public void test() {
		menu.acessarTelaPrincipal();
		Assert.assertEquals("500.00", homePage.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA));
	}

}
