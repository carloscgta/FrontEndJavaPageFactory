#encoding UTF-8
#Author: Carlos Almeida

@geralPagarComBoleto
Feature: 	Suportar pagamento por Boleto como meio de pagamento
        	Como Visitante/Assinante eu quero poder escolher 
		   		Pagar com Boleto Bancario
		   		para Adquirir uma nova Assinatura

@PagamentoBoletoValidarFormularioEndereco
Scenario: realizar pagamento por meio de boleto
       Given que o assinante esta na tela de Assinatura Exame
       And na sessao de Cadastro preencher com dados validos  ao clicar no botao Cadastro deve avancar para a Sessao Endereco
       And Escolhe a opcao Boleto 
       Then deve ser exibido o formulario para endereco de com os campos acordo com a tela de UX com a mensagem na tela "Para emissão do boleto, é necessário o endereço de faturamento."

       
@cadastrarAssinaturaBoletoPlanoImpresso
Scenario: Fazer Assinatura com metodo de Pagamento Boleto para plano Impresso
       Given que um visitante não assinante acessa a pagina da exame
       And Clica no link Assinar localizado no menu Principal superior da pagina
       When na tela Planos Clica em Assine do Plano Impresso
       And na tela de Assinatura Exame na sessao Cadastro Preencher o formulario com Dados validos e clicar em Cadastro
       When usuario ser levado para a sessao de Endereco preencher com o endereo e clicar em Prosseguir
       And usuario deve ser levado para a sessao de Pagamento e tela segue layout conforme definido por UX
       And as demais opcoes da pagamento Debito em Conta e Cartao de Credito devem estar inativas
       When Preencher as informacoes e dados referentes ao meio de pagamento escolhido apos clicar em Finalizar Compra
       Then usuario deve receber um email com o Boleto em Anexo no email usado para criar a Assinatura
       
       
@cadastrarAssinaturaBoletoPlanoDigital
Scenario: Fazer Assinatura com metodo de Pagamento Boleto para plano Digital
       Given que um visitante não assinante acessa a pagina da exame
       And Clica no link Assinar localizado no menu Principal superior da pagina
       When na tela Planos Clica em Assine do Plano Digital 
       And na tela de Assinatura Exame na sessao Cadastro Preencher o formulario com Dados validos e clicar em Cadastro
       When usuario ser levado para a sessao de Endereco preencher com o endereo e clicar em Prosseguir
       And usuario deve ser levado para a sessao de Pagamento e tela segue layout conforme definido por UX
       And as demais opcoes da pagamento Debito em Conta e Cartao de Credito devem estar inativas
       When Preencher as informacoes e dados referentes ao meio de pagamento escolhido apos clicar em Finalizar Compra
       Then usuario deve receber um email com o Boleto em Anexo no email usado para criar a Assinatura
       
    
       