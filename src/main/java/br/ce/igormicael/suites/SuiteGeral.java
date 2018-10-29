package br.ce.igormicael.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.igormicael.tests.ContaTest;
import br.ce.igormicael.tests.MovimentacaoTest;
import br.ce.igormicael.tests.RemoverMovimentacaoContaTest;
import br.ce.igormicael.tests.ResumoTest;
import br.ce.igormicael.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})
public class SuiteGeral {
	

}
