package br.ce.igormicael.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.igormicael.core.BaseTest;
import br.ce.igormicael.pages.ContasPage;
import br.ce.igormicael.pages.MenuPage;

public class ContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void testInserirConta() {
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome("Outra Conta");
		contasPage.salvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
		
	}

}
