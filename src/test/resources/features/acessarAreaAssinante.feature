#encoding UTF-8
#Author: Carlos Almeida
#Email: carlosteixeira@brq.com

@geral
Feature: Acessar Área do Assinante
  Como assinante, quero acessar minha área exclusiva, para atualizar meus dados cadastrais

  @AcessarTeladeLogin
  Scenario: Abrir Tela Login
    Given que usuario esteja na Home Page da Exame
    And Clico no icone do Usuario na parte superior direita do cabeçalho
   	Then a tela de Login deve ser exibida


 @LoginAssinanteMenuSanduich
  Scenario: Acessar Tela de Login a partir do Menu Sandwich
    Given que usuario esteja na Home Page da Exame
    When clicar menu sanduiche na parte superior esquerda do cabeçalho
    And o menu ser exibido
    When clicar no link para fazer login Acesse Sua conta
   	Then a tela de Login deve ser exibida

	@ValidarConteudoTelaLogin
  Scenario Outline: Validar Conteudo da Tela de login
    Given o usuario esteja na tela de login
    Then é exibido o <texto> na tela
  

    Examples: 
      | texto  																					|
      | Acesse a Exame																	|
      | Assine e tenha acesso a todo conteúdo da Exame	|
      | Esqueceu sua Senha?															|
      | Lembre-se de mim																|
      
	@irParaTelaDeAssinatura
  Scenario: Ir para tela de Assinatura
    Given que usuario esteja na Home Page da Exame
    And Clico no icone do Usuario na parte superior direita do cabeçalho
   	When a tela de Login ser exibida
    Then é exibido o  <linkAssine> na tela 
    When clicar no "<linkAssine>" 
    Then o usuario é redirecionado para a tela de Assinatura "<url>"
      
	@validarCamposTelaLogin
  Scenario: Validar Campos da Tela de Login
    Given que usuario esteja na Home Page da Exame
    And Clico no icone do Usuario na parte superior direita do header
   	When a tela de Login ser exibida
   	Then o campo de "<InputEmail>" e "<InputSenha>" e "<BotaoEntrar>" sao exibidos
   	
  @RedirecionamentoParaTelaRecuperarSenha
  Scenario: Validar redirecionamento para a Tela de recuperação da senha
    Given que usuario esteja na Home Page da Exame
    And Clico no icone do Usuario na parte superior direita do cabeçalho
   	When a tela de Login ser exibida
   	And o usuário clica no link "<EsqueceuSuaSenha>"
   	Then aplicação redireciona o usuário para a tela de recuperação de senha 
   	And exibe os campos "Email" e Botao "Confirmar Email" com os labels "Informe seu e-mail para enviarmos um link de recuperação de senha"
   	
  @EsqueciMinhaSenharEnviarEmail
  Scenario:  Esqueci minha Senha
    Given que usuario esteja na Home Page da Exame
    And Clico no icone do Usuario na parte superior direita do cabeçalho
   	When a tela de Login ser exibida
   	And o usuário clica no link "<EsqueceuSuaSenha>"
   	And a aplicação redireciona o usuário para a tela de recuperação de senha
   	And a tela de recuperação de senha é exibida
   	And exibe os campos "Email" e Botao "Confirmar Email" com os labels "Informe seu e-mail para enviarmos um link de recuperação de senha"
   	And usuario insere seu email <email> cadastrado previamente
   	And Clicar no botao Confirmar Email
   	And o sistema grava o e-mail na base de dados
   	Then dispara um e-mail para o usuário com um código de 6 dígitos
   
  @FazerLogin
  Scenario Outline: Fazer Login
    Given o usuario esteja na tela de login
    And insere o  <email> e <senha>
    When clicar no botao entrar
    Then o usuário deve ser levado para a área do assinante
  

    Examples: 
      | email  									|senha  	|
      | carloscgta@gmail.com  	|123456  	|
   	
   	
   	
  @ValidarDadosDoASsinanteAposLogin
  Scenario Outline: Validar dados do assinante apos Login
    Given o usuario esteja na tela de login
    And insere o  <email> e <senha>
    When clicar no botao entrar
    And o usuário deve ser levado para a área do assinante
  	Then deve ser exibido as seguintes informacoes: "<nome>""<Email>""<cpf>""<senha>""<telefone>"
#Ao efetuar o logon, exibir  "Área do assinante", com os seguintes campos:
#Nome (obrigatório, habilitado para edição)
#E-mail (desabilitado)
#CPF (desabilitado)
#Senha (desabilitado com opção para visualizar os caracteres)
#Telefone (obrigatório, habilitado para edição)


    Examples: 
      | nome						|Email								|cpf						|senha						|telefone				|
      | Acesse a Exame	|carloscgta@mail.com  |09876543212		|dfaasdfasdfas    | 11930035623		|

   	   	
  @FazerLoginInvalido
  Scenario Outline: Fazer Login Invalido
    Given o usuario esteja na tela de login
    And insere o <email> e <senha> invalods
    When clicar no botao entrar
    Then deve ser apresentada uma mensagem de erro "<Usuário/Senha de acesso incorretos>"
    And nao deve exibir a area do assinante
  

    Examples: 
      | email  									|senha  	|
      | dsdsdsdsds@gmail.com  	|123456  	|
      
