package br.com.exame.steps;

import br.com.exame.core.DriverFactory;
import br.com.exame.core.PDFGenerator;
import br.com.exame.core.TipoDriver;
import br.com.exame.core.YamlHelper;
import br.com.exame.pages.LoginPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginInvalidoSteps {
	
	public LoginInvalidoSteps() {
		
	}
	
	PDFGenerator pdfgenerator = new PDFGenerator();
	YamlHelper yaml = new YamlHelper();
	
	@Before(value = "@validarRealizacaoLoginInvalido", order = 1)
	public void before(Scenario cenario) throws Exception {
		pdfgenerator.iniciaPDF(cenario);
	}
	
	@Given("^que usuario esteja na Login Page da Exame com usuario e senha invalidos$")
	public void que_usuario_esteja_na_Login_Page_da_Exame_com_usuario_e_senha_invalidos() throws Throwable {
		DriverFactory.getDriver(TipoDriver.CHROME).navigate().to(YamlHelper.getAtributo("env","uat").toString() +"login");
	}

	@When("^preencho os respectivos campos \"([^\"]*)\" e \"([^\"]*)\"$")
	public void preencho_os_respectivos_campos_e(String campoUsuario, String campoSenha) throws Throwable {
		pdfgenerator.conteudoPDF("preencho os respectivos campos usuario e senha: ");
		DriverFactory.page.GetInstance(LoginPage.class).preencherCaixaDeTextoDigiteSeuEmail(campoUsuario);
		DriverFactory.page.GetInstance(LoginPage.class).preencherCaixaDeTextoDigiteSenha(campoSenha);
		DriverFactory.page.GetInstance(LoginPage.class).clicarBotaoEntrar();
	  
	}
	
	@Then("^o login nao e realizado pois o \"([^\"]*)\"$")
	public void o_login_nao_e_realizado_pois_o(String resultado) throws Throwable {
		pdfgenerator.conteudoPDF("o login esta sendo validado: ");
		DriverFactory.page.GetInstance(LoginPage.class).validarResultado(resultado);
		pdfgenerator.conteudoPDF("o login esta sendo invalido Email e/ou senha inválido(s): ");
	}
	
	@After(value = "@validarRealizacaoLoginInvalido", order = 1)
	public void finalizaPDF(Scenario cenario) throws Exception {
		pdfgenerator.fechaPDF("Fechar PDF");
		DriverFactory.closeDriver();

	}

}
