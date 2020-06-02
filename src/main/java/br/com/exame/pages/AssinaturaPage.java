package br.com.exame.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssinaturaPage extends BasePage {

	public AssinaturaPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath = "//img[@id='main-header-logo']")
	public WebElement logoExame;

	public void validarResultado() throws InterruptedException {
	
		Assert.assertTrue(elementIsDisplayed(logoExame));
	}

}
