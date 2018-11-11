## MUTANTE - Mercado Livre

Magneto quer recrutar tantos mutantes quanto possível para lutar contra os X-Men.

Ele contratou você para desenvolver um projeto que detecta se um
Humano é mutante baseado em sua sequência de DNA.

## Sobre o Ambiente

- Ambiente desenvolvido na linguagem Java
- 100% serverless
- Alta disponibilidade

## Tecnologias
- AWS API Gateway
- AWS Lambda
- AWS DynamboDB
- AWS CloudWatch 

## URL API 

URL in AWS API Gateway: https://zvgr0hmrr1.execute-api.us-east-1.amazonaws.com/prd/mutant

## SERVIÇOS
Verifica DNA Mutante
Request:

POST /mutant
Request body (Exemplo DNA Mutante):
  ```json
  {"dna":["ATGCGA", "CAGGGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]}
```
Response:
  200 OK

Request body (Exemplo DNA Humano):
```json
  {"dna":["AATACT", "CCCAGA", "GGGATT", "AATTCC", "AGAGCG", "TCACTG"]}
  ```
Response:
  403 Forbidden





