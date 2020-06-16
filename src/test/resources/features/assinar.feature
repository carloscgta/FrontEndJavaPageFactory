#encoding UTF-8
@geralAssinar
Feature: Assinar revista
              Como assinante gostaria 
              de assinar a revista

@ValidarOpcoesDeassinaturaDigital
Scenario: O site devera exibir as seguintes opcoes de selecao
       Given que um leitor nao assinante acessa um noticia do Paywayll
       And o sistema exbibira as seguintes opcoes de data 
      |exame digital														|
      |exame digital + impressa									|


@cadastrarClienteAssinante
Scenario: Clicar em Assine e Cadastrar Dados do Customer na tela de Cadastro
       Given que um leitor nao assinante esteja no Paywall clica no botao Assine
       And na tela de Cadasatro preenche os campos do Customer para validar o email de Cadastro com os seguintes Dados 
      |Nome														|email						| Senha										|ConfirmarSenha			| cpf						|Telefone			|
      |Carlos Gabriel Albuquerte					|@gmail.com				| Solrac@89								|Solrac@89					| 04519323584		|11930035118	|

	
	@cadastrarClienteAssinanteDebitoConta
Scenario: Cliente realiza a assinatura selecionando Debito em Conta como meio de pagamento
       Given usuario escolhe plano Digital
       And na tela de Assinatura insere os dados pessoas para avancar para a sessao de Pagamento e escolhe Debito em Conta como meio de Pagamento 
      |Nome														|email						| Senha										|ConfirmarSenha			| cpf						|Telefone			|
      |Carlos Gabriel Junior Woz				|@gmail.com				| Solrac@89								|Solrac@89					| 04519323584		|11930035118	|

	
@cadastrarAssinaturaBoleto
Scenario: Cliente realiza a assinatura selecionando Boleto em Conta como meio de pagamento
       Given escolher um plano de assinatura
       And usando os dados abaixo insere as informacoes no form de cadastro ao chegar na sessao da pagamento escolhe  
      |Nome														|email						| Senha										|ConfirmarSenha			| cpf						|Telefone			|
      |Juruenildo Galinild Junirildo	|@gmail.com				| Solrac@89								|Solrac@89					| 04519323584		|11930035118	|

	
	
@validarMensagensDeErroNoCadastro
Scenario: Validar Mensagens de Validacoes dos campos do formulário de Cadastro
       Given que um usuario esteja no formulario de cadastro
       And insere informacoes invalidas para validar as mensagens de validacao usando os Dados
       |MensagenErroTexto																						|
       |Informe seu nome completo																		|
       |E-mail inválido																							|
       |Composta de maiúsculas, minúsculas, números e !@#$%&*				|
       |Senhas não coincidem																				|
       |Documento inválido																					|
       |Telefone inválido																						|
       |E-mails não coincidem																				|
  