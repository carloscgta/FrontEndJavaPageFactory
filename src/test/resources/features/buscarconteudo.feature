#encoding UTF-8
Feature: Buscar por conteúdos específico
                Como leitor gostaria de buscar um conteúdo específico
                para saber mais exclusivamente sobre um assunto

@VerResultaldosDaBusca
Scenario: O título da página deve ser o resultado da busca
         Given que o usuario acessa a pagina na regiao de buscas
         Then eu visualizo na pagina os resultados das buscas

@BuscaRetornaConteudoBuscadoPeloUSuario
Scenario: O conteúdo que o usuario buscou no site exame corresponde ao resultado da busca
         Given que o leitor acessa o site na regiao de buscas
         And o leitor busca uma notícia
         Then a  leitor corresponde ao que usuario buscou na pagina de buscas    

@NoticiaOrdenadaPelaRelevancia
Scenario: O título que o usuario buscou no site exame deve ser classificado por data
        Given que o leitor acessa o site na regiao de buscas
        And o leitor busca uma noticia
        Then a noticia no site é ordenada pela data e relevância

@BuscaRetornaConteudoBuscadoPeloUSuario
Scenario: A exibição da matéria que foi buscado pelo usuário deve conter a imagem da notícia
         Given que o leitor acessa o site na regiao de buscas
         And o leitor busca uma noticia
         Then a noticia do site deve conter a imgaem da noticia

@validarNOmeDaEditorianabusca
Scenario: A exibição da matéria que foi buscado pelo usuário deve conter o nome da editoria
         Given que o leitor acessa o site na regiao de buscas
         And o leitor busca uma noticia
         Then a noticia do site deve conter o nome da editoria onde a noticia foi publicada

@ValidarTituloDanoticia
Scenario: A exibição da matéria que foi buscado pelo usuário deve conter o titulo da notícia
         Given que o leitor acessa o site na regiao de buscas
         And o leitor busca uma noticia
         Then a noticia do site deve conter o titulo da noticia

@NoticiaDeveConterDataDaPublicacao
Scenario: A exibição da matéria que foi buscado pelo usuário deve conter a data de publicação da notícia
         Given que o leitor acessa o site na regiao de buscas
         And o leitor busca uma noticia
         Then a noticia do site deve conter a data de publicação da noticia  

@ValidarPaginacaoDasMaterias
Scenario: A exibição de varias materias com paginação
        Given que o leitor acessa o site na regiao de buscas
        And o leitor busca uma noticia
        And clica em uma nova pagina
        Then o leitor consegue visualizar a informacao das outras paginas e a paginacao está correta

@BuscaDeveConterSomenteNoticiasDoSitedaExame
Scenario: O resultado da busca que o leitor buscou deve trazer somente notícias do site da exame
        Given que o leitor acessa o site na regiao de buscas
        And o leitor busca uma noticia
        Then a noticia que que é exibida em buscas está no site da exame  

@ValidarQuantidadeDeResultadosdaBusca
Scenario: Os resultados da busca devem ser contabilizados de acordo com que a pagina mostra ao leitor
        Given que o leitor acessa o site na regiao de buscas
        And o leitor busca uma noticia
        Then o resultado da busca e contabilizado de acordo com que a pagina mostra ao leitor   

@resultadoDeveConterTituloDabusca
Scenario: O usuário buscou o forum internacional em Davos
        Given que o leitor acessa o site na regiao de buscas
        And o leitor busca a noticia o usuario buscou "forum internacional em Davos"
        Then o resultado da pesquisa e texto tenham forum e internacional em davos com a quantidade de ocorrencias e data



