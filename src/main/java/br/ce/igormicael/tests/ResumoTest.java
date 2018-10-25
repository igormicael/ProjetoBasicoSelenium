package br.ce.igormicael.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.igormicael.core.BaseTest;
import br.ce.igormicael.pages.MenuPage;
import br.ce.igormicael.pages.ResumoPage;

public class ResumoTest extends BaseTest{

	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();
	
	@Test
	public void teste() {
		menuPage.acessarTelaResumo();
		resumoPage.excluirMovimentacao();
		
		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
		
	}
	
}
