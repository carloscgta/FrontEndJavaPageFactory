package br.com.exame.core;

import java.util.Locale;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class GeradorEmail {

	public GeradorEmail() {
		// TODO Auto-generated constructor stub
	}

private String email;
	
	public String geraEmail() {
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("pt-BR"), new RandomService());

	    email = fakeValuesService.bothify("exametesteautomatizado+?########?@gmail.com");
			
	    return email;
	}
	
}
