package br.ce.igormicael.core;

public class Propriedades {

	public static boolean FECHAR_BROWSER = true;
	
	public static Browsers browser = Browsers.FIREFOX;
	
	public static String NOME_CONTA = "Conta " + System.nanoTime();
	
	public static String NOME_CONTA_ALTERADA = "Conta Alterada " + System.nanoTime(); 
	
	public enum Browsers{
		CHROME,
		FIREFOX
	}
	
}
