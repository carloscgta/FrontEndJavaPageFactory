package br.com.exame.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayWallOpcoesAssinaturaPage extends BasePage {

	public PayWallOpcoesAssinaturaPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		super(driver);
	}

	@FindBy(xpath = "//div[@id='root']")
	public WebElement divPayWall;
	
	@FindBy(xpath = "(//a[@href='/subscription'])[1]")
	public WebElement buttonAssineDigital;
	
	@FindBy(xpath = "(//a[@href='/subscription'])[2]")
	public WebElement buttonAssineImpresso;
	

	public void clicarBotaoAssineDigital() throws InterruptedException {
		
		click(buttonAssineDigital);
	}
	

	public void clicarBotaoAssineImpresso() throws InterruptedException {
		
		click(buttonAssineImpresso);
	}
	
	public boolean validarOpcoesExibidas(String texto) throws Exception {
		boolean result = false;
		
				try {
					
					String textoDivDigital = divPayWall.getText();
					waitForElement(buttonAssineDigital);
					scrollToElement(divPayWall);
					if(textoDivDigital.contains(texto)) {
						result = true;
						System.out.println("O texto da opcao foi encontrado na pagina:"+texto);	
				
					}
					
					scrollToElement(buttonAssineImpresso);
					
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				return result;
		
			
	}
	

	
	
	
}
