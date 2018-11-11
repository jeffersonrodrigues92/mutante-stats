# MUTANTE - Mercado Livre

Magneto quer recrutar tantos mutantes quanto possível para lutar contra os X-Men.

Ele contratou você para desenvolver um projeto que detecta se um
Humano é mutante baseado em sua sequência de DNA.

## Sobre o Ambiente

- Ambiente desenvolvido na linguagem Java
- 100% serveless

## URL API 

URL in AWS API Gateway: https://zvgr0hmrr1.execute-api.us-east-1.amazonaws.com/prd/mutant

## SERVICES
Verify mutant DNA
Request:

POST /mutants
Request body (exemple mutant DNA):
  ```json
  {"dna":["ATGCGA", "CAGGGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]}
```
Response:
  200 OK

Request body (exemple human DNA):
```json
  {"dna":["AATACT", "CCCAGA", "GGGATT", "AATTCC", "AGAGCG", "TCACTG"]}
  ```
Response:
  403 Forbidden





