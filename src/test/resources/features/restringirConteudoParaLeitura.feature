#encoding UTF-8
#Author: carlosteixeira@brq.com
#Keywords Summary : Gerenciar as regras para exibição de conteúdo restrito para 
#assinantes e não-assinantes da revista EXAME.


@geral
Feature: Restringir conteúdo para não assinantes
  Como não-assinante, quero ler um certo número de notícias, para decidir se assino o conteúdo

  @conteudoRestrito
  Scenario Outline: Clicar em um conteúdo restrito apos acessar mais de 3 vezes
    Given esteja na pagina principal da exame
    And não está logado
    And navega ate a sessão de Materias
    And clica em uma materia com o <parametro>
    Then o site deverá exibir a mensagem "<Para continuar acessando nosso conteúdo, favor efetuar o login/cadastro no site>"
    
    
  @restrigirLeituraNaoAssinante
  Scenario Outline: Identificar se o conteudo é restrito ou não
    Given esteja na pagina principal da exame
    And navega ate a sessão de Materias
    And clica em uma materia com o <parametro>
    And Aplicacao checa se a <quantidade> de vezes que o usuario ja acessou aquele conteudo não é maior que 3
    Then aplicação abre a materia o usuario
    
        Examples: 
      | parametros  						|
      | Conteúdo Aberto 				|
      | Conteúdo Limitado 			|
      |	Só para Assinantes			|
    

