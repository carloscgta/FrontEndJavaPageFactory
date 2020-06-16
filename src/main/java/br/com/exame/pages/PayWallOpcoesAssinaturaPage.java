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
	
	@FindBy(xpath = "//*[@data-plan-title='exame digital']")
	public WebElement buttonAssineDigital;
	

	@FindBy(xpath = "//*[@data-plan-title='exame digital + impressa']")
	public WebElement buttonAssineImpresso;
	
	public void clicarBotaoAssineDigital() throws InterruptedException {
		moverParaElemento(buttonAssineDigital);
		click(buttonAssineDigital);
	}
	

	public void clicarBotaoAssineImpresso() throws InterruptedException {
		
		click(buttonAssineImpresso);
	}
	
	public boolean validarOpcoesExibidas(String texto) throws Exception {
		boolean result = false;
		
				try {
					
					String textoDivDigital = divPayWall.getText();
					System.out.println(textoDivDigital);
					
					waitForElement(divPayWall);
					//moverParaElemento(buttonAssineDigital);
					if(textoDivDigital.contains(texto)) {
						result = true;
						System.out.println("O texto da opcao foi encontrado na pagina:"+texto);	
				
					}
					
					System.out.println("O texto da opcao foi encontrado na pagina:"+texto);	
					//moverParaElemento(buttonAssineImpresso);
					
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				return result;
		
			
	}
	

	
	
	
}
