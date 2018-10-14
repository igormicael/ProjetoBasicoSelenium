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
	
	@Test
	public void testAlterarConta() {
		menuPage.acessarTelaListagemConta();
		
		contasPage.clicarAlterarConta("Outra Conta");
		
		contasPage.setNome("Outra Conta 2");
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
		
	}

}
