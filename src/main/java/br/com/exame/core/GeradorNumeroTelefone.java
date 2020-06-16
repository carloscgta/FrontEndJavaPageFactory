package br.com.exame.core;

import java.util.Locale;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class GeradorNumeroTelefone {

	public GeradorNumeroTelefone() {
		// TODO Auto-generated constructor stub
	}
	

	private String geraTelefoneFixo;
	
	public String geraTelefoneFixo() {
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("pt-BR"), new RandomService());

		geraTelefoneFixo= fakeValuesService.bothify("113#######");
			
	    return geraTelefoneFixo;
		
	}
	


	private String geraTelefoneMovel;
	
	public String geraTelefoneMovel() {
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("pt-BR"), new RandomService());

		geraTelefoneMovel= fakeValuesService.bothify("119########");
			
	    return geraTelefoneMovel;
		
	}

}
