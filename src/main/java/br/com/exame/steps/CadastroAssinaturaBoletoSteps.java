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

public class CadastroAssinaturaBoletoSteps    {

	public CadastroAssinaturaBoletoSteps() {
		// TODO Auto-generated constructor stub
	}

	
	PDFGenerator pdfgenerator = new PDFGenerator();
	YamlHelper yaml = new YamlHelper();
	Faker faker = new Faker();
	GeradorEmail gerarEmail = new GeradorEmail();
	
	
	@Before(value = "@cadastrarAssinaturaBoleto", order = 1)
	public void before(Scenario cenario) throws Exception {
		pdfgenerator.iniciaPDF(cenario);
		
	}
	
	
	@Given("^escolher um plano de assinatura$")
	public void escolher_um_plano_de_assinatura() throws Throwable {
	    
try {
			
		DriverFactory.page.GetInstance(PayWallOpcoesAssinaturaPage.class).clicarBotaoAssineDigital();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Given("^usando os dados abaixo insere as informacoes no form de cadastro ao chegar na sessao da pagamento escolhe$")
	public void usando_os_dados_abaixo_insere_as_informacoes_no_form_de_cadastro_ao_chegar_na_sessao_da_pagamento_escolhe(DataTable DadosCadastroCustomer) throws Throwable {

		List<Map<String, String>> listCustomerDados = DadosCadastroCustomer.asMaps(String.class, String.class);
		
		  pdfgenerator.conteudoPDF("na_tela_de_Cadasatro_preenche_os_campomms_do_Customer_com_os_seguintes_Dados:");
		  
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
		
	  DriverFactory.page.GetInstance(CustomerPage.class).esperarBotaoBoleto();
		  
		  DriverFactory.page.GetInstance(CustomerPage.class).irparaBotaoBoleto();
		  
		  DriverFactory.page.GetInstance(CustomerPage.class).clicarBotaoBoleto();
		  
		  DriverFactory.page.GetInstance(CustomerPage.class).escreverCEP("01246000");
		  DriverFactory.page.GetInstance(CustomerPage.class).escreverinputEndereco("Av. Dr. Arnaldo 2234");
		  
		  DriverFactory.page.GetInstance(CustomerPage.class).escreverinputNumero("657");
		  
		  DriverFactory.page.GetInstance(CustomerPage.class).escreverinputComplemento("1 Andar");
		  
		  DriverFactory.page.GetInstance(CustomerPage.class).escreverinputBairro("Pacaembu");
		  
		  DriverFactory.page.GetInstance(CustomerPage.class).escreverinputCidade("São Paulo");
		  DriverFactory.page.GetInstance(CustomerPage.class).selecionarEstadoBoleto("SP");
		  
		  
		  DriverFactory.page.GetInstance(CustomerPage.class).irparaBotaoProsseguirBoletoProsseguir();
		
		  DriverFactory.page.GetInstance(CustomerPage.class).clicarBotaoBoletoProsseguir();
		  
		  DriverFactory.page.GetInstance(CustomerPage.class).clicarBotaoConcluir();
		  
		  
		  Assert.assertTrue(DriverFactory.page.GetInstance(CustomerPage.class).validarCadastroBoleto());
		  
//		  DriverFactory.getDriver(TipoDriver.CHROME).switchTo().defaultContent();
		  
		  
	}
	
	
	
	
	@After(value = "@cadastrarAssinaturaBoleto", order = 1)
	public void finalizaPDF(Scenario cenario) throws Exception {

		
		pdfgenerator.fechaPDF("Fechar PDF");
//		ArrayList<String> tabs = new ArrayList<String> (DriverFactory.getDriver(TipoDriver.CHROME).getWindowHandles());
//		DriverFactory.getDriver(TipoDriver.CHROME).switchTo().defaultContent();
		
		
		
		

	}
	
}
