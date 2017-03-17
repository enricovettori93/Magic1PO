package Magic.Rounds;

import Magic.Game.Player;
import Magic.Game.Playground;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Rappresnets the draw phase
 *
 * @author Enrico
 */
public class DrawPhase implements Phase {

    /**
     * The playground
     */
    private Playground playground;

    /**
     * The player
     */
    private Player player;

    /**
     * The input stream
     */
    private InputStreamReader reader;

    /**
     * The buffer
     */
    private BufferedReader myInput;

    /**
     * variable that check if program launch an exception
     */
    private boolean throwedexc = false;
    
    /**
     * Initalize the Draw pahse
     *
     * @param playground The playground
     * @param player The player
     */
    public DrawPhase(Playground playground, Player player) {
        this.playground = playground;
        this.player = player;
        reader = new InputStreamReader(System.in);
        myInput = new BufferedReader(reader);
    }

    @Override
    public void initPhase() {
        System.out.println("\nInizio del turno di " + player.getNome() + ". Draw Phase.");
        System.out.println("\n");
        playground.printPlayground(player);
        checkEmptyDeck();
        if (player.isInGame()) {
            player.estraiCarta();
            checkHand();
        }
    }

    /**
     * Checks if the player has or not left cards in deck. If no cards are left,
     * the player is setted as no more in game.
     */
    private void checkEmptyDeck() {
        if (player.carteMazzo() == 0) {
            player.setInGioco(false);
        }
    }

    /**
     * Chacks if the player has the right number of max cards in hand. If not,
     * let him choose which reject
     */
    private void checkHand() {
        while (player.getMano().size() > 7) {
            System.out.println(player.getNome() + " hai troppe carte in mano, quali vuoi scartare (indicare con un intero l'indice della carta da rimuovere)?");
            player.stampaMano();
            System.out.println("");
            int input = 0;
            do {
                throwedexc=false;
                try {
                    System.out.print("\n-> ");
                    try{
                        input = Integer.parseInt(myInput.readLine());
                    }
                    catch(NumberFormatException exc){
                        throwedexc=true;
                        System.out.println("Input errato.");
                    }
                    //NON SONO STATE GENERATE ECCEZIONI
                    if(throwedexc == false){
                        if ((input < 1) || (input > player.getMano().size() + 1)) {
                            System.out.println("Indice errato");
                        } else {
                            player.getMano().remove(input - 1);
                        }
                    }
                } catch (IOException ex) {
                    System.out.println("Si è verificato un errore: " + ex);
                }
            } while (((input > player.getMano().size() + 1) || (input < 1)) && throwedexc == true);
        }
    }
}