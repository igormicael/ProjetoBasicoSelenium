package br.ce.igormicael.tests;

import static br.ce.igormicael.core.DriverFactory.getDriver;

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
	
	@Test
	public void testResultadoMensal() {
		menuPage.acessarTelaResumo();
		
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
	}
	
}
