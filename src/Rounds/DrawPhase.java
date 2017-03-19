package Magic.Rounds;

import Magic.Game.Player;
import Magic.Game.Playground;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Represents draw phase
 *
 * @author Enrico
 */
public class DrawPhase implements Phase {

    /**
     * Playground
     */
    private Playground playground;

    /**
     * Player
     */
    private Player player;

    /**
     * Input stream
     */
    private InputStreamReader reader;

    /**
     * Buffer
     */
    private BufferedReader myInput;

    /**
     * Variable that checkes if program launch an exception
     */
    private boolean throwedexc = false;
    
    /**
     * Initialize Draw pahse
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
     * The method checkEmptyDeck checks if deck is empty. If deck is empty,
     * the player is setted as not in game.
     */
    private void checkEmptyDeck() {
        if (player.carteMazzo() == 0) {
            player.setInGioco(false);
        }
    }

    /**
     * The method checkHand checks if player has the correct number of cards in his hand, 
     * otherwise the player must discard a card.
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
                    //No exceptions generated
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
