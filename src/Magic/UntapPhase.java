package Magic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Rappresents the untap phase
 *
 * @author Enrico
 */
public class UntapPhase implements Phase {

    /**
     * The injected playground. TODO: inject the istance
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
     * The buffer reader
     */
    private BufferedReader myInput;

    /**
     * Inits the UntapPhase
     * @param playground The injected palyground
     * @param player The player
     */
    public UntapPhase(Playground playground, Player player) {
        this.playground = playground;
        this.player = player;
        reader = new InputStreamReader(System.in);
        myInput = new BufferedReader(reader);
    }

    @Override
    public void initPhase() {
        System.out.println("Sono nella untap phase");
        //DEVO ACCEDERE ALLE LISTE DI MOSTRI IN CAMPO PER POTER SCEGLIERE QUALI TAPPARE/NON TAPPARE
        //SONO NEL GIOCATORE 1
        if (this.player.equals(this.playground.player1)) {
            this.handlePlayer(playground.player1);
        } else {
            this.handlePlayer(playground.player2);
        }

    }

    /**
     * Handle the untap phase for a player
     *
     * @param player The player
     */
    private void handlePlayer(Player player) {
        if (player.getMonsters().size() > 0) {
            System.out.println(player.getNome() + " quali mostri vuoi tappare (indicare con un numero intero l'indice, -1 per non tappare nulla)?");
            for (int i = 0; i < player.getMonsters().size(); i++) {
                System.out.print((i+1) + "-" + player.getMonsters().get(i).getName() + " ");
            }
            try {
                System.out.print("\n-> ");
                int input = Integer.parseInt(myInput.readLine());
                if (input != -1) {
                    if ((input < 1) || (input > player.getMonsters().size() + 1)) {
                        System.out.println("Indice errato");
                    } else {
                        //TAPPA IL MOSTRO INDICATO NEL CAMPO DI GIOCO
                        player.tapMonster(input);
                    }
                }
            } catch (IOException ex) {
                System.out.println("Si è verificato un errore: " + ex);
            }
        }
    }

}
