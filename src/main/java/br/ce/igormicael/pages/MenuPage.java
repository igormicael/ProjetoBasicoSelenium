package br.ce.igormicael.pages;

import br.ce.igormicael.core.BasePage;

public class MenuPage extends BasePage {

	public void acessarTelaInserirConta() {
		clicarLink("Contas");
		clicarLink("Adicionar");
	}
	
}
