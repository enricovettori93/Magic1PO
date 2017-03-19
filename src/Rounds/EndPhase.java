package Magic.Rounds;

import Magic.Game.Player;
import Magic.Game.Playground;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Represents the end phase
 *
 * @author Enrico
 */
public class EndPhase implements Phase {
    /**
     * Input stream
     */
    private InputStreamReader reader;
    
    /**
     * Buffer's reader
     */
    private BufferedReader myInput;
    /**
     * Playground
     */
    private Playground playground;

    /**
     * Player
     */
    private Player player;

    /**
     * Initialize end phase
     *
     * @param playground The playground
     * @param player The player
     */
    public EndPhase(Playground playground, Player player) {
        this.playground = playground;
        this.player = player;
    }

    @Override
    public void initPhase() {
        System.out.println("Sono nella End phase.");
        //I remove the cards that have been played to the stack to cancel the effects
        playground.removePlayedCardStack();
        //I control magic cards present in the playground and I remove all effects except sorcery
        for(int i=0;i<player.getMagics().size();i++){
            if(!"Sourcery".equals(player.getMagics().get(i).getType())){
                //if(!"Istant".equals(player.getMagics().get(i).getType()))
                    player.getMagics().get(i).removeCard();
                player.getMagics().remove(i);
            }
        }
        reader = new InputStreamReader(System.in);
        myInput = new BufferedReader(reader);
        System.out.println("Premere INVIO per passare al prossimo turno.");
        String c;
        try {
            c = myInput.readLine();
        } catch (IOException ex) {
            System.out.println("ahiahiahi");
        }
    }
}
