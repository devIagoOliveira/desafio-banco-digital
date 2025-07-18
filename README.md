# 💳 Desafio Banco Digital DIO Santander Bootcamp

Um sistema bancário simples feito em Java, com operações básicas como criação de conta, depósito, saque, impressão de extrato e listagem de contas/clientes.

## 📌 Funcionalidades

- Criar conta corrente ou poupança
- Depósito e saque por nome do cliente
- Impressão de extrato
- Listagem de contas e clientes
- Contas pré-cadastradas (João e Maria)

## 🛠 Tecnologias

- Programação Orientada a Objetos
- Scanner para entrada de dados
- Estruturas `List`, `ArrayList` e `switch-case`


## 📸 Exemplo do menu

```
==================
IAGO OLIVEIRA BANK      
==================
1. Criar uma conta
2. Imprimir Extrato
3. Depositar
4. Sacar
5. Lista de Clientes
6. Lista de Contas
0. Sair
```
## 📁 Estrutura do projeto

O sistema é composto por:

- Main.java: Lógica principal do sistema

- Cliente.java: Classe que representa o cliente

- Conta.java: Classe que representa a conta e suas operações

- ContaCorrente.java e ContaPoupanca.java: Tipos de conta sobrescrevendo o método `imprimirExtrato()`

- Banco.java: Representa o banco, armazena contas e clientes

## 🎥 Vídeo Live Coding

[Desafio Banco Digital](https://youtu.be/Z_fC9NoRxiM)
