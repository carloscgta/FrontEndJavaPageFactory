#encoding UTF-8

@geralSignWall
Feature: Signwall
				Como VISITANTE DO SITE eu QUERO ME CADASTRA
				para TER ACESSO A UM NUMERO MAIOR DE CONTEUDOS


@SignWallGuiaAnonima
Scenario Outline: Acessar o site da Exame usando Guia Anonima
        Given  que o usuario abre uma guia Anonima navegador 
        And acessa o site da exame <path>
        Then o Signwall deve aparecer imediatamente

@ValidarLimiteDoParametroParaSignwall
Scenario Outline: Limite de numero de Materias
        Given  faltar 2 materias  o usuario abre o navegador
        When acessar uma materia com SignWall
        Then o sistema deve exibir um aviso para o Leitor <limite>
        

	@limiteIguala0
	Scenario Outline: Validar  quando o limite estiver zerado
        Given  que o usuario acessa a home page
        And o limite esta zerado
        Then é exibido o SignWall para o leitor
        
        
        
@UsuarioNaoAssinanteAcessarMateriaConteudoLimitado
Scenario Outline: Acessar Materia de Conteudo Limitado
        Given  que o usuario nao assinante acessa o site da Exame
	       When clicar no link de uma materia de conteudo limitado
	       And limite igual a 0
        Then o SignWall e exibido
        
			
			
@SolicitacaodeCadastradoSignwall
Scenario Outline: Aviso de quantidade de Materias e exibido para o usuário
        Given  que o leitor nao assinante acessa o site da Exame pela primeira vez
        And clica no link de conteudo limiteado
        Then e exibido o aviso da quantidade de materias que ele pode ler por mes 5 "Você atingiu o limite máximo de reportagens lidas no mês."
        
        
	@SolicitacaoDeLoginOuCadastroSignwall
	Scenario Outline: Usuario se depara com a solicitação de login ou cadastro no Signwall
        Given  abre o site da exame
        And e exibido o aviso da quantidade de materias que ele pode ler por mes 5
        When acessar o limite de materias
        Then a tela solicitação de login deve ser exibida de acordo com desenho de UX
        
@loginSignWall
	Scenario Outline:  Visitante nao e Assinante
        Given  visitante abre o site da exame
        And e exibido o aviso da quantidade de materias que ele pode ler por mes 5
        When acessar o limite de materias
        And solicitação de login ou cadastro ser exibida
        And clicar em Login
        Then deve ser exibitado a tela de Login do Signwall de acordo com desenho de UX      
       
        
	@CadastradoApartirDoSignwall
	Scenario Outline:  Cadastro a partir do Signwall
        Given  abre o site da exame
        When acessar uma materia com signwall 
        And exibido o aviso da quantidade de materias que ele pode ler por mes
        And solicitação de login ou cadastro no Signwall deve ser exibida de acordo com desenho de UX
        When clicar em Cadastro
        And realiza o Cadastro preenchendo as informacoes necessarias
        Then deve ser permitido realizar o login 
        Then e permitido acessar os conteudos restritos a assinantes
        
        