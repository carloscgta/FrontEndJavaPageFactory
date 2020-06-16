package br.com.exame.steps;

import java.net.MalformedURLException;
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

public class CustomerCadastroSteps    {

	public CustomerCadastroSteps() {
		// TODO Auto-generated constructor stub
	}
	
	PDFGenerator pdfgenerator = new PDFGenerator();
	YamlHelper yaml = new YamlHelper();
	Faker faker = new Faker();
	GeradorEmail gerarEmail = new GeradorEmail();
	
	
	@Before(value = "@cadastrarClienteAssinante", order = 1)
	public void before(Scenario cenario) throws Exception {
		pdfgenerator.iniciaPDF(cenario);
//		DriverFactory.getDriver(TipoDriver.CHROME).get("https://pre.exame.com.br/");
	}
	
	@Given("^que um leitor nao assinante esteja no Paywall clica no botao Assine$")
	public void que_um_leitor_nao_assinante_esteja_no_Paywall_clica_no_botao_Assine() throws MalformedURLException, InterruptedException  {
		
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

	
	@Given("^na tela de Cadasatro preenche os campos do Customer para validar o email de Cadastro com os seguintes Dados$")
	public void na_tela_de_Cadasatro_preenche_os_campos_do_Customer_para_validar_o_email_de_Cadastro_com_os_seguintes_Dados(DataTable DadosCadastroCustomer) throws Throwable {
	  
		List<Map<String, String>> listCustomerDados = DadosCadastroCustomer.asMaps(String.class, String.class);
	
	    
	    pdfgenerator.conteudoPDF("na_tela_de_Cadasatro_preenche_os_campomms_do_Customer_com_os_seguintes_Dados:");
		//boolean resultTest = false;
		
		for(int i=0; i<listCustomerDados.size(); i++) {
			System.out.println(listCustomerDados.get(i));
			
			
			
			DriverFactory.page.GetInstance(CustomerPage.class).escreverNomeCustomer(listCustomerDados.get(i).get("Nome"));
			pdfgenerator.conteudoPDF("Preenchido campo com o conteudo:" + listCustomerDados.get(i).get("Nome"));
			
			String emailGerado = gerarEmail.geraEmail();
			DriverFactory.page.GetInstance(CustomerPage.class).escreverEmail(emailGerado);
			DriverFactory.page.GetInstance(CustomerPage.class).escreverConfirmarEmail(emailGerado);
			pdfgenerator.conteudoPDF("Preenchido campo  com o conteudo:" +emailGerado );
			
			DriverFactory.page.GetInstance(CustomerPage.class).escreverSenha(listCustomerDados.get(i).get("Senha"));
			pdfgenerator.conteudoPDF("Preenchido campo com o conteudo:" + listCustomerDados.get(i).get("Senha"));
			
			DriverFactory.page.GetInstance(CustomerPage.class).ConfirmarSenha(listCustomerDados.get(i).get("ConfirmarSenha"));
			pdfgenerator.conteudoPDF("Preenchido campo com o conteudo:" + listCustomerDados.get(i).get("ConfirmarSenha"));
			
			String cpf = null;
			cpf= DriverFactory.page.GetInstance(CustomerPage.class).escreverCPF();
			pdfgenerator.conteudoPDF("Preenchido campo com o conteudo:" + cpf);
			GeradorNumeroTelefone geradorPhone = new GeradorNumeroTelefone();
			String telefoneGerado = geradorPhone.geraTelefoneMovel();
			DriverFactory.page.GetInstance(CustomerPage.class).escreverPhone(telefoneGerado);
			
			pdfgenerator.conteudoPDF("Preenchido campo com o conteudo:"+telefoneGerado);
				
		      DriverFactory.page.GetInstance(CustomerPage.class).clicarRecaptcha();
		      
		      DriverFactory.page.GetInstance(CustomerPage.class).irparaBotacaoCadastro();

		      DriverFactory.page.GetInstance(CustomerPage.class).avancarSessaoPagamento();
		     
		}
		
		     
		//DriverFactory.page.GetInstance(CustomerPage.class).clicarBotaoOpcaoCartaoCredito();
		
		DriverFactory.page.GetInstance(CustomerPage.class).esperarUmPouco();
		
		DriverFactory.page.GetInstance(CustomerPage.class).escreverCardNumber("5508117491182547");
		
		DriverFactory.page.GetInstance(CustomerPage.class).escreverCardCVV("307");
		
		DriverFactory.page.GetInstance(CustomerPage.class).escreverCardNome("Joao Nunes Almeida Carlos");
		
		DriverFactory.page.GetInstance(CustomerPage.class).escreverDataValidadeCartao("09","2021");
		
		 DriverFactory.page.GetInstance(CustomerPage.class).irparaBotacaoProsseguir();
		 
		DriverFactory.page.GetInstance(CustomerPage.class).clicarBotaoProsseguir();
		
		
		DriverFactory.page.GetInstance(CustomerPage.class).clicarBotaoConcluir();
		
		pdfgenerator.conteudoPDF("Realizado clique no botao Finalizar Compra");

		Assert.assertTrue(DriverFactory.page.GetInstance(CustomerPage.class).validarCadastroCartaoDeCredito());

//		DriverFactory.getDriver(TipoDriver.CHROME).switchTo().defaultContent();
	} 

	
	@After(value = "@cadastrarClienteAssinante", order = 1)
	public void finalizaPDF(Scenario cenario) throws Exception {

//		ArrayList<String> tabs = new ArrayList<String> (DriverFactory.getDriver(TipoDriver.CHROME).getWindowHandles());
//		DriverFactory.getDriver(TipoDriver.CHROME).switchTo().window(tabs.get(0)).close();
//		DriverFactory.getDriver(TipoDriver.CHROME).switchTo().defaultContent().close();
		pdfgenerator.fechaPDF("Fechar PDF");
//			ArrayList<String> tabs = new ArrayList<String> (DriverFactory.getDriver(TipoDriver.CHROME).getWindowHandles());
	//	DriverFactory.getDriver(TipoDriver.CHROME).switchTo().defaultContent();
		
		

	}
	
	
	
	
}
