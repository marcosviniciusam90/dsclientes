> Trabalho final do Cap�tulo 1 - CRUD (Bootcamp Spring React)

**CRUD completo de web services REST para acessar um recurso de clientes** <br/>

Cole��o do Postman para testar requisi��es: [Link](https://github.com/marcosviniciusam90/dsclientes/blob/master/doc/DSClientes.postman_collection.json) <br/>
Imagem docker API: https://hub.docker.com/r/marcosviniciusam90/dsclientes

# Subir backend

- O banco de dados pode ser acessado pelo endere�o **`localhost:8080/h2-console`**

### Por linha de comando
1. Navegue at� o diret�rio ra�z do projeto (diret�rio que cont�m o arquivo pom.xml).
2. Execute o comando: 
- No Windows `mvnw.cmd spring-boot:run`
- No Linux `mvnw spring-boot:run`

### Pela IDE
1. Fa�a import do projeto (Maven) na IDE.
2. Execute o m�todo principal da classe **DsclientesApplication**.

**A api ficar� dispon�vel no endere�o `localhost:8080`**