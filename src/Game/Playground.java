package Magic.Game;

import Magic.Cards.Card;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Represents the playground. TODO: Must be singleton
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
    protected Stack<Player> cartaGiocataDa;
    protected ArrayList<Card> playedCardStack;

    /**
     * Initialize a new playground
     */
    public Playground() {
        effetti = new Stack <>();
        cartaGiocataDa = new Stack <>();
        playedCardStack = new ArrayList <>();
        this.player1 = new Player(this);
        this.player2 = new Player(this);
        inizializza();
        gioco();
    }

    /**
     * The method gioco inits rounds of the players
     */
    private void gioco() {
        while (player1.isInGame() && player2.isInGame()) {
            player1.initRound();
            if (player1.isInGame())
                player2.initRound();
        }
        if (player1.isInGame()) {
            System.out.println("Bravo " + player1.getNome() + " hai vinto!");
        } else {
            System.out.println("Bravo " + player2.getNome() + " hai vinto!");
        }
    }

    /**
     * The method Inizializza inits players
     */
    private void inizializza() {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader myInput = new BufferedReader(reader);
        System.out.println("Primo assignment P.O. 2016/2017.\nStudenti: Enrico Vettori, Alessia Marostica, Giacomo De Liberali, Elena Rossetto.\n\n");
        //Player's creation
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
        
        //Create decks and hands of the players
        player1.creaMazzo();
        player1.creaMano();
        player2.creaMazzo();
        player2.creaMano();
        
        //Print decks and the hands of the players
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
            System.out.print(" " + player.getMagics().get(i).getName());
        }
        System.out.println("\n");
    }


    public void stampaMostri(Player player) {
        int i;
        System.out.println("\nMostri giocatore " + player.getNome());
        for (i = 0; i < player.getMonsters().size(); i++) {
            System.out.print(" " + player.getMonsters().get(i).getName());
        }
        System.out.println("\n");
    }

    /*
    Player player: player that plays the first card in the stack
     */
    public void checkIstantOtherPlayer(Player player) {
        //I check if player1 has istant card to play as a response
        boolean istantp1 = true;
        boolean istantp2 = true;
        if (player.equals(this.player1)) {
            while(istantp1==true && istantp2==true){
                istantp2=player2.checkIstantToPlay();
                if(istantp2==true){
                    istantp1=player1.checkIstantToPlay();
                }
            }
        } //I check if player2 has instant card to play as a response
        else {
            while(istantp1==true && istantp2==true){
                istantp1=player1.checkIstantToPlay();
                if(istantp1==true){
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
            System.out.println(i + " - " + effetti.get(i).getName() + " " + effetti.get(i).getType() + " giocata da " + cartaGiocataDa.get(i).getNome());
        }
        i=effetti.size()-1;
        while(!effetti.isEmpty()){
            Card app;
            Player app_p;
            //I take the card that has been played from the top of the stack
            app_p = cartaGiocataDa.pop();
            app = effetti.pop();
            //I add the card from the top of the stack in a list of card that have been played.
            //This list will be removed at the end of the turn to cancel all applied effects
            if(effetti.size()>=1)
                playedCardStack.add(app);
            System.out.println("Effetto della carta " + i + " - " + app.getName() + " giocata da " + app_p.getNome());
            app.execute();
            i--;
        }
    }
    
    public ArrayList getPlayedCardStack(){
        return playedCardStack;
    }
    /**
     * The method removePlayedCardStack removes card's effects that have been played
     */
    public void removePlayedCardStack(){
        for(int i=0; i<playedCardStack.size();i++){
            playedCardStack.get(i).removeCard();
        }
        playedCardStack.clear();
    }

        /**
     * The method addStack adds to the stack who played that card
     * @param carta: played card
     * @param p: player who play the card
     */
    public void addStack(Card carta, Player p){
        if(p.equals(player1)){
            cartaGiocataDa.push(player1);
        }
        else{
            cartaGiocataDa.push(player2);
        }
        effetti.push(carta);
    }
    
    
    public void printPlayground(Player caller){
        if(caller.equals(player1)){
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
        else{
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
    }
}
