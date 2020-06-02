package br.com.exame.pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "email")
	public WebElement caixaDeTextoDigiteSeuEmail;

	@FindBy(id = "currentPassword")
	public WebElement caixaDeTextoSenha;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement botaoEntrar;

	@FindBy(xpath = "//div[@class='sc-AxjAm ABkPO e-alert']")
	public WebElement labelEmailSenhaInvalidos;
	
	@FindBy(xpath = "//img[@id='main-header-logo']")
	public WebElement logoExame;

	public void preencherCaixaDeTextoDigiteSeuEmail(String texto) throws InterruptedException {

		writeText(caixaDeTextoDigiteSeuEmail, texto);
	}

	public void preencherCaixaDeTextoDigiteSenha(String texto) throws InterruptedException {
		writeText(caixaDeTextoSenha, texto);

	}

	public void clicarBotaoEntrar() throws InterruptedException {
		click(botaoEntrar);
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}

	public void validarResultado(String resultado) {

		String resultadosTela = labelEmailSenhaInvalidos.getText();
		Assert.assertTrue(resultado.contains(resultadosTela));
		
		

	}

}
