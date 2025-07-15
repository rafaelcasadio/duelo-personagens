package ufjf.duelo.personagens;

/**
 *
 * @author Rafael
 */

public class Mago extends Personagem {
    
    public Mago(String nome, boolean ehBot) {
        super("Mago " + nome, 10, 7, 3, "Trocar Vida", ehBot);
    }
    
    @Override
    public void defender(){
        setForcaDeDefesa(7);
    }
    
    @Override
    public void especial(Personagem oponente){
        int aux = getPontosDeVida();
        setPontosDeVida(oponente.getPontosDeVida());
        oponente.setPontosDeVida(aux);
    }

}
