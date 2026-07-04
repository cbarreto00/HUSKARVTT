# 🐉 HUSKAR VTT

## 1. Tema e escopo do projeto:

Plataforma Virtual Tabletop que visa a criação de mesas de RPG com interação virtual entre usuários, abordando diferentes ferramentas para uso ao decorrer da experiência dos jogadores. Baseado nos livros, dados e formatos do famoso RPG Dungeons & Dragons. Com objetivo de superar e inovar a plataforma já existente Roll20, que apesar de possuir uma ótima perspectiva, é alvo de diversas deficiências notadas pelos usuários, essas que só são otimizadas na sua versão paga, o nosso projeto de RPG Virtual aborda a democratização através de um uso de qualidade e totalmente gratuito.
De início, o projeto terá sua interface gráfica em desktop, com planejamento de ser multiplataforma (mobile, web).
 
## 2. Referências e projetos semelhantes:

* **Roll20:** VTT que funciona no navegador, uso gratuito com oferecimento de serviços pagos, suporte nativo de grandes sistemas, interação entre usuários.
* **D&D Beyond:** VTT que é a plataforma digital oficial do Dungeons & Dragons, via web e mobile, uso gratuito com serviços pagos de marketplace para desbloquear conteúdo.
* **Livro do Jogador e Livro do Mestre Dungeons & Dragons 5º Ed.:** fornece o sistema de regras e gerenciamento para personagens, combate, exploração, magias, equipamentos e talentos.

## 3. Arquitetura e Modelagem: 

Estruturado seguindo as lógicas de Programação Orientada a Objetos e padrão arquitetural MVC (Model-View-Controller), utilizando o banco de dados SQLite, intermediado pelo framework ORMLite.

### 3.1 Diagramas:

#### 3.1.1 Diagrama de Caso de Uso Geral

<img width="717" height="282" alt="Diagrama de Caso de Uso" src="https://github.com/user-attachments/assets/4ea1bcfe-6bd9-4aa2-b924-41ce3489183d" />

#### 3.1.2 Diagrama de Caso de Uso (Menu)

<img width="295" height="306" alt="diagramacasodeuso2" src="https://github.com/user-attachments/assets/651b46b4-e826-4879-bc03-9c5aa0d2f927" />

#### 3.1.3 Diagrama de Classes

<img width="453" height="820" alt="Diagrama de Classes" src="https://github.com/user-attachments/assets/b3bfa52f-7c1f-4d9f-a714-298bf63ce2ce" />

#### 3.1.4 Diagrama de Fluxo 

<img width="1530" height="785" alt="Diagrama de Fluxo" src="https://github.com/user-attachments/assets/f28e4786-1a04-46b0-9a32-4c59eb357448" />


## 4.Tutorial de Build e Execução

### 4.1 Pré-requisitos

Antes de iniciar, certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

* **Git**: Para clonar o repositório.
* **Java Development Kit (JDK)**: Versão 17 ou superior.
* **Apache Maven**:  3.8 ou superior
---

### Passo 1: Clonar o Repositório

Abra o terminal (ou prompt de comando) e execute o comando abaixo para clonar o projeto para o seu ambiente local:

```bash
git clone https://github.com/poo-ec-2026-1/g11.git
```
Em seguida, navegue para a pasta do projeto:

```bash
cd g11
```

### Passo 2: Buildar (Compilar) o Projeto

Utilizar o Maven para resolver todas as dependências.

```bash
mvn javafx:run
```