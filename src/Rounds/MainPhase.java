package Magic.Rounds;

import Magic.Game.Player;
import Magic.Game.Playground;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Represents the main phase
 *
 * @author Enrico
 */
public class MainPhase implements Phase {

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
     * Creats a new Main pahse
     *
     * @param playground The playground
     * @param player The player
     */
    public MainPhase(Playground playground, Player player) {
        this.playground = playground;
        this.player = player;
        reader = new InputStreamReader(System.in);
        myInput = new BufferedReader(reader);
    }

    @Override
    public void initPhase() {
        System.out.println("Sono nella Main Phase");
        System.out.println(player.getNome() + " quale carta desideri giocare (indicare con un intero l'indice della carta, -1 per non giocare nulla)?");
        player.stampaMano();
        System.out.println("");
        int input = 0;
        do {
            try {
                throwedexc=false;
                System.out.print("\n-> ");
                try{
                    input = Integer.parseInt(myInput.readLine());
                }
                catch(NumberFormatException exc){
                    System.out.println("Input errato.");
                    throwedexc=true;
                }
                if ((((input < 1) || (input > player.getMano().size() + 1)) && input != -1) && throwedexc==false) {
                    System.out.println("Indice errato.");
                } else {
                    if(input != -1 && throwedexc==false){
                        System.out.println("gioco la carta");
                        player.giocaCarta(input);
                        //input = 0; TRUCCO PER FAR RIPETERE IL DO WHILE
                    }
                }
            } catch (IOException ex) {
                System.out.println("Si è verificato un errore: " + ex);
            }
        } while (((input > player.getMano().size() + 1) || (input < 1) && input != -1) && throwedexc==true);
        System.out.println("\n");
        playground.printPlayground(player);
    }
}