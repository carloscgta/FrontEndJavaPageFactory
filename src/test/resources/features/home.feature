#encoding UTF-8
#Author: Carlos Almeida
#Email: carlosteixeira@brq.com

@geralHome
Feature: Home


@acessarPaginaInicialNovoSiteExame
Scenario Outline: Acessar home da pagina Exame
        Given  que o usuario esteja com o navegador aberto
        And navague até a página da exame <path>
        Then a home e carregada com sucesso no respectivo navegador
        
        
Examples:
|path													|
|assine.exame.stg.s3-website-us-east-1.amazonaws.com/login	|

	@validarExibicaoDoSiteExameNoDiferentesBrowsers
	Scenario Outline: Validar site exame em diferentes navegadores
        Given  que o usuario abre o "<navegador>"
        When acessar o site "url" da exame
        Then é exibido o site sem quebrar o conteudo
        
      Examples: 
      |navegador			|
			|Chrome					|
			|IE							|
			|Firefox				|
			|Edge						|
			|Safari					|
			


	@validarExibicaoDosCardsNaHome
	Scenario Outline: Validar Links do header exibido na Home
        Given  que o usuario acessa a home page
        When clicar no link "<hodapeMenu>"
        Then é exibido na Home o conteúdo da editoria
        
      Examples: 
      |hodapeMenu			|
			|Brasil					|
			|Negócios				|
			|Economia				|
			|Tecnologia			|
			|Research				|
			|Assine					|
			
@ValidarItensMenuSanduiche
Scenario Outline: Validar exibicao dos itens no menu Sanduiche
        Given  que o usuario acessa a home page
        And clica no card icone do Menu Sanduich
        When o Menu ser exibido
        And clicar no "<link>"
        Then a lista de links é exibida no Menu
        
      Examples: 
      |link					|
			|Brasil				|
			|Carreira			|	
			|Ciência			| 
			|Colunistas		|
			|Economia			|
			|Eventos			|
			|Especiais		|
			|Marketing		|
			|Mercados			|
			|Mundo				|
			|Negócios			| 
			|PME					|
			|Podcasts			|
			|Seu dinheiro	|
			|Tecnologia	 	|
			|Vida e Arte	|
			|Videos				|
			
			
@validarExibicaoDosCardsNaHome
Scenario Outline: Validar exibicao dos Cards na home da Exame
        Given  que o usuario acessa a home page
        Then é exibido na Home os principais "<cards>" de acordo com a escolha do usuario
        
      Examples: 
      |cards				|
			|Brasil				|
			|Carreira			|	
			|Ciência			| 
			|Colunistas		|
			|Economia			|
			|Eventos			|
			|Especiais		|
			|Marketing		|
			|Mercados			|
			|Mundo				|
			|Negócios			| 
			|PME					|
			|Podcasts			|
			|Seu dinheiro	|
			|Tecnologia	 	|
			|Vida e Arte	|
			|Videos				|
			
			
	@validarExibicaoDosCardsNaHome
	Scenario Outline: Validar Links do header exibido na Home
        Given  que o usuario acessa a home page
        When clicar no link "<hodapeMenu>"
        Then é exibido na Home o conteúdo da editoria
        
      Examples: 
      |hodapeMenu			|
			|Brasil					|
			|Negócios				|
			|Economia				|
			|Tecnologia			|
			|Research				|
			|Assine					|

