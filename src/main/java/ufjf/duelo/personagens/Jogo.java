package ufjf.duelo.personagens;

/**
 *
 * @author Rafael
 */

import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro;

    public Jogo() {
        tabuleiro = new Tabuleiro();
    }

    public void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public void iniciar() {
        int opcaoMenu = 10;
        Scanner ler = new Scanner(System.in);

        while (opcaoMenu != 0) {
            System.out.println("Bem vindos ao duelo");
            System.out.println("1 - Duelo contra outro jogador");
            System.out.println("2 - Duelo contra bot");
            System.out.println("0 - Sair");
            System.out.print("Digite a opcao que voce deseja: ");
            opcaoMenu = ler.nextInt();

            while (opcaoMenu != 0 && opcaoMenu != 1 && opcaoMenu != 2) {
                System.out.print("Opcao invalida, digite novamente: ");
                opcaoMenu = ler.nextInt();
            }

            if (opcaoMenu == 1) 
                jogar(ler, opcaoMenu);
            else if(opcaoMenu == 2)
                jogar(ler,opcaoMenu);
        }
    }

    public void jogar(Scanner ler, int opcaoMenu) {
        Personagem[] jogadores = escolherPersonagens(ler, opcaoMenu);
        int turno = 0;
        String acaoBot = "";
        
        while (jogadores[0].getPontosDeVida() > 0 && jogadores[1].getPontosDeVida() > 0) {
            limparTela();
            System.out.println(acaoBot);
            tabuleiro.atualizar(jogadores);
            tabuleiro.mostrar(jogadores);
            
            if(opcaoMenu == 2 && turno == 1)
                acaoBot = jogadores[turno].escolhaBot(jogadores[1 - turno]);
            else
                escolherAcao(ler, jogadores, turno);

            turno = 1 - turno;
        }

        limparTela();
        System.out.println("O jogador " + jogadores[1 - turno].getNome() + " ganhou!!");
        System.out.println("-----------------------");
        System.out.println();
        
    }

    public Personagem[] escolherPersonagens(Scanner ler, int opcaoMenu ) {
        int personagem;
        String nome;
        Personagem[] jogadores = new Personagem[2];

        for (int i = 0; i < 2; i++) {
            boolean ehBot =false;
            if(opcaoMenu == 2 && i ==1){
                ehBot =true;
            }
            
            limparTela();
            if(ehBot)
                System.out.println("Escolha de perssonagem para o bot");
            else
                System.out.println("Escolha de Personagens jogador " + (i + 1));
            System.out.println("1 - Arqueiro");
            System.out.println("2 - Guerreiro");
            System.out.println("3 - Mago");
            System.out.print("Digite a opcao que voce deseja: ");
            personagem = ler.nextInt();

            while (personagem != 1 && personagem != 2 && personagem != 3) {
                System.out.print("Opcao invalida, digite novamente: ");
                personagem = ler.nextInt();
            }
        
            limparTela();
            if(!ehBot){
                System.out.print("Digite o nome do seu personagem: ");
                nome = ler.next();
            }
            else
                nome = "Bot";
            
            switch (personagem) {
                case 1 -> jogadores[i] = new Arqueiro(nome, ehBot);
                case 2 -> jogadores[i] = new Guerreiro(nome, ehBot);
                case 3 -> jogadores[i] = new Mago(nome, ehBot);
            }
        }

        return jogadores;
    }

    public void escolherAcao(Scanner ler, Personagem[] jogadores, int turno) {
        int acao;

        System.out.println();
        System.out.println("Vez do jogador: " + (turno + 1));
        System.out.println("O que voce deseja fazer: ");
        System.out.println("1 - Mover");
        System.out.println("2 - Atacar");
        System.out.println("3 - Defender");
        System.out.println("4 - Especial");
        System.out.print("Digite a sua acao: ");
        acao = ler.nextInt();

        while (acao != 1 && acao != 2 && acao != 3 && acao != 4) {
            System.out.print("Opcao invalida, digite novamente: ");
            acao = ler.nextInt();
        }

        switch (acao) {
            case 1 -> {
                int erro = 0;
                while (erro == 0) {
                    System.out.println();
                    System.out.println("Para onde voce deseja mover: ");
                    System.out.println("C - Cima");
                    System.out.println("B - Baixo");
                    System.out.println("E - Esquerda");
                    System.out.println("D - Direita");
                    System.out.print("Direcao: ");

                    char direcao = Character.toUpperCase(ler.next().charAt(0));

                    if (direcao != 'C' && direcao != 'B' && direcao != 'E' && direcao != 'D') {
                        System.out.println("Opcao invalida, digite novamente.");
                        continue;
                    }
                    
                    erro = jogadores[turno].mover(direcao, jogadores[1 - turno]);
             
                    if (erro == 0) {
                        System.out.println("Movimento invalido, tente novamente. ");
                    }
                }
            }

            case 2 ->  jogadores[turno].atacar(jogadores[1 - turno]);
     
            case 3 -> jogadores[turno].defender();
         
            case 4 -> jogadores[turno].especial(jogadores[1 - turno]);
        }
    }
}

