#encoding UTF-8

@geral
Feature: Ver Editorias


@editoria
Scenario: Validar exibicao da sessão de cada editoria
        Given que o usuario acessa a home page
        And clica no card  <editoria>
        Then o sistema carrega a página da respectiva editoria na pagina da exame
        


Scenario Outline: Validar redirecionamento dos links da pagina
        Given  que o usuario acessa uma "<editoria>"
        And clica em um produto da pagina
        Then o aplicação redireciona o usuario para a digital pages  <editoria>
 


Scenario Outline: Validar lista de cursos da pagina academy
        Given  que o usuario acessa a home
        And clica no no link de um <cursos> da digital page
        Then o aplicação abre uma nova aba com a pagina da digital pages exibindo a lista de cursos
 
			 
		 Examples: 
      |cursos				|
			|financas			|
			|tecnologias	|
			
			
			Scenario: 	
        Given  que o usuario acessa a home
        And clica no no link de um "research" da home page da exame
        Then o aplicação abre uma nova aba com a pagina da digital pages exibindo o conteudo da pagina Reserach
 
