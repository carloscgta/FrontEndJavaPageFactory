package br.com.exame.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeExamePage extends BasePage {

	public HomeExamePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		super(driver);
	}

	@FindBy(xpath = "//a[@href='https://assine.stage.exame.dev/']")
	public WebElement buttonAssine;
	
	@FindBy(xpath = "//*[@id=\"cse-search-box\"]/input")
	public WebElement inputEstado;
	
	public void clicarBotaoAssine() throws InterruptedException {
		
		click(buttonAssine);
	}
	
	
}
