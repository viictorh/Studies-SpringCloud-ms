# Studies-SpringCloud-ms
Estudo sobre utilização de Microserviços com springcloud tendo como referencia o curso da Udemy https://www.udemy.com/course/microsservicos-java-spring-cloud/

## Arquitetura Final

![Arquitetura](/doc-images/arquitetura_do_projeto.pdf.png)

## hr-api-gateway-zuul

## hr-eureka-server

## hr-payroll

## hr-worker

## hr-user
Projeto responsável por controlar as informações dos usuários e seus perfis. 
Por padrão, o spring-security utiliza o nome do perfil como **ROLE_**perfil

## hr-oauth
Microserviço responsável pela autorização das requisições no servidor. Ele faz a validação do usuário utilizando o hr-user, para localizar o usuário, utilizando Feign, e gera o token JWT permitindo a autenticação e posteriores requisições nos recursos

## hr-config-server

Este projeto possibilita a configuração de em um repositorio. Com ele, todas as configurações podem ser buscadas em algum local e utilizadas pelas aplicações. 
Normalmente, haveria um repositorio especifico apenas para configurações, mas, para manter todos os arquivos relacionados ao estudo no mesmo repositorio, utilizei a raiz deste repositorio.

Os arquivos properties com o nome do projeto são relacionados a estas configurações. Por exemplo: hr-worker.properties



