# Coleta FIAP

Aplicação API 

## Pré-requisitos

- Java 21
- Git
- Docker

## Build e execução

```sh
docker compose up --build
```

## Testes unitários (validação)

./mvnw test

## Coleta API na Azure (Docs)

https://fiap-coleta-api-gbfhfpbrftbgd4ct.brazilsouth-01.azurewebsites.net/swagger-ui/index.html

![](/assets/images/swagger-coleta-fiap.png)

## Parar e execução da Aplicação

```sh
docker compose down
```

