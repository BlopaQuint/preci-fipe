# PRECIFIPE

PRECIFIPE é uma aplicação desenvolvida em **Java** com **Spring Boot** que permite consultar informações sobre veículos diretamente da **Tabela FIPE**.

## 🧰 Funcionalidades

- Seleção entre carro, moto ou caminhão
- Consulta por marca, modelo e ano de fabricação
- Exibição detalhada com valor, combustível, marca e modelo
- Filtragem de modelos por nome digitado
- Ordenação alfabética das listas
- Consumo da API FIPE com `HttpClient`
- Desserialização de dados usando Jackson

## 🔧 Tecnologias utilizadas

- Java 21+
- Spring Boot
- Maven Wrapper
- Jackson Databind
- API pública da FIPE:  
  [https://parallelum.com.br/fipe/api/v1/](https://parallelum.com.br/fipe/api/v1/)

## ▶️ Como executar

### Sem o Maven instalado

O projeto inclui o Maven Wrapper, permitindo execução mesmo sem Maven instalado globalmente:

```bash
./mvnw spring-boot:run
```

### Com Maven instalado

```bash
mvn spring-boot:run
```

## 👤 Autor

Desenvolvido por **Pablo Quintiliano**  
Projeto criado com foco em aprendizado, boas práticas e profissionalismo no código.

## 📄 Licença

Este projeto está licenciado sob os termos da **MIT License**.  
Você pode usar, modificar e distribuir como quiser — aproveite!