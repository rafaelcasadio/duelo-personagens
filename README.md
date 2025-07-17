# Duelo de Personagens 🗡️🧙‍♂️🏹

**Projeto de Orientação a Objetos - UFJF (2025)**  
Jogo de estratégia por turnos em Java, simulado no console, onde dois jogadores (humanos ou bot) controlam personagens distintos em um tabuleiro 2D para um duelo.

## 🎮 Descrição

Este é um jogo de duelo entre personagens em um tabuleiro 10x10. Cada jogador controla um único personagem (Mago, Arqueiro ou Guerreiro), com habilidades e atributos distintos. O jogo é executado no terminal com menus interativos e apresenta movimentação, combate e poderes especiais.

## 🧠 Personagens

- **Mago** 🧙‍♂️  
  - Ataque: 10  
  - Defesa: 7  
  - Alcance: 3  
  - Poder especial: Troca de vida com o inimigo  

- **Arqueiro** 🏹  
  - Ataque: 8  
  - Defesa: 5  
  - Alcance: 5  
  - Poder especial: Aumenta o alcance permanentemente  

- **Guerreiro** 🛡️  
  - Ataque: 15  
  - Defesa: 10  
  - Alcance: 1  
  - Poder especial: Ataque dobrado (30)  

## 📜 Regras Principais

- Turnos alternados entre os jogadores
- Ações por turno:
  - Mover (validação de limites e colisão)
  - Atacar (com validação de alcance e cálculo de dano)
  - Defender (restaura a defesa ao valor base)
  - Ativar poder especial
- Vence quem reduzir os PV do oponente a zero
- Tabuleiro exibido em texto a cada turno

## 🤖 Modos de Jogo

- Humano vs Humano
- Humano vs Bot (IA simples com decisões automáticas)

## 💻 Tecnologias e Execução

- Linguagem: **Java 21**
- Build: **Maven**
- Execução no terminal 

## ✅ Requisitos

- JDK 21 instalado
- Maven instalado

## ▶️ Como executar

```bash
# Clonar o projeto
git clone https://github.com/rafaelcasadio/duelo-personagens.git
cd duelo-personagens

# Compilar com Maven
mvn clean install

# Executar
java -jar target/duelo-personagens-1.0-SNAPSHOT.jar
```

## 🔄 Funcionalidades extras
Validação de entradas e ações inválidas

Bot com tomada de decisão automatizada

Exibição do tabuleiro e estado atual após cada turno


## 🙋‍♂️ Autor<br>
Rafael Casadio Costa<br>
GitHub: rafaelcasadio<br>
LinkedIn: https://www.linkedin.com/in/rafael-casadio/
