package ufjf.duelo.personagens;

/**
 *
 * @author Rafael
 */

public class Tabuleiro {
    private int[][] matriz;
    private final int tamanho = 10;

    public Tabuleiro() {
        matriz = new int[tamanho][tamanho];
    }

    public void atualizar(Personagem[] jogadores) {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                matriz[i][j] = 0;
            }
        }
        matriz[jogadores[0].getI()][jogadores[0].getJ()] = 1;
        matriz[jogadores[1].getI()][jogadores[1].getJ()] = 2;
    }

    public void mostrar(Personagem[] jogadores) {
      
        System.out.println("   -------------------------------");
    
        for (int i = 0; i < tamanho; i++) {
            
            System.out.print(" | ");
            
            for (int j = 0; j < tamanho; j++) {
                switch (matriz[i][j]) {
                    case 1 -> System.out.print("J1 ");
                    case 2 ->{
                        if(jogadores[1].getEhBot() == false)
                            System.out.print("J2 ");
                        else
                            System.out.print("B  ");
                    }
                    default -> System.out.print(".  ");
                }
            }
            System.out.println("|");
        }
    
        System.out.println("   -------------------------------");
        System.out.println();
        
        System.out.println();
        System.out.println(jogadores[0].getNome() + " --- " +jogadores[1].getNome());
        System.out.println(jogadores[0].getPontosDeVida() + " - vida - " + jogadores[1].getPontosDeVida());
        System.out.println(jogadores[0].getForcaDeDefesa() + " - forca  de defesa - " + jogadores[1].getForcaDeDefesa());
        System.out.println(jogadores[0].getForcaDeAtaque() + " - forca  de ataque - " + jogadores[1].getForcaDeAtaque());
        System.out.println(jogadores[0].getAlcanceDeAtaque() + " - alcande de ataque - " + jogadores[1].getAlcanceDeAtaque());
        System.out.println(jogadores[0].getEspecial() + " - Especial - " + jogadores[1].getEspecial());
    }
}

