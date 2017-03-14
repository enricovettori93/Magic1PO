package Magic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

/**
 * Rappresnets a player
 *
 * @author Enrico
 */
public class Player {

    /**
     * The player name
     */
    private String name;

    /**
     * The initsal life points
     */
    private int lifePoints = 10;

    /**
     * The deck
     */
    private List<Card> mazzo = new ArrayList<>();

    /**
     * The hand
     */
    protected List<Card> mano = new ArrayList<>();

    /**
     * The round handler
     */
    private Round t;

    /**
     * Indicates if the player is currenlty in game or not
     */
    private Boolean ingioco = true;

    /**
     * The playground
     */
    private Playground playground;

    /**
     * The player magics
     */
    private List<Card> magics = new ArrayList<>();

    /**
     * The player monsters
     */
    private List<Creature> monsters = new ArrayList<>();
    
    /**
     * The input stream
     */
    private InputStreamReader reader;
    
    /**
     * The buffer reader
     */
    private BufferedReader myInput;
    
    /**
     * Creates a new player
     *
     * @param name The player name
     * @param playground The playground
     */
    public Player(String name, Playground playground) {
        this.name = name;
        this.playground = playground;
        reader = new InputStreamReader(System.in);
        myInput = new BufferedReader(reader);
    }

    /**
     * Creates a new player
     *
     * @param playground The playground
     */
    public Player(Playground playground) {
        this.playground = playground;
        reader = new InputStreamReader(System.in);
        myInput = new BufferedReader(reader);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public boolean isInGame() {
        return ingioco;
    }

    public void setInGioco(Boolean boneggio) {
        ingioco = boneggio;
    }

    public List<Card> getMagics() {
        return magics;
    }

    public void addMagic(Card magic) {
        this.magics.add(magic);
    }

    public void addMagics(List<Card> magics) {
        this.magics.addAll(magics);
    }

    /*Lista de creature non più di carte!*/
    public List<Creature> getMonsters() {
        return monsters;
    }

    public void addMonster(Creature monster) {
        this.monsters.add(monster);
    }

    public void addMonster(List<Creature> monsters) {
        this.monsters.addAll(monsters);
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Deck handlers">
    protected void creaMazzo() {
        int i=0;
        int carta=0;
        do{
            do{
                System.out.println(this.getNome() + " seleziona la carta " + (i+1) + " da inserire nel mazzo (presente solo omeophaty)");
                System.out.println("1 - Omeophaty");
                try {
                    System.out.print("-> ");
                    carta = Integer.parseInt(myInput.readLine());
                } catch (IOException ex) {
                    System.out.println("ahiahiaahi");
                }
            }while(carta != 1);
            i++;
            mazzo.add(new Instant("Omeophaty","Omeophaty does nothing"));
        //MAZZO DI 6 CARTE PER DEBUG
        }while(i<6);
        Collections.shuffle(mazzo);
    }

    public void stampaMazzo() {
        for (int i = 0; i < mazzo.size(); i++) {
            System.out.print(mazzo.get(i).getName() + " ");
        }
    }

    public void estraiCarta() {
        if (mazzo.isEmpty()) {
            ingioco = false;
        } else {
            mano.add(mazzo.get(mazzo.size()-1));
            mazzo.remove(mazzo.size()-1);
        }
    }

    /**
     * Gets the number of cards the player has in his deck
     * @return The number of card left in the deck
     */
    public int carteMazzo() {
        return mazzo.size();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Hand handlers">
    protected void creaMano() {
        //MANO DI 1 ELEMENTO PER DEBUG
        for (int i = 0; i < 1; i++) {
            mano.add(mazzo.get(mazzo.size()-1));
            mazzo.remove(mazzo.size()-1);
        }
    }

    public void stampaMano() {
        for (int i = 0; i < mano.size(); i++) {
            System.out.print((i+1) + "-" + mano.get(i).getName() + " " + mano.get(i).getType() + " ");
        }
    }
    
    /**
     *Check if the player can and would use istant's card, otherwise don't do nothing
     * Return true: if the player use an istans, false if don't want to play some istants
     * @return 
     */
    public boolean checkIstantToPlay(){
        if(!mano.isEmpty()){
            System.out.println(" vuoi giocare un istantaneo (-1 per uscire)?");
            Card app;
            stampaMano();
            int carta=0;
            do{
                do{
                    try {
                        System.out.print("-> ");
                        carta = Integer.parseInt(myInput.readLine());
                        if(carta != -1)
                            carta --;
                    } catch (IOException ex) {
                        System.out.println("ahiahiaahi");
                    }
                    if(carta==-1){
                        return false;
                    }
                }while(carta<0 || carta>mano.size());
                app=mano.get(carta);
                if("Istant".equals(app.getType())){
                    playground.addStack(app,this);
                    mano.remove(carta);
                    return true;
                }
            }while((!"Istant".equals(app.getType())));
            return false;
        }
        else{
            return false;
        }
    }
    
    public void giocaCarta(int indice) {
        if("Istant".equals(mano.get(indice-1).getType()) || "Enchantment".equals(mano.get(indice-1).getType())  || "Sourcery".equals(mano.get(indice-1).getType())){
            addMagic(mano.get(indice-1));
            playground.addStack(mano.get(indice-1),this);
            playground.checkIstantOtherPlayer(this);
        }
        else{
            addMonster((Creature)mano.get(indice-1));
            playground.checkIstantOtherPlayer(this);
        }
        //playground.addMostro(mano.get(indice - 1), this);
        mano.remove(indice - 1);
        //CODICE DI DEBUG
        playground.stampaMagie(playground.player1);
        playground.stampaMagie(playground.player2);
        playground.stampaMostri(playground.player1);
        playground.stampaMostri(playground.player2);
    }
    // </editor-fold>
    

    /**
     * Initalize a new round
     */
    public void initTurno() {
        t = new Round(playground, this);
    }
}
