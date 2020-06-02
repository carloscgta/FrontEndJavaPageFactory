package br.com.exame.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.exame.core.DriverFactory;

public class CustomerPage extends BasePage {

	public CustomerPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath = "//input[@id='name']")
	public WebElement inputNome;

	@FindBy(xpath = "//input[@id='email']")
	public WebElement inputEmail;

	@FindBy(xpath = "//input[@id='confirm-email']")
	public WebElement inputConfrimarEmail;

	
	@FindBy(xpath = "//input[@id='password']")
	public WebElement inputSenha;
	
	@FindBy(xpath = "//input[@id='confirm-password']")
	public WebElement inputConfirmarSenha;
	
	
	@FindBy(xpath ="//input[@id='document']")
	public WebElement inputCPF;

	@FindBy(xpath ="//input[@id='phone']")
	public WebElement inputPhone;
	
	@FindBy(xpath ="//button[@type='submit']")
	public WebElement buttonCadastro;
	
	
/**************************************************************************/
	@FindBy(xpath ="//input[@id='card-number']")
	public WebElement inputCardNumber;

	@FindBy(xpath ="//input[@id='card-name']")
	public WebElement inputCardName;
	
	@FindBy(xpath ="//input[@id='card-exp']")
	public WebElement inputDataValidade;
	
	@FindBy(xpath ="//input[@id='card-cvv']")
	public WebElement inputCardCVV;
	
	@FindBy(xpath ="(//button[@type='submit'])[1]")
	public WebElement buttonProsseguir;

	@FindBy(xpath ="//button[@type='submit']")
	public WebElement buttonFinalizarCompra;
	
	//Elementos do Formulário de Endereço
	@FindBy(xpath ="//input[@id='zipcode']")
	public WebElement inputCep;
	
	@FindBy(xpath = "//div[@id='root']")
	public WebElement divPaginaCadastroCustomer;
	
	@FindBy(xpath ="//button[@type='submit']")
	public WebElement buttonSalvarAlteracoes;
	

	public void escreverNomeCustomer(String texto) throws InterruptedException {

		writeText(inputNome, texto);

	}
	
	public void escreverEmail(String texto) throws InterruptedException {
		
		
		writeText(inputEmail, texto);

	}

	public void escreverSenha(String texto) throws InterruptedException {
		

		
		
		writeText(inputSenha, texto);

	}

	
	public void ConfirmarSenha(String texto) throws InterruptedException {
		

		
		writeText(inputConfirmarSenha, texto);

	}
	
	public String escreverCPF() throws Exception {
		

		
		String cpfGerado = geraCPF();
		writeText(inputCPF, cpfGerado);
		
		return cpfGerado;

	}
	
public void escreverCPFTexto(String cpfTexto) throws Exception {
		
		
		writeText(inputCPF, cpfTexto);
		
		

	}
	
	public void escreverPhone(String texto) throws InterruptedException {
		
		
		writeText(inputPhone, texto);

	}
	
	public void escreverCardNumber(String texto) throws InterruptedException {
		
		writeText(inputCardNumber, texto);

	}
	
	public void escreverCardNome(String texto) throws InterruptedException {
		
		
		writeText(inputCardName, texto);

	}
	
	public void escreverDataValidadeCartao(String texto) throws InterruptedException {
	
		
		writeText(inputDataValidade, texto);
		
	}
	
	public void escreverCardCVV(String texto) throws InterruptedException {
		
		
		writeText(inputCardCVV, texto);
		
	}
	
	
	public void clicarBotaoProsseguir() throws InterruptedException {
			
		click(buttonProsseguir);
		
	}
	
	public void clicarBotaoFinalizarCompra() throws InterruptedException {
		
		
		click(buttonFinalizarCompra);
		
	}
	
	
	
	public  boolean validarCadastro() throws InterruptedException {
		
		boolean result = false;
		
		scrollToElement(buttonSalvarAlteracoes);
		
				if(elementIsDisplayed(buttonSalvarAlteracoes)) {
			result = true;
		}
			
		return result;
		
		
	}
	
	public  boolean validarMensagemErroExibida(String msgErrorTexto) throws InterruptedException {
		
		boolean result = false;
		String texto = divPaginaCadastroCustomer.getText().toString();
		System.out.println(texto);
		if(texto.contains(msgErrorTexto)){
			
			result = true;
		}else {
			
			result = false;
		}
					
		return result;
		
		
	}


	
}
