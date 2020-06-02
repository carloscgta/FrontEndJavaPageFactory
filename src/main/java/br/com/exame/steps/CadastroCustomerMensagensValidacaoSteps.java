package br.com.exame.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.github.javafaker.Faker;

import br.com.exame.core.DriverFactory;
import br.com.exame.core.PDFGenerator;
import br.com.exame.core.TipoDriver;
import br.com.exame.core.YamlHelper;
import br.com.exame.pages.CustomerPage;
import br.com.exame.pages.HomeExamePage;
import br.com.exame.pages.PayWallOpcoesAssinaturaPage;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class CadastroCustomerMensagensValidacaoSteps {

	public CadastroCustomerMensagensValidacaoSteps() {
		// TODO Auto-generated constructor stub
	}

	PDFGenerator pdfgenerator = new PDFGenerator();
	YamlHelper yaml = new YamlHelper();
	Faker faker = new Faker();
	
	
	@Before(value = "@validarMensagensDeErroNoCadastro", order = 1)
	public void before(Scenario cenario) throws Exception {
		pdfgenerator.iniciaPDF(cenario);
	}
	
	
	@Given("^que um usuario esteja no formulario de cadastro$")
	public void que_um_usuario_esteja_no_formulario_de_cadastro() throws Throwable {
	    
		try {
			DriverFactory.getDriver(TipoDriver.CHROME).navigate().to("https://assine.stage.exame.dev/sign-upn");
			
//			DriverFactory.page.GetInstance(HomeExamePage.class).clicarBotaoAssine();
//			
//			ArrayList<String> tabs2 = new ArrayList<String> (DriverFactory.getDriver(TipoDriver.CHROME).getWindowHandles());
//			DriverFactory.getDriver(TipoDriver.CHROME).switchTo().window(tabs2.get(1));
//			DriverFactory.page.GetInstance(PayWallOpcoesAssinaturaPage.class).clicarBotaoAssineDigital();

		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	@Given("^insere informacoes invalidas para validar as mensagens de validacao usando os Dados$")
	public void insere_informacoes_invalidas_para_validar_as_mensagens_de_validacao_usando_os_Dados(DataTable dataTableMensagensValidacaoErro) throws Throwable {
	
List<Map<String, String>> listMensagensValidacaoErro = dataTableMensagensValidacaoErro.asMaps(String.class, String.class);
	
	    
	    pdfgenerator.conteudoPDF("insere_informacoes_invalidas_para_validar_as_mensagens_de_validacao_usando_os_Dados:");
		//boolean resultTest = false;
		
	    DriverFactory.page.GetInstance(CustomerPage.class).escreverNomeCustomer("O");
		pdfgenerator.conteudoPDF("Preenchido campo com o conteudo:" + "O");
		
		
		DriverFactory.page.GetInstance(CustomerPage.class).escreverEmail("carlosgta");
		pdfgenerator.conteudoPDF("Preenchido campo  com o conteudo:" +"carlosgta" );
		
		
		DriverFactory.page.GetInstance(CustomerPage.class).escreverSenha("Sol");
		pdfgenerator.conteudoPDF("Preenchido campo com o conteudo:" + "Sol");
		
		DriverFactory.page.GetInstance(CustomerPage.class).ConfirmarSenha("Solrac");
		pdfgenerator.conteudoPDF("Preenchido campo com o conteudo:" + "Solrac");
		
		DriverFactory.page.GetInstance(CustomerPage.class).escreverCPFTexto("567");
		pdfgenerator.conteudoPDF("Preenchido campo com o conteudo:" + "567");
		
		DriverFactory.page.GetInstance(CustomerPage.class).escreverPhone("11");
		
		pdfgenerator.conteudoPDF("Preenchido campo com o conteudo:" + "11");
		
		DriverFactory.page.GetInstance(CustomerPage.class).escreverCardNumber("32");
		
		DriverFactory.page.GetInstance(CustomerPage.class).escreverCardCVV(" ");
		
		DriverFactory.page.GetInstance(CustomerPage.class).escreverCardNome("i");
		
		DriverFactory.page.GetInstance(CustomerPage.class).escreverDataValidadeCartao("0000");
		DriverFactory.page.GetInstance(CustomerPage.class).escreverCardNumber("320");
		

		for(int i=0; i<listMensagensValidacaoErro.size(); i++) {
			//System.out.println(listMensagensValidacaoErro.get(i));
			
			
		if(DriverFactory.page.GetInstance(CustomerPage.class).validarMensagemErroExibida(listMensagensValidacaoErro.get(i).get("MensagenErroTexto"))){
			System.out.println("OK - Mensagem de Validacao foi exibida:"+listMensagensValidacaoErro.get(i).get("MensagenErroTexto"));
			
		}
				
		}
		
		
		
		
	}


	@After(value = "@validarMensagensDeErroNoCadastro", order = 1)
	public void finalizaPDF(Scenario cenario) throws Exception {

		
		pdfgenerator.fechaPDF("Fechar PDF");
		

	}
	
}
