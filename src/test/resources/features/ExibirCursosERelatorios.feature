#encoding UTF-8
#Author: carlosteixeira@brq.com


@geral
Feature: Ver Cursos e Relatórios 

  @ExibirCursosERelatorios
  Scenario: Acessar as paginas Cursos(Academy) e Relatorio(Research) através da Home Page
    Given Usuario acessa a Home page da Exame
    Then A pagina exibe no cabeçalho dois links de acesso Cursos (Academy) 
    And Relatórios (Research)


  @NavegarParaCursos
  Scenario: Navegar para pagina Cursos(Academy)
    Given Usuario está na Home page da exame
    And clina no link Cursos 
   	Then a aplicação redireciona o usuário para uma nova aba do navegador exibindo "cursos" 

   	
  @NavegarParaRelatorios
  Scenario: Navegar para pagina Relatorio(Research)
    Given Usuario está na Home page da Exame
    And clina no link  Relatorio(Reserach)
   	Then a aplicação redireciona o usuário para  uma nova aba do navegador exibindo "relatorios" 
   	
   	
  @validarExibicaoDoCardAcademy
  Scenario: Validar exibicao do Card Academy na home page  
    Given Usuario está na Home page da Exame
   	Then card de "Academy" é exibido
   	
  @tecnologia
  Scenario: Validar exibicao do Card tecnologia na home page  
    Given Usuario está na Home page da Exame
   	Then sessao de "tecnologia" é exibido
   	