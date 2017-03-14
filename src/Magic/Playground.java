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
    protected Stack<Card> effetti;
    protected Stack<Player> cartagiocatada;

    /**
     * Initialize a new playground
     */
    public Playground() {
        effetti = new Stack();
        cartagiocatada = new Stack();
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
            if (player1.isInGame())
                player2.initTurno();
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
        System.out.print("Giocatore 1, inserisci il tuo nome: ");
        do {
            try {
                player1.setNome(myInput.readLine());
            } catch (IOException e) {
                System.out.println("Si è verificato un errore: " + e);
            }
        } while (player1.getNome().equals(""));
        System.out.print("Giocatore 2, inserisci il tuo nome: ");
        do {
            try {
                player2.setNome(myInput.readLine());
            } catch (IOException e) {
                System.out.println("Si è verificato un errore: " + e);
            }
        } while (player2.getNome().equals(""));
        
        //crea mazzo e mano
        player1.creaMazzo();
        player1.creaMano();
        player2.creaMazzo();
        player2.creaMano();
        
        //Visualizzo i mazzi e le mani dei giocatori
        System.out.println("\nMazzo di " + player1.getNome());
        player1.stampaMazzo();
        System.out.println("\nMano di " + player1.getNome());
        player1.stampaMano();
        System.out.println("\n");
        
        System.out.println("\nMazzo di " + player2.getNome());
        player2.stampaMazzo();
        System.out.println("\nMano di " + player2.getNome());
        player2.stampaMano();
        System.out.println("\n");
               
    }

    public void stampaMagie(Player player) {
        int i;
        System.out.println("\nMagie giocatore " + player.getNome());
        for (i = 0; i < player.getMagics().size(); i++) {
            System.out.print(" " + player.getMagics().get(i).name);
        }
        System.out.println("\n");
    }


    public void stampaMostri(Player player) {
        int i;
        System.out.println("\nMostri giocatore " + player.getNome());
        for (i = 0; i < player.getMonsters().size(); i++) {
            System.out.print(" " + player.getMonsters().get(i).name);
        }
        System.out.println("\n");
    }

    /*
    Player player: giocatore che esegue la prima carta dello stack
     */
    public void checkIstantOtherPlayer(Player player) {
        //CONTROLLO SE IL G1 HA ISTANTANEI DA GIOCARE DI RISPOSTA
        boolean istantp1 = true;
        boolean istantp2 = true;
        if (player.equals(this.player1)) {
            while(istantp1==true && istantp2==true){
                System.out.print(""+player2.getNome());
                istantp2=player2.checkIstantToPlay();
                if(istantp2==true){
                    System.out.print(""+player1.getNome());
                    istantp1=player1.checkIstantToPlay();
                }
            }
        } //CONTROLLO SE IL G2 HA ISTANTANEI DA GIOCARE DI RISPOSTA
        else {
            while(istantp1==true && istantp2==true){
                System.out.print(""+player1.getNome());
                istantp1=player1.checkIstantToPlay();
                if(istantp1==true){
                    System.out.print(""+player2.getNome());
                    istantp2=player2.checkIstantToPlay();
                }
            }
        }
        execStack();
    }
    
    /**
     * Execute the card's stack
     */
    public void execStack(){
        System.out.println("\n\nEseguo gli effetti in ordine LIFO");
        int i;
        for(i=effetti.size()-1;i>=0;i--){
            System.out.println(i + " - " + effetti.get(i).getName() + " " + effetti.get(i).getType() + " giocata da " + cartagiocatada.get(i).getNome());
        }
        i=effetti.size()-1;
        while(!effetti.isEmpty()){
            Card app;
            Player app_p;
            app_p = cartagiocatada.pop();
            app = effetti.pop();
            System.out.println("Effetto della carta " + i + " - " + app.getName() + " giocata da " + app_p.getNome());
            app.execute();
            i--;
        }
    }
    
    /**
     * Add a card into stack
     * @param carta: played card
     * @param p: player who play the card
     */
    //DA AGGIUNGERE NELLO STACK QUALE GIOCATORE HA GIOCATO QUESTA CARTA
    public void addStack(Card carta, Player p){
        if(p.equals(player1)){
            cartagiocatada.push(player1);
        }
        else{
            cartagiocatada.push(player2);
        }
        effetti.push(carta);
    }
    
    
    public void printPlayground(Player caller){
        
        if(caller.equals(player1)){
            System.out.println("===================================================================================");
            System.out.println("Carte in gioco di "+player1.getNome());
            System.out.println("===================================================================================");
            player1.printPlayerPlayground();
            System.out.println("===================================================================================");
            player2.printPlayerPlayground();
            System.out.println("===================================================================================");
            System.out.println("Carte in gioco di "+player2.getNome());
            System.out.println("===================================================================================");
        }
        else{
            System.out.println("===================================================================================");
            System.out.println("Carte in gioco di "+player2.getNome());
            System.out.println("===================================================================================");
            player2.printPlayerPlayground();
            System.out.println("===================================================================================");
            player1.printPlayerPlayground();
            System.out.println("===================================================================================");
            System.out.println("Carte in gioco di "+player1.getNome());
            System.out.println("===================================================================================");
        }
        
    
    }
}
