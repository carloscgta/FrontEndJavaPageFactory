#encoding UTF-8
#Email: carlostexeira@brq.com
#Author: Carlos Almeida

@geral
Feature: Institucional
  Como usuario quero visualizar o conteúdo da institucional 


  @linksInstitucionaisRodape
  Scenario Outline: Validar os links das paginas institucionais presentes no menu lateral esquerdo 
    Given esteja na home paga da exame
    And clicar no menu lateral esquerdo
    When abrir o Menu com as opcoes
    And os links links institucionais serem exibidos
    When clica em um link <institucional>
    Then a aplicacao redireciona o usuario para a pagina institucional

    Examples: 
      | institucional  					| 
 			| Fale conosco						| 	
      | Termos de Uso						|
      | Politica de Privacidade	|

      
      
 	@linksInstitucionaisMenuSanduiche
  Scenario Outline:  Validar os links das paginas institucionais presentes no footer da home page
    Given esteja na home paga da exame
    And navege ate o rodape da pagina
    And os links institucionais serem exibidos
    When clicar em um link <institucional>
    Then a aplicacao redireciona o usuario para a pagina institucional

    
       Examples: 
      | institucional  					| 
 			| Fale conosco						| 	
      | Termos de Uso						|
      | Politica de Privacidade	|