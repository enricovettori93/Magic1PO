package Magic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Rappresents the playground. TODO: Must be singleton
 *
 * @author Enrico
 */
public class Playground {

    public Player player1;
    public Player player2;

    /**
     * The stack of effects present in the playground
     */
    protected Stack<Integer> effetti;

    /**
     * Initialize a new playground
     */
    public Playground() {
        effetti = new Stack();
        this.player1 = new Player(this);
        this.player2 = new Player(this);

        inizializza();
        gioco();
    }

    /**
     * Inits the players round
     */
    private void gioco() {
        while (player1.isInGame() && player2.isInGame()) {
            player1.initTurno();
            if (player1.isInGame()) {
                player2.initTurno();
            }
        }
        if (player1.isInGame()) {
            System.out.println("Bravo " + player1.getNome() + " hai vinto!");
        } else {
            System.out.println("Bravo " + player2.getNome() + " hai vinto!");
        }
    }

    /**
     * Inits players
     */
    private void inizializza() {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader myInput = new BufferedReader(reader);
        //Creo i giocatori
        System.out.println("Giocatore 1, inserisci il tuo nome: ");
        do {
            try {
                player1.setNome(myInput.readLine());
            } catch (IOException e) {
                System.out.println("Si è verificato un errore: " + e);
            }
        } while (player1.getNome().equals(""));
        System.out.println("Giocatore 2, inserisci il tuo nome: ");
        do {
            try {
                player2.setNome(myInput.readLine());
            } catch (IOException e) {
                System.out.println("Si è verificato un errore: " + e);
            }
        } while (player2.getNome().equals(""));
        //Visualizzo i mazzi
        System.out.println("\nMazzo di " + player1.getNome());
        player1.stampaMazzo();
        System.out.println("\nMazzo di " + player2.getNome());
        player2.stampaMazzo();
        //Visualizzo le mani di entrambi i giocatori
        System.out.println("\nCarte iniziali di " + player1.getNome());
        player1.stampaMano();
        System.out.println("\nCarte iniziali di " + player2.getNome());
        player2.stampaMano();
    }

    public void stampaMagie(Player player) {
        int i;
        System.out.println("\nMagie giocatore " + player.getNome());
        for (i = 0; i < player.getMagics().size(); i++) {
            System.out.print(" " + player.getMagics().get(i));
        }
        System.out.println("\n");
    }


    public void stampaMostri(Player player) {
        int i;
        System.out.println("\nMostri giocatore " + player.getNome());
        for (i = 0; i < player.getMonsters().size(); i++) {
            System.out.print(" " + player.getMonsters().get(i));
        }
        System.out.println("\n");
    }

    //METODI PER AGGIUNGERE MOSTRI E MAGIE ALLE LISTE IN CAMPO IN BASE AL GIOCATORE CHE HA GIOCATO LA CARTA
    public void addMostro(Integer i, Player player) {
        player.addMonster(i);
    }

    public void addMagia(Integer i, Player player) {
        player.addMagic(i);
    }


    /*
    Player g: giocatore che deve tappare il mostro nella sua lista
    index: indice del mostro da tappare
     */
    public void tapMonster(Player player, int index) {
        //TAPPO IL MOSTRO DI G1
        if (player.equals(this.player1)) {

        } //TAPPO IL MOSTRO DI G2
        else {

        }
        System.out.println("Ho tappato il mostro " + index);
    }
}
