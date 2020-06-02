#encoding UTF-8
#Author: carlostexeira@brq.com

@geral
Feature: Noticias e Materias
		Como leitor, quero ver as notícias e matérias para me manter atualizado.

@noticiasCard
Scenario: Ver Noticias e Materias
        Given  que o usuario esteja na home da exame
       	And navague ate o card da noticia
				When clicar no card de uma Noticia
        Then a noticia e aberta para leitura


@conteudoPatrocinado
Scenario: Validar Sessao Conteudo Patrocinado
        Given  que o usuario esteja com a pagina da materia aberta
        And navague até o final da página
				Then deve ser visualizado a sessao Conteudo Patrocinado
				

@anuncios
Scenario: Validar Sessao de anuncios
        Given  que o usuario esteja com a pagina da materia aberta
        Then deve ser visualizado do lado direito a sessao de anuncios
        

@editoriaDetalhes
Scenario Outline: Validar nome da editoria
        Given  que o usuario esteja com a materia aberta
       Then deve ser exibido o nome da editoria "<nomeEditoria>"
        

Examples:
|nomeEditoria		|
|Tecnologia			|
|Financeiro			|
|Academy				|
|Reserach				|


@noticiasRelacionadas
Scenario: Validar sessao de noticias relacionada
        Given  que o usuario esteja com a materia aberta
        Then deve ser exibido a sessao de noticias relacionadas
        

@dataHoraPublicacao
Scenario: Validar data hora da publicacao
        Given  que o usuario esteja a materia aberta
        Then deve ser exibida a data hora da publicacao
        
@tituloDaMateria
Scenario: Validar Exibição do Título da Matéria ao abrir
        Given  que o usuario esteja a materia aberta
        Then deve ser exibida a data hora da publicacao

@imagemDaMateria
Scenario: Exibição da Imagem ao abrir a materia
        Given  que o usuario esteja na home page
        When clicar no card da materia
        Then deve ser exibida uma imagem na pagina relacionada a materia
        
        
@secaoVejaTambem
Scenario: Exibição da secao veja tambem
        Given  que o usuario esteja na home page
        When clicar no card da materia
        And a materia é exibida
        When usuario descer para o final da materia
        Then deve ser exibida a seção "Veja também"

@nomeResponsavelPublicacao
Scenario Outline: Validar nome do Responsavel pela materia
        Given  que o usuario clica no card da Materia
        When a materia é exibida 
        Then o Titulo da Matéria deve ser exibido
        And o Subtitulo da materia tambem é exibido


@nomeResponsavelPublicacao
Scenario Outline: Validar nome do Responsavel pela materia
        Given  que o usuario esteja com a materia aberta
        Then o nome do "<nomeResponsavel>" deve ser exibido na parte superior direita do 	texto
        

Examples:

|nomeResponsavel	|
|pedro Bial				|


@informacoesAutorMateria
Scenario Outline: Validar informacoes do Responsavel pela materia
        Given  que o usuario esteja na Home page
        When clicar no card da Materia
        And a materia ser exibida
        Then no canto superior esquerdo, as seguintes informacoes devem ser exibidas: "<nomeAutor>" <foto> <dataPulbicacao> <tempoLeitura> <tempoLeitura>
        
        
        
@acessibilidadeAumentarZoomDaFonte
Scenario Outline: Validar acessibilidade aumentar zoom da fonte
        Given  que o usuario esteja na Home page
        When clicar no card da Materia
        And a materia ser exibida
        When no canto superior direito, clicar no icone de aumentar a fonte <A+>
        Then o texto da fonte deve ser aumentado de acordo com o zoom <A+> 
  
@acessibilidadeDiminuirZoomDaFonte
Scenario Outline: Validar acessibilidade aumentar zoom da fonte
        Given  que o usuario esteja na Home page
        When clicar no card da Materia
        And a materia ser exibida
        When no canto superior direito, clicar no icone de aumentar a fonte <A->
        Then o texto da fonte deve ser aumentado de acordo com o zoom <A->    
        
@carrosselNoticiasRelacionadasAvancar
Scenario Outline: Avancar carrossocel Noticias relacionadas
        Given  que o usuario esteja na Home page
        When clicar no card da Materia
        And a materia ser exibida
        When descer para a sessao de noticias relacionadas
        And clicar no carrossel para avançar
        Then avança para a proxima lista de noticias relacionadas exibindo <3> cards
        
@carrosselNoticiasRelacionadasVoltar
Scenario Outline: voltar carrossocel Noticias relacionadas
        Given  que o usuario esteja na Home page
        When clicar no card da Materia
        And a materia ser exibida
        When descer para a sessao de noticias relacionadas
        And clicar no carrossel para voltar
        Then voltar para a lista anterior de noticias relacionadas exibindo <3> cards
        
                
@palavrasRelaciondas
Scenario Outline: exibicao das palavras-chaves relacionadas
        Given  que o usuario esteja na Home page
        When clicar no card da Materia
        And a materia ser exibida
        When descer para o final da materia
        Then deve ser exibido as palavras relacionadas
        
        
@iconesCompartilhamento
Scenario Outline: Validar exibicao dos icones de compartilhamento
        Given  que o usuario abra uma Materia para leitura
        Then os "<icone>" de compartilhamento e exibido no inicio da materia
       

Examples:

|icone			|
|Whatsapp		|
|Linkedin		|
|Telegram		|
|Instagram	|
|TW					|
|Facebook		|
|CopiarLink	|
|Twitter		|
|E-mail			|

@iconesCompartilhamento
Scenario Outline: Compartilhar uma Materia
        Given  que o usuario esteja com a pagina da Materia aberta
				And clica no "<redeSocial>" da rede social para compartilhar
   			Then a pagina da materia e compartilhada na respectiva "<redeSocial>" 
        

Examples:
|redeSocial	|
|Whatsapp		|
|Linkedin		|
|Telegram		|
|Instagram	|
|TW					|
|Facebook		|
|CopiarLink	|
|Twitter		|
|E-mail			|

@conteudoPatrocinado
Scenario: Ver conteudo Patrocinado
        Given  que o usuario esteja na home page
        And clica no card de uma Materia
        When descer ate o final da pagina
        Then deve ser exibido a sessa de conteudo patrocinando
        
        
@CompartilharUmaNOticia
Scenario Outline: O leitor podera compartilhar as materias pelos canais
        Given que o leitor leu a materia
        Then o usuario podera compartilhar a materia pelos "<canais>"

Examples:
|canais         |
|Facebook       |
|Twitter        |
|Instagram      |
|Whatsapp       |
|Telegram       |
|LinkedIn       |
|e-mail         |
|copia do link  | 
        
        
