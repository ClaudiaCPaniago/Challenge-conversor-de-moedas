# Challenge-conversor-de-moedas

Este é um projeto de conversor de moedas desenvolvido em Java, que utiliza a **[ExchangeRate-API](https://www.exchangerate-api.com/)** para obter taxas de câmbio atualizadas. O usuário pode escolher entre várias opções de conversão e inserir o valor desejado para obter o valor convertido.
 Este projeto faz parte de um desafio do programa ONE ORACLE G8.

 ## Certificação
 
Fui reconhecida com a seguinte insígnia pelo programa ONE ORACLE:
<br>
 ![badge](Badge-Conversor.png)

## Pré-requisitos
Antes de executar o projeto, certifique-se de ter:

* Java 17 ou superior instalado.
* Uma chave de API válida da ExchangeRate-API.

  ##  Funcionalidades

- Conversão entre diferentes pares de moedas:
  - Dólar (USD) ↔ Peso argentino (ARS)
  - Dólar (USD) ↔ Real brasileiro (BRL)
  - Dólar (USD) ↔ Peso colombiano (COP)
- Leitura dinâmica do valor a ser convertido
- Requisições à API de câmbio em tempo real
- Repetição contínua até que o usuário escolha sair
- Integração com a biblioteca **Gson** para leitura do JSON

##  Tecnologias utilizadas

- Java 
- [ExchangeRate-API](https://www.exchangerate-api.com/)
- Biblioteca [Gson](https://github.com/google/gson)
- IntelliJ IDEA
  
##  Exemplo de uso

```
Seja bem-vindo ao Conversor de Moeda 
1) Dólar >> Peso argentino
2) Peso argentino >> Dólar
3) Dólar >> Real brasileiro
4) Real brasileiro >> Dólar
5) Dólar >> Peso colombiano
6) Peso colombiano >> Dólar
7) Sair
Escolha uma opção válida: 3
Digite o valor a ser convertido: 100
Valor convertido: 520.00 BRL
```
