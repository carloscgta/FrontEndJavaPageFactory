#encoding UTF-8
#Author: Carlos Almeida
#Email: carlosteixeira@brq.com
# [32] Acessar área do assinante (Login) -  https://jira.brq.com/browse/EX-10
#
#Correções:
#Corrigir as palavras visuzliar, pefil, botacao
#Corrigir "do usuários" (é "do usuário")
#Os seguintes nomes são bloqueados contra alteração: Nome, CPF, data de nascimento e código do assinante.
#Os campos presentes nesta tela serão (além dos acima): e-mail, senha, tel1, tel2, tipo de assinatura (produto que assina), número do cartão, nome como consta no cartão, díg. verificador e validade.
#A msgs que a Vindi retorna são "Transação aprovada" ou "Transação não permitida", dependendo do caso.
@geral
Feature: Área do Assinante
 	Como assinante, quero acessar minha área exclusiva, para visualizar/atualizar meus dados cadastrais

  @validarDadosDoAssinante
  Scenario Outline: Validar Dados Cadastrais do Assinante
    Given Esteja na página da exame
    And realizada o login com seus dados <email> e <senha>
    When na area do assinante clicar no icone Meu Perfil
    And exibir os dados cadastrais do usuarios
    When usuário realiza a atualização dos dados
    And clica no botao "Confirmar Alterações"
    Then será exibida a mensagem: "Dados Alterados com Sucesso" 
   
Examples: 
| email		 									|senha 					| Nome 										|EmailNovo 									| CPF 							| te1 				|te2 					|TipoAssinatura	|NumeroCartao				|NomeDoCartao			|digito	|validadeCartao	|
| email@domain.com 					|123456					|	Gabriel Almeida 				|carloscgta@gmail.com				| 234 098 789 23		| 11 930023443|11 930022323	|	online				|	2345 2323 2343		| Carlos Y U Roque|123		|11/2030				|	
  

  @alterarDados
  Scenario Outline: Alterar Dados Cadastrais do Assinante
    Given Esteja na página da exame
    And realizada o login com seus dados <email> e <senha>
    When na area do assinante clicar no icone Meu Perfil
    And exibir os dados cadastrais do usuarios
    When usuário realiza a atualização dos dados
    And clica no botao "Confirmar Alterações"
    Then será exibida a mensagem: "Dados Alterados com Sucesso" 
   
Examples: 
| email		 									|senha 					| Nome 										|EmailNovo 									| CPF 							| te1 				|te2 					|TipoAssinatura	|NumeroCartao				|NomeDoCartao			|digito	|validadeCartao	|
| email@domain.com 					|123456					|	Gabriel Almeida 				|carloscgta@gmail.com				| 234 098 789 23		| 11 930023443|11 930022323	|	online				|	2345 2323 2343		| Carlos Y U Roque|123		|11/2030				|	
  
      
  @alterarDadosPagamento
  Scenario Outline: Alterar Dados do pagamento do Assinante com cartao inválido
    Given Esteja na página da exame
    And realizada o login com seus dados "<email>" e "<senha>"
    When estiver na area do assinante clicar no icone "Meu Perfil"
    And exibir os dados cadastrais do usuario
    When usuário realiza a atualização dos dados usando um cartao de crédito inválido "<cartoCredito>"
    And clica no botacao "Confirmar Alterações"
    Then será exibida a mensagem: "Ocorreu um erro no processamento dos dados do seu cartão de crédito" 
   
Examples: 
| email		 									|senha 					| Nome 										|EmailNovo 									| CPF 							| te1 				|te2 					|TipoAssinatura	|NumeroCartao				|NomeDoCartao			|digito	|validadeCartao	|
| email@domain.com 					|123456					|	Gabriel Almeida 				|carloscgta@gmail.com				| 234 098 789 23		| 11 930023443|11 930022323	|	online				|	2345 2323 2343		| Carlos Y U Roque|123		|11/2030				|	
  