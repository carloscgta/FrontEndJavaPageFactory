#encoding UTF-8
#Author: carlosteixeira@brq.com
#Summary: Como leitor, quero ver os indicadores financeiros na home page, para poder acompanhá-los rapidamente.
#Disponibilizar na Homepage os indicadores financeiros da IBOVESPA e Dólar.

@geral
Feature: ver os indicadores financeiros na home page
  Como leitor, quero ver os indicadores financeiros na home page, para poder acompanhá-los rapidamente

  @verIndicadoresFinanceiros
  Scenario: Validar sessão de exibição dos Indicadores Financeiro na Home Page
    Given esteja na Home page da Exame
    Then deve ser exibido os indicadores financeiros está sendo exibido em um painel circular
  
  @clicarEmAtivo  
  Scenario Outline: Clicar em um Ativo
    Given esteja na Home page da Exame
    Then clicar em um "<ativo>" deve ser redirecionado para a pagina correspondente do Ativo
    
Examples: 
  |ativo  				|			
  |bovespa 				|
  |dollar 				| 
  |ações	 				| 

	@validarAtivos
  Scenario Outline: Validar informacoes dos Ativos
    Given usuário esteja na home page
    And os indicadores financeiros está sendo exibido em um painel circular
    Then para cada "<ativo>" são exibidos as seguintes informacoes "<nomeAtvio>" - "<valorAbertura>"  "<valorDesvalorizacao>"  "<porcentagemDeValorizacao>"

Examples: 
  |ativo  		|nomeAtvio 		|valorAbertura 	|valorDesvalorizacao|porcentagemDeValorizacao		|			
  |Bolsa 			|	Bolsa				|100						|	-2								|	1%												|
  |Dólar 			|	Dólar				|34							|	-4								|	4%												|
  |Bovespa 		|	Bovespa			|120						|	-5								|	5%												|
