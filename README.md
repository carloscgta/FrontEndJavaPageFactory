# exame-automacao-testes-front
Framework para automação Front End - Selenium - Java JUnit

Projeto de Automação FrontEnd Wordpress para o Site da nova Exame

Tecnologias Utilizadas:
Java 11
Selenium Webdriver
JUnit
Maven
Cucumber

Gitflow sugerido para ser seguindo pelos QA's:


MASTER > DEVELOP > RELEASE
obs: essas três branches não podem ser apagadas

1. Sempre criar uma branch "feature/EX-[NUMERO USER STORY]" a partir da "develop" (ou pode ser definida outra nomenclatura)
2. Após terminar o desenvolvimento fazer Pull Request para a branch "Release"
3. Fazer Merge da "develop" com a "Release"
4. Fazer merge na "Master" com a "release"
5. Criar uma tag "Versão"
