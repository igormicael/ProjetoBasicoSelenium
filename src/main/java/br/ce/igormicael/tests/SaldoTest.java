package br.ce.igormicael.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.igormicael.core.BaseTest;
import br.ce.igormicael.pages.HomePage;

public class SaldoTest extends BaseTest {
	
	private HomePage homePage = new HomePage();
	
	@Test
	public void test() {
		Assert.assertEquals("500.00", homePage.obterSaldoConta("Outra Conta 2"));
	}

}
