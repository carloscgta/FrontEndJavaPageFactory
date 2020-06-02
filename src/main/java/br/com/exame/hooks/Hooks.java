package br.com.exame.hooks;

import br.com.exame.core.PDFGenerator;
import br.com.exame.core.YamlHelper;
import cucumber.api.Scenario;

public class Hooks {

	public Hooks() {
		// TODO Auto-generated constructor stub
	}
	
	PDFGenerator pdfgenerator;
	YamlHelper yamlhelper = new YamlHelper();
	
	
	public void antesScenario(Scenario cenario) throws Exception {

		
	}

	public void depoisScenario(Scenario cenario) throws Exception {
		
	
	}

}
