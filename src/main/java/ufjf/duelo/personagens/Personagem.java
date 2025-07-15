package ufjf.duelo.personagens;

/**
 *
 * @author Rafael
 */

import java.util.Random;

import java.util.Random;

public abstract class Personagem {
    private final String nome;
    private int pontosDeVida;
    private final int forcaDeAtaque;
    private int alcanceDeAtaque;
    private int forcaDeDefesa;
    private int i, j;
    private String especial;
    private boolean ehBot;
    
    Random random = new Random();
   
    public Personagem(String nome, int forcaDeAtaque, int forcaDeDefesa, int alcanceDeAtaque, String especial, boolean ehBot) {
        this.nome = nome;
        this.pontosDeVida = 100;
        this.forcaDeAtaque = forcaDeAtaque;
        this.forcaDeDefesa = forcaDeDefesa;
        this.alcanceDeAtaque = alcanceDeAtaque;
        this.i = random.nextInt(10);
        this.j = random.nextInt(10);
        this.especial = especial;
        this.ehBot = ehBot;
    }
    
    public String escolhaBot(Personagem oponente){
        
        if(!ehBot)
            return null ;
       
        if(pontosDeVida < pontosDeVida * 0.3){
            defender();
            return "Bot Defendeu";
        }
        
        int distancia = Math.max(Math.abs(i - oponente.getI()), Math.abs(j - oponente.getJ()));
        if(distancia <= alcanceDeAtaque){
            atacar(oponente);
            return "Bot atacou";
        }
        
        mover(calcularDirecao(oponente), oponente);
        return "Bot moveu";
        
    }
    
    private char calcularDirecao(Personagem oponente) {

        if (Math.abs(i - oponente.getI()) > Math.abs(j - oponente.getJ())) {
            if (i < oponente.getI()) return 'B'; 
            else return 'C';                  
        } else {
            if (j < oponente.getJ()) return 'D';  
            else return 'E';                  
        }
    }

    
    public int mover(char movimento, Personagem oponente){
        switch (movimento){
            case 'C' -> {
                if(i-1 >= 0 && (i-1 != oponente.getI() || j != oponente.getJ()))
                    i -=1;
                else
                    return 0;
            }
            case 'B' -> {
                if(i+1 <=9 && (i+1 != oponente.getI() || j != oponente.getJ()))
                    i +=1;
                else
                    return 0;
            }
            case 'E' -> {
                if(j-1 >=0 && (i != oponente.getI() || j-1 != oponente.getJ()))
                    j -=1;
                else
                    return 0;
            }
            case 'D' -> {
                if(j+1 <=9 && (i != oponente.getI() || j+1 != oponente.getJ()))
                    j +=1;
                else
                    return 0;
            }
        }
        
        return 1;
    }
    
    public void atacar(Personagem alvo){
        int distancia = Math.max(Math.abs(i - alvo.getI()), Math.abs(j - alvo.getJ()));
        
        if(distancia <= alcanceDeAtaque){
            int dano = Math.max(0, forcaDeAtaque - alvo.getForcaDeDefesa());
            if(dano > 0 ){
                alvo.pontosDeVida=(alvo.getPontosDeVida() - dano);
            }
            alvo.setForcaDeDefesa(Math.max(0, alvo.getForcaDeDefesa() - forcaDeAtaque));
        }
    }
    
    public abstract void defender();
    
    public abstract void especial(Personagem oponente);
       
   public int getI(){
       return i;
   }
   
    public int getJ(){
       return j;
   }
    
    public String getNome() {
        return nome;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public int getForcaDeAtaque() {
        return forcaDeAtaque;
    }

    public int getForcaDeDefesa() {
        return forcaDeDefesa;
    }

    public int getAlcanceDeAtaque() {
        return alcanceDeAtaque;
    }
    
    public String getEspecial() {
        return especial;
    }
    
     public boolean getEhBot() {
        return ehBot;
    }

    public void setForcaDeDefesa(int forcaDeDefesa) {
        this.forcaDeDefesa = forcaDeDefesa;
    }
    
    public void setAlcanceDeAtaque(int alcanceDeAtaque){
        this.alcanceDeAtaque = alcanceDeAtaque;
    }  
    
    public void setPontosDeVida(int pontosDeVida){
        this.pontosDeVida = pontosDeVida;
    }
}
