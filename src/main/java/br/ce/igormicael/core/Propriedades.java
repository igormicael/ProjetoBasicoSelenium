package br.ce.igormicael.core;

public class Propriedades {

	public static boolean FECHAR_BROWSER = true;
	
	public static Browsers BROWSER = Browsers.FIREFOX;
	
	public static String NOME_CONTA = "Conta " + System.nanoTime();
	
	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.NUVEM;
	
	public enum Browsers{
		CHROME,
		FIREFOX,
		IE
	}
	
	public enum TipoExecucao{
		LOCAL,
		GRID,
		NUVEM
	}
	
}
