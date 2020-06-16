package br.com.exame.hooks;

import java.util.ArrayList;

import org.junit.AfterClass;

import br.com.exame.core.DriverFactory;
import br.com.exame.core.PDFGenerator;
import br.com.exame.core.TipoDriver;
import br.com.exame.core.YamlHelper;
import br.com.exame.pages.HomeExamePage;
import br.com.exame.pages.PayWallOpcoesAssinaturaPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	public Hooks() {
		// TODO Auto-generated constructor stub
	}
	
	PDFGenerator pdfgenerator;
	YamlHelper yamlhelper = new YamlHelper();
	
	
	@Before
	public void antesScenario(Scenario cenario) throws Exception {
		
		System.out.println("This will run before the Scenario");
		DriverFactory.getDriver(TipoDriver.CHROME)
		.get("https://pre.exame.com.br/");
		
		DriverFactory.getDriver(TipoDriver.CHROME)
		.navigate().to("https://assine.stage.exame.dev/");
		
	
	}

	
	@AfterClass
	public void depoisScenario(Scenario cenario) throws Exception {
		 System.out.println("This will run after the Scenario");
		 DriverFactory.closeDriver();
		 
	}

}
