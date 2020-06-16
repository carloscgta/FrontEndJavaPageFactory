package br.com.exame.pages;

import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends PageGenerator {

	public BasePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	
	Properties prop = new Properties();

	// If we need we can use custom wait in BasePage and all page classes

	WebDriverWait wait = new WebDriverWait(this.driver, 40);
 
	// Click Method by using JAVA Generics (You can use both By or Webelement)

	
	public <T> void avancarSessaoPagamento() throws InterruptedException {
		
	new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit'])[1]"))).click();
	   
	        
	}

	public <T> void clicarBotaoProsseguir() throws InterruptedException {
		
	new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit'])[1]"))).click();
	   
	        
	}
	
	
	public <T> void click(T elementAttr) throws InterruptedException {

		waitForElement(elementAttr);
		((WebElement) elementAttr).click();

	}
	

	// Wait generic method

	public <T> void waitForElement(T elementAttr) throws InterruptedException {
		moverParaElemento(elementAttr);
		wait.until(ExpectedConditions. visibilityOf((WebElement) elementAttr));
		
		((WebElement) elementAttr).isDisplayed();
	}

	public <T> Boolean elementIsDisplayed(T elementAttr) throws InterruptedException {
		scrollToElement(elementAttr);
		Boolean  isDisplayed=false;
		if(((WebElement) elementAttr).isDisplayed()) {
			 isDisplayed=true;
		}
		
		return isDisplayed;
	}

	
	// Write Text by using JAVA Generics (You can use both By or Webelement)

	public <T> void writeText(T elementAttr, String text) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttr));

		((WebElement) elementAttr).sendKeys(text);

	}

	// Write Text by using JAVA Generics (You can use both By or Webelement)

	public <T> void clearText(T elementAttr) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttr));

		((WebElement) elementAttr).clear();

		((WebElement) elementAttr).sendKeys("");

	}

	
	// Read Text by using JAVA Generics (You can use both By or Webelement)

	public <T> String readText(T elementAttr) {

		wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttr));

		return ((WebElement) elementAttr).getText();
	

	}

	// Check if the element is visible (You can use both By or Webelement)

	public <T> boolean elementVisible(T elementAttr) {

		wait.until(ExpectedConditions.elementToBeClickable((WebElement) elementAttr));

		boolean b = false;

		try {

			if (((WebElement) elementAttr).isDisplayed()) {

				b = true;

			}

		} catch (Exception e) {

			return false;

		}

		return b;

	}

	public <T> void scrollToElement(T elementAttr) throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ((WebElement) elementAttr));

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		jse.executeScript("window.scrollBy(0,200)", "");
	}
	
	
	

	public <T> void moverParaElemento(T elementAttr) throws InterruptedException {


		Actions builder = new Actions(driver);
		builder.moveToElement((WebElement) elementAttr).perform();
		
	}

	public <T> void dismissAlertPopup() throws InterruptedException {

		wait.until(ExpectedConditions.alertIsPresent());

		driver.switchTo().alert().dismiss();

	}

	
	public <T> void MarcarCheckBoxRecaptcha() throws InterruptedException {
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]"))).click();
	   
	        
	}
	

	/*
	 * 
	 * 
	 * @Author: Carlos Almeida
	 * 
	 * 
	 *@FindBy(xpath ="")
	public WebElement selectMes;
	
	@FindBy(xpath ="//select[@id=\"cardExpirationYear\"]")
	public WebElement selectAno; 
	 */
	

	// Read Text by using JAVA Generics (You can use both By or Webelement)

	public <T> void selectElement(T elementAttr, int index) {

		
		List<WebElement> elements = (List<WebElement>) elementAttr;

		elements.get(index).click();

	}
	
	public <T> void selectMes(T elementAttr, String index) throws InterruptedException {
		
		irParaElementoMes();
		Select selectMes = new Select(driver.findElement(By.xpath("//select[@id='cardExpirationMonth']")));
		selectMes.selectByVisibleText("09");
		
	
	}
	
	public <T> void selectGeneric(T elementAttr, String index) throws InterruptedException {
		
		moverParaElemento(elementAttr);
		Select selectMes = new Select((WebElement) elementAttr);
		selectMes.selectByVisibleText(index);
		
	
	}
	
	
	public <T> void selectAno(T elementAttr, String index) throws InterruptedException {

		irParaElementoAno();
		Select selectAno = new Select(driver.findElement(By.xpath("//select[@id='cardExpirationYear']")));
		selectAno.selectByVisibleText("2021");
	
	}

	
	public <T> void irParaElementoMes() throws InterruptedException {

		WebElement element = driver.findElement(By.xpath("//select[@id='cardExpirationMonth']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	
	}
	
	public <T> void irParaElementoAno() throws InterruptedException {

		WebElement element = driver.findElement(By.xpath("//select[@id='cardExpirationYear']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	
	}
	
	public <T> void fazerUploadDeArquivo(T elementAttr, String PahtToFIle) throws InterruptedException {

		((WebElement) elementAttr).sendKeys(PahtToFIle);

	}
	
	public <T> String geraCPF() throws Exception {

		int digito1 = 0, digito2 = 0, resto = 0;
		String nDigResult;
		String numerosContatenados;
		String numeroGerado;

		Random numeroAleatorio = new Random();

		// numeros gerados
		int n1 = numeroAleatorio.nextInt(10);
		int n2 = numeroAleatorio.nextInt(10);
		int n3 = numeroAleatorio.nextInt(10);
		int n4 = numeroAleatorio.nextInt(10);
		int n5 = numeroAleatorio.nextInt(10);
		int n6 = numeroAleatorio.nextInt(10);
		int n7 = numeroAleatorio.nextInt(10);
		int n8 = numeroAleatorio.nextInt(10);
		int n9 = numeroAleatorio.nextInt(10);

		int soma = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;

		int valor = (soma / 11) * 11;

		digito1 = soma - valor;

		// Primeiro resto da divisão por 11.
		resto = (digito1 % 11);

		if (digito1 < 2) {
			digito1 = 0;
		} else {
			digito1 = 11 - resto;
		}

		int soma2 = digito1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;

		int valor2 = (soma2 / 11) * 11;

		digito2 = soma2 - valor2;

		// Primeiro resto da divisão por 11.
		resto = (digito2 % 11);

		if (digito2 < 2) {
			digito2 = 0;
		} else {
			digito2 = 11 - resto;
		}

		// Conctenando os numeros
		numerosContatenados = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3) + String.valueOf(n4)
				+ String.valueOf(n5) + String.valueOf(n6) + String.valueOf(n7) + String.valueOf(n8)
				+ String.valueOf(n9);

		// Concatenando o primeiro resto com o segundo.
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

		numeroGerado = numerosContatenados + nDigResult;

		return numeroGerado;
	}// fim do metodo geraCPF

	public String mostraResultado() throws Exception {

		String resultadoCPF = geraCPF();

		return resultadoCPF;
	}

}
