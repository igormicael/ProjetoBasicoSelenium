package br.ce.igormicael.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.igormicael.core.BaseTest;
import br.ce.igormicael.core.Propriedades;
import br.ce.igormicael.pages.ContasPage;
import br.ce.igormicael.pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void test1_testInserirConta() {
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome(Propriedades.NOME_CONTA);
		contasPage.salvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
		
	}
	
	@Test
	public void test2_testAlterarConta() {
		menuPage.acessarTelaListagemConta();
		
		contasPage.clicarAlterarConta(Propriedades.NOME_CONTA);
		
		contasPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
		
	}
	
	@Test
	public void test3_testInserirContaMesmoNome() {
		
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
		contasPage.salvar();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
		
	}

}
