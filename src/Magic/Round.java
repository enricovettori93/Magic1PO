package Magic;

import java.util.ArrayList;
import java.util.List;

/**
 * Rappresents a Round
 *
 * @author Enrico
 */
public class Round {

    private Playground playground;
    private Player player;
    List<Phase> fasi;
    /* counterPhase è un vettore che tiene conto di quante volte deve essere presente nel turno una determinata fase
     * codifica: 
     *  0 - DrawPhase
     *  1 - UntapPhase
     *  2 - MainPhase
     *  3 - CombatPhase
     *  4 - EndPhase
     */
    Integer[] counterPhase;

    public Round(Playground playground, Player player) {
        this.playground = playground;
        this.player = player;
        fasi = new ArrayList<>();
        
        counterPhase= new Integer[5];
        for(int i = 0; i<5; i++)
            counterPhase[i]=1;
        
        creaTurno();
    }

    private void creaTurno() {
        int i;
        /* done è true se il vettore counterPhase è stato svuotato interamente*/
        boolean done = false;
        /*
        Eventuali effetti che possono modificare il numero di fasi in un turno
        vengono gestiti dal metodo execute() della carta che va a modificare
        il vettore counterPhase modificando l'elemento presente all'indice 
        corrispondente alla fase
        */
        
        while(!done){
            for(i=0;i<5;i++){
                if(counterPhase[i]!=0){
                    switch(i){
                        case 0 : 
                            fasi.add(new DrawPhase(playground, player));
                            counterPhase[i]--;
                            break;
                        case 1 :
                            if(player.isInGame()){
                                fasi.add(new UntapPhase(playground, player));
                                counterPhase[i]--;
                            }
                            break;
                        case 2 :
                            if(player.isInGame()){
                                fasi.add(new MainPhase(playground, player));
                                counterPhase[i]--;
                            }
                            break;
                        case 3 :
                            if(player.isInGame()){
                                fasi.add(new CombatPhase(playground, player));
                                counterPhase[i]--;
                            }
                            break;
                        case 4 :
                            if(player.isInGame()){
                                fasi.add(new EndPhase(playground, player));
                                counterPhase[i]--;
                            }
                            break;
                    }
                }                
            }
            done=true;
            for(i=0;i<5;i++){
                if(counterPhase[i]!=0)
                    done = false;
            }
                       
        }
        
        
        if(player.isInGame()){
            for(i = 0; i<5; i++)
                counterPhase[i]=1;
            
            System.out.println("\n");
            playground.printPlayground(player);
            
            for (i = 0; i < fasi.size(); i++) {
                fasi.get(i).initPhase();
            }
        }
    }
}
