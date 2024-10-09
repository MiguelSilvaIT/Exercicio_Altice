
# 🚀 Projeto LabSeq - Desafio Altice Labs

![Java](https://img.shields.io/badge/java-17%2B-blue)

![Quarkus](https://img.shields.io/badge/Quarkus-2.x-blue)

![Last Commit](https://img.shields.io/github/last-commit/MiguelSilvaIT/Exercicio_Altice)



Bem-vindo ao **LabSeq**, um projeto que  resolve um problema de cálculo recursivo avançado, com foco na eficiência e boas práticas de programação . Este repositório apresenta uma implementação completa da sequência LabSeq, desenvolvida com Quarkus e Docker, e inclui uma interface frontend em HTML, CSS e JavaScript.

## 🎯 Objetivo do Projeto

Desenvolver um serviço REST para calcular a sequência **LabSeq**, que utiliza caching e um design eficiente para garantir que valores elevados, como `l(10000)`, sejam processados em menos de 10 segundos. O frontend permite que os utilizadores explorem o cálculo de forma intuitiva.

## 🧠 Estrutura da Sequência LabSeq

A sequência LabSeq, \( l(n) \), é definida da seguinte forma:

- **Condições iniciais**:
  - \( l(0) = 0 \)
  - \( l(1) = 1 \)
  - \( l(2) = 0 \)
  - \( l(3) = 1 \)
- **Caso geral (para n > 3)**:
  - \( l(n) = l(n-4) + l(n-3) \)

Por exemplo, os primeiros valores da sequência são:
```
0, 1, 0, 1, 1, 1, 1, 2, 2, 2, 3, ...
```

O endpoint é acessível através do formato:  
```http://localhost:8080/labseq/{n}```  
onde `{n}` representa o índice desejado da sequência.

## 🛠 Tecnologias Utilizadas

### Backend
- **[Quarkus](https://quarkus.io)**: Framework  Java com foco em velocidade e baixo uso de memória.
- **Caching Avançado**: Implementado para reduzir o tempo de cálculo, especialmente em chamadas repetidas de índices elevados.
- **Documentação da API**: Disponível via Swagger para facilitar a integração.

### Frontend
- **HTML, CSS, JavaScript**: Interface simples, mas eficiente, que permite a interação direta com a API.
- **Docker**: O backend é containerizado para fácil implantação e escalabilidade.

### Documentação
- **Swagger**: Documentação detalhada da API, localizada em `http://localhost:8080/q/swagger-ui`.

## 🚀 Instruções de Execução

### Clonagem do Repositório

Clone o repositório para ter acesso ao código-fonte:
```bash
git clone https://github.com/MiguelSilvaIT/Exercicio_Altice.git
cd Exercicio_Altice
```

### Backend - Quarkus com Docker

#### 1. Construção da Imagem Docker
Crie a imagem Docker do backend:
```bash
docker build -t labseq-backend .
```

#### 2. Execução do Container
Execute o container:
```bash
docker run -p 8080:8080 labseq-backend
```

Após a execução, a API REST estará disponível em `http://localhost:8080`.

### Frontend - Interface Gráfica

Basta abrir o ficheiro `index.html` num navegador para aceder à interface do utilizador.

## 🧩 Arquitetura e Design

1. **Desempenho**: A implementação é otimizada para cálculos rápidos, com caching em diferentes camadas para minimizar recalculações.
2. **Escalabilidade**: A estrutura baseada em Docker permite implantação em larga escala, se necessário.
3. **Melhores Práticas**: Código organizado, com tratamento de erros e modularidade clara para manutenção e extensibilidade.

## 📖 Documentação Completa da API

A documentação OpenAPI (Swagger) pode ser acedida em [Swagger UI](http://localhost:8080/q/swagger-ui) ao executar o backend.

## 🔍 Assunções e Limitações

Este projeto assume:

- **Caching Completo**: Utilizamos caching para melhorar o desempenho geral. Valores já calculados são armazenados para chamadas subsequentes.
- **Manutenção de Performance**: Testado para garantir o cálculo de valores altos, como `l(10000)`, em menos de 10 segundos.

## 🌱 Possibilidades de Expansão

- **Frontend Angular**: Para interfaces mais dinâmicas e ricas, um frontend em Angular está nos planos de expansão.
- **Deployment em Cloud**: Facilidade de expansão para plataformas como Kubernetes para escalabilidade empresarial.

---

> **Nota**: Este projeto foi desenvolvido com atenção aos requisitos de performance e boas práticas de desenvolvimento em Java, visando fornecer um exemplo robusto e escalável.
