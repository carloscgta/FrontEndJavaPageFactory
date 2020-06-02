#encoding UTF-8

@geralCadastroUsuario
Feature: Realizar Pesquisa no site da Exame
                Como usuario da Pagina
                desejo acessar a home page para realizar uma busca
                	
@pesquisa
Scenario Outline: Realizar Pesquisa no site da Exame
        Given  que o usuario navegue ate home page da exame
        And Realiza uma busca por "<titulo>"
        Then a pesquisa realizada com sucess
 
Examples:
|titulo|
|Bolsa |

