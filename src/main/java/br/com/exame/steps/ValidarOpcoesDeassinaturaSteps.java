package br.com.exame.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import br.com.exame.core.DriverFactory;
import br.com.exame.core.PDFGenerator;
import br.com.exame.core.TipoDriver;
import br.com.exame.hooks.Hooks;
import br.com.exame.pages.HomeExamePage;
import br.com.exame.pages.PayWallOpcoesAssinaturaPage;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.runtime.junit.Assertions;


public class ValidarOpcoesDeassinaturaSteps    {

	public ValidarOpcoesDeassinaturaSteps() {
		// TODO Auto-generated constructor stub
	}

	PDFGenerator pdfgenerator = new PDFGenerator();
	String currentHandle;
	String currentHandle2;
	
//	mvn test -Dcucumber.options="--tags @ValidarOpcoesDeassinaturaDigital"
	@Before(value = "@ValidarOpcoesDeassinaturaDigital", order = 1)
	public void before(Scenario cenario) throws Exception {
//		DriverFactory.getDriver(TipoDriver.CHROME).get("https://pre.exame.com.br/");
		pdfgenerator.iniciaPDF(cenario);
		
	}
	
	   //List<Map<String, String>> list = dt.asMaps(String.class, String.class);
	
	@Given("^que um leitor nao assinante acessa um noticia do Paywayll$")
	public void que_um_leitor_nao_assinante_acessa_um_noticia_do_Paywayll() throws Throwable {
		pdfgenerator.conteudoPDF("seleciona_a_opcao_de_assinatura");
		
		
	}

	
	@Given("^o sistema exbibira as seguintes opcoes de data$")
	public void o_sistema_exbibira_as_seguintes_opcoes_de_data(DataTable tipoPlanoMensal) throws Throwable {
	    
			    
		List<String> listaPlanos = tipoPlanoMensal.asList(String.class);
	    
	    pdfgenerator.conteudoPDF("o_sistema_exbibira_as_seguintes_opcoes_de:");
		boolean resultTest = false;
		
		for(int i=0; i<listaPlanos.size(); i++) {
			System.out.println(listaPlanos.get(i));
			
			resultTest = DriverFactory.page.GetInstance(PayWallOpcoesAssinaturaPage.class).validarOpcoesExibidas (listaPlanos.get(i));	
			Assert.assertTrue(resultTest);
		}
		
		System.out.println(listaPlanos.get(0));
		
		
	    
	}
	
		
		@After(value = "@ValidarOpcoesDeassinaturaDigital", order = 1)
		public void finalizaPDF(Scenario cenario) throws Exception {
			
//			ArrayList<String> tabs = new ArrayList<String> (DriverFactory.getDriver(TipoDriver.CHROME).getWindowHandles());
//			DriverFactory.getDriver(TipoDriver.CHROME).switchTo().window(tabs.get(0));
//			DriverFactory.getDriver(TipoDriver.CHROME).switchTo().defaultContent().close();
			pdfgenerator.fechaPDF("Fechar PDF");
//			DriverFactory.closeDriver();
			
//			ArrayList<String> tabs = new ArrayList<String> (DriverFactory.getDriver(TipoDriver.CHROME).getWindowHandles());
//			DriverFactory.getDriver(TipoDriver.CHROME).switchTo().defaultContent();
			
			
		}
		
		
		

}
