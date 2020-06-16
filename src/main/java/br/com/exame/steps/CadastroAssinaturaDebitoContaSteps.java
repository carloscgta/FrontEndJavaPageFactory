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

public class CadastroAssinaturaDebitoContaSteps  {

	public CadastroAssinaturaDebitoContaSteps() {
		// TODO Auto-generated constructor stub
	}
	

	PDFGenerator pdfgenerator = new PDFGenerator();
	YamlHelper yaml = new YamlHelper();
	Faker faker = new Faker();
	GeradorEmail gerarEmail = new GeradorEmail();
	
	
	@Before(value = "@cadastrarClienteAssinanteDebitoConta", order = 1)
	public void before(Scenario cenario) throws Exception {
		pdfgenerator.iniciaPDF(cenario);

		
		
	}
	
	
	@Given("^usuario escolhe plano Digital$")
	public void usuario_escolhe_plano_Digital() throws Throwable {
		
		try {
			DriverFactory.page.GetInstance(PayWallOpcoesAssinaturaPage.class).clicarBotaoAssineDigital();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   
	}
	

	@Given("^na tela de Assinatura insere os dados pessoas para avancar para a sessao de Pagamento e escolhe Debito em Conta como meio de Pagamento$")
	public void na_tela_de_Assinatura_insere_os_dados_pessoas_para_avancar_para_a_sessao_de_Pagamento_e_escolhe_Debito_em_Conta_como_meio_de_Pagamento(DataTable DadosCadastroCustomer) throws Throwable {
	   
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
		  
		  
		  DriverFactory.page.GetInstance(CustomerPage.class).esperarBotao();
		  
		  DriverFactory.page.GetInstance(CustomerPage.class).irparaBotaoOpcaoDebitoConta();
		  
		  DriverFactory.page.GetInstance(CustomerPage.class).clicarBotaoDebitoConta();
		  
		 DriverFactory.page.GetInstance(CustomerPage.class).irparaBotaoBradesco();
		 
		  DriverFactory.page.GetInstance(CustomerPage.class).clicarBancoBradesco();
		  
		  DriverFactory.page.GetInstance(CustomerPage.class).escreverNomeTitularConta("Jurinildo Santos Marosildo");
		  
		  DriverFactory.page.GetInstance(CustomerPage.class).escreverAgencia("8150");
		  
		  DriverFactory.page.GetInstance(CustomerPage.class).escreverContaCorrente("271461");
		  
		  DriverFactory.page.GetInstance(CustomerPage.class).irparaBotacaoProsseguirbuttonDebitoContaProsseguir();
		  
		  DriverFactory.page.GetInstance(CustomerPage.class).clicarButtonDebitoContaProsseguir();
		  	
		  DriverFactory.page.GetInstance(CustomerPage.class).clicarBotaoConcluir();
		  
		  Assert.assertTrue(DriverFactory.page.GetInstance(CustomerPage.class).validarCadastroDebitoConta());
			
//			DriverFactory.getDriver(TipoDriver.CHROME).switchTo().defaultContent();
			
	}
	
	
	@After(value = "@cadastrarClienteAssinanteDebitoConta", order = 1)
	public void finalizaPDF(Scenario cenario) throws Exception {

//		ArrayList<String> tabs = new ArrayList<String> (DriverFactory.getDriver(TipoDriver.CHROME).getWindowHandles());
//		DriverFactory.getDriver(TipoDriver.CHROME).switchTo().window(tabs.get(0)).close();
//		DriverFactory.getDriver(TipoDriver.CHROME).switchTo().defaultContent().close();
		pdfgenerator.fechaPDF("Fechar PDF");
//		ArrayList<String> tabs = new ArrayList<String> (DriverFactory.getDriver(TipoDriver.CHROME).getWindowHandles());
//		DriverFactory.getDriver(TipoDriver.CHROME).switchTo().defaultContent();
		
	}
	
	

}
