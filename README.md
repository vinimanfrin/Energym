# 🔋Energym

## Integrantes:

- 552293 - Vinicius Monteiro Manfrin
- 552302 - Samara De Oliveira Moreira
- 551261 - Giovanni Sguizzardi Conde
- 98057 - Nicolas Eiti Inohue
- 99841 - Marcel Prado Soddano


## Descrição

Este é um sistema de gerenciamento de Academia para registrar e consultar exercícios aos praticantes brevemente cadastrados. Desenvolvido com *Java 17*, utilizando o framework *Spring Boot* e *Thymeleaf* para a camada de visualização. O sistema tem como objetivo gerenciar *academias*,*praticantes* e *exercícios*.

## Funcionalidades

- *Registro e Login de Academias*
- *Registro de Exercícios*
- *Visualização de Praticantes*

## Tecnologias Utilizadas
- *Java 17*
- *Spring Boot*
- *Thymeleaf* (para renderização de páginas HTML)
- *Banco de dados H2* (em memória) para desenvolvimento
- *Banco de dados Oracle* (em memória) para produção
- *Javascript*

## Como Executar

### Pré-requisitos

- Java 17 instalado
- Maven para gerenciar as dependências
- Docker

### Passos para execução

1. Clone o repositório:

   ```bash
   git clone https://github.com/vinimanfrin/Energym

2. Acesse o diretório em que você clonou o projeto:
    ```bash
    cd diretório

3. Baixe as dependências e compile o projeto:
    ```bash
    mvn clean install

4. Faça o clone do worker do RabbitMQ e o configure de acordo com as instruções em:
    ```bash
    https://github.com/vinimanfrin/EnergynWorker

5. Inicie a aplicação:
    ```bash
    mvn spring-boot:run

6. Acesse a aplicação e navegue entre as páginas no seu navegador em:
    ```bash
    http://localhost:8080
