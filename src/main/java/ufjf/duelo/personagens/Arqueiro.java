package ufjf.duelo.personagens;

/**
 *
 * @author Rafael
 */

public class Arqueiro extends Personagem {

    public Arqueiro(String nome, boolean ehBot) {
        super("Arqueiro " + nome, 8, 5, 5, "Flecha Precisa", ehBot);
    }
    
    @Override
    public void defender(){
        setForcaDeDefesa(5);
    }
    
    @Override
    public void especial(Personagem oponente){
        //esse especial não usa o oponente
        setAlcanceDeAtaque(getAlcanceDeAtaque() + 1);
    }

}

