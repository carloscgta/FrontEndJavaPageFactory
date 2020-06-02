#encoding UTF-8
#Email: brunocarvalho@brq.com
#Author: Bruno Carvalho

@geralLogin
Feature: Realizar Login
         Como usuario gostaria 
         de realizar login

@validarRealizacaoLogin
Scenario Outline: Realizar o login com sucesso
       Given que usuario esteja na Home Page da Exame
       When preencho os respectivos campos "<usuario>"
       Then o login e realizado com sucesso         

Examples:
|usuario                           |
|brunocarvalhodesa@gmail.com       |              


@validarRealizacaoLoginInvalido
Scenario Outline: Realizar o login invalido
       Given que usuario esteja na Login Page da Exame com usuario e senha invalidos
       When preencho os respectivos campos "<usuario>" e "<senha>"
       Then o login nao e realizado pois o "Email e/ou senha inválido(s)"         

Examples:
|usuario                                  |senha            |
|joaodasilva@gmail.com                    |12345678         |     




