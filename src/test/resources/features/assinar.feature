#encoding UTF-8
@geralAssinar
Feature: Assinar revista
              Como assinante gostaria 
              de assinar a revista

@ValidarOpcoesDeassinaturaDigital
Scenario: O site devera exibir as seguintes opcoes de selecao
       Given que um leitor nao assinante acessa um noticia do Paywayll
       And o sistema exbibira as seguintes opcoes de data 
      |planos																		|
      |exame digital														|
      |Exemplar Impresso												|


@cadastrarClienteAssinante
Scenario: Clicar em Assine e Cadastrar Dados do Customer na tela de Cadastro
       Given que um leitor nao assinante esteja no Paywall clica no botao Assine
       And na tela de Cadasatro preenche os campos do Customer para validar o email de Cadastro com os seguintes Dados 
      |Nome														|Email						| Senha										|ConfirmarSenha	| CPF						|Telefone			|
      |Carlos Gabriel Juliano					|@gmail.com				| Solrac@89								|Solrac@89			| 04519323584		|11930035118	|

	
@validarMensagensDeErroNoCadastro
Scenario: Validar Mensagens de Validacoes dos campos do formulário de Cadastro
       Given que um usuario esteja no formulario de cadastro
       And insere informacoes invalidas para validar as mensagens de validacao usando os Dados
       |MensagenErroTexto																											|
       |Por favor, adicione o nome completo																		|
       |Formato inválido de email																							|
       |Senha deve conter uma letra maiuscula e caracter especial							|
       |Confirmação de senha não coincide com a senha													|
       |CPF/CNPJ inválido																											|
       |Telefone inválido																											|
       |Número do cartão inválido																							|
       |Nome inválido																													|
       |Data de expiração é obrigatório																				|
       |CVV é obrigatório																											|
  