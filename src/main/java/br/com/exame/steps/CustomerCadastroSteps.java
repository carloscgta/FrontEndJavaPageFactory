package br.com.exame.steps;

import java.net.MalformedURLException;
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

public class CustomerCadastroSteps {

	public CustomerCadastroSteps() {
		// TODO Auto-generated constructor stub
	}
	
	PDFGenerator pdfgenerator = new PDFGenerator();
	YamlHelper yaml = new YamlHelper();
	Faker faker = new Faker();
	

	@Before(value = "@cadastrarClienteAssinante", order = 1)
	public void before(Scenario cenario) throws Exception {
		pdfgenerator.iniciaPDF(cenario);
	}
	
	@Given("^que um leitor nao assinante esteja no Paywall clica no botao Assine$")
	public void que_um_leitor_nao_assinante_esteja_no_Paywall_clica_no_botao_Assine() throws MalformedURLException  {
		
		try {
			DriverFactory.getDriver(TipoDriver.CHROME).navigate().to("https://pre.exame.com.br/");
			
			DriverFactory.page.GetInstance(HomeExamePage.class).clicarBotaoAssine();
			//  ArrayList<String> tabs = new ArrayList<String> ( DriverFactory.getDriver(TipoDriver.CHROME).getWindowHandles());
			
			ArrayList<String> tabs2 = new ArrayList<String> (DriverFactory.getDriver(TipoDriver.CHROME).getWindowHandles());
			DriverFactory.getDriver(TipoDriver.CHROME).switchTo().window(tabs2.get(1));
			//DriverFactory.getDriver(TipoDriver.CHROME).close();
			//DriverFactory.getDriver(TipoDriver.CHROME).switchTo().window(tabs2.get(0));
			 
			
			DriverFactory.page.GetInstance(PayWallOpcoesAssinaturaPage.class).clicarBotaoAssineDigital();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			
			String emailGerado = faker.internet().emailAddress();
			DriverFactory.page.GetInstance(CustomerPage.class).escreverEmail(emailGerado);
			pdfgenerator.conteudoPDF("Preenchido campo  com o conteudo:" +emailGerado );
			
			
			DriverFactory.page.GetInstance(CustomerPage.class).escreverSenha(listCustomerDados.get(i).get("Senha"));
			pdfgenerator.conteudoPDF("Preenchido campo com o conteudo:" + listCustomerDados.get(i).get("Senha"));
			
			DriverFactory.page.GetInstance(CustomerPage.class).ConfirmarSenha(listCustomerDados.get(i).get("ConfirmarSenha"));
			pdfgenerator.conteudoPDF("Preenchido campo com o conteudo:" + listCustomerDados.get(i).get("ConfirmarSenha"));
			
			String cpf = null;
			cpf= DriverFactory.page.GetInstance(CustomerPage.class).escreverCPF();
			pdfgenerator.conteudoPDF("Preenchido campo com o conteudo:" + cpf);
			
			DriverFactory.page.GetInstance(CustomerPage.class).escreverPhone("11930035118");
			
			pdfgenerator.conteudoPDF("Preenchido campo com o conteudo:" + listCustomerDados.get(i).get("Telefone"));
				
		}
		
		DriverFactory.page.GetInstance(CustomerPage.class).escreverCardNumber("4539974265652295");
		
		DriverFactory.page.GetInstance(CustomerPage.class).escreverCardCVV("405");
		
		DriverFactory.page.GetInstance(CustomerPage.class).escreverCardNome("Joao Nunes Almeida Carlos");
		
		DriverFactory.page.GetInstance(CustomerPage.class).escreverDataValidadeCartao("08/21");
		
		DriverFactory.page.GetInstance(CustomerPage.class).clicarBotaoFinalizarCompra();
		
		pdfgenerator.conteudoPDF("Realizado clique no botao Finalizar Compra");
		
		Assert.assertTrue(DriverFactory.page.GetInstance(CustomerPage.class).validarCadastro());

	
	}

	
	@After(value = "@cadastrarClienteAssinante", order = 1)
	public void finalizaPDF(Scenario cenario) throws Exception {

		
		pdfgenerator.fechaPDF("Fechar PDF");
		DriverFactory.closeDriver();

	}
	
	
	
	
}
