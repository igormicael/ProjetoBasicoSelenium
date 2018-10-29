package br.ce.igormicael.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.igormicael.core.Propriedades;
import br.ce.igormicael.pages.ContasPage;
import br.ce.igormicael.pages.MenuPage;

public class RemoverMovimentacaoContaTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void testExcluirContaComMovimentacao() {
		menuPage.acessarTelaListagemConta();
		
		contasPage.clicarExcluirConta(Propriedades.NOME_CONTA_ALTERADA);
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
		
	}

}
