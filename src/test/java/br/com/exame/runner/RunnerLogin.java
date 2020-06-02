package br.com.exame.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue = { "br.com.exame.steps", "br.com.exame.hooks"}, 
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:src/main/report/cucumber-reports/report.html"},

		 features = {"./src/test/resources/features" }, 
tags = { "@geralLogin" })


public class RunnerLogin {
	

}
