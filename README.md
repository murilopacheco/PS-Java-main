# Avaliação Java
# API para ecomerce de games

<p align="center">

[![Java](https://img.shields.io/badge/Java-11-orange.svg)](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.4.2-darkgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.6.3-green.svg)](https://maven.apache.org/download.cgi)
[![H2](https://img.shields.io/badge/HSQLDB-2.4.0.-darkblue.svg)](https://mvnrepository.com/artifact/org.hsqldb/hsqldb/2.4.0)
</p>

## Descrição

  O teste consiste em construir a camada de serviço de um pseudo ecommerce de games mobile utilizando Java

## Justificativa dos Frameworks
<p>

A escolha dos frameworks presentes no projeto se deve devido a produtividade do spring boot e sua arquitetura
de microserviços. Uma arquitetura robusta e leve, com esse framework é possível construir API's  REST, HTTP, XML 
ou SOAP e também simplifica a construção de um sistema MVC com a integração do Framework spring DATA JPA, que 
utilizando a implementação JPA do Hibernate cria interfaces chamadas Repository simplificando CRUDS básicos, 
bem produtivo para o teste proposto.

</p>

## Como executar os testes
  
  O projeto usa o maven warper (mvnw).
  Para executar os testes de exemplo basta o comando abaixo:
  ```sh
  ./mvnw clean test
  ```

## Requisitos

  1 Existe um exemplo de carga de banco de dados em memória em [ProductDAoExampleTest.java](./src/test/java/br/com/supera/game/store/ProductDAoExampleTest.java)
  2 Os valores exibidos no checkout (frete, subtotal e total) devem ser calculados dinamicamente
  3 O usuário poderá adicionar e remover produtos do carrinho
  4 O usuário poderá ordenar os produtos por preço, popularidade (score) e ordem alfabética.
  5 A cada produto adicionado, deve-se somar R$ 10,00 ao frete.
  6 O frete é grátis para compras acima de R$ 250,00 (sem o frete dos demais produtos).

## Instruções de Execução:
   
  - projeto empacotado em formato .jar (comando para empacotar: mvnw package)
  - para executar abrir o terminal na pasta do arquivo jar criado e rodar o seguinte comando: 
    java -jar PS-Java-main-0.0.1-SNAPSHOT.jar
  - OBS** se o projeto for executado direto do IDE(construído no intellij) o arquivo jar estará na parta target e o
comando de execução será: java -jar target/PS-Java-main-0.0.1-SNAPSHOT.jar no console do IDE.
    
## EndPoints
 - Requisito 5:
   A busca pode ser ordenada por qualquer atributo de product (id, name, price, score, image), devido a 
   integração do framework. OBS** A paginação não foi implementada nesse endpoint.
   
   Busca por produtos:
   http://localhost:8080/api/product/all/{sort}
   Ex: 
   http://localhost:8080/api/product/all/name (busca ordenada por ordem alfabética).
   
   retorno:
   
        [{
          "id":1,
          "name":"Super Mario Odyssey",
          "price":197.88,
          "score":100,
          "image":"super-mario-odyssey.png"
        }]


## O que iremos avaliar

Levaremos em conta os seguintes critérios:

  - Cumprimento dos requisitos
  - Qualidade do projeto de API e fluidez da DX
  - Organização do código e boas práticas
  - Domínio das linguagens, bibliotecas e ferramentas utilizadas
  - Organização dos commits
  - Escrita e cobertura de testes

## Sobre a entrega

  - O prazo para entrega do projeto é para dia 01/02/2021.
  - A API pode ser HTTP, Restful, WSDL/SOAP, HATEOAS ou gRCP mas deverá ser documentado no [README.md](.) como executar/compilar/empacotar o projeto e quais os endpoints solicitados nos requisitos acima. 
  - A versão do Java pode ser atualizada para 11 ou 14.
  - Não existe restrição de framework (EE, Spring, Quarkus etc) mas será melhor avaliado se justificado no [README.md](.) os motivos da decisão.


### Assim que concluir o teste, nos encaminhe a url do repositório onde o teste foi escrito e o pacote { *.jar, *.war, *.ear ...} do projeto através [deste formulário](https://forms.gle/HsvTdsM8qF7mqrzt8)
