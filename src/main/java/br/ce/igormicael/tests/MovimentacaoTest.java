package br.ce.igormicael.tests;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.ce.igormicael.core.BaseTest;
import br.ce.igormicael.pages.MenuPage;
import br.ce.igormicael.pages.MovimentacaoPage;
import br.ce.igormicael.utils.DataUtils;

public class MovimentacaoTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	MovimentacaoPage movimentacaoPage = new MovimentacaoPage();

	@Test
	public void test1_testInserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		movimentacaoPage.setDataMovimentacao("01/09/2017");
		movimentacaoPage.setDataPagamento("02/09/2017");
		movimentacaoPage.setDescricao("Movimentação do Teste");
		movimentacaoPage.setInteressado("Interessado");
		movimentacaoPage.setValor("500");
		movimentacaoPage.setConta("Conta para movimentacoes");
		movimentacaoPage.setSituacaoPago();
		movimentacaoPage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", 
				movimentacaoPage.obterMensagemSucesso());
	}
	
	@Test
	public void test2_testCamposObrigatorios() {
		menuPage.acessarTelaInserirMovimentacao();
		movimentacaoPage.salvar();
		
		List<String> erros = movimentacaoPage.obterErros();
		
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório",
				"Descrição é obrigatório",
				"Interessado é obrigatório",
				"Valor é obrigatório",
				"Valor deve ser um número"
				)));
	}
	
	@Test
	public void test3_testInserirMovimentacaoFutura() {
		
		menuPage.acessarTelaInserirMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		String obterDataFormatada = DataUtils.obterDataFormatada(dataFutura);
		
		movimentacaoPage.setDataMovimentacao(obterDataFormatada);
		movimentacaoPage.setDataPagamento(obterDataFormatada);
		movimentacaoPage.setDescricao("Movimentação do Teste");
		movimentacaoPage.setInteressado("Interessado");
		movimentacaoPage.setValor("500");
		movimentacaoPage.setConta("Conta para movimentacoes");
		movimentacaoPage.setSituacaoPago();
		movimentacaoPage.salvar();
		
		List<String> erros = movimentacaoPage.obterErros();
		
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação deve ser menor ou igual à data atual"
				)));
	}
	
}
