#encoding UTF-8
#Author: Carlos Almeida
#Email: carlosteixeira@brq.com

@geral
Feature: Acessar Fale Conosco
  Como usuário quero ter acesso ao Fale conosco da Exame, para tirar minhas dúvidas

#A inclusão do link "Fale conosco" no menu sanduíche e no rodapé da home page.

  @validarExibicaoLInkFaleConosocoMenuSanduiche
  Scenario Outline: Validar Exibicao do link "Fale Conosco" no menu Sanduiche
    Given Estou na Home Page da Exame
    And Clico no Menu Sanduiche
    When O Menu abrir
    And descer a barra de rolagem para o final da lista
    Then o link "Fale Conosco" é exibido
    When clicar no link 
    Then deve ser redirecionado para a pagina "<linkPagina>"

    Examples: 
      | linkPagina					  |
      | www.exame.zendesk.com |
      
      
 
      
      
  @validarExibicaoLInkFaleConosocoNoRodapePagina
  Scenario Outline: Validar Exibicao do link "Fale Conosco" no Rodape da Pagina
    Given Estou na Home Page da Exame
    And desço até Rodape no final da pagina 
    And o link "Fale Conosco" é exibido
		When clicar no link  "<linkPagina>"
		Then deve ser redirecionado para a pagina "<linkPagina>"

    Examples: 
      | linkPagina					  |
      | www.exame.zendesk.com |
      
      
  @realizarContatoAtravesDaPaginaFaleConosco
  Scenario Outline: realizar contato atraves da pagina Fale Conosco
    Given Estou na Home Page da Exame
    And desço até Rodape no final da pagina 
    And o link "Fale Conosco" é exibido
		When clicar no link  "<linkPagina>"
		And deve ser redirecionado para a pagina "<linkPagina>"
		And preencho os campos da pagina 
		And clico em submeter as informacoes
		Then a solicitacao de contato é realizada

    Examples: 
      | linkPagina					  |
      | www.exame.zendesk.com |
      