package br.com.exame.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.github.javafaker.Faker;

import br.com.exame.core.DriverFactory;
import br.com.exame.core.GeradorEmail;
import br.com.exame.core.GeradorNumeroTelefone;
import br.com.exame.core.PDFGenerator;
import br.com.exame.core.TipoDriver;
import br.com.exame.core.YamlHelper;
import br.com.exame.hooks.Hooks;
import br.com.exame.pages.CustomerPage;
import br.com.exame.pages.HomeExamePage;
import br.com.exame.pages.PayWallOpcoesAssinaturaPage;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class CadastroCustomerMensagensValidacaoSteps   {

	public CadastroCustomerMensagensValidacaoSteps() {
		// TODO Auto-generated constructor stub
	}

	PDFGenerator pdfgenerator = new PDFGenerator();
	YamlHelper yaml = new YamlHelper();
	Faker faker = new Faker();
	GeradorEmail gerarEmail = new GeradorEmail();
	
	
	@Before(value = "@validarMensagensDeErroNoCadastro", order = 1)
	public void before(Scenario cenario) throws Exception {
		pdfgenerator.iniciaPDF(cenario);
//		DriverFactory.getDriver(TipoDriver.CHROME).get("https://pre.exame.com.br/");
	}
	
	
	@Given("^que um usuario esteja no formulario de cadastro$")
	public void que_um_usuario_esteja_no_formulario_de_cadastro() throws Throwable {
	    
		try {

//			DriverFactory.page.GetInstance(HomeExamePage.class).clicarBotaoAssine();
//			
//			ArrayList<String> tabs2 = new ArrayList<String> (DriverFactory.getDriver(TipoDriver.CHROME).getWindowHandles());
//			DriverFactory.getDriver(TipoDriver.CHROME).switchTo().window(tabs2.get(1));
//			
			DriverFactory.page.GetInstance(PayWallOpcoesAssinaturaPage.class).clicarBotaoAssineDigital();
			
		
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
		
		DriverFactory.page.GetInstance(CustomerPage.class).escreverConfirmarEmail("carloscg");
		pdfgenerator.conteudoPDF("Preenchido campo  com o conteudo:" +"carloscg" );
		
		DriverFactory.page.GetInstance(CustomerPage.class).escreverSenha("Sol");
		pdfgenerator.conteudoPDF("Preenchido campo com o conteudo:" + "Sol");
		
		DriverFactory.page.GetInstance(CustomerPage.class).ConfirmarSenha("Solrac");
		pdfgenerator.conteudoPDF("Preenchido campo com o conteudo:" + "Solrac");
		
		DriverFactory.page.GetInstance(CustomerPage.class).escreverCPFTexto("567");
		pdfgenerator.conteudoPDF("Preenchido campo com o conteudo:" + "567");
		
		DriverFactory.page.GetInstance(CustomerPage.class).escreverPhone("11");
		
		pdfgenerator.conteudoPDF("Preenchido campo com o conteudo:" + "11");

		for(int i=0; i<listMensagensValidacaoErro.size(); i++) {
			
			System.out.println(listMensagensValidacaoErro.get(i));
			
			
		if(DriverFactory.page.GetInstance(CustomerPage.class).validarMensagemErroExibida(listMensagensValidacaoErro.get(i).get("MensagenErroTexto"))){
			System.out.println("OK - Mensagem de Validacao foi exibida:"+listMensagensValidacaoErro.get(i).get("MensagenErroTexto"));
			
		}
				
		}
		
		/*************************PREENCHER FORMULARIO PARA AVANCAR PARA A PROXIMA SESSAO******************/
		
		
				
		DriverFactory.page.GetInstance(CustomerPage.class).escreverNomeCustomer("Joao Almeida Arilindo");
			
		String emailGerado = gerarEmail.geraEmail();
		DriverFactory.page.GetInstance(CustomerPage.class).escreverEmail(emailGerado);
		DriverFactory.page.GetInstance(CustomerPage.class).escreverConfirmarEmail(emailGerado);
		DriverFactory.page.GetInstance(CustomerPage.class).escreverSenha("Solrac@89");
		
		DriverFactory.page.GetInstance(CustomerPage.class).ConfirmarSenha("Solrac@89");
		
		String cpf = null;
		cpf= DriverFactory.page.GetInstance(CustomerPage.class).escreverCPF();
	
		DriverFactory.page.GetInstance(CustomerPage.class).escreverCPFTexto(cpf);
		
		GeradorNumeroTelefone geradorPhone = new GeradorNumeroTelefone();
		String telefoneGerado = geradorPhone.geraTelefoneMovel();
		DriverFactory.page.GetInstance(CustomerPage.class).escreverPhone(telefoneGerado);
		
		 DriverFactory.page.GetInstance(CustomerPage.class).clicarRecaptcha();
	      
	      DriverFactory.page.GetInstance(CustomerPage.class).irparaBotacaoCadastro();

	      DriverFactory.page.GetInstance(CustomerPage.class).avancarSessaoPagamento();
		
	      /**************************************************8AVANCAR PARA A PROXIMA SESSAO******************/
		
//	      DriverFactory.getDriver(TipoDriver.CHROME).switchTo().defaultContent();
	}


	@After(value = "@validarMensagensDeErroNoCadastro", order = 1)
	public void finalizaPDF(Scenario cenario) throws Exception {

		
		pdfgenerator.fechaPDF("Fechar PDF");
//		ArrayList<String> tabs = new ArrayList<String> (DriverFactory.getDriver(TipoDriver.CHROME).getWindowHandles());
//		DriverFactory.getDriver(TipoDriver.CHROME).switchTo().defaultContent();
		

	}
	
}
