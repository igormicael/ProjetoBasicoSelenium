package br.ce.igormicael.tests;

import static br.ce.igormicael.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.igormicael.core.BaseTest;
import br.ce.igormicael.core.DriverFactory;
import br.ce.igormicael.pages.MenuPage;
import br.ce.igormicael.pages.ResumoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest{

	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();
	
	@Test
	public void test1_testExcluirMovimentacao() {
		menuPage.acessarTelaResumo();
		
		resumoPage.selecionarCombo("mes", "Setembro");
		resumoPage.selecionarCombo("ano", "2017");
		resumoPage.buscar();
		
		resumoPage.excluirMovimentacao();
		
		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
		
	}
	
	@Test
	public void test2_testResultadoMensal() {
		menuPage.acessarTelaResumo();
		
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
	}
	
	@Test
	public void test2ResumoMensal(){
		menuPage.acessarTelaResumo();
		
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		
		List<WebElement> elementosEncontrados = 
				DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		Assert.assertEquals(0, elementosEncontrados.size());
		
	}
	
}
