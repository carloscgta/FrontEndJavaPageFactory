package br.com.exame.steps;

import br.com.exame.core.DriverFactory;
import br.com.exame.core.PDFGenerator;
import br.com.exame.core.TipoDriver;
import br.com.exame.core.YamlHelper;
import br.com.exame.pages.AssinaturaPage;
import br.com.exame.pages.LoginPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	
	PDFGenerator pdfgenerator = new PDFGenerator();
	YamlHelper yaml = new YamlHelper();
	
	
	public LoginSteps() {
		
		
	}
	
	@Before(value = "@validarRealizacaoLogin", order = 1)
	public void before(Scenario cenario) throws Exception {
		pdfgenerator.iniciaPDF(cenario);
	}
	
	@Given("^que usuario esteja na Home Page da Exame$")
	public void que_usuario_esteja_na_Home_Page_da_Exame() throws Throwable {
		DriverFactory.getDriver(TipoDriver.CHROME).navigate().to(YamlHelper.getAtributo("env","uat").toString() +"login");
	}

	@When("^preencho os respectivos campos \"([^\"]*)\"$")
	public void preencho_os_respectivos_campos(String campoUsuario) throws Throwable {
		pdfgenerator.conteudoPDF("preencho os respectivos campos: ");
		DriverFactory.page.GetInstance(LoginPage.class).preencherCaixaDeTextoDigiteSeuEmail(campoUsuario);
		DriverFactory.page.GetInstance(LoginPage.class).preencherCaixaDeTextoDigiteSenha("Yeshu@18");
		DriverFactory.page.GetInstance(LoginPage.class).clicarBotaoEntrar();
		
		
	}

	@Then("^o login e realizado com sucesso$")
	public void o_login_e_realizado_com_sucesso() throws Throwable {
		pdfgenerator.conteudoPDF("o login está sendo realizado: ");
		DriverFactory.page.GetInstance(AssinaturaPage.class).validarResultado();
		pdfgenerator.conteudoPDF("o login e realizado com sucesso: ");
		
	}
	
	@After(value = "@validarRealizacaoLogin", order = 1)
	public void finalizaPDF(Scenario cenario) throws Exception {
		pdfgenerator.fechaPDF("Fechar PDF");

	}

}
