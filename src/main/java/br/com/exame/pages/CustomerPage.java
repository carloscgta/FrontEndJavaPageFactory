package br.com.exame.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CustomerPage extends BasePage {

	public CustomerPage(WebDriver driver) {
		super(driver);
	}

	/***********************CADASTRO*****************************************/
	
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
	
	
	@FindBy(xpath ="//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")
	public WebElement checkboxRecaptcha;
	
	@FindBy(xpath ="//span[@id='recaptcha-anchor']")
	public WebElement spanheckboxRecaptcha;
	
	
			
	@FindBy(xpath ="//*[@id=\"root\"]/div/main/div/div/div[2]/div/div/div[2]/div/button[2]")
	public WebElement buttonDebitoConta;
			
	@FindBy(xpath ="//*[@id=\"root\"]/div/main/div/div/div[2]/div/div/div[2]/div/button[3]")
	public WebElement buttonBoleto;
	
	@FindBy(xpath ="//*[@id=\"root\"]/div/main/div/div/div[2]/div/div/div[2]/div/button[1]")
	public WebElement buttonCartaoCredito;
//	
	
	
/*********************** PAGAMENTO - CRÉDITO *************************************/
	@FindBy(xpath ="//input[@id='cardNumber']")
	public WebElement inputCardNumber;

	@FindBy(xpath ="(//input[@id='cardName'])[1]")
	public WebElement inputCardName;
	
	@FindBy(xpath ="//select[@id='cardExpirationMonth']")
	public WebElement selectMes;
	
	@FindBy(xpath ="//select[@id='cardExpirationYear']")
	public WebElement selectAno;
	
	@FindBy(xpath ="//input[@id='cardCvv']")
	public WebElement inputCardCVV;
	
	@FindBy(xpath ="(//button[@type='submit'])[1]")
	public WebElement buttonProsseguir;
	/*********************** PAGAMENTO - DÉBITO EM CONTA *************************************/
	
	@FindBy(xpath ="//label[@for='bank-bradesco']//img")
	public WebElement inputBancoBradesco;
	
	@FindBy(xpath ="(//input[@id='cardName'])[2]")
	public WebElement inputNomeTitularConta;
	
	@FindBy(xpath ="//input[@id='agency']")
	public WebElement inputAgencia;
	
	@FindBy(xpath ="//input[@id='accountNumber']")
	public WebElement inputContaCorrente;
	
	
	@FindBy(xpath ="(//button[@type='submit'])[2]")
	public WebElement buttonDebitoContaProsseguir;
	
	/*********************** PAGAMENTO - BOLETO *************************************/
	@FindBy(xpath ="//input[@id='zipcode']")
	public WebElement inputCEP;
	
	@FindBy(xpath ="//input[@id='addressDelivery']")
	public WebElement inputEndereco;
	
	@FindBy(xpath ="//input[@id='addressNumber']")
	public WebElement inputNumero;
	
	@FindBy(xpath ="//input[@id='addressNeighborhood']")
	public WebElement inputBairro;
	
	@FindBy(xpath ="//input[@id='addressComplement']")
	public WebElement inputComplemento;
	
	@FindBy(xpath ="//input[@id='addressCity']")
	public WebElement inputCidade;
	
	@FindBy(xpath= "//select[@id='addressState']")
	public WebElement selectEstado;
	
	@FindBy(xpath ="((//button[@type='submit']))[3]")
	public WebElement buttonBoletoProsseguir;
	
	
	/*********************** PAGAMENTO *************************************/

	@FindBy(xpath ="//button[@class='sc-fznyAO cmHUyL']")
	public WebElement buttonConcluir;
	
	@FindBy(xpath ="//*[@id='root']")
	public WebElement divPaginaConfirmacao;
	
	
	@FindBy(xpath ="//a[@href='/login']")
	public WebElement buttonLoginPaginaConfirmacao;
	
	
	@FindBy(xpath ="//a[@href='https://exame.com/']")
	public WebElement buttonPortalExame;
	
	
	/*********************** MÉTODOS - FLUXO ASSINATURA BOLETO *************************************/
	public void escreverCEP(String texto) throws InterruptedException {
		
		writeText(inputCEP, texto);
	}
	
	public void escreverinputEndereco(String texto) throws InterruptedException {
		
		writeText(inputEndereco, texto);
	}
	
	public void escreverinputNumero(String texto) throws InterruptedException {
		
		writeText(inputNumero, texto);
	}
	
	public void escreverinputComplemento(String texto) throws InterruptedException {
		
		writeText(inputComplemento, texto);
	}
	
	public void escreverinputBairro(String texto) throws InterruptedException {
		
		writeText(inputBairro, texto);
	}
	
	public void escreverinputCidade(String texto) throws InterruptedException {
		
		writeText(inputCidade, texto);
	}
	
	
	public void selecionarEstadoBoleto(String texto) throws InterruptedException {

		selectGeneric(selectEstado, texto);

	}
	
public void irparaBotaoProsseguirBoletoProsseguir() throws InterruptedException {
		
		moverParaElemento(buttonBoletoProsseguir);
	}

public void clicarBotaoBoletoProsseguir() throws InterruptedException {
	
	click(buttonBoletoProsseguir);
}

	
	
/*********************** MÉTODOS - FLUXO ASSINATURA BOLETO *************************************/
	public void selecionarEstado(int index) throws InterruptedException {

		selectElement(selectEstado, index);

	}
	
	public void clicarBancoBradesco() throws InterruptedException {

		click(inputBancoBradesco);

	}
	
	public void irparaBotaoBradesco() throws InterruptedException {
		
		moverParaElemento(inputBancoBradesco);
	}

public void irparaBotaoOpcaoDebitoConta() throws InterruptedException {
		
	moverParaElemento(buttonDebitoConta);
	}
	
public void irparaBotaoBoleto() throws InterruptedException {
	
	moverParaElemento(buttonBoleto);
	}
	

public void esperarBotao() throws InterruptedException {
	
	waitForElement(buttonDebitoConta);
}

public void esperarBotaoBoleto() throws InterruptedException {
	
	waitForElement(buttonBoleto);
}


public void moverParaOpcaoDebitoConta() throws InterruptedException {
	
	moverParaElemento(buttonDebitoConta);
}
	
	public void escreverNomeTitularConta(String texto) throws InterruptedException {

		writeText(inputNomeTitularConta, texto);

	}
	
	public void escreverAgencia(String texto) throws InterruptedException {

		writeText(inputAgencia, texto);

	}
	
	public void escreverContaCorrente(String texto) throws InterruptedException {

		writeText(inputContaCorrente, texto);

	}
	
	public void clicarButtonDebitoContaProsseguir() throws InterruptedException {

		click(buttonDebitoContaProsseguir);

	}
	
	public void irparaBotacaoProsseguirbuttonDebitoContaProsseguir() throws InterruptedException {
		
		scrollToElement(buttonDebitoContaProsseguir);
	}
	

	public void clicarBotaoDebitoConta() throws InterruptedException {

		click(buttonDebitoConta);

	}
	
	public void clicarBotaoBoleto() throws InterruptedException {

		click(buttonBoleto);

	}
	
	public void esperarUmPouco() throws InterruptedException {

		waitForElement(inputCardNumber);

	}
	
	public void clicarRecaptcha() throws InterruptedException {

		MarcarCheckBoxRecaptcha();
	}

	public void irparaBotacaoCadastro() throws InterruptedException {
		
		scrollToElement(buttonCadastro);
	}
	
	public void irparaBotacaoProsseguir() throws InterruptedException {
		
		scrollToElement(buttonBoletoProsseguir);
	}


	
	public void escreverNomeCustomer(String texto) throws InterruptedException {
		limparInput(inputNome);
		writeText(inputNome, texto);

	}
	
	public void limparInput(WebElement element) throws InterruptedException {

		clearText(element);

	}
	
	public void escreverEmail(String texto) throws InterruptedException {
		
		limparInput(inputEmail);
		writeText(inputEmail, texto);

	}
	
	
	public void escreverConfirmarEmail(String texto) throws InterruptedException {
		
		limparInput(inputConfrimarEmail);
		writeText(inputConfrimarEmail, texto);

	}
	
	public void escreverSenha(String texto) throws InterruptedException {
		limparInput(inputSenha);
		writeText(inputSenha, texto);

	}

	
	public void ConfirmarSenha(String texto) throws InterruptedException {
		
		limparInput(inputConfirmarSenha);
		writeText(inputConfirmarSenha, texto);

	}
	
	public String escreverCPF() throws Exception {
		limparInput(inputCPF);
		String cpfGerado = geraCPF();
		writeText(inputCPF, cpfGerado);
		
		return cpfGerado;

	}
	
public void escreverCPFTexto(String cpfTexto) throws Exception {
		
		limparInput(inputCPF);
		writeText(inputCPF, cpfTexto);
		
	}
	
	public void escreverPhone(String texto) throws InterruptedException {
		
		limparInput(inputPhone);
		writeText(inputPhone, texto);

	}
	
	public void escreverCardNumber(String texto) throws InterruptedException {
		limparInput(inputCardNumber);
		writeText(inputCardNumber, texto);

	}
	
	public void escreverCardNome(String texto) throws InterruptedException {
		limparInput(inputCardName);
		
		writeText(inputCardName, texto);

	}
	
	public void escreverDataValidadeCartao(String indexMes, String indexAno) throws InterruptedException {
		
		click(selectMes);
		selectMes(selectMes, indexMes);
		click(selectAno);
		selectAno(selectAno, indexAno);
		
	}
	
	public void escreverCardCVV(String texto) throws InterruptedException {
		limparInput(inputCardCVV);
		
		writeText(inputCardCVV, texto);
		
	}
	
	
	public void clicarBotaoProsseguir() throws InterruptedException {
			
		click(buttonProsseguir);
		
	}
	
	
	
	public void clicarBotaoOpcaoCartaoCredito() throws InterruptedException {
		moverParaElemento(buttonCartaoCredito);
		click(buttonCartaoCredito);
		
	}
	public void clicarBotaoConcluir() throws InterruptedException {
		
		
		click(buttonConcluir);
		
	}
	
	
	public void clicarBotaoCadastro() throws InterruptedException {
		
		click(buttonCadastro);
		
	}
	
public  boolean validarCadastroBoleto() throws InterruptedException {
		
		boolean result = false;
		
		moverParaElemento(buttonPortalExame);
		
				if(elementIsDisplayed(buttonPortalExame)) {
			result = true;
		}
			
		return result;
		
		
	}
	

	public  boolean validarCadastroCartaoDeCredito() throws InterruptedException {
		
		boolean result = false;
		
		scrollToElement(buttonLoginPaginaConfirmacao);
		
				if(elementIsDisplayed(buttonLoginPaginaConfirmacao)) {
			result = true;
		}
			
		return result;
		
		
	}
	
public  boolean validarCadastroDebitoConta() throws InterruptedException {
		
		boolean result = false;
		
		scrollToElement(buttonPortalExame);
		
				if(elementIsDisplayed(buttonPortalExame)) {
			result = true;
		}
			
		return result;
		
		
	}

	
	
	public  boolean validarMensagemErroExibida(String msgErrorTexto) throws InterruptedException {
		
		boolean result = false;
		String textoDivDigital = divPaginaConfirmacao.getText();
		System.out.println(textoDivDigital);
		if(textoDivDigital.contains(msgErrorTexto)){
			
			result = true;
		}else {
			
			result = false;
		}
					
		return result;
		
		
	}


	
}
