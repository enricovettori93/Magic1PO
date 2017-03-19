package Magic.Rounds;

import Magic.Game.Player;
import Magic.Game.Playground;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Round
 *
 * @author Enrico
 */
public class Round {

    private Playground playground;
    private Player player;
    List<Phase> fasi;
    /* counterPhase is an array that counts how many times a phase must be present during the turn.
     * codification: 
     *  0 - DrawPhase
     *  1 - UntapPhase
     *  2 - MainPhase
     *  3 - CombatPhase
     */
    Integer[] counterPhase;

    public Round(Playground playground, Player player) {
        this.playground = playground;
        this.player = player;
        fasi = new ArrayList<>();
        
        counterPhase= new Integer[4];
        for(int i = 0; i<4; i++)
            counterPhase[i]=1;
        
        creaTurno();
    }

    private void creaTurno() {
        int i;
        //done is true if the array counterPhase is completely empty
        boolean done = false;
        //Possible effects that can change the number of phases in a turn are managed 
        //by the method execute() of the card. This method changes the array
        //counterPhase, then it changes the element present to the index of the phase
        
        while(!done){
            for(i=0;i<4;i++){
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
                                fasi.add(new CombatPhase(playground, player));
                                counterPhase[i]--;
                            }
                            break;
                        case 3 :
                            if(player.isInGame()){
                                fasi.add(new MainPhase(playground, player));
                                counterPhase[i]--;
                            }
                            break;
                    }
                }                
            }
            done=true;
            for(i=0;i<4;i++){
                if(counterPhase[i]!=0)
                    done = false;
            }
                       
        }
        
        if(player.isInGame())
            fasi.add(new EndPhase(playground, player));
        
        
        
        if(player.isInGame()){
            for(i = 0; i<4; i++)
                counterPhase[i]=1;
            
            for (i = 0; i < fasi.size(); i++) {
                if(player.isInGame())
                    fasi.get(i).initPhase();
            }
        }
    }
    
    /*Methods to add or remove phases in a turn*/
    public void addDrawPhase(){
        counterPhase[0]++;
    }
    public void removeDrawPhase(){
        counterPhase[0]--;
    }
    
    public void addUntapPhase(){
        counterPhase[1]++;
    }
    public void removeUntapPhase(){
        counterPhase[1]--;
    }
    
    public void addCombatPhase(){
        counterPhase[2]++;
    }
    public void removeCombatPhase(){
        counterPhase[2]--;
    }
    
    public void addMainPhase(){
        counterPhase[3]++;
    }
    public void removeMainPhase(){
        counterPhase[3]--;
    }
}
