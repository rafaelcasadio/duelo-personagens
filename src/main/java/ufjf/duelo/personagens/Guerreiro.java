package ufjf.duelo.personagens;

/**
 *
 * @author Rafael
 */

public class Guerreiro extends Personagem {
    
    public Guerreiro(String nome, boolean ehBot) {
        super("Guerreiro " + nome, 15, 10, 1, "Carga Brutal", ehBot);
    }
    
    @Override
    public void defender(){
        setForcaDeDefesa(10);
    }
    
    @Override
    public void especial(Personagem oponente){
        //esse especial não usa o oponente
        setAlcanceDeAtaque(getAlcanceDeAtaque() * 2);
    }

}

