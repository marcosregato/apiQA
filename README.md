# apiQA

> 	Api QA, faz parte do projeto de arquitetura de QA.
> 	Versão 04

> __Mais Informações sobre a Arquitetura QA__

>	Email = marcosregato01@gmail.com <br/>
>	Assunto = Arquitetura QA

> __Descrição do projeto__

>	Recebe as informações (formato JSON) dos resultados dos teste e envia para o banco de dados (MongoDB)

![Semantic description of image](./diagrama.png)</p>

> ** Ferramentas de desenvolvimento ** </br>
> * Java - versão 8
> * Spring boot - versão 2.3.0
> * REST
> * Conexao com MongoDB </br>

# Erro quando roda API

> 	Verify the connector's configuration, identify and stop any process that's listening on port 8080, or configure this application to listen on another port.<br/>
> 	(Verifique a configuração do conector, identifique e pare qualquer processo que esteja escutando na porta 8080 ou configure este aplicativo para escutar em outra porta.)

> __Solucão do erro__ <br/>
> 	sudo kill -9 $(lsof -i :8080) <br/> 

# URL para acessar API
> Acesse http://localhost:8080/api/

# Links dos projetos da arquitetura

> __Modelo Teste Funcional__
> [Link do projeto](https://github.com/marcosregato/modeloTesteFuncional).</br>

> __Painel Teste Angular__
> [Link do projeto](https://github.com/marcosregato/painelTesteAngular).</br>

> __Teste API QA__
> [Link do projeto](https://github.com/marcosregato/testeApiQA).</br>

> __convert CSV to JSON__
> [Link do projeto](https://github.com/marcosregato/convertCSVtoJSON).</br>

> __Data Science QA__
> [Link do projetos](https://github.com/marcosregato/dataScienceQA).</br>

> __Api QA__
> [Link do projeto](https://github.com/marcosregato/apiQA).</br>

> __Gerador massa de dados QA__
> [Link do projeto](https://github.com/marcosregato/geradorMassaQA).</br>
