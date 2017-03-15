package Magic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Rappresnets the end phase
 *
 * @author Enrico
 */
public class EndPhase implements Phase {
    /**
     * The input stream
     */
    private InputStreamReader reader;
    
    /**
     * The buffer reader
     */
    private BufferedReader myInput;
    /**
     * The playground
     */
    private Playground playground;

    /**
     * The player
     */
    private Player player;

    /**
     * Initalize the end phase
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
        System.out.println("Sono nella End phase");
        //CONTROLLO LE MAGIE PRESENTI IN CAMPO E RIMUOVO TUTTI GLI EFFETTI TRANNE LE STREGONERIE
        for(int i=0;i<player.getMagics().size();i++){
            if(!"Sourcery".equals(player.getMagics().get(i).getType())){
                player.getMagics().get(i).removeCard();
                player.getMagics().remove(i);
            }
        }
        reader = new InputStreamReader(System.in);
        myInput = new BufferedReader(reader);
        System.out.println("Premere passare al prossimo turno.");
        String c;
        try {
            c = myInput.readLine();
        } catch (IOException ex) {
            System.out.println("ahiahiahi");
        }
    }
}
