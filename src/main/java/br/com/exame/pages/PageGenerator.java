package br.com.exame.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageGenerator {

	public WebDriver driver;

	/*
	 * Maven Project - Docker Build 
	 * http://whitfin.io/speeding-up-maven-docker-builds/
	 * */

	public PageGenerator(WebDriver driver) {

		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	//JAVA Generics to Create and return a New Page

    public  <TPage extends BasePage> TPage GetInstance (Class<TPage> Pageclass) throws Exception {

        try {

           //Initialize the Page with its elements and return it.

            return PageFactory.initElements(driver,  Pageclass);

        } catch (Exception e) {

            e.printStackTrace();
            
            throw e;

        }

    }
	
	
	

}
