# 🗓️ Agenda Eletrônica em Java – WebQuest 3

## 📘 Curso
**Licenciatura em Ciência da Computação**

**Disciplina:** Programação II  
**Carga Horária:** 90h  
**Professor:** Augusto César Ferreira de Miranda Oliveira   

---

## 🎯 Título
**Desenvolvendo uma Agenda Eletrônica com Java e Manipulação de Arquivos**

---

## 🧩 Introdução
Este projeto consiste no desenvolvimento de uma **agenda eletrônica em Java**, proposta na **3ª WebQuest** da disciplina **Programação II**.  
O sistema foi criado para gerenciar contatos de forma eficiente, aplicando os principais conceitos da **Programação Orientada a Objetos (POO)**.  

A aplicação permite:
- Adicionar, buscar, remover e listar contatos;
- Persistir dados em arquivos **CSV**;
- Tratar erros e exceções personalizadas;
- Interagir com o usuário via **console**;
- Buscar contatos por **domínio de e-mail**;
- Listar contatos em **ordem alfabética**.

---

## 👩‍💻 Integrantes da Equipe
 - José Paulo Cauás Tenório 
 - Juliana Dias da Silva 
 - Karina Viana Caldas da Silva 
 - Petrus Oliveira de Andrade Cruz 
 - Thiago Nicolas Ananias da Silva

> ⚠️ Todos os nomes dos integrantes devem constar também nos arquivos-fonte como comentários.

---

## 🧠 Habilidades Desenvolvidas
- Implementação de **classes** com **encapsulamento** adequado;  
- Utilização de **coleções (ArrayList, HashMap)** para gerenciar dados;  
- Criação e **tratamento de exceções personalizadas**;  
- **Leitura e gravação de arquivos CSV** com `BufferedReader` e `BufferedWriter`;  
- Desenvolvimento de **menu interativo** com `Scanner`;  
- Aplicação de **algoritmos de ordenação e busca**.

---

## 🧱 Estrutura do Projeto

AgendaEletronica/
│
├── src/ 
│   ├── model/ 
│   │   └── Contato.java 
│   │ 
│   ├── service/ 
│   │   ├── GerenciadorContatos.java 
│   │   └── AgendaManager.java 
│   │ 
│   ├── exception/ 
│   │   ├── ContatoExistenteException.java 
│   │   └── ContatoNaoEncontradoException.java 
│   │ 
│   └── app/ 
│       └── AgendaApplication.java 
│ 
└── contatos.csv

