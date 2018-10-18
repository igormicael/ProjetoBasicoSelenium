package br.ce.igormicael.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.igormicael.core.BaseTest;
import br.ce.igormicael.pages.MenuPage;
import br.ce.igormicael.pages.MovimentacaoPage;

public class MovimentacaoTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	MovimentacaoPage movimentacaoPage = new MovimentacaoPage();

	@Test
	public void testInserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		movimentacaoPage.setDataMovimentacao("01/09/2017");
		movimentacaoPage.setDataPagamento("02/09/2017");
		movimentacaoPage.setDescricao("Movimentação do Teste");
		movimentacaoPage.setInteressado("Interessado");
		movimentacaoPage.setValor("500");
		movimentacaoPage.setConta("Outra Conta 2");
		movimentacaoPage.setSituacaoPago();
		movimentacaoPage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", 
				movimentacaoPage.obterMensagemSucesso());
	}
	
}
